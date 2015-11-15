package com.bluesky.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.dao.InspectionPersonnelDao;

/**
 * Servlet implementation class addInspectionPersonnelServlet
 */
@WebServlet("/jsp/addInspectionPersonnelServlet")
public class addInspectionPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addInspectionPersonnelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		InspectionPersonnelDao inspectionPersonnelDao=new InspectionPersonnelDao();
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String section=request.getParameter("section");
		String precinct=request.getParameter("precinct");
		String tel=request.getParameter("tel");
		String idcardno=request.getParameter("idcardno");
		String pwd=request.getParameter("pwd");
		int id=inspectionPersonnelDao.qureyNumOfInspectors()+1;
		String idString="555"+id;
		InspectionPersonnel inspectionPersonnel=new InspectionPersonnel();
		inspectionPersonnel.setId(idString);
		inspectionPersonnel.setIdCardNo(idcardno);
		inspectionPersonnel.setName(name);
		inspectionPersonnel.setPassword(pwd);
		inspectionPersonnel.setPrecinct(precinct);
		inspectionPersonnel.setSection(section);
		inspectionPersonnel.setSex(sex);
		inspectionPersonnel.setTel(tel);
		inspectionPersonnelDao.addManager(inspectionPersonnel);
		request.getRequestDispatcher("addInspectionPersonnel.jsp").forward(request, response);
	}

}
