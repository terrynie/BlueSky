package com.bluesky.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.dao.ConstructionSiteDao;

/**
 * Servlet implementation class weixin_initServlet
 */
@WebServlet("/jsp/weixin_initServlet")
public class weixin_initServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public weixin_initServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String s1=null;
		String s2=null;
		ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
		LinkedList<String> str_district=constructionSiteDao.queryDistricts();
		for(String s : str_district){
			s1=s;
			break;
		}
		LinkedList<String> str_street=constructionSiteDao.queryStreetByDistrict(s1);
		for(String s : str_street){
			s2=s;
		}
		LinkedList<String> str_constructionId=constructionSiteDao.queryConSiteNameByStreet(s2);
		request.setAttribute("str_district", str_district);
		request.setAttribute("str_street", str_street);
		request.setAttribute("str_constructionId", str_constructionId);
		request.getRequestDispatcher("weixin.jsp").forward(request, response);
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
	}

}
