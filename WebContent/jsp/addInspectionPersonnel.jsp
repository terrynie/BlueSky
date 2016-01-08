<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>添加巡检</h1>
	<hr>
	<div>
	<form action="addInspectionPersonnelServlet" method="post" class="table table-bordered">
	<table>
		<tr><td>姓名：</td><td><input type="text" name="name" ></td></tr>
		<tr><td>性别：</td><td><select name="sex"><option selected="selected">请选择性别</option><option>男</option><option>女</option></select></td></tr>
		<tr><td>科室：</td><td><select name="section"><option selected="selected">请选择科室</option><option>巡检一科</option><option>巡检二科</option><option>巡检三科</option><option>巡检四科</option></select></td></tr>
		<tr><td>辖区：</td><td><select name="precinct"><option selected="selected">请选择辖区</option><option>金水区</option><option>二七区</option><option>管城区</option><option>中原区</option><option>惠济区</option></select></td></tr>
		<tr><td>电话：</td><td><input type="text" name="tel"></td></tr>
		<tr><td>身份证号：</td><td><input type="text" name="idcardno"></td></tr>
		<tr><td>初始密码：</td><td><input type="text" name="pwd" readonly="readonly" value="123456"></td></tr>
	</table>
		<input type="submit" value="添加">
	</form>
	</div>
</center>
</body>
</html>