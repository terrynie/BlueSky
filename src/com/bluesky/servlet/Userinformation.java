package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluesky.bean.Admin;
import com.bluesky.dao.AdminDao;

/**
 * Servlet implementation class Userinformation
 */
@WebServlet("/jsp/Userinformation")
public class Userinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Userinformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String flag = request.getParameter("flag");
		String id = request.getParameter("id");
		String passwdpage = request.getParameter("passwdpage");
		Admin admin = new Admin();
		AdminDao adminDao = new AdminDao();
		if (flag.equals("ini")) {
			admin = adminDao.queryOne(id);
			System.out.println(admin.getName());

		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String telphone = request.getParameter("telphone");
			String idcardno = request.getParameter("idcardno");
			if (username != null) {
				admin = adminDao.queryOne(id);
				admin.setId(id);
				admin.setName(username);
				admin.setTel(telphone);
				admin.setIdCardNo(idcardno);
			}
			if (password != null) {
				admin.setPassword(password);
//				adminDao.updatePasswd(id, password);
				System.out.println("passwd change success!");
			}
			adminDao.updateAdmin(admin);
			System.out.println("infomation change success!");
		}
		request.setAttribute("admininfo", admin);
		if (passwdpage == null) {
			request.getRequestDispatcher("userinformation.jsp").forward(
					request, response);
		}else if (passwdpage.equals("checkpasswd")) {
			String pw=request.getParameter("inipasswd");
			admin = adminDao.queryOne(id);
			System.out.println("pw:"+pw);
			if(!pw.equals(admin.getPassword())){
				out.print("false");	
			}else {
				out.print("true");	
			}
			
		} else {
			out.println("<td height=\"100px\" colspan=\"2\" ><p style=\"margin-left:250px;font-weight:bold;\">原始密码：");
			out.println("<input type=\"password\" name=\"inipassword\" id=\"inipassword\" onblur=\"checkpw('"+id+"')\" AUTOCOMPLETE=\"off\"/><font id=\"pwcheck\" color='red'></font> </p>");
			out.println("<p style=\"margin-left:250px;font-weight:bold;\">新的密码：");
			out.println("<input type=\"password\" name=\"password\" id=\"password\" AUTOCOMPLETE=\"off\"/></p>");
			out.println("<p style=\"margin-left:250px;font-weight:bold;\">重复密码：<input type=\"password\" onkeyup=\"insurepad()\" name=\"password2\" id=\"password2\"  AUTOCOMPLETE=\"off\"/><span id=\"show\"></span></p></th>");
			System.out.println("<p>重复密码：<input type=\"password\" onkeyup=\"insurepad()\" name=\"password2\" /></p><span id=\"show\"></span></td>");
			//out.println("<td width=\"168\"><input type=\"text\" name=\"confimpasswd\" /></td></tr>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
