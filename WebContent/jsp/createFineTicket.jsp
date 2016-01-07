<%@page import="com.bluesky.bean.Notification"%>
<%@page import="com.bluesky.dao.NotificationDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
		NotificationDao notificationDao=new NotificationDao();
		ArrayList<Notification> list_notifications=notificationDao.queryNotifications();
	%>
	<center>
		<h1>罚单</h1>
		<hr>
		<form action="createFineTicketServlet" method="post">
		<table>
		<tr><td>罚单编号：</td><td><input type="text" name="id" readonly="readonly" value="<%=date.getTime()%>"></td></tr>
		<tr><td>通知编号：</td><td><select name="notificationId"><%for(Notification n : list_notifications){ %><option><%=n.getId() %></option><%} %></select></td></tr>
		<tr><td>施工单位：</td><td><input type="text" name="company"></td></tr>
		<tr><td>罚款金额：</td><td><input type="text" name="money"></td></tr>
		<tr><td>开具时间：</td><td><input type="text" name="startTime" readonly="readonly" value="<%=simpleDateFormat.format(date)%>"></td></tr>
		<tr><td>截止时间：</td><td><input type="text" onfocus='this.value=""' onblur='if(this.value==""){this.value="格式：YYYY-MM-DD"}' name="endTime" value="<%=simpleDateFormat.format(date)%>"></td><td>日期格式：YYYY-MM-DD（如实例所示）</td></tr>
		<tr><td>开单人员：</td><td><input type="text" name="who"></td></tr>	
		<tr><td></td><td><input type="submit" value="创建罚单"></td></tr>
		</table>
		
		</form>
	</center>
</body>
</html>