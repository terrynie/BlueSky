package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.bean.ConstructionSite;
import com.bluesky.dao.ConstructionSiteDao;



/**
 * Servlet implementation class monitoringcenter_adminServlet
 */
//@WebServlet("/jsp/monitoringcenter_adminServlet")
public class Monitoringcenter_adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Monitoringcenter_adminServlet() {
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String id = "111100";
		String str_id = request.getParameter("id");
		if (str_id != null) {
			id = str_id;
		}
		System.out.println(id);
		System.out.println(str_id);
		//ConstructionSiteImpl constructionSiteImpl = new ConstructionSiteImpl();
		ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
		LinkedList<ConstructionSite> list_constructionSites = constructionSiteDao.queryConSites();
		ConstructionSite constructionSite = constructionSiteDao.queryOne(id);
		System.out.println(constructionSite.getTotalMonitors());
		request.setAttribute("list_constructionSites", list_constructionSites);
		request.setAttribute("constructionSite", constructionSite);
		if (str_id == null) {
			request.getRequestDispatcher("monitoringcenter_admin.jsp").forward(
					request, response);
		} else {
			out.println("<table>");
			for (int i = 1; i <= constructionSite.getTotalMonitors(); i++) {
				 out.println("<tr>");
				 out.println(i+"������ͷ");
				 out.println("</tr>");
				 out.println("<br>");
			}
			out.println("</table>");
			out.close();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
