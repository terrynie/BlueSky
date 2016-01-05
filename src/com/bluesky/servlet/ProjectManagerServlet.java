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
import com.bluesky.dao.ConstructionManagerDao;
import com.bluesky.tools.ConSite_Director;

/**
 * Servlet implementation class projectManagerServlet
 */
@WebServlet("/jsp/projectManagerServlet")
public class ProjectManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectManagerServlet() {
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

		
		String precinct = "金水区";
		String str_precinct = request.getParameter("precinct");
		if (str_precinct != null) {
			precinct = str_precinct;
		}
		System.out.println(precinct);
		System.out.println(str_precinct);
		
		ConstructionManagerDao conDir = new ConstructionManagerDao();
		ConSite_Director conSite_Director=new ConSite_Director();
		LinkedList<String> precincts=conDir.queryPrecinctInConDir();
		System.out.println(precincts+"--------------------");
		LinkedList<Con_Dir> list_conDirs=conSite_Director.queryConInfo(precinct);
		request.setAttribute("precincts", precincts);
		request.setAttribute("precinct", str_precinct);
		request.setAttribute("list_conDirs", list_conDirs);
		request.getRequestDispatcher("projectManager.jsp").forward(request, response);
		
		
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
