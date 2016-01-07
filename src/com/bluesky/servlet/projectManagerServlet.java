package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.bean.Con_Dir;
import com.bluesky.dao.ConstructionManagerDao;
import com.bluesky.tools.ConSite_Director;

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

		
		String precinct = "金水区";
		String str_precinct = request.getParameter("precinct");
		if (str_precinct != null) {
			precinct = str_precinct;
		}
		System.out.println(precinct);
		System.out.println(str_precinct);
		
		ConstructionManagerDao conDir = new ConstructionManagerDao();
		ConSite_Director conSite_Director=new ConSite_Director();
		ArrayList<String> precincts=conDir.queryPrecinctInConDir();
		System.out.println(precincts+"--------------------");
		ArrayList<Con_Dir> list_conDirs=conSite_Director.queryConInfo(precinct);
		request.setAttribute("precincts", precincts);
		//request.setAttribute("precinct", str_precinct);
		request.setAttribute("list_conDirs", list_conDirs);
		//request.getRequestDispatcher("projectManager.jsp").forward(request, response);
		if(str_precinct ==null){
			request.getRequestDispatcher("projectManager.jsp").forward(request, response);
		}else {
			out.println("<table width=\"100%\" class=\" table table-striped table-bordered  table-hover center\">");
			for(Con_Dir i : list_conDirs){
				out.println("<tr>");
				out.println("<td width="+20+"%"+">");
				out.println(i.getConName());
				out.println("</td>");
				out.println("<td width="+20+"%"+">");
				out.println("</td>");
				out.println("<td width="+30+"%"+">");
				out.println(i.getDirectorName());
				out.println("</td>");
				out.println("<td width="+30+"%"+">");
				out.println(i.getProgress());
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
