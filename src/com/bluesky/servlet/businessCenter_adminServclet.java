package com.bluesky.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.action.GetBooleanAction;

import com.bluedsky.bean.Notification;
import com.bluedsky.bean.TaskList;
import com.bluesky.dao.NotificationDao;
import com.bluesky.dao.TaskListDao;



/**
 * Servlet implementation class businessCenter_adminServclet
 */
//@WebServlet("/jsp/businessCenter_adminServclet")
public class businessCenter_adminServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page_notifiction="1";
	int pagesize=1;
	int startNum_notifiction;
	int countNotifiction;//记录数据库信息总条数(整改通知)
	int count_notifiction;//记录返回的总页数(整改通知)
	int countInfoTask_done;
	int countTask_done;
	int countInfoTask_nodone;
	int countTask_nodone;
	NotificationDao notificationDao=new NotificationDao();
	TaskListDao taskListDao=new TaskListDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public businessCenter_adminServclet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   /* public void getcount(int countinfo,int pagesize){
    	if(countinfo%pagesize==0){
    		return countinfo/pagesize;
    	}
    }*/
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String page_notifiction1=null;
		page_notifiction1=request.getParameter("page_notifiction");
		if(page_notifiction1 !=null){
			page_notifiction=request.getParameter("page_notifiction");
		}
		//未处理
		countInfoTask_done=taskListDao.qureyNumOfTaskDone();
		
		//通知公告
		countNotifiction=notificationDao.qureyNumOfNotifications();
		if(countNotifiction%pagesize==0){
			count_notifiction=countNotifiction/pagesize;
		}else {
			count_notifiction=countNotifiction/pagesize+1;
		}
		startNum_notifiction=((Integer.parseInt(page_notifiction))-1)*pagesize;
		request.setAttribute("count_notifiction", count_notifiction);
		LinkedList<Notification> perNotifictions=notificationDao.queryByPage(startNum_notifiction, pagesize);
		request.setAttribute("perNotifictions", perNotifictions);
		request.getRequestDispatcher("businessCenter_admin.jsp").forward(request, response);
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
		doGet(request, response);
	}

}
