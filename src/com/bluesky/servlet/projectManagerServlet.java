package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.Con_Dir;
import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.tools.ConSite_Director;
import com.bluesky.tools.QueryByPrecincts;
import com.bluesky.tools.QueryPrecinctInConDir;
import com.bluesky.tools.QueryPrecincts;

/**
 * Servlet implementation class projectManagerServlet
 */
@WebServlet("/jsp/projectManagerServlet")
public class projectManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectManagerServlet() {
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
		System.out.println(precinct);
		System.out.println(str_precinct);
		
		QueryPrecinctInConDir queryPrecinctInConDir=new QueryPrecinctInConDir();
		ConSite_Director conSite_Director=new ConSite_Director();
		LinkedList<String> precincts=queryPrecinctInConDir.queryPrecinctInConDir();
		System.out.println(precincts+"--------------------");
		LinkedList<Con_Dir> list_conDirs=conSite_Director.queryConInfo(precinct);
		request.setAttribute("precincts", precincts);
		request.setAttribute("list_conDirs", list_conDirs);
		//request.getRequestDispatcher("manager.jsp").forward(request, response);
		if(str_precinct ==null){
			request.getRequestDispatcher("projectManager.jsp").forward(request, response);
		}else {
			out.println("<table width="+100+"%"+">");
			for(Con_Dir c : list_conDirs){
				out.println("<tr>");
				out.println("<td width="+30+"%"+">");
				out.println(c.getConName());
				out.println("</td>");
				out.println("<td width="+30+"%"+">");
				out.println(c.getDirectorName());
				out.println("</td>");
				out.println("<td width="+30+"%"+">");
				out.println(c.getProgress());
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
	}

}
