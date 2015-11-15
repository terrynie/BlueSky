<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/login.css">


<title>Insert title here</title>
</head>
<body>
<div class="content" >
	<div class="login-box">
	<form id="form" action="">
		<div class="login-content">
			<div class="login">
			<span>用户名</span>
			<input type="text" name="username" id="username" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}"/>
		</div>
		<div class="login">
		<span>密&nbsp;&nbsp;  &nbsp;码</span>
		<input type="password" name="password" id="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
		</div>
		<div class="login">
			<span>部&nbsp;&nbsp; &nbsp;门</span>
			<select  id="dept" name="dept" style="width: 174px;">
            	<option selected="selected" value="">请选择部门</option>
            	<option value="Admin">管理员</option>
            	<option value="InspectionPersonnel">巡检科</option>
            	<option value="LawEnforcingDept">执法科</option>
            	<option value="ConstructionSiteDirector">工地负责人</option>
       	    </select>
		</div>
		<div class="footer-btn">
			<input type="submit" class="btn btn-primary" value="&nbsp;登录&nbsp;" onclick="checkInput();return false;"/>
		</div>
	</form>
		
		
		</div>
		
		</div>
		<script type="text/javascript">
			function checkInput(){
				if(document.getElementById("username").value == '' || document.getElementById("username").value == '用户名' ){
					alert("请输入用户名！");
				}else if (document.getElementById("password").value == ""||document.getElementById("password").value =="password"){
					alert("请输入密码！");
				}else if(document.getElementById("dept").value == ""){
					alert("请选择部门！");
				}else {
					 document.getElementById("form").action="loginservlet";				 
					 document.getElementById("form").submit();
				}
			}
		</script>
</div>
</body>
</html>