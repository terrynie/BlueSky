package com.bluesky.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.FineTicket;
import com.bluesky.bean.Notification;
import com.bluesky.dao.FineTicketDao;
import com.bluesky.dao.NotificationDao;



/**
 * Servlet implementation class businessCenter_adminServclet
 */
//@WebServlet("/jsp/businessCenter_adminServclet")
public class businessCenter_constructionManagerServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page = "1";
	String flag = "1";
	LinkedList<Notification> perInfos;
	LinkedList<FineTicket> perInfos_fineTickets;
	
	int pagesize = 1;
	int startNum;
	int countInfo;
	int count;
	int count_fineTickets;

	NotificationDao notificationDao = new NotificationDao();
	FineTicketDao fineTicketDao = new FineTicketDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public businessCenter_constructionManagerServclet() {
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
		System.out.println("zheli page"+page);
		System.out.println("zheli flag"+flag);
		startNum = ((Integer.parseInt(page)) - 1) * pagesize;
		int flagnum=Integer.parseInt(flag);
		if(flagnum==1){
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(startNum, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			//
			countInfo = fineTicketDao.qureyNumOfFineTicket();
			count_fineTickets = this.getcount(countInfo, pagesize);
			perInfos_fineTickets = fineTicketDao.queryByPage(0, pagesize);
			request.setAttribute("count_fineTickets", count_fineTickets);
			request.setAttribute("perInfos_fineTickets", perInfos_fineTickets);
			request.getRequestDispatcher("businessCenter_constructionManager.jsp").forward(
					request, response);
		}else if(flagnum==2){
			countInfo = fineTicketDao.qureyNumOfFineTicket();
			count_fineTickets = this.getcount(countInfo, pagesize);
			perInfos_fineTickets = fineTicketDao.queryByPage(startNum, pagesize);
			request.setAttribute("count_fineTickets", count_fineTickets);
			request.setAttribute("perInfos_fineTickets", perInfos_fineTickets);
			//
			countInfo = notificationDao.qureyNumOfNotifications();
			count = this.getcount(countInfo, pagesize);
			perInfos = notificationDao.queryByPage(0, pagesize);
			request.setAttribute("count", count);
			request.setAttribute("perInfos", perInfos);
			request.getRequestDispatcher("businessCenter_constructionManager.jsp").forward(request, response);
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
