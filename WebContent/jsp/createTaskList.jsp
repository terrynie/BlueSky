<%@page import="com.bluesky.bean.TaskList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap/zui.min.css"/>
<link rel="stylesheet" type="text/css" href="../css/style_.css"/>
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
			<div class="task_1">
				<div class="task-lab-1">
					<span>业务编号:</span><input type="text" class="form-control"   disabled="disabled" value="<%=d%>">
				</div>
				<div class="task-lab-2">
					<input   name="id"type="hidden" value="<%=d %>">
					<span>上传附件:</span>
					<input type="file" name="src" onchange="showImage(this)" />
				</div>
				<div class="task-lab-3"> <input type="submit" class="btn btn-primary" value="创建"></div>
			</div>
			<div class="task_2">
				 <div class="task_title"><span class= "label label-badge label-primary">业务内容</span> </div>
					<textarea name="content"  class="form-control" rows="5"><%=date.getYear()+1990%>/<%=date.getMonth()%>/<%=date.getDay()%></textarea> 
					<div id="imgPreview" style='width:100; height:80;'>	</div> 
			</div>
		<div class="foot-btn"><button class="btn btn-success">提交</button></div>
	</form>
</body>
</html>