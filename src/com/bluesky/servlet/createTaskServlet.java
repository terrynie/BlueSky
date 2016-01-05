package com.bluesky.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluesky.bean.TaskList;
import com.bluesky.bean.WeChat;
import com.bluesky.dao.TaskListDao;
import com.bluesky.dao.WeChatDao;

/**
 * Servlet implementation class creattaskServlet
 */

public class createTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createTaskServlet() {
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
		TaskList taskList=new TaskList();
		TaskListDao taskListDao=new TaskListDao();
		WeChat wechat=new WeChat();
		WeChatDao wechatdao=new WeChatDao();
		taskList.setId(id);
	
		taskList.setStatus(status);
		taskListDao.updateTaskStatus(id, status);;
		System.out.println("status change success");
		response.setContentType("text/html;charset=utf-8");
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
