<%@page import="java.util.LinkedList,com.bluesky.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	%>
	<div id="body">
		<div id="body_table">
			<table>
				<tr>
					<td>工地名称</td>
					<td>
						<select  id="manager" style="width: 100%" onchange="changeSelect()">
							<% 
								for(String s:precincts){
							%>
							<option><%=s %></option>
							<% 
								}
							%>
						</select>
					</td>
					<td>负责人</td>
					<td>项目进度</td>
					<td>
						<input type="submit" value="添加">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div id="body_info">
			<table>
				<%
					for(Con_Dir c : list_conDirs){				
				%>
				<tr>
					<td><%=c.getConName() %></td>
					<td><%=c.getDirectorName() %></td>
					<td><%=c.getProgress() %></td>
				</tr>
				<%}%>
			</table>
		</div>
	</div>
</body>
</html>