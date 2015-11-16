<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>蓝天卫士</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
   <!-- <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" /> -->

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/elements.css" />
    <link rel="stylesheet" type="text/css" href="css/icons.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen" />    

    <!-- open sans font -->
    <link href='css/opensansfont.' rel='stylesheet' type='text/css' />
	
	<!-- custom icons -->
	<link href='css/cus-icons' rel='stylesheet' type='text/css'>
    <!-- lato font -->
    <link href='css/latofont.css' rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="css/index-bluesky.css"/>
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
		<!-- navbar -->
    <div class="navbar navbar-inverse" style="background-color: #3A7BDA">
        <div class="navbar-inner logo-nav" style="background-color: #3A7BDA">
            <!--<button type="button" class="btn btn-navbar visible-phone" id="menu-toggler">
            </button>-->
            
            <!-- <a class="brand" href="index.html"><img src="img/logo.png" /></a> -->
            <a class="brand"><img alt="蓝天卫士" src="images/icons/logo.png"/></a>
          	<label class="logo-nav-1">建设工地施工现场</label>
          	<label class="logo-nav-2">扬尘治理及施工安全管理系统</label>
          	<ul>
          		<li id="uesr-nmae">admin</li>
          		<li id="login-out"><a href="login.jsp" ><em></em>退出</a></li>
          	</ul>
        </div>
    </div>
    <!-- end navbar -->
    
	<div id="page_content">
	
    
    <style type="text/css">
    	
    </style>
    
    <!-- sidebar -->
    <div id="sidecontent">
    	<div id="sidebar-nav" >
        <ul id="dashboard-menu" >
            <li class="active">
               <a onclick="changeContent('jsp/dataCenter.jsp');" id="slider-bar " class="slider-bar-1" ><em></em> 数据中心</a>
            </li>            
            <li>
                <a onclick="changeContent('jsp/businessCenter_adminServlet'); " class="slider-bar-2"><em></em>业务中心</a>
            </li>
            <li>
                <a onclick="changeContent('jsp/monitoringcenter_adminServlet');" class="slider-bar-3"><em></em>监控中心</a>
            </li>
            <li>
                <a onclick="changeContent('jsp/weixing.jsp');" class="slider-bar-4"><em></em>卫星资源</a>
            </li>
            <li>
                <a onclick="changeContent('jsp/projectManagerServlet');" class="slider-bar-5"><em></em>工地管理</a>
            </li>
            <li>
                <a onclick="changeContent('jsp/managerServlet');" class="slider-bar-6"><em></em>人员管理
                </a>
            </li>
            <li>
                <a onclick="changeContent('');" class="slider-bar-7"><em></em>系统设置
                </a>
            </li>
            <li>
                <a onclick="changeContent('');" class="slider-bar-8"><em></em>使用帮助    
                </a>
            </li>
        </ul>
    </div>
    </div>
    
    <!-- end sidebar -->


	<!-- main container -->
    <div class="content" style="margin-bottom: 0px;" name="contentDiv">

       <!--  <div class="container-fluid">
        </div> -->
        <iframe id="frame" src="jsp/dataCenter.jsp" frameborder="0" scrolling="no" width="100%" name="frame" height="3800px"  ></iframe>
    </div>


	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-ui-1.10.2.custom.min.js"></script>
    <!-- knob -->
    <script src="js/jquery.knob.js"></script>
    <!-- flot charts -->
    <script src="js/jquery.flot.js"></script>
    <script src="js/jquery.flot.stack.js"></script>
    <script src="js/jquery.flot.resize.js"></script>
    <script src="js/theme.js"></script>
	<script src="js/index-blursky.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    
        function changeContent(newUrl){
        	var frame = document.getElementById('frame');
        	frame.src = newUrl;
/*         	var youbiao = document.getElementById('side');
        	document.getElementById('arrow').setAttribute("margin-top", parseInt(youbiao.getAttribute("value"))*51); */
        }
        
        
        /* var divInitTop;
        function moveDivAd(){
        	if(document.getElementById("sidecontent").style.pixel)
        } */
    </script>

	</div>
    
</body>
</html>