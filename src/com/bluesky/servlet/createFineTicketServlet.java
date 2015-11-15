package com.bluesky.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.bean.FineTicket;
import com.bluesky.dao.FineTicketDao;
import com.bluesky.dao.NotificationDao;

/**
 * Servlet implementation class createFineTicketServlet
 */
@WebServlet("/jsp/createFineTicketServlet")
public class createFineTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date sqlEndDate;
	java.sql.Date sqlStartDate;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createFineTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String notificationId=request.getParameter("notificationId");
		String company=request.getParameter("company");
		String money=request.getParameter("money");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String who=request.getParameter("who");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date startdate=simpleDateFormat.parse(startTime);
			sqlStartDate=new Date(startdate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			java.util.Date endDate=simpleDateFormat.parse(endTime);
			sqlEndDate=new Date(endDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NotificationDao notificationDao=new NotificationDao();
		String conSiteId=notificationDao.queryConSiteIdById(notificationId);
		FineTicket fineTicket=new FineTicket();
		FineTicketDao fineTicketDao=new FineTicketDao();
		fineTicket.setCompany(company);
		fineTicket.setConSiteId(conSiteId);
		fineTicket.setDeadLine(sqlEndDate);
		fineTicket.setFineMoney(Double.parseDouble(money));
		fineTicket.setId(""+fineTicketDao.qureyNumOfFineTicket());
		fineTicket.setNotificationId(notificationId);
		fineTicket.setStartTime(sqlStartDate);
		fineTicket.setWho(who);
		fineTicketDao.addFineTicket(fineTicket);
		request.getRequestDispatcher("createFineTicket.jsp").forward(request, response);
		
				
	}

}
