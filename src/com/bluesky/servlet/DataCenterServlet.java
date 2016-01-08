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
import com.bluesky.dao.WeatherDao;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		int weChatTotalDataNum = new WeChatDao()
				.queryNumOfComplaintsByStatus(0);
		int weChatDealedDataNum = new WeChatDao()
				.queryNumOfComplaintsByStatus(1);

		WeChat weChat = new WeChat();
		WeChatDao weChatDao = new WeChatDao();
		WeatherDao weatherDao = new WeatherDao();
		TimeConvert timeConvert = new TimeConvert();
		Date now = new Date();

		Calendar ca = Calendar.getInstance();
		int[][] pm = new int[12][3];
		int[][] customer = new int[12][3];
		int month = ca.get(Calendar.MONTH);// 获取当前月份-1
		System.out.println("月份：" + month);
		for (int i = 0; i < 12; i++) {
			int year = ca.get(Calendar.YEAR);// 获取当前年份
			if (month > 12) {
				month = month - 12;
			} else {
				year--;
			}
			System.out.println("年份：" + year);
			int sumofpm10 = weatherDao.queryNumOfPMItemByMonth(year, month);
			// int sumofpm10=10;
			int sumofpm25 = 20; // 暂时没有数据
			int sumcustomer = weChatDao.qureyNumOfComplaints();
			int partcustomer = weChatDao.queryNumOfComplaintsByStatus(1);
			int[] a = { month, sumofpm10, sumofpm25 };
			int[] b = { month, sumcustomer, partcustomer };
			pm[i] = a;
			customer[i] = b;
			// System.out.println("pm:"+pm[i][1]);
			month++;

		}
		request.setAttribute("dataofpm", pm); // 有关pm图的数据
		request.setAttribute("customer", customer); // 有关customer数据
		// System.out.println("text:"+weChatTotalDataNum);
		request.setAttribute("weChatTotalDataNum", weChatTotalDataNum);
		request.setAttribute("weChatDealedDataNum", weChatDealedDataNum);
		request.getRequestDispatcher("dataCenter.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
