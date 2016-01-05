package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.dao.ConstructionSiteDao;

/**
 * Servlet implementation class weixin_selectFirServlet
 */
@WebServlet("/jsp/weixin_selectFirServlet")
public class Weixin_selectFirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Weixin_selectFirServlet() {
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
		PrintWriter out=response.getWriter();
		
		String district=request.getParameter("district");
		String street=null;
		ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
		LinkedList<String> str_district=constructionSiteDao.queryDistricts();
		LinkedList<String> str_street=constructionSiteDao.queryStreetByDistrict(district);
		for(String s : str_street){
			street=s;
		}
		LinkedList<String> str_constructionId=constructionSiteDao.queryConSiteNameByStreet(street);
		out.println("选择工地");
		out.println("<select id='select_district' onchange='changeSelect_fir()'>");
		out.println("<option>");
		out.println(district);
		out.println("</option>");
		for(String s : str_district){ 
			if(s.equals(district)){
				continue;
			}else{
				out.println("<option>");
				out.println(s);
				out.println("</option>");
			}
		}
		out.println("</select>");
		out.println("<select id='select_street' onchange='changeSelect_sec()'>");
		for(String s1 : str_street){
			out.println("<option>");
			out.println(s1);
			out.println("</option>");
		}
		out.println("</select>");
		out.println("<select id='select_constructionId'>");
		for(String s : str_constructionId){
			out.println("<option>");
			out.println(s);
			out.println("</option>");
		}
		out.println("</select>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
