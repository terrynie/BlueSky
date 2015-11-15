package com.bluesky.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.bean.TaskList;
import com.bluesky.dao.TaskListDao;



/**
 * Servlet implementation class businessCenter_adminServclet
 */
//@WebServlet("/jsp/businessCenter_adminServclet")
public class businessCenter_justiceServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page = "1";
	String flag = "1";
	int pagesize=1;
	int countInfo;
	int startNum;
	LinkedList<TaskList> perInfos_not;
	LinkedList<TaskList> perInfos_done;
	int count_not;
	int count_done;
	TaskListDao taskListDao = new TaskListDao();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public businessCenter_justiceServclet() {
        super();
        // TODO Auto-generated constructor stub
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
		startNum = ((Integer.parseInt(page)) - 1) * pagesize;
		int flagnum=Integer.parseInt(flag);
		if (flagnum== 1) {
			countInfo = taskListDao.qureyNumOfTaskNotDone();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.queryTaskNotDone(startNum, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//
			countInfo = taskListDao.qureyNumOfTaskDone();
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.queryTaskDone(0, pagesize);
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			request.getRequestDispatcher("businessCenter_justice.jsp").forward(
					request, response);
			
		} else if (flagnum == 2) {
			countInfo = taskListDao.qureyNumOfTaskDone();
			count_done = this.getcount(countInfo, pagesize);
			perInfos_done = taskListDao.queryTaskDone(startNum, pagesize);
			request.setAttribute("count_done", count_done);
			request.setAttribute("perInfos_done", perInfos_done);
			//
			countInfo = taskListDao.qureyNumOfTaskNotDone();
			count_not = this.getcount(countInfo, pagesize);
			perInfos_not = taskListDao.queryTaskNotDone(0, pagesize);
			request.setAttribute("count_not", count_not);
			request.setAttribute("perInfos_not", perInfos_not);
			//
			request.getRequestDispatcher("businessCenter_justice.jsp").forward(
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
