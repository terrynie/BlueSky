<%@page import="com.bluesky.dao.ConstructionSiteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	ConstructionSiteDao constructionSiteDao=new ConstructionSiteDao();
%>
<center>
	<h1>添加工地</h1>
	<hr>
	<div>
	<form action="addConstructionSiteServlet" method="post">
	<table>
		<tr><td colspan="2"><center><h3>工地</h3></center></td><td colspan="2"><center><h3>负责人</h3></center></td></tr>
		<tr><td>工地编号：</td><td><input type="text" name="id" readonly="readonly" value="<%=constructionSiteDao.qureyNumOfConSites()+1 %>"></td><td>负责人编号：</td><td><input type="text" name="directorId" ></td></tr>
		<tr><td>项目名称：</td><td><input type="text" name="projectName" ></td><td>负责人姓名：</td><td><input type="text" name="directorName"></td></tr>
		<tr><td>工地名称：</td><td><input type="text" name="name" ></td><td>负责人性别：</td><td><select name="sex"><option>请选择性别</option><option>男</option><option>女</option></select></td></tr>
		<tr><td>工地面积：</td><td><input type="text" name="area" ></td><td>负责人电话：</td><td><input type="text" name="tel"></td></tr>
		<tr><td>开始日期：</td><td><input type="text" name="startTime" onfocus='this.value=""' onblur='if(this.value==""){this.value="格式：YYYY-MM-DD"}' value="格式：YYYY-MM-DD"></td><td>身份证号:</td><td><input type="text" name="idCardNo"></td></tr>
		<tr><td>完成日期：</td><td><input type="text" name="completeTime" onfocus='this.value=""' onblur='if(this.value==""){this.value="格式：YYYY-MM-DD"}' value="格式：YYYY-MM-DD"></td><td>所属公司：</td><td><input type="text" name="company" ></td></tr>
		<tr><td>工程层数：</td><td><input type="text" name="totalFloors" ></td><td>初始密码：</td><td><input type="text" name="pwd" readonly="readonly" value="123456"></td></tr>
		<tr><td>所属区：</td><td><input type="text" name="district" ></td></tr>
		<tr><td>所属街道：</td><td><input type="text" name="street" ></td></tr>
		<tr><td>经度：</td><td><input type="text"></td></tr>
		<tr><td>纬度：</td><td><input type="text"></td></tr>
		<tr><td>工程结构：</td><td><input type="text" name="struct" ></td></tr>
		<tr><td>工程造价：</td><td><input type="text" name="price" ></td></tr>
		<tr><td>监控数量：</td><td><input type="text" name="totalMonitors" ></td></tr>
		<tr><td>工程进度</td><td><input type="text" name="progress" ></td></tr>
	</table>
		<input type="submit" value="添加">
	</form>
	</div>
</center>
</body>
</html>