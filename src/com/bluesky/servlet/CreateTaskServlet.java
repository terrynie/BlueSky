package com.bluesky.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluesky.bean.TaskImages;
import com.bluesky.bean.TaskList;
import com.bluesky.bean.WeChat;
import com.bluesky.bean.WeChatImages;
import com.bluesky.dao.TaskImageDao;
import com.bluesky.dao.TaskListDao;
import com.bluesky.dao.WeChatDao;
import com.bluesky.dao.WeChatImagesDao;
import com.bluesky.tools.TimeConvert;

/**
 * Servlet implementation class creattaskServlet
 */

public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskServlet() {
        super();
        System.out.println("run");
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	HttpSession session = request.getSession();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		int status=Integer.parseInt(request.getParameter("status"));
		WeChatDao wechatdao=new WeChatDao();
		WeChat wechat=wechatdao.queryOne(id);
		wechatdao.updateStatusById(id, status);
		TaskList taskList=new TaskList();
		TaskListDao taskListDao=new TaskListDao();
		taskList.setContent(wechat.getContent());
		taskList.setCreateTime(TimeConvert.ConvertToSqlDate(new Date()));
		taskList.setHasContent(1);
		taskList.setHasImg(wechat.getHasImg());
		taskList.setHasVideo(0);
		taskList.setId(new Date().getTime()+"");
		taskList.setSource("微信举报");
		taskList.setStatus(0);
		taskListDao.addTask(taskList);
		WeChatImagesDao weChatImagesDao=new WeChatImagesDao();
		LinkedList<WeChatImages> list_weChatImages=weChatImagesDao.queryImages(wechat.getId());
		for (WeChatImages wi:list_weChatImages) {
			TaskImageDao taskImageDao=new TaskImageDao();
			TaskImages taskImages=new TaskImages();
			taskImages.setImgId(new Date().getTime()+"");
			taskImages.setImgPath(wi.getImgPath());
			taskImages.setTaskId(taskList.getId());
			taskImageDao.addImage(taskImages);
		}
		System.out.println("status change success");
		response.setContentType("text/html;charset=utf-8");//这里是防止出现乱码，很重要的
		response.getWriter().print( " <script> location.href= '"+request.getContextPath()+"/jsp/businessCenter_adminServlet?flag=1&page=1'; </script> ");
		//response.sendRedirect("/jsp/businessCenter_adminServclet");
		//request.getRequestDispatcher("jsp/businessCenter_adminServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
