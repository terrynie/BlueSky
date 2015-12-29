package com.bluesky.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class businessCenter_adminServclet
 */
//@WebServlet("/jsp/businessCenter_adminServlet")
public class businessCenter_adminServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page = "1";
	String flag = "1";
	LinkedList<Notification> perInfos;
	LinkedList<TaskList> perInfos_not;
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
	public businessCenter_adminServclet() {
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
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("admin");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskWaitDealedByPage(0, pagesize, "admin");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.queryTaskDoneByPage(startNum, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
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
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("admin");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskWaitDealedByPage(0, pagesize, "admin");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.queryTaskDoneByPage(startNum, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
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
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("admin");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskWaitDealedByPage(0, pagesize, "admin");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.queryTaskDoneByPage(startNum, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			request.getRequestDispatcher("businessCenter_admin.jsp").forward(
					request, response);
			
		} else if (flagnum == 4) {
			//we chat datas
			countInfo = weChatDao.qureyNumOfComplaints();
			count_weChat = this.getcount(countInfo, pagesize);
			perInfos_weChat = weChatDao.queryByPage(0, pagesize);
			request.setAttribute("count_weChat", count_weChat);
			request.setAttribute("perInfos_weChat", perInfos_weChat);
			//wait dealed
			countInfo = taskListDao.qureyNumOfTaskWaitDealed("admin");
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.qureyTaskWaitDealedByPage(0, pagesize, "admin");
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//dealed 
			countInfo = taskListDao.qureyNumOfTaskListDone();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.queryTaskDoneByPage(startNum, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
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
