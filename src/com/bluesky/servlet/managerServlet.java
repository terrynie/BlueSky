package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.bean.InspectionPersonnel;
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
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String precinct = "二七区";
		String str_precinct = request.getParameter("precinct");
		if (str_precinct != null) {
			precinct = str_precinct;
		}
		//System.out.println(precinct);
		//System.out.println(str_precinct);
		
		
		
		InspectionPersonnelDao inspectionPersonnel = new InspectionPersonnelDao();
	
		ArrayList<String> precincts=inspectionPersonnel.queryPrecinct();
		System.out.println(precincts+"--------------------");
		ArrayList<InspectionPersonnel> list_inspectionPersonnels=inspectionPersonnel.queryInspByPrecinct(precinct);
		request.setAttribute("precincts", precincts);
//		request.setAttribute("precinct", str_precinct);
		request.setAttribute("list_inspectionPersonnels", list_inspectionPersonnels);
		//request.getRequestDispatcher("manager.jsp").forward(request, response);
		if(str_precinct ==null){
			request.getRequestDispatcher("manager.jsp").forward(request, response);
		}else {
			out.println("<table width=\"100%\" class=\" table table-striped table-bordered  table-hover center\">");
			for(InspectionPersonnel i : list_inspectionPersonnels){
				out.println("<tr>");
				out.println("<td width="+20+"%"+">");
				out.println(i.getName());
				out.println("</td>");
				out.println("<td width="+20+"%"+">");
				out.println("</td>");
				out.println("<td width="+30+"%"+">");
				out.println(i.getSection());
				out.println("</td>");
				out.println("<td width="+30+"%"+">");
				out.println(i.getTel());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
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
