<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录界面</title>
    <script src="../js/jquery-1.11.1.js"></script>
    <script src="../js/login.js"></script>
    <link href="../css/login-style.css" rel="stylesheet" type="text/css" />
<title>蓝天卫士-登录</title>
</head>
<body>
<div class="login">-
        <h2>郑州市建设施工现场安全监督管理系统</h2>
        <div class="login-top">
        	<h1>登录</h1>
        	<form action = "/bluesky/loginServlet">
            	<div class="loginform">
               	 	<div class="loginform_row">
                    	<label>用户名:</label>
                    	<input type="text" class="loginform_input" name="username" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}"/>
                	</div>
                	<div class="loginform_row">
                    	<label>密码:</label>
                    	<input type="password" class="loginform_input" name="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}"/>
                	</div>
                	<div class="loginform_row">
                    	<label>部门:</label><br>
                    	<select name="dept">
                    		<option select="selected" value="">请选择部门</option>
                    		<option value="LawEnforcingDeptAndAdmin">管理员</option>
                    		<option value="InspectionPersonnel">巡检科</option>
                    		<option value="LawEnforcingDeptAndAdmin">执法科</option>
                    		<option value="ConstructionSiteDirector">工地负责人</option>
                    	</select>
                	</div>
               		<div class = "loginform_row">
                    	<label>验证码:</label>
                    	<input type = "text" class="loginform_input_validationCode" name = "validationCode"/>
                    	<center><img class = "validationCode_img" src="/bluesky/validationCode"></center>
                	</div>
                	<div class="forgot">
	    				<a href="#">忘记密码</a>
	    				<input type="submit" class="loginform_submit" value="登录" >
	   				 </div>
            	</div>
        	</form>
        </div>
        <div class="login-bottom">
			Copyright &copy; 2015.特比佳 All rights reserved.
		</div>
    </div>
</body>
</html>