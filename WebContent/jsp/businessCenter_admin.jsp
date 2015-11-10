<%@page import="com.bluedsky.bean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/businessCenter_admin.css"
	type="text/css" />
<script src="../js/SpryAccordion.js" type="text/javascript"></script>
<link href="../css/SpryAccordion.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function tab_list(thisObj, n) {
		if (thisObj.className == "active")
			return;
		var tabList = document.getElementById("ul_style4")
				.getElementsByTagName("li");
		for (i = 0; i < tabList.length; i++) {
			if (i == n) {
				thisObj.className = "active";
				document.getElementById("list_data" + i).style.display = "block";
			} else {
				tabList[i].className = "normal";
				document.getElementById("list_data" + i).style.display = "none";
			}
		}
	}
</script>	
<script type="text/javascript">
function search(){
}
</script>
</head>
<body id="body">
	<%
		int count_notifiction=((Integer)request.getAttribute("count_notifiction")).intValue();
		LinkedList<Notification> perNotifictions=(LinkedList<Notification>)request.getAttribute("perNotifictions");
		int initpage=1;
		if(request.getParameter("page_notifiction")!=null){
		 initpage=Integer.parseInt(request.getParameter("page_notifiction"));
		}
	%>
	<div id="list">
		<div class="list_ul">
			<label>业务中心</label>
			<!-- <form action="businessCenter_adminServclet" method="post">
				<input type="text" name="search_input">
				<input type="submit" value="搜索" name="search_sub" onclick="search();">
			</form> -->
			<ul id="ul_style4">
				<li class="active" onclick="tab_list(this,0);">待办事物</li>
				<li class="normal" onclick="tab_list(this,1);">已处理</li>
				<li class="normal" onclick="tab_list(this,2);">通知</li>
				<li class="normal" onclick="tab_list(this,3);">微信数据</li>
				<li class="normal" onclick="tab_list(this,4);">创建业务</li>
			</ul>
		</div>
		<div class="list_data">
			<div id="list_data0">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<% for(Notification n :perNotifictions){ %>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<td>任务简报</td>
									<td>附件</td>
								</tr>
								<tr>
									<td><%=n.getId() %></td>
									<td><%=n.getAccordingTo() %></td>
									<td><%=n.getContent() %></td>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent"><%=n.getContent() %></div>
					</div>
					<% }%>
				</div>

				<center>
					<form name="list_notifiction" method="GET">
						<%
						for(int i=initpage-1,k=1;k<=3;i++,k++){
								if(i==0){
									k--;
									continue;
								}
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i%>">[<%=i%>]
						</a>
						<%
						if(i>count_notifiction-1){
							if(i==count_notifiction-2){
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i-2%>">[<%=i-2%>]
						</a>
						<%		}
							break;
						}else{
							if(k==3){
					%>
						...<a
							href="businessCenter_adminServclet?page_notifiction=<%=count_notifiction%>">[<%=count_notifiction%>]
						</a>
						<%}
						}
							}
					%>


					</form>
				</center>
			</div>
			<div id="list_data1" class="none">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<% for(Notification n :perNotifictions){ %>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<td>任务简报</td>
									<td>附件</td>
								</tr>
								<tr>
									<td><%=n.getId() %></td>
									<td><%=n.getAccordingTo() %></td>
									<td><%=n.getContent() %></td>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent"><%=n.getContent() %></div>
					</div>
					<% }%>
				</div>

				<center>
					<form name="list_notifiction" method="GET">
						<%
						for(int i=initpage-1,k=1;k<=3;i++,k++){
								if(i==0){
									k--;
									continue;
								}
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i%>">[<%=i%>]
						</a>
						<%
						if(i>count_notifiction-1){
							if(i==count_notifiction-2){
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i-2%>">[<%=i-2%>]
						</a>
						<%		}
							break;
						}else{
							if(k==3){
					%>
						...<a
							href="businessCenter_adminServclet?page_notifiction=<%=count_notifiction%>">[<%=count_notifiction%>]
						</a>
						<%}
						}
							}
					%>


					</form>
				</center>
			</div>
			<div id="list_data2" class="none">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<% for(Notification n :perNotifictions){ %>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<td>任务简报</td>
									<td>附件</td>
								</tr>
								<tr>
									<td><%=n.getId() %></td>
									<td><%=n.getAccordingTo() %></td>
									<td><%=n.getContent() %></td>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent"><%=n.getContent() %></div>
					</div>
					<% }%>
				</div>

				<center>
					<form name="list_notifiction" method="GET">
						<%
						for(int i=initpage-1,k=1;k<=3;i++,k++){
								if(i==0){
									k--;
									continue;
								}
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i%>">[<%=i%>]
						</a>
						<%
						if(i>count_notifiction-1){
							if(i==count_notifiction-2){
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i-2%>">[<%=i-2%>]
						</a>
						<%		}
							break;
						}else{
							if(k==3){
					%>
						...<a
							href="businessCenter_adminServclet?page_notifiction=<%=count_notifiction%>">[<%=count_notifiction%>]
						</a>
						<%}
						}
							}
					%>


					</form>
				</center>
			</div>
			<div id="list_data3" class="none">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<% for(Notification n :perNotifictions){ %>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<td>任务简报</td>
									<td>附件</td>
								</tr>
								<tr>
									<td><%=n.getId() %></td>
									<td><%=n.getAccordingTo() %></td>
									<td><%=n.getContent() %></td>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent"><%=n.getContent() %></div>
					</div>
					<% }%>
				</div>

				<center>
					<form name="list_notifiction" method="GET">
						<%
						for(int i=initpage-1,k=1;k<=3;i++,k++){
								if(i==0){
									k--;
									continue;
								}
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i%>">[<%=i%>]
						</a>
						<%
						if(i>count_notifiction-1){
							if(i==count_notifiction-2){
					%>
						<a href="businessCenter_adminServclet?page_notifiction=<%=i-2%>">[<%=i-2%>]
						</a>
						<%		}
							break;
						}else{
							if(k==3){
					%>
						...<a
							href="businessCenter_adminServclet?page_notifiction=<%=count_notifiction%>">[<%=count_notifiction%>]
						</a>
						<%}
						}
							}
					%>


					</form>
				</center>
			</div>
			<div id="list_data4" class="none">创建业务</div>
		</div>
	</div>
	<script type="text/javascript">
		var Accordion1 = new Spry.Widget.Accordion("Accordion1");
	</script>
</body>
</html>