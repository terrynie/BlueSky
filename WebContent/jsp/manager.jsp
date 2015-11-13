<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	var id=document.getElementById("manager").value;
	var url="monitoringcenter_adminServlet?id="+id;
	xmlHttp.onreadystatechange=callback;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
}
function callback(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			document.getElementById("monitoring").innerHTML="";
			document.getElementById("monitoring").innerHTML=xmlHttp.responseText;
		}
	}
} 
</script>
</head>
<body>
	<%
			
	%>
	<div id="body">
		<div id="body_table">
			<table>
				<tr>
					<td>姓名</td>
					<td>
						<select  id="manager" style="width: 100%" onchange="changeSelect()">
							<option></option>
						</select>
					</td>
					<td>科室</td>
					<td>联系方式</td>
					<td>
						<input type="submit" value="添加">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div id="body_info"></div>
	</div>
</body>
</html>