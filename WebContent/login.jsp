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
		<div class="login-content">
			<div class="login">
			<span>用户名</span>
			<input type="text" />
		</div>
		<div class="login">
		<span>密&nbsp;&nbsp;  &nbsp;码</span>
		<input type="password">
		</div>
		<div class="login">
			<span>部&nbsp;&nbsp; &nbsp;门</span>
			<select name="dept" style="width: 174px;">
            	<option select="selected" value="">请选择部门</option>
            	<option value="LawEnforcingDeptAndAdmin">管理员</option>
            	<option value="InspectionPersonnel">巡检科</option>
            	<option value="LawEnforcingDeptAndAdmin">执法科</option>
            	<option value="ConstructionSiteDirector">工地负责人</option>
       	    </select>
		</div>
		<div class="footer-btn">
			<input type="button" class="btn btn-primary" value="&nbsp;登录&nbsp;" />
		</div>
		</div>
		
		</div>
	</div>
</body>
</html>