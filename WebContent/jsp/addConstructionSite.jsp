<%@page import="com.bluesky.dao.ConstructionSiteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/pintuer.css"/>
	<link rel="stylesheet" type="text/css" href="../css/manager.css"/>
<title>Insert title here</title>
</head>
<body>
<% 
	ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
%>
<center>
	<h1>添加工地</h1>
	<hr>
	<div class="addDiv">
	<form action="addConstructionSiteServlet" method="post">
	<table class="table table-bordered">
		<tr><td rowspan="17"></td><td colspan="2"><center><h3>工地</h3></center></td><td colspan="2"><center><h3>负责人</h3></center></td><td rowspan="17"></td></tr>
		<tr><th width="10%">工地编号：</th><td width="25%"><input type="text" class="input" name="id" readonly="readonly" value="<%=constructionSiteDao.qureyNumOfConSites()+1 %>"></td><th width="10%">负责人编号：</th><td width="25%"><input type="text" class="input" name="directorId" ></td></tr>
		<tr><th>项目名称：</th><td><input type="text" class="input" name="projectName" ></td><th>负责人姓名：</th><td><input type="text"  class="input" name="directorName"></td></tr>
		<tr><th>工地名称：</th><td><input type="text" class="input" name="name" ></td><th>负责人性别：</th><td><select name="sex" style="width: 100%; height: 32px;"><option>请选择性别</option><option>男</option><option>女</option></select></td></tr>
		<tr><th>工地面积：</th><td><input type="text" class="input" name="area" ></td><th>负责人电话：</th><td><input type="text" class="input" name="tel"></td></tr>
		<tr><th>开始日期：</th><td><input type="text" class="input" name="startTime" onfocus='this.value=""' onblur='if(this.value==""){this.value="格式：YYYY-MM-DD"}' value="格式：YYYY-MM-DD"></td><th>身份证号:</th><td><input class="input" type="text" name="idCardNo"></td></tr>
		<tr><th>完成日期：</th><td><input type="text" class="input" name="completeTime" onfocus='this.value=""' onblur='if(this.value==""){this.value="格式：YYYY-MM-DD"}' value="格式：YYYY-MM-DD"></td><th>所属公司：</th><td><input class="input" type="text" name="company" ></td></tr>
		<tr><th>工程层数：</th><td><input type="text" class="input" name="totalFloors" ></td><th>初始密码：</th><td><input type="text" name="pwd" readonly="readonly" class="input" value="123456"></td></tr>
		<tr><th>所属区：</th><td><input type="text" class="input" name="district" ></td><td></td><td></td></tr>
		<tr><th>所属街道：</th><td><input type="text" class="input" name="street" ></td><td></td><td></td></tr>
		<tr><th>经度：</th><td><input type="text" class="input"></td><td></td><td></td></tr>
		<tr><th>纬度：</th><td><input type="text" class="input"></td><td></td><td></td></tr>
		<tr><th>工程结构：</th><td><input type="text" class="input" name="struct" ></td><td></td><td></td></tr>	
		<tr><th>工程造价：</th><td><input type="text" class="input" name="price" ></td><td></td><td></td></tr>
		<tr><th>监控数量：</th><td><input type="text" class="input" name="totalMonitors" ></td><td></td><td></td></tr>
		<tr><th>工程进度</th><td><input type="text" class="input" name="progress" ></td><td></td><td></td></tr>
		<tr><td colspan="4"><input type="submit" class="button bg-sub" value="添加"></td></tr>
	</table>
	</form>
	</div>
</center>
</body>
</html>