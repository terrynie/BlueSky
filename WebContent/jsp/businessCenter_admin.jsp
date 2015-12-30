<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="com.bluesky.bean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap/zui.min.css" />
<link rel="stylesheet" type="text/css" href="../css/pintuer.css"/>
<link rel="stylesheet" href="../css/businessCenter_admin.css"type="text/css" />

<script src="../js/jquery.min.js" type="text/javascript"></script>

<script src="../js/SpryAccordion.js" type="text/javascript"></script>

<script src="../js/admin-center.js" type="text/javascript" charset="utf-8"></script>
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

	function creat_task(id,source,content){
		alert("处理成功"+id);
		var url="../createTaskServlet.do?id="+id+"&source="+source+"&content="+content;
		window.location.href=url;	
	}
	function it_notture(id){
		alert("处理成功"+id);
		var url="../createTaskServlet.do?id="+id+"&source="+source+"&content="+content;
		window.location.href=url;
	}
	

</script>

</head>
<body id="body">
	<%
		int count=((Integer)request.getAttribute("count")).intValue();
		int count_not=((Integer)request.getAttribute("count_not")).intValue();
		int count_done=((Integer)request.getAttribute("count_done")).intValue();
		int count_weChat=((Integer)request.getAttribute("count_weChat")).intValue();
		LinkedList<Notification> perInfos=(LinkedList<Notification>)request.getAttribute("perInfos");
		LinkedList<TaskList> perInfos_not=(LinkedList<TaskList>)request.getAttribute("perInfos_not");
		LinkedList<TaskList> perInfos_done=(LinkedList<TaskList>)request.getAttribute("perInfos_done");
		LinkedList<WeChat> perInfos_weChat=(LinkedList<WeChat>)request.getAttribute("perInfos_weChat");
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
			
			<ul id="ul_style4">
				<li class="normal" onclick="tab_list(this,3);">微信数据</li>
				<li class="active openline" onclick="tab_list(this,0);">待办业务</li>
				<li class="normal" onclick="tab_list(this,1);">已处理</li>
				<li class="normal" onclick="tab_list(this,2);">通知公告</li>				
				<li class="normal" onclick="tab_list(this,4);">创建任务</li>
			</ul> 
			<!-- /input-group -->
			<div class="input-x">
					<input type="text" class="form-control" name="search_input">
					<input type="button" class="btn btn-primary btn-sert" value="搜索" />
			</div>	
		</div>
		<div class="list_data">
			<div id="list_data0">
				<div id="Accordion1" class="Accordion" >
					<%
						for(TaskList t :perInfos_not){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>

						</div>
						<div class="panelContent">
							<!-- <div class="AccordionPanelContent"><%=t.getContent()%></div> -->
							<div class="time_item"><span>2015/09/10</span></div>
							<div  class="time_item"><span>WE二期工地扬尘漫天，多次沟通，拒不改正。态度及其恶劣，严重影响附近居民的正常生活。特提交有关部门，望你部积极整治，还老百姓一个好的生活环境。</span></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="info_item">
							<input type="button" class="btn btn-primary" value="查看数据监控"/>
							<input type="button" class="btn btn-primary" value="属实，转下级"/>
							<input type="button" class="btn btn-primary" value="不属实，驳回"/>
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
						<a href="businessCenter_adminServlet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_not-1){
															if(i==count_not-2){
						%>
						<a href="businessCenter_adminServlet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=1&page=<%=count_not%>">[<%=count_not%>]
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
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="time_item"><span>2015/09/10</span></div>
							<div  class="time_item"><span>WE二期工地扬尘漫天，多次沟通，拒不改正。态度及其恶劣，严重影响附近居民的正常生活。特提交有关部门，望你部积极整治，还老百姓一个好的生活环境。</span></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="info_item">
							<input type="button" class="btn btn-primary" value="查看监控数据"/>
							<input type="button" class="btn btn-primary" value="属实，已转下级"/>
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
						<a href="businessCenter_adminServlet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_done-1){
															if(i==count_done-2){
						%>
						<a href="businessCenter_adminServlet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=2&page=<%=count_done%>">[<%=count_done%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>				
			</div>
			<div id="list_data2" class="none">
			<div id="Accordion3" class="Accordion" tabindex="0">
					<%
						for(Notification n :perInfos){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=n.getId()%></div>
								<div class="row_table"><%=n.getAccordingTo()%></div>
								<div class="row_table"><%=n.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="time_item li_title"><span>2015/09/10</span></div>
							<ul>
								<li><p>一、提高思想认识、加强施工现场安全管理</p></li>
								<li><p>二、强化从业人员的素质，加大安全教育培训力度</p></li>
								<li><p>三、全面排查施工现场隐患，严格做好安全工作</p></li>
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
						<a href="businessCenter_adminServlet?flag=3&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count-1){
															if(i==count-2){
						%>
						<a href="businessCenter_adminServlet?flag=3&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=3&page=<%=count%>">[<%=count%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data3" class="none">
			<div id="Accordion4" class="Accordion" tabindex="0">
					<%
						for(WeChat w :perInfos_weChat){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=w.getId()%></div>
								<div class="row_table"><%=w.getWeChatNo()%></div>
								<div class="row_table"><%=w.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="time_item"><span>2015/09/10</span></div>
							<div  class="time_item"><span>WE二期工地扬尘漫天，多次沟通，拒不改正。态度及其恶劣，严重影响附近居民的正常生活。特提交有关部门，望你部积极整治，还老百姓一个好的生活环境。</span></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="img_item"><img alt="" src="../images/copy 2.png"></div>
							<div class="info_item">
							<!-- -<button class="btn btn-primary">在线巡查</button>
							<button class="btn btn-primary" onclick="javascript:textz()">生成任务</button>-->
							 <input type="hidden" value="<%=w.getId()%>" id="id">
							<input type="hidden" value="<%=w.getWeChatNo()%>" id="sourse">
							<input type="hidden" value="<%=w.getContent()%>" id="content">
							<input type="button" class="btn btn-primary" value="在线巡查" />
							<input type="button" class="btn btn-primary" value="生成任务"  
							onclick="javascript:creat_task('<%=w.getId()%>','<%=w.getWeChatNo()%>','<%=w.getContent()%>')"/>
							<input type="button" class="btn btn-primary" value="不属实"
							onclick="javascript:it_notture('<%=w.getId()%>')"/>
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
						<a href="businessCenter_adminServlet?flag=4&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_weChat-1){
															if(i==count_weChat-2){
						%>
						<a href="businessCenter_adminServlet?flag=4&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=4&page=<%=count_weChat%>">[<%=count_weChat%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data4" class="none"><iframe src="createTaskList.jsp" width="100%" height="600px"></iframe></div>
		</div>
	</div>
	<%
		}else if(initflag==2){
	%>
	<div id="list">
		<div class="list_ul">
		<ul id="ul_style4">
				<li class="normal" onclick="tab_list(this,0);">微信数据</li>
				<li class="active" onclick="tab_list(this,1);">待办业务</li>
				<li class="normal" onclick="tab_list(this,2);">已处理</li>
				<li class="normal" onclick="tab_list(this,3);">通知公告</li>				
				<li class="normal" onclick="tab_list(this,4);">创建任务</li>
			</ul> 
			<!-- /input-group -->
			<div class="input-x">
					<input type="text" class="input" name="search_input">
					<input type="button" class="btn btn-primary" value="搜索" />
			</div>	
			
		</div>
		<div class="list_data">
			<div id="list_data0" class="none">
			<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(TaskList t :perInfos_not){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							
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
						<a href="businessCenter_adminServlet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_not-1){
															if(i==count_not-2){
						%>
						<a href="businessCenter_adminServlet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=1&page=<%=count_not%>">[<%=count_not%>]
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
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							
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
						<a href="businessCenter_adminServlet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_done-1){
															if(i==count_done-2){
						%>
						<a href="businessCenter_adminServlet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=2&page=<%=count_done%>">[<%=count_done%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data2" class="none">
			<div id="Accordion3" class="Accordion" tabindex="0">
					<%
						for(Notification n :perInfos){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=n.getId()%></div>
								<div class="row_table"><%=n.getAccordingTo()%></div>
								<div class="row_table"><%=n.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							
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
						<a href="businessCenter_adminServlet?flag=3&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count-1){
															if(i==count-2){
						%>
						<a href="businessCenter_adminServlet?flag=3&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=3&page=<%=count%>">[<%=count%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data3" class="none">
			<div id="Accordion4" class="Accordion" tabindex="0">
					<%
						for(WeChat w :perInfos_weChat){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=w.getId()%></div>
								<div class="row_table"><%=w.getWeChatNo()%></div>
								<div class="row_table"><%=w.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							
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
						<a href="businessCenter_adminServlet?flag=4&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_weChat-1){
															if(i==count_weChat-2){
						%>
						<a href="businessCenter_adminServlet?flag=4&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=4&page=<%=count_weChat%>">[<%=count_weChat%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data4" class="none"><iframe src="createTaskList.jsp" width="100%" height="600px"></iframe></div>
		</div>
	<%
		}else if(initflag==3){
	%>
	<div id="list">
		<div class="list_ul">
		<ul id="ul_style4">
				<li class="normal" onclick="tab_list(this,0);">微信数据</li>
				<li class="active" onclick="tab_list(this,1);">待办业务</li>
				<li class="normal" onclick="tab_list(this,2);">已处理</li>
				<li class="normal" onclick="tab_list(this,3);">通知公告</li>				
				<li class="normal" onclick="tab_list(this,4);">创建任务</li>
			</ul> 
			<!-- /input-group -->
			<div class="input-x">
					<input type="text" class="input" name="search_input">
					<input type="button" class="btn btn-primary" value="搜索" />
			</div>	
			
		</div>
		<div class="list_data">
			<div id="list_data0" class="none">
			<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(TaskList t :perInfos_not){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							
							
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
						<a href="businessCenter_adminServlet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_not-1){
															if(i==count_not-2){
						%>
						<a href="businessCenter_adminServlet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=1&page=<%=count_not%>">[<%=count_not%>]
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
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=t.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_done-1){
															if(i==count_done-2){
						%>
						<a href="businessCenter_adminServlet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=2&page=<%=count_done%>">[<%=count_done%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data2">
				<div id="Accordion3" class="Accordion" tabindex="0">
					<%
						for(Notification n :perInfos){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=n.getId()%></div>
								<div class="row_table"><%=n.getAccordingTo()%></div>
								<div class="row_table"><%=n.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=n.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=3&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count-1){
															if(i==count-2){
						%>
						<a href="businessCenter_adminServlet?flag=3&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=3&page=<%=count%>">[<%=count%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data3" class="none">
			<div id="Accordion4" class="Accordion" tabindex="0">
					<%
						for(WeChat w :perInfos_weChat){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=w.getId()%></div>
								<div class="row_table"><%=w.getWeChatNo()%></div>
								<div class="row_table"><%=w.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=w.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=4&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_weChat-1){
															if(i==count_weChat-2){
						%>
						<a href="businessCenter_adminServlet?flag=4&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=4&page=<%=count_weChat%>">[<%=count_weChat%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data4" class="none" height=""><iframe src="createTaskList.jsp" width="100%" height="600px"></iframe></div>
		</div>
	</div>
	<%
		}else if(initflag==4){
	%>
	<div id="list">
		<div class="list_ul">
			<ul id="ul_style4">
				<li class="normal" onclick="tab_list(this,0);">微信数据</li>
				<li class="active" onclick="tab_list(this,1);">待办业务</li>
				<li class="normal" onclick="tab_list(this,2);">已处理</li>
				<li class="normal" onclick="tab_list(this,3);">通知公告</li>				
				<li class="normal" onclick="tab_list(this,4);">创建任务</li>
			</ul> 
			<!-- /input-group -->
			<div class="input-x">
					<input type="text" class="input" name="search_input">
					<input type="button" class="btn btn-primary" value="搜索" />
			</div>	
			
		</div>
		<div class="list_data">
			<div id="list_data0"  class="none">
			<div id="Accordion1" class="Accordion" tabindex="0">
					<%
						for(TaskList t :perInfos_not){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
							<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=t.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=1&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_not-1){
															if(i==count_not-2){
						%>
						<a href="businessCenter_adminServlet?flag=1&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=1&page=<%=count_not%>">[<%=count_not%>]
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
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=t.getId()%></div>
								<div class="row_table"><%=t.getSource()%></div>
								<div class="row_table"><%=t.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=t.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=2&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_done-1){
															if(i==count_done-2){
						%>
						<a href="businessCenter_adminServlet?flag=2&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=2&page=<%=count_done%>">[<%=count_done%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data2" class="none">
			<div id="Accordion3" class="Accordion" tabindex="0">
					<%
						for(Notification n :perInfos){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=n.getId()%></div>
								<div class="row_table"><%=n.getAccordingTo()%></div>
								<div class="row_table"><%=n.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=n.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=3&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count-1){
															if(i==count-2){
						%>
						<a href="businessCenter_adminServlet?flag=3&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=3&page=<%=count%>">[<%=count%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data3">
				<div id="Accordion4" class="Accordion" tabindex="0">
					<%
						for(WeChat w :perInfos_weChat){
					%>
					<div class="AccordionPanel">
						<div class="AccordionPanelTab">
						<div class="row_content row_1">
								<div class="row_table">任务编号</div>
								<div class="row_table">来源</div>
								<div class="row_table">任务简报</div>
								<div class="row_table">附件</div>
								<div class="right_item"><i class="icon icon-bars"></i></div>
							</div>
							<div class="row_content row_2">
								<div class="row_table"><%=w.getId()%></div>
								<div class="row_table"><%=w.getWeChatNo()%></div>
								<div class="row_table"><%=w.getContent()%></div>
								<div class="row_table"><i class="icon icon-file-word-o"></i><i class="icon icon-file-image-o"></i><i class="icon  icon-file-video-o"></i></div>
								
							</div>
							
						</div>
						<div class="panelContent">
							<div class="AccordionPanelContent"><%=w.getContent()%></div>
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
						<a href="businessCenter_adminServlet?flag=4&page=<%=i%>">[<%=i%>]
						</a>
						<%
							if(i>count_weChat-1){
															if(i==count_weChat-2){
						%>
						<a href="businessCenter_adminServlet?flag=4&page=<%=i-2%>">[<%=i-2%>]
						</a>
						<%
							}
															break;
														}else{
															if(k==3){
						%>
						...<a href="businessCenter_adminServlet?flag=4&page=<%=count_weChat%>">[<%=count_weChat%>]
						</a>
						<%
							}
														}
															}
						%>


					</form>
				</center>
			</div>
			<div id="list_data4" class="none"><iframe width="100%" height="600px" src="createTaskList.jsp" ></iframe></div>
		</div>
	</div>
	<%
		}
	%>
</div>
<script type="text/javascript">
	var Accordion1 = new Spry.Widget.Accordion("Accordion1");
	var Accordion2 = new Spry.Widget.Accordion("Accordion2");
	var Accordion3 = new Spry.Widget.Accordion("Accordion3");
	var Accordion4 = new Spry.Widget.Accordion("Accordion4");
</script>
</body>
</html>