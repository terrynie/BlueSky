package com.bluesky.servlet;
import com.bluesky.dao.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import com.bluesky.tools.*;

public class LoginServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
  		resp.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String validationCode = req.getParameter("validationCode");
        String dept = req.getParameter("dept");
        Boolean validationCodeRightOrNot = null;

        HttpSession session = req.getSession();
// 		  //下边功能是验证码
//        String validation_code = (String)session.getAttribute("validation_code");
       
//        if(validationCode.equalsIgnoreCase(validation_code)){
//        	validationCodeRightOrNot = true;
//        }else{
//        	validationCodeRightOrNot = false;
//        	out.println("<html>");
//      		out.println("<script type='text/javascript'>");
//      		out.println("alert('验证码错误!')");
//      		out.println("</script></html>");
//      		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//            rd.forward(req, resp);
//        }
        if (username.equals("")||username.equals("用户名")) {
        	out.println("<!DOCTYPE html>");
            out.println("<html>");
      		out.println("<script type='text/javascript'>");
      		out.println("alert('请输入用户名!')");
      		out.println("</script></html>");
      		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
		}else if(password.equals("")||password.equals("password")){
			out.println("<!DOCTYPE html>");
            out.println("<html>");
      		out.println("<script type='text/javascript'>");
      		out.println("alert('请输入密码!')");
      		out.println("</script></html>");
      		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
		}else if(dept.equals("")||dept.equals("password")){
			out.println("<!DOCTYPE html>");
            out.println("<html>");
      		out.println("<script type='text/javascript'>");
      		out.println("alert('请选择部门!')");
      		out.println("</script></html>");
      		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
		}
        System.out.println(dept+"\n"+username+"\n"+password);
        CheckUser mss = new CheckUser();
        
        String result = mss.checkUser(dept,username,password);
        
        if (result.equals("hasUserNameAndPasswordCorrect")) {
        	out.println("<!DOCTYPE html>");
            out.println("<html>");
      		out.println("<script type='text/javascript'>");
      		out.println("alert('登录成功!')");
      		out.println("</script></html>");
      		
      		if(dept.equals("Admin")){
      			
      			//跳转至管理员界面
      			RequestDispatcher rd = req.getRequestDispatcher("");
                rd.forward(req, resp);
      		}else if(dept.equals("InspectionPersonnel")){
      			//跳转至巡检科界面
      			RequestDispatcher rd = req.getRequestDispatcher("");
                rd.forward(req, resp);
      		}else if(dept.equals("LawEnforcingDept")){
      			//跳转至执法科界面
      			RequestDispatcher rd = req.getRequestDispatcher("");
                rd.forward(req, resp);
      		}else if(dept.equals("ConstructionSiteDirector")){
      			//跳转至工地负责人界面
      			RequestDispatcher rd = req.getRequestDispatcher("");
                rd.forward(req, resp);
      		}
            
        } else if (result.equals("hasUserNameButPasswordInCorrect")) {
      		RequestDispatcher rd = req.getRequestDispatcher("error/usernameErrorPage.jsp");
            rd.forward(req, resp);
        } else if (result.equals("hasNoUserName")) {
        	
        	out.println("<html>");
      		out.println("<script type='text/javascript'>");
      		out.println("alert('该用户不存在，请输入正确的用户名!')");
      		out.println("</script></html>");
      		RequestDispatcher rd = req.getRequestDispatcher("error/usernameErrorPage.jsp");
            rd.forward(req, resp);
        }
      
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

