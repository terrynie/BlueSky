package com.bluesky.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.bluesky.bean.WeChat;
import com.bluesky.dao.WeChatDao;
import com.bluesky.tools.TimeConvert;

/**
 * Servlet implementation class dataCenterServlet
 */
@WebServlet("/jsp/dataCenterServlet")
public class DataCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataCenterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int weChatTotalDataNum = new WeChatDao().queryNumOfComplaintsByStatus(0);
		int weChatDealedDataNum = new WeChatDao().queryNumOfComplaintsByStatus(1);
		
		WeChat weChat=new WeChat();
		WeChatDao weChatDao=new WeChatDao();
		TimeConvert timeConvert=new TimeConvert();
		Date now = new Date();
		
		 Calendar ca = Calendar.getInstance();
	      int year = ca.get(Calendar.YEAR);//获取年份
	      int month=ca.get(Calendar.MONTH);//获取月份
	      int day=ca.get(Calendar.DATE);//获取日
		System.out.println(now.getYear());
//		System.out.println("text:"+weChatTotalDataNum);
		request.setAttribute("weChatTotalDataNum", weChatTotalDataNum);
		request.setAttribute("weChatDealedDataNum", weChatDealedDataNum);
		request.getRequestDispatcher("dataCenter.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
