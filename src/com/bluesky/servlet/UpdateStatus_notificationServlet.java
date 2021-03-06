package com.bluesky.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluesky.bean.Notification;
import com.bluesky.dao.NotificationDao;
import com.bluesky.dao.TaskListDao;

/**
 * Servlet implementation class UpdateStatus_notifactionServlet
 */
@WebServlet("/UpdateStatus_notificationServlet.do")
public class UpdateStatus_notificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus_notificationServlet() {
        super();
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
		NotificationDao notificationDao=new NotificationDao();
		notificationDao.updateStatus(id, status);
		System.out.println("status change success");
		response.setContentType("text/html;charset=utf-8");//这里是防止出现乱码，很重要的
		response.getWriter().print( " <script> location.href= '"+request.getContextPath()+"/jsp/businessCenter_supervisorServclet?flag=3&page=1'; </script> ");
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
