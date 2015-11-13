package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.ConstructionSite;
import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.dao.ConstructionSiteDao;
import com.bluesky.dao.InspectionPersonnelDao;

/**
 * Servlet implementation class managerServlet
 */
@WebServlet("/jsp/managerServlet")
public class managerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerServlet() {
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
		PrintWriter out = response.getWriter();
		
		String precinct = "金水区";
		String str_precinct = request.getParameter("precinct");
		if (str_precinct != null) {
			precinct = str_precinct;
		}
		System.out.println(precinct);
		System.out.println(str_precinct);
		InspectionPersonnelDao inspectionPersonnelDao=new InspectionPersonnelDao();
		LinkedList<InspectionPersonnel> list_inspeInspectionPersonnels= inspectionPersonnelDao.queryInspectors();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
