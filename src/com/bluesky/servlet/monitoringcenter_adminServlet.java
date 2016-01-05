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
import com.bluesky.dao.ConstructionManagerDao;
import com.bluesky.dao.ConstructionSiteDao;




/**
 * Servlet implementation class monitoringcenter_adminServlet
 */
 //@WebServlet("/jsp/monitoringcenter_adminServlet")
public class monitoringcenter_adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public monitoringcenter_adminServlet() {
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
			HttpServletResponse response) throws ServletException, IOException 

{
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String id = "金水区";
		String str_id = request.getParameter("id");
		if (str_id != null) {
			id = str_id;
		}
		System.out.println(id);
		System.out.println(str_id);
		ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
		ConstructionManagerDao conDir = new ConstructionManagerDao();
//		String c_id="111100";
//		String con_id=request.getParameter("con_id");
//		if(con_id!=null){
//			c_id=con_id;
//		}
//		ConstructionSite con_site=constructionSiteDao.queryOne(c_id);
//		request.setAttribute("con_site", con_site);
		
		LinkedList<ConstructionSite> list_constructionSites = constructionSiteDao.queryByDistrict(id);	
		
		LinkedList<String> precincts=conDir.queryPrecinctInConDir();
		request.setAttribute("precincts", precincts);
		request.setAttribute("list_constructionSites", list_constructionSites);
		if (str_id == null) {
			request.getRequestDispatcher("monitoringcenter_admin.jsp").forward(
					request, response);
		} else {
			out.println("<table>");
			for (ConstructionSite c : list_constructionSites) {
				/* out.println("<script type='text/javascript'>");
				 out.println("function  dealConstructionSite(dist,street,company){");
				 out.println("aa.innerHTML=dist+street+company;");
				 out.println("}");		 
				 out.println("</script>");*/
				 out.println("<tr>");
				 out.println("<a  href=\"javascript:dealConstructionSite('"+c.getDistrict()+"','"+c.getStreet() +"','"+c.getCompany() +"')\">"+c.getName()+"</a>");
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
			HttpServletResponse response) throws ServletException, IOException 

{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 

{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
