<%@page import="java.util.LinkedList"%>
<%@page import="com.bluesky.bean.ConstructionSite"%>
<%@page import="com.bluesky.dao.ConstructionSiteDao"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;"  />
<title>Insert title here</title>
</head>

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
<script type="text/javascript">
var xmlHttp=false;

function createXMLHttpRequest() {
 if(window.XMLHttpRequest) {
  xmlHttp = new XMLHttpRequest();
 } else if(window.ActiveXObject) {
  try{
	  xmlHttp=new ActiveXObject("Msxm12.XMLHTTP");
  }catch(e){
	  try{
		  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }catch(e){}  
  }
 }
}
function changeSelect_fir(){
	createXMLHttpRequest();
	var district=document.getElementById("select_district").value;
	var url="weixin_selectFirServlet?district="+district;
	xmlHttp.onreadystatechange=callback_fir;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
}
function callback_fir(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			document.getElementById("select").innerHTML="";
			document.getElementById("select").innerHTML=xmlHttp.responseText;
		}
	}
} 
function changeSelect_sec(){
	createXMLHttpRequest();
	var district=document.getElementById("select_district").value;
	var street=document.getElementById("select_street").value;
	var url="weixin_selectSecServlet?district="+district+"&street="+street;
	xmlHttp.onreadystatechange=callback_sec;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
}
function callback_sec(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			document.getElementById("select").innerHTML="";
			document.getElementById("select").innerHTML=xmlHttp.responseText;
		}
	}
} 
</script>

<body>
	<h1>微信举报</h1>
	<%
		Date date=new Date();
		long d=date.getTime();
		LinkedList<String> str_district=(LinkedList<String>)request.getAttribute("str_district");
		LinkedList<String> str_street=(LinkedList<String>)request.getAttribute("str_street");
		LinkedList<String> str_constructionId=(LinkedList<String>)request.getAttribute("str_constructionId");
	%>
	<form action="weixin_infoServlet"method="post">
		业务编号<input type="text"  disabled="disabled" value="<%=d%>">&nbsp;&nbsp;&nbsp;&nbsp;
			
			<input   name="id"type="hidden" value="<%=d %>">
		
		上传附件<input type="file" name="src" onchange="showImage(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<input type="submit" value="创建"><br>
		<div id="select">
			选择工地
			<select name="select_district" onchange="changeSelect_fir()">
			<%for(String s : str_district){ %>
				<option><%=s %></option>
			<%} %>
			</select>
			<select name="select_street" onchange="changeSelect_sec()">
			<%for(String s : str_street){ %>
				<option><%=s %></option>
			<%} %>
			</select>
			<select name="select_constructionId">
			<%for(String s : str_constructionId){ %>
				<option><%=s %></option>
			<%} %>
			</select>
		</div>
		<br>
		业务内容<br>
		<div style='width:100%; height:300px;'>
			<textarea name="content" rows="15%" cols="80%"></textarea> 
			<div id="imgPreview" style='width:100; height:80;'>	
   			</div>
		</div>
		<br><br>
	</form>
</body>
</html>