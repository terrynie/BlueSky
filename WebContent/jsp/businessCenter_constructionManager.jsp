<%@page import="com.bluesky.bean.*"%>
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
<script src="../js/change_table.js" type="text/javascript" charset="utf-8"></script>
</head>
<body id="body">
	<%
	int count=((Integer)request.getAttribute("count")).intValue();
	int count_fineTickets=((Integer)request.getAttribute("count_fineTickets")).intValue();
	ArrayList<Notification> perInfos=(ArrayList<Notification>)request.getAttribute("perInfos");
	ArrayList<FineTicket> perInfos_fineTickets=(ArrayList<FineTicket>)request.getAttribute("perInfos_fineTickets");
	int initpage=1;int initflag=1;
	if(request.getParameter("page")!=null){
	 initpage=Integer.parseInt(request.getParameter("page"));
	}
	if(request.getParameter("flag")!=null){
		initflag=Integer.parseInt(request.getParameter("flag"));
	}
	System.out.println("jsp page"+initpage);
	System.out.println("jsp flag"+initflag);
	if(initflag==1){
	%>
	<div id="list">
		<div class="list_ul">
			<!--  <label>业务中心</label> -->
			<!-- <form action="businessCenter_adminServclet" method="post">
				<input type="text" name="search_input">
				<input type="submit" value="搜索" name="search_sub" onclick="search();">
			</form> -->
			<ul id="ul_style4">
				<li class="active openline" onclick="tab_list(this,0);">整改通知</li>
				<li class="normal" onclick="tab_list(this,1);">罚单</li>
			</ul>  
		</div>
		<div class="list_data">
			<div id="list_data0">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(Notification n :perInfos){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<!-- <td>任务简报</td> -->
									<td>附件</td>
								</tr>
								<tr>
									<td><%=n.getId()%></td>
									<td><%=n.getAccordingTo()%></td>
									<%-- <td><%=n.getContent()%></td> --%>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item"><span><%=n.getPublishDate() %></span></div>
							<div  class="time_item"><span><%=n.getContent() %></span></div>
							<%if(n.getHasImgs()==1){ 
							%>
								<div class="img_item"><img alt="" src="<%=n.getImgPath() %>"></div>
							<%
							}else{
							%>
								<div class="img_item" style="width: 204px;height: 152px;"><center>无图片信息！！！</center></div>
							<%} %>
						</div>
					</div>
					<%
						}
					%>
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
						<a href="businessCenter_constructionManagerServclet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count-1){
															if(i==count-2){
						%>
						<a href="businessCenter_constructionManagerServclet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_constructionManagerServclet?flag=1&page=<%=count%>">[<%=count%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data1" class="none">
			<div id="Accordion2" class="Accordion" tabindex="0">
					<%
						for(FineTicket f :perInfos_fineTickets){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<td>开具日期</td>
									<td>附件</td>
								</tr>
								<tr>
									<td><%=f.getId()%></td>
									<td><%=f.getWho()%></td>
									<td><%=f.getStartTime()%></td>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item li_title"><span>发布日期：<%=f.getStartTime() %> 截止日期：<%=f.getDeadLine() %></span></div>
							<ul>
							<li><p>处罚单位：<%=f.getCompany() %></p></li>
							<li><p>处罚金额：¥<%=f.getFineMoney() %></p></li>
							<br><br>
							<li><p>开具人姓名：<%=f.getWho() %></p></li>
							</ul>
						</div>
					</div>
					<%
						}
					%>
				</div>

				<center>
					<form name="list_notifiction" method="GET">
						<%
							for(int i=0,k=1;k<=3;i++,k++){
																if(i==0){
																	k--;
																	continue;
																}
						%>
						<a href="businessCenter_constructionManagerServclet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_fineTickets-1){
															if(i==count_fineTickets-2){
						%>
						<a href="businessCenter_constructionManagerServclet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=2&page=<%=count_fineTickets%>">[<%=count_fineTickets%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>				
			</div>
		</div>
	</div>
	<%
		}else if(initflag==2){
	%>
	<div id="list">
		<div class="list_ul">
			<!--  <label>业务中心</label> -->
			<!-- <form action="businessCenter_adminServclet" method="post">
				<input type="text" name="search_input">
				<input type="submit" value="搜索" name="search_sub" onclick="search();">
			</form> -->
			<ul id="ul_style4">
				<li class="normal" onclick="tab_list(this,0);">整改通知</li>
				<li class="active openline" onclick="tab_list(this,1);">罚单</li>
			</ul>  
		</div>
		<div class="list_data">
			<div id="list_data0" class="none">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(Notification n :perInfos){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<!-- <td>任务简报</td> -->
									<td>附件</td>
								</tr>
								<tr>
									<td><%=n.getId()%></td>
									<td><%=n.getAccordingTo()%></td>
									<%-- <td><%=n.getContent()%></td> --%>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item"><span><%=n.getPublishDate() %></span></div>
							<div  class="time_item"><span><%=n.getContent() %></span></div>
							<%if(n.getHasImgs()==1){ 
							%>
								<div class="img_item"><img alt="" src="<%=n.getImgPath()%>"></div>
							<%
							}else{
							%>
								<div class="img_item" style="width: 204px;height: 152px;"><center>无图片信息！！！</center></div>
							<%} %>
						</div>
					</div>
					<%
						}
					%>
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
						<a href="businessCenter_constructionManagerServclet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count-1){
															if(i==count-2){
						%>
						<a href="businessCenter_constructionManagerServclet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_constructionManagerServclet?flag=1&page=<%=count%>">[<%=count%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data1" >
			<div id="Accordion2" class="Accordion" tabindex="0">
					<%
						for(FineTicket f :perInfos_fineTickets){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<table border="0" width="100%" height="70">
								<tr>
									<td>任务编号</td>
									<td>来源</td>
									<td>开具日期</td>
									<td>附件</td>
								</tr>
								<tr>
									<td><%=f.getId()%></td>
									<td><%=f.getWho()%></td>
									<td><%=f.getStartTime()%></td>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item li_title"><span>发布日期：<%=f.getStartTime() %> 截止日期：<%=f.getDeadLine() %></span></div>
							<ul>
							<li><p>处罚单位：<%=f.getCompany() %></p></li>
							<li><p>处罚金额：¥<%=f.getFineMoney() %></p></li>
							<br><br>
							<li><p>开具人姓名：<%=f.getWho() %></p></li>
							</ul>
						</div>
					</div>
					<%
						}
					%>
				</div>

				<center>
					<form name="list_notifiction" method="GET">
						<%
							for(int i=0,k=1;k<=3;i++,k++){
																if(i==0){
																	k--;
																	continue;
																}
						%>
						<a href="businessCenter_constructionManagerServclet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_fineTickets-1){
															if(i==count_fineTickets-2){
						%>
						<a href="businessCenter_constructionManagerServclet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=2&page=<%=count_fineTickets%>">[<%=count_fineTickets%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>				
			</div>
		</div>
	</div>
	<%
		}
	%>
	<script type="text/javascript">
		var Accordion1 = new Spry.Widget.Accordion("Accordion1");
		var Accordion2 = new Spry.Widget.Accordion("Accordion2");
	</script>
</body>
</html>