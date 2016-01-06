<%@page import="com.bluesky.dao.TaskImageDao"%>
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
<script type="text/javascript">
	function creat_task(id,status){
		alert("处理成功"+id);
		var url="../UpdateStatus_supervisorServlet.do?id="+id+"&status="+status;
		window.location.href=url;	
	}
</script>
</head>
<body id="body">
	<%
		int count_not=((Integer)request.getAttribute("count_not")).intValue();
		int count_done=((Integer)request.getAttribute("count_done")).intValue();
		LinkedList<TaskList> perInfos_not=(LinkedList<TaskList>)request.getAttribute("perInfos_not");
		LinkedList<TaskList> perInfos_done=(LinkedList<TaskList>)request.getAttribute("perInfos_done");
		int initpage=1;int initflag=1;
		if(request.getParameter("page")!=null){
		 initpage=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("flag")!=null){
			initflag=Integer.parseInt(request.getParameter("flag"));
		}
		if(initflag==1){
	%>
	<div id="list">
		<div class="list_ul">
			<label>业务中心</label>
			<ul id="ul_style4">
				<li class="active openline" onclick="tab_list(this,0);">待办事物</li>
				<li class="normal" onclick="tab_list(this,1);">已处理</li>
				<li class="normal" onclick="tab_list(this,2);">创建罚单</li>
			</ul>
		</div>
		<div class="list_data">
			<div id="list_data0">
				<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(TaskList t :perInfos_not){
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
									<td><%=t.getId()%></td>
									<td><%=t.getSource()%></td>
									<%-- <td><%=t.getContent()%></td> --%>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item"><span><%=t.getCreateTime() %></span></div>
							<div  class="time_item"><span><%=t.getContent() %></span></div>
							<%if(t.getHasImg()==1){ 
								LinkedList<TaskImages> link_images=new TaskImageDao().queryImages(t.getId());
								for(TaskImages ti:link_images){
							%>
								<div class="img_item"><img alt="" src="<%=ti.getImgPath() %>"></div>
							<%	}
							}else{
							%>
								<div class="img_item" style="width: 204px;height: 152px;"><center>无图片信息！！！</center></div>
							<%} %>
							<div class="info_item">
							<input type="button" class="btn btn-primary" value="查看数据监控"/>
							<input type="button" class="btn btn-primary" value="属实，转下级"
							onclick="javascript:creat_task('<%=t.getId()%>',2)"/>
							</div>
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
						<a href="businessCenter_justiceServclet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_not-1){
															if(i==count_not-2){
						%>
						<a href="businessCenter_justiceServclet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_justiceServclet?flag=1&page=<%=count_not%>">[<%=count_not%>]
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
						for(TaskList t :perInfos_done){
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
									<td><%=t.getId()%></td>
									<td><%=t.getSource()%></td>
									<%-- <td><%=t.getContent()%></td> --%>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item"><span><%=t.getCreateTime() %></span></div>
							<div  class="time_item"><span><%=t.getContent() %></span></div>
							<%if(t.getHasImg()==1){ 
								LinkedList<TaskImages> link_images=new TaskImageDao().queryImages(t.getId());
								for(TaskImages ti:link_images){
							%>
								<div class="img_item"><img alt="" src="<%=ti.getImgPath() %>"></div>
							<%	}
							}else{
							%>
								<div class="img_item" style="width: 204px;height: 152px;"><center>无图片信息！！！</center></div>
							<%} %>
							<div class="info_item">
							<input type="button" class="btn btn-primary" value="查看数据监控"/>
							<input type="button" class="btn btn-primary" value="属实，已处理" disabled="disabled"/>
							</div>
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
						<a href="businessCenter_justiceServclet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_done-1){
															if(i==count_done-2){
						%>
						<a href="businessCenter_justiceServclet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_justiceServclet?flag=2&page=<%=count_done%>">[<%=count_done%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>				
			</div>
			<div id="list_data2" class="none">创建罚单</div>
		</div>
	</div>
	<%}else if(initflag==2){ %>
		<div id="list">
		<div class="list_ul">
			<label>业务中心</label>
			<!-- <form action="businessCenter_adminServclet" method="post">
				<input type="text" name="search_input">
				<input type="submit" value="搜索" name="search_sub" onclick="search();">
			</form> -->
			<ul id="ul_style4">
				<li class="normal" onclick="tab_list(this,0);">待办事物</li>
				<li class="active openline" onclick="tab_list(this,1);">已处理</li>
				<li class="normal" onclick="tab_list(this,2);">创建罚单</li>
			</ul>
		</div>
		<div class="list_data">
			<div id="list_data0" class="none">
			<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(TaskList t :perInfos_not){
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
									<td><%=t.getId()%></td>
									<td><%=t.getSource()%></td>
									<%-- <td><%=t.getContent()%></td> --%>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item"><span><%=t.getCreateTime() %></span></div>
							<div  class="time_item"><span><%=t.getContent() %></span></div>
							<%if(t.getHasImg()==1){ 
								LinkedList<TaskImages> link_images=new TaskImageDao().queryImages(t.getId());
								for(TaskImages ti:link_images){
							%>
								<div class="img_item"><img alt="" src="<%=ti.getImgPath() %>"></div>
							<%	}
							}else{
							%>
								<div class="img_item" style="width: 204px;height: 152px;"><center>无图片信息！！！</center></div>
							<%} %>
							<div class="info_item">
							<input type="button" class="btn btn-primary" value="查看数据监控"/>
							<input type="button" class="btn btn-primary" value="属实，转下级"
							onclick="javascript:creat_task('<%=t.getId()%>',2)"/>
							</div>
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
						<a href="businessCenter_justiceServclet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_not-1){
															if(i==count_not-2){
						%>
						<a href="businessCenter_justiceServclet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_justiceServclet?flag=1&page=<%=count_not%>">[<%=count_not%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data1">
				<div id="Accordion2" class="Accordion" tabindex="0">
					<%
						for(TaskList t :perInfos_done){
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
									<td><%=t.getId()%></td>
									<td><%=t.getSource()%></td>
									<%-- <td><%=t.getContent()%></td> --%>
									<td>图视文</td>
								</tr>
							</table>
						</div>
						<div class="AccordionPanelContent">
							<div class="time_item"><span><%=t.getCreateTime() %></span></div>
							<div  class="time_item"><span><%=t.getContent() %></span></div>
							<%if(t.getHasImg()==1){ 
								LinkedList<TaskImages> link_images=new TaskImageDao().queryImages(t.getId());
								for(TaskImages ti:link_images){
							%>
								<div class="img_item"><img alt="" src="<%=ti.getImgPath() %>"></div>
							<%	}
							}else{
							%>
								<div class="img_item" style="width: 204px;height: 152px;"><center>无图片信息！！！</center></div>
							<%} %>
							<div class="info_item">
							<input type="button" class="btn btn-primary" value="查看数据监控"/>
							<input type="button" class="btn btn-primary" value="属实，已处理" disabled="disabled"/>
							</div>
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
						<a href="businessCenter_justiceServclet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_done-1){
															if(i==count_done-2){
						%>
						<a href="businessCenter_justiceServclet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_justiceServclet?flag=2&page=<%=count_done%>">[<%=count_done%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			
			<div id="list_data2" class="none">创建罚单</div>
		</div>
	<%} %>
	<script type="text/javascript">
		var Accordion1 = new Spry.Widget.Accordion("Accordion1");
		var Accordion2 = new Spry.Widget.Accordion("Accordion2");
	</script>
</body>
</html>