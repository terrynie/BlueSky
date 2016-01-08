<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/bootstrap/zui.min.css"/>
		<link rel="stylesheet" type="text/css" href="../css/dataCenter.css"/>
		<script src="../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/zui.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
<%

	/* String weChatTotalDataNum = (String)request.getAttribute("weChatTotalDataNum");
	String weChatDealedDataNum =(String)  request.getAttribute("weChatDealedDataNum"); */
	int weChatTotalDataNum =  Integer.parseInt(request.getAttribute("weChatTotalDataNum").toString());
	int weChatDealedDataNum = Integer.parseInt(request.getAttribute("weChatDealedDataNum").toString()); 
	System.out.println("text:"+weChatTotalDataNum);
%>
		<div class="dataWrapper">
			<div class="row-title"><label>数据统计</label></div>
			<div class="row">
			  <div class="col-xs-6 col-sm-3">
			  		<div class="row_title_content">
			  			<span class="row_span row-1"><img alt="" src="../images/dataImg.png"/></span>
			  			<span class="row_span row-2 row-span-1"><span >

 <%=weChatTotalDataNum %> </span><i></i><small> <%=weChatDealedDataNum %> </small></span>
			  			<label class="row_span row-3">受举报群众(人次)/有效受理</label>
			  		</div>
			  		
			  </div> 
			  <div class="col-xs-6 col-sm-3">
			  	<div class="row_title_content">
			  		<span class="row_span row-1"><img alt="" src="../images/dataImg.png"/></span>
			  		<span class="row_span row-2 row-span-2"><span>56472</span><i></i><small>43217</small></span>
			  		<label class="row_span row-3">系统反馈(次)/在线巡查</label>
			  	</div>
				</div>
			
			  <div class="col-xs-6 col-sm-3">
			  <div class="row_title_content">
			  	<span class="row_span row-1"><img alt="" src="../images/dataImg.png"/></span>
			  		<span class="row_span row-2 row-span-3"><span>234</span><i></i><small>1276</small></span>
			  		<label class="row_span row-3">PM10数据接入(次)/告警(次)</label>
			  		</div>
			  </div>
			  <div class="col-xs-6 col-sm-3">
			  <div class="row_title_content row_title_last">
			  	<span class="row_span row-1"><img alt="" src="../images/dataImg.png"/></span>
			  		<span class="row_span row-2 row-span-4"><span>678</span><i></i><small>4475</small></span>
			  		<label class="row_span row-3">智能电表箱接入(次)/告警(次)</label>
			  		</div>
			  </div>
			</div>
			<div class="row-title"><label>易发区分布示意图</label></div>
			<div class="row-map">
				<section>
				  <article>
				    <div class="example">
				      <ul id="myTab" class="nav nav-tabs">
				        <li class="active">
				          <a href="#tab1" data-toggle="tab">群众举报</a>
				        </li>
				        <li>
				          <a href="#tab2" data-toggle="tab">PM10</a>
				        </li>
				        <li>
				          <a href="#tab3" data-toggle="tab">卫星资源</a>
				        </li>
				        <li>
				          <a href="#tab4" data-toggle="tab">智能电表</a>
				        </li>
				      </ul>
				      <div class="tab-content">
				        <div class="tab-pane in active" id="tab1">
				         	<iframe width="100%" height="360px" name="map-iframe" frameborder="0" scrolling="no" allowtransparency="yes" src="map.jsp"></iframe>
				        	<div class="bottom-frame">
				        		<ul>
				        			<li><i class="i_1"></i><label>群众举报高发区</label></li>
				        			<li><i class="i_2"></i><label>群众举报易发区</label></li>
				        			<li><i class="i_3"></i><label>群众举报低发区</label></li>
				        		</ul>
				        		
				        	</div>
				        </div>
				        <div class="tab-pane" id="tab2">
				         <iframe width="100%" height="360px" name="map-iframe" frameborder="0" scrolling="no" allowtransparency="yes" src="map.jsp"></iframe>
				        	<div class="bottom-frame">
				        		<ul>
				        			<li><i class="i_1"></i><label>群众举报高发区</label></li>
				        			<li><i class="i_2"></i><label>群众举报易发区</label></li>
				        			<li><i class="i_3"></i><label>群众举报低发区</label></li>
				        		</ul>
				        		
				        	</div>
				        </div>
				
				        <div class="tab-pane" id="tab3">
				         <iframe width="100%" height="360px" name="map-iframe" frameborder="0" scrolling="no" allowtransparency="yes" src="map.jsp"></iframe>
				        	<div class="bottom-frame">
				        		<ul>
				        			<li><i class="i_1"></i><label>群众举报高发区</label></li>
				        			<li><i class="i_2"></i><label>群众举报易发区</label></li>
				        			<li><i class="i_3"></i><label>群众举报低发区</label></li>
				        		</ul>
				        		
				        	</div>
				        </div>
				        <div class="tab-pane" id="tab4">
				         <iframe width="100%" height="360px" name="map-iframe" frameborder="0" scrolling="no" allowtransparency="yes" src="map.jsp"></iframe>
				        	<div class="bottom-frame">
				        		<ul>
				        			<li><i class="i_1"></i><label>群众举报高发区</label></li>
				        			<li><i class="i_2"></i><label>群众举报易发区</label></li>
				        			<li><i class="i_3"></i><label>群众举报低发区</label></li>
				        		</ul>
				        		
				        	</div>
				        </div>
				      </div>
				    </div>    
				  </article>
				</section>
			</div>
			<div class="row-title"><label>业务走势及饼图分布</label></div>
			 <div class="row-chart">
			 	<div class="one-charts">
			 		<span class="item_title">举报有效率</span>
			 		<div id="one-charts">
			 		</div>
			 		<div id="one-charts-pie">
			 		</div>
		 			<span id="it_1"> 50092</span>
		 			<span id="it_2">61100</span>
		 			<span class="item_footer">2015年1月至今</span>

			    </div>
			    <div class="two-charts">
			    	
			 		<div id="two-charts">
			 		</div>
			 		<div id="two-charts-pie">
			 		</div>
			 		<span class="item_title_2">出勤效率</span>
					<span  class="qin_1"> 556</span>
		 			<span  class="qin_2">1345</span>
			 		<span class="item_footer_2">2015年1月至今</span>
			    </div>
			    <div class="row-title"><label>PM10及最近天气对比图</label></div>
			    <div class="three-charts">
			 		<div id="three-charts">
			 		</div>
			 		<div id="three-charts-pie">
			 			<div class="i-charts ch-1"><i></i>PM10(PM10数据检测站报告)</div>
			 			<div class="i-charts ch-2"><i></i>PM2.5(天气质量检测报告)</div>
			 			<div class="pro-bar"><span class="trapezoid"></span></div>
			 			<div class="pro-text">
			 				<div class="col-xs-6 col-sm-4">轻</div>
			 				<div class="col-xs-6 col-sm-4">中</div>
			 				<div class="col-xs-6 col-sm-4">重</div>
			 			</div>
			 			<div class="pro-text foot-text">
			 				<div class="col-xs-6 col-sm-12">
			 					<label>质量检测报告分析：</label>
			 					 <p> 4月、6月、8月为工地扬尘问题易发期</p>
			 					<p>建议工地及有关部门做好防尘准备工作。</p>
			 				</div>
			 				
			 			</div>
			 		</div>
			    </div>
			     <div class="row-title"><label>智能电表警告柱状统计</label></div>
			    <div class="one-charts enb-bar">
			    <span class="item_title">有效事故避免率</span>
			 		<div id="four-charts">
			 		</div>
			 		<div id="four-charts-pie">
			 		</div>
			 		<span id="it_1"> 241</span>
		 			<span id="it_2">453</span>
		 			<span class="item_footer">2015年1月至今</span>
			 		
			    </div>
			    <div class="two-charts">
			 		<div id="five-charts">
			 		</div>
			 		<div id="five-charts-pie">
			 		</div>
			 		<span class="item_title_2">有效事故避免率</span>
					<span  class="qin_1 deg-1"> 266</span>
		 			<span  class="qin_2 deg-2">537</span>
			 		<span class="item_footer_2 last-month">2015年1月至今</span>
			    </div>
			 </div>
			
			
		</div>
		
				
		
<!--	<!--	<!--
		
		<div>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
		</div>
		<div>
			
		</div>
		<div>
			<iframe src="jubaoLine.jsp"></iframe>
			<iframe src="jubaoDoughnut.jsp"></iframe>
		</div>
		<div>
			<iframe src="chuqinLine.jsp"></iframe>
			<iframe src="chuqinDoughnut.jsp"></iframe>
		</div>
		<div>
			<iframe src="pm10Line.jsp"></iframe>
			<iframe src=""></iframe>
		</div>
		<div>
			<iframe src="elecWarn.jsp"></iframe>
			<iframe src="elecWarnDoughnut.jsp"></iframe>
		</div>
		<div>
			<iframe src="hotWarn.jsp"></iframe>
			<iframe src="hotWarnDoughnut.jsp"></iframe>
		</div>-->
		<script src="../js/eChartjs/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart1.js" type="text/javascript" charset="utf-8"></script>	
		<script src="../js/data-chart2.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart3.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart4.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart5.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart6.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart7.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart8.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/data-chart9.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
