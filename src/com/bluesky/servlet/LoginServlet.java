package com.bluesky.servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String dept = req.getParameter("dept");
        
//      String validationCode = req.getParameter("validationCode");
//        Boolean validationCodeRightOrNot = null;

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
        
        
//        //验证是否填写表单
//        if (username.equals("")||username.equals("用户名")) {
//        	//如需提示，只需将请求转发至“error/noUser.jsp”即可
//        	resp.sendRedirect("login.jsp");
//		}else if(password.equals("")||password.equals("password")){
//			//如需提示，只需将请求转发至“error/noPasswd.jsp”即可
//      		resp.sendRedirect("login.jsp");
//		}else if(dept.equals("")){
//			//如需提示，只需将请求转发至“error/noDept.jsp”即可
//			resp.sendRedirect("login.jsp");
//		}
        //验证账号信息
        
        String result = CheckUser.checkUser(dept,username,password);
        
        //没有从数据库获取到信息
        if(result==null){
        	RequestDispatcher rd = req.getRequestDispatcher("error/usernameErrorPage.jsp");
            rd.forward(req, resp);
        }
        //用户名和密码均正确
        else if (result.equals("hasUserNameAndPasswordCorrect")) {
        	session.setAttribute("dept", dept);
      		if(dept.equals("Admin")){
      			//跳转至管理员界面
      			RequestDispatcher rd = req.getRequestDispatcher("index-bluesky.jsp");
                rd.forward(req, resp);
      		}else if(dept.equals("InspectionPersonnel")){
      			//跳转至巡检科界面
      			RequestDispatcher rd = req.getRequestDispatcher("index-bluesky.jsp");
                rd.forward(req, resp);
      		}else if(dept.equals("LawEnforcingDept")){
      			//跳转至执法科界面
      			RequestDispatcher rd = req.getRequestDispatcher("index-bluesky.jsp");
                rd.forward(req, resp);
      		}else if(dept.equals("ConstructionSiteDirector")){
      			//跳转至工地负责人界面
      			RequestDispatcher rd = req.getRequestDispatcher("index-bluesky.jsp");
                rd.forward(req, resp);
      		}
            
        } else if (result.equals("hasUserNameButPasswordInCorrect")) {
      		RequestDispatcher rd = req.getRequestDispatcher("error/usernameErrorPage.jsp");
            rd.forward(req, resp);
        } else if (result.equals("hasNoUserName")) {
      		RequestDispatcher rd = req.getRequestDispatcher("error/usernameErrorPage.jsp");
            rd.forward(req, resp);
        }
      
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

