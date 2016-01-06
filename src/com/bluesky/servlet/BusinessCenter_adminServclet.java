package com.bluesky.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.Notification;
import com.bluesky.bean.TaskList;
import com.bluesky.bean.WeChat;
import com.bluesky.dao.NotificationDao;
import com.bluesky.dao.TaskListDao;
import com.bluesky.dao.WeChatDao;
import com.bluesky.tools.TimeConvert;
import com.sun.org.apache.bcel.internal.generic.NEW;



/**
 * Servlet implementation class businessCenter_adminServclet
 */
//@WebServlet("/jsp/businessCenter_adminServlet")
public class BusinessCenter_adminServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page = "1";
	String flag = "1";
	LinkedList<Notification> perInfos;
	LinkedList<WeChat> perInfos_not;
	LinkedList<TaskList> perInfos_done;
	LinkedList<WeChat> perInfos_weChat;

	int pagesize = 5;
	int startNum;
	int countInfo;
	int count;
	int count_not;
	int count_done;
	int count_weChat;

	NotificationDao notificationDao = new NotificationDao();
	TaskListDao taskListDao = new TaskListDao();
	WeChatDao weChatDao = new WeChatDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusinessCenter_adminServclet() {
		super();
	}

	public int getcount(int countinfo, int pagesize) {
		if (countinfo % pagesize == 0) {
			return countinfo / pagesize;
		} else {
			return countinfo / pagesize + 1;
		}
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		if (flagnum == 1) {
			//we chat datas
			countInfo = weChatDao.qureyNumOfComplaints();
			count_weChat = this.getcount(countInfo, pagesize);
			perInfos_weChat = weChatDao.queryByPage(0, pagesize);
			request.setAttribute("count_weChat", count_weChat);
			request.setAttribute("perInfos_weChat", perInfos_weChat);
			//wait dealed
			countInfo = weChatDao.queryNumOfComplaintsByStatus(0);
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = weChatDao.queryComplaintsByStatus(0, startNum, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.queryTaskDoneByPage(0, pagesize);
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_admin.jsp").forward(
					request, response);
			
		} else if (flagnum == 2) {
			//we chat datas
			countInfo = weChatDao.qureyNumOfComplaints();
			count_weChat = this.getcount(countInfo, pagesize);
			perInfos_weChat = weChatDao.queryByPage(0, pagesize);
			request.setAttribute("count_weChat", count_weChat);
			request.setAttribute("perInfos_weChat", perInfos_weChat);
			//wait dealed
			countInfo = weChatDao.qureyNumOfComplaints();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = weChatDao.queryComplaintsByStatus(0, 0, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.queryTaskDoneByPage(startNum, pagesize);
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_admin.jsp").forward(
					request, response);
			
		} else if (flagnum == 3) {
			//we chat datas
			countInfo = weChatDao.qureyNumOfComplaints();
			count_weChat = this.getcount(countInfo, pagesize);
			perInfos_weChat = weChatDao.queryByPage(0, pagesize);
			request.setAttribute("count_weChat", count_weChat);
			request.setAttribute("perInfos_weChat", perInfos_weChat);
			//wait dealed
			countInfo = weChatDao.queryNumOfComplaintsByStatus(0);
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = weChatDao.queryComplaintsByStatus(0, 0, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.queryTaskDoneByPage(0, pagesize);
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(startNum, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_admin.jsp").forward(
					request, response);
			
		} else if (flagnum == 4) {
			//we chat datas
			countInfo = weChatDao.qureyNumOfComplaints();
			count_weChat = this.getcount(countInfo, pagesize);
			perInfos_weChat = weChatDao.queryByPage(startNum, pagesize);
			request.setAttribute("count_weChat", count_weChat);
			request.setAttribute("perInfos_weChat", perInfos_weChat);
			//wait dealed
			countInfo = weChatDao.queryNumOfComplaintsByStatus(0);
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = weChatDao.queryComplaintsByStatus(0, 0, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.queryTaskDoneByPage(0, pagesize);
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_admin.jsp").forward(
					request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
