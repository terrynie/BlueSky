<%@page import="com.bluesky.bean.TaskList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function showImage(imgFile){
	var pattern= /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/; 
	if(!pattern.test(imgFile.value)){
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imgFile.focus();
	}else{
		var path;
		if(document.all){
			 imgFile.select(); 
		      path = document.selection.createRange().text; 
		      document.getElementById("imgPreview").innerHTML=""; 
		      document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + path + "\")";
		}
		else{
			path = URL.createObjectURL(imgFile.files[0]);
		      document.getElementById("imgPreview").innerHTML = "<img width='"+100+"'height='"+80+"' src='"+path+"'/>"; 
		}
	}
}
</script>
</head>
<body>
	<%
		Date date=new Date();
		long d=date.getTime();
	%>
	<form action="createTaskList"method="post">
		业务编号<input type="text"  disabled="disabled" value="<%=d%>">&nbsp;&nbsp;&nbsp;&nbsp;
			
			<input   name="id"type="hidden" value="<%=d %>">
		
		上传附件<input type="file" name="src" onchange="showImage(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<input type="submit" value="创建"><br>
		
		业务内容<br>
		<div style='width:100%; height:300px;'>
			<textarea name="content" rows="15%" cols="100%"><%=date.getYear()+1990%>/<%=date.getMonth()%>/<%=date.getDay()%></textarea> 
			<div id="imgPreview" style='width:100; height:80;'>	
   			</div>
		</div>
		<br><br>
	</form>
</body>
</html>