package com.bluesky.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.Notification;
import com.bluesky.bean.TaskList;
import com.bluesky.dao.NotificationDao;
import com.bluesky.dao.TaskListDao;


/**
 * Servlet implementation class businessCenter_adminServclet
 */
//@WebServlet("/jsp/businessCenter_adminServclet")
public class BusinessCenter_supervisorServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page = "1";
	String flag = "1";
	ArrayList<Notification> perInfos;
	ArrayList<TaskList> perInfos_not;
	ArrayList<TaskList> perInfos_done;
	int pagesize = 5;
	int startNum;
	int countInfo;
	int count;
	int count_not;
	int count_done;

	NotificationDao notificationDao = new NotificationDao();
	TaskListDao taskListDao = new TaskListDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
	public int getcount(int countinfo, int pagesize) {
		if (countinfo % pagesize == 0) {
			return countinfo / pagesize;
		} else {
			return countinfo / pagesize + 1;
		}
	}

    public BusinessCenter_supervisorServclet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		String page1 = null;
		String flag1 = null;
		page1 = request.getParameter("page");
		if (page1 != null) {
			page = request.getParameter("page");
		}
		flag1 = request.getParameter("flag");
		if (flag1 != null) {
			flag = request.getParameter("flag");
		}
		System.out.println("zheli page"+page);
		System.out.println("zheli flag"+flag);
		startNum = ((Integer.parseInt(page)) - 1) * pagesize;
		int flagnum=Integer.parseInt(flag);
		if (flagnum== 1) {
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("InspectionPersonnel");
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.qureyTaskWaitDealedByPage(startNum, pagesize, "InspectionPersonnel");
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//
			countInfo = taskListDao.qureyNumOfTaskDealing("InspectionPersonnel");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskDealingByPage(0, pagesize, "InspectionPersonnel");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_supervisor.jsp").forward(
					request, response);
			
		} else if (flagnum == 2) {
			countInfo = taskListDao.qureyNumOfTaskDealing("InspectionPersonnel");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskDealingByPage(startNum, pagesize, "InspectionPersonnel");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("InspectionPersonnel");
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.qureyTaskWaitDealedByPage(0, pagesize, "InspectionPersonnel");
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_supervisor.jsp").forward(
					request, response);
		} else if (flagnum == 3) {
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(startNum, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("InspectionPersonnel");
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.qureyTaskWaitDealedByPage(0, pagesize, "InspectionPersonnel");
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("InspectionPersonnel");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskDealingByPage(0, pagesize, "InspectionPersonnel");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			request.getRequestDispatcher("businessCenter_supervisor.jsp").forward(
					request, response);
		} 
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
