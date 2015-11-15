package com.bluesky.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.ConstructionManager;
import com.bluesky.bean.ConstructionSite;
import com.bluesky.dao.ConstructionManagerDao;
import com.bluesky.dao.ConstructionSiteDao;

import sun.nio.cs.SingleByte;

/**
 * Servlet implementation class addConstructionSiteServlet
 */
@WebServlet("/jsp/addConstructionSiteServlet")
public class addConstructionSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addConstructionSiteServlet() {
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
		
		String directorId=request.getParameter("directorId");
		String directorName=request.getParameter("directorName");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("tel");
		String idCardNo=request.getParameter("idCardNo");
		String company=request.getParameter("company");
		String pwd=request.getParameter("pwd");
		String id=request.getParameter("id");
		String projectName=request.getParameter("projectName");
		String name=request.getParameter("name");
		double area=Double.parseDouble(request.getParameter("area"));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = null;
		try {
			startTime = new Date(simpleDateFormat.parse(request.getParameter("startTime")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date completeTime = null;
		try {
			completeTime = new Date(simpleDateFormat.parse(request.getParameter("completeTime")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int totalFloors=Integer.parseInt(request.getParameter("totalFloors"));
		String district=request.getParameter("district");
		String street=request.getParameter("street");
		String struct=request.getParameter("struct");
		double price=Double.parseDouble(request.getParameter("price"));
		int totalMonitors=Integer.parseInt(request.getParameter("totalMonitors"));
		String progress=request.getParameter("progress");
		
		ConstructionSite constructionSite=new ConstructionSite();
		ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
		constructionSite.setArea(area);
		constructionSite.setCompany(company);
		constructionSite.setCompleteTime(completeTime);
		constructionSite.setDirectorId(directorId);
		constructionSite.setDistrict(district);
		constructionSite.setId(id);
		constructionSite.setName(name);
		constructionSite.setPrice(price);
		constructionSite.setProgress(progress);
		constructionSite.setProjectName(projectName);
		constructionSite.setStartTime(startTime);
		constructionSite.setStreet(street);
		constructionSite.setStruct(struct);
		constructionSite.setTotalFloors(totalFloors);
		constructionSite.setTotalMonitors(totalMonitors);
		constructionSiteDao.addConSite(constructionSite);
		ConstructionManager constructionManager=new ConstructionManager();
		ConstructionManagerDao constructionManagerDao=new ConstructionManagerDao();
		constructionManager.setCompany(company);
		constructionManager.setConstructionId(id);
		constructionManager.setId(directorId);
		constructionManager.setIdCardNo(idCardNo);
		constructionManager.setName(directorName);
		constructionManager.setPassword(pwd);
		constructionManager.setSex(sex);
		constructionManager.setTel(tel);
		constructionManagerDao.addManager(constructionManager);
		request.getRequestDispatcher("addConstructionSite.jsp").forward(request, response);
	}

}
