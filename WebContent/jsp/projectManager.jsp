<%@page import="java.util.LinkedList,com.bluesky.bean.*"%>
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
function changeSelect(){
	createXMLHttpRequest();
	var precinct=document.getElementById("manager").value;
	var url="projectManagerServlet?precinct="+precinct;
	xmlHttp.onreadystatechange=callback;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
}
function callback(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			document.getElementById("body_info").innerHTML="";
			document.getElementById("body_info").innerHTML=xmlHttp.responseText;
		}
	}
} 
</script>

<body>
	<%
		LinkedList<Con_Dir> list_conDirs=(LinkedList<Con_Dir>)request.getAttribute("list_conDirs");
		LinkedList<String> precincts=(LinkedList<String>)request.getAttribute("precincts");
		//String str_precinct = request.getParameter("precinct");
	%>
	<div id="body">
		<div id="body_table">
			<div class="tab_btn">
				<a src=""></a>
				<button class="button bg-sub 	button-small"  >添加</button>
			</div>
			<table width="100%" class="table  table-bordered  green center">
				<tr>
					<td width="20%">工地名称</td>
					<td width="20%">
						<span>所属</span>
						<select  id="manager" style="width: 50%" onchange="changeSelect()">
							<% 
								for(String s:precincts){
							%>
							<option><%=s %></option>
							<% 
								}
							%>
						</select>
					</td>
					<td width="30%">负责人</td>
					<td width="30%">项目进度</td>
					
				</tr>
			</table>
		</div>
		<div id="body_info">
			<table width="100%" class=" table table-striped table-bordered  table-hover center">
				<%
					for(Con_Dir c : list_conDirs){				
				%>
				<tr>
					<td width="20%"><%=c.getConName() %></td>
					<td width="20%"></td>
					<td width="30%"><%=c.getDirectorName() %></td>
					<td width="30%"><%=c.getProgress() %></td>
				</tr>
				<%}%>
			</table>
		</div>
	</div>
</body>
</html>