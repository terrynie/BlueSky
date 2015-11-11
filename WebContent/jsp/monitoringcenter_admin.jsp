<%@page import="java.util.LinkedList,com.bluesky.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/monitoringcenter_admin.css" type="text/css"/>
<script src="../js/SpryAccordion.js" type="text/javascript"></script>
<link href="../css/SpryAccordion.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
function nTabs(thisObj,Num){
	if(thisObj.className == "active")return;
	var tabList = document.getElementById("ul_style3").getElementsByTagName("li");
	for(i=0; i <tabList.length; i++)
	{
	  if (i == Num)
	  {
	   thisObj.className = "active"; 
	      document.getElementById("data_"+i).style.display = "block";
	  }else{
	   tabList[i].className = "normal"; 
	   document.getElementById("data_"+i).style.display = "none";
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
function changeSelect(){
	createXMLHttpRequest();
	var id=document.getElementById("constructionsite").value;
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
<body id="body">
<% 
	LinkedList<ConstructionSite> list_constructionSites=(LinkedList<ConstructionSite>)request.getAttribute("list_constructionSites");
	ConstructionSite constructionSite=(ConstructionSite)request.getAttribute("constructionSite");
	int totalMonitors=constructionSite.getTotalMonitors();
%>
<div id="data">
	<div id="data_0">
		<div class="data_data_video"></div>
		<div class="data_data_pm">
		<div id="data_data_pm_top" style="height:165px"></div>
		<div id="data_data_pm_bm">
		<iframe id="data_data_pm_bm_frame" src="smoothie.html"scrolling="no" width="100%" height="110px"></iframe>
		</div>
		</div>
		<div class="data_data_select">
		<select id="constructionsite" style="width: 100%" onchange="changeSelect()">
				<%for(ConstructionSite c : list_constructionSites){%>
				<option value="<%=c.getId() %>"><%=c.getName() %></option>
				<%} %>
			</select><div id="monitoring" style="OVERFLOW-Y:auto;PADDING-LEFT:10px;SCROLLBAR-FACE-COLOR:#ffffff;FONT-SIZE:11pt;PADDING-BOTTOM:0px;SCROLLBAR-HIGHLIGHT-COLOR:#ffffff;OVERFLOW:auto;WIDTH:90%;SCROLLBAR-SHADOW-COLOR:#919192;COLOR:#000000;SCROLLBAR-3DLIGHT-COLOR:#ffffff;LINE-HEIGHT:100%;SCROLLBAR-ARROW-COLOR:#919192;PADDING-TOP:0px;SCROLLBAR-TRACK-COLOR:#ffffff;FONT-FAMILY:宋体;SCROLLBAR-DARKSHADOW-COLOR:#ffffff;LETTER-SPACING:1pt;HEIGHT:255px;TEXT-ALIGN:left">
			<table>
			<%for(int i=1;i<=totalMonitors;i++){ %>
				<tr><%=i %>号监控</tr><br>
				<%} %>
			</table>
			</div>
		</div>
	</div>
	<div id="data_1" class="none">	
	</div>
	<div class="data_ul">
		<ul id="ul_style3">
			<li class="active" onclick="nTabs(this,0);">监控数据</li>
			<li class="normal" onclick="nTabs(this,1);">地图</li>
		</ul>
	</div>
	<div id="data_bm">
	
	</div>
	
</div>
</body>
</html>