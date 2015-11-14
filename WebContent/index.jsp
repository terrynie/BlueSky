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

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
		<!-- navbar -->
    <div class="navbar navbar-inverse" style="background-color: #3A7BDA">
        <div class="navbar-inner" style="background-color: #3A7BDA">
            <button type="button" class="btn btn-navbar visible-phone" id="menu-toggler">
            </button>
            
            <!-- <a class="brand" href="index.html"><img src="img/logo.png" /></a> -->
            <a class="brand">蓝天卫士</a>
            
        </div>
    </div>
    <!-- end navbar -->
    
	<div id="page_content">
	
    
    <style type="text/css">
    	.cus {
   			background-image: url(images/spritesheet.png);
    		background-repeat: no-repeat;
    		display: block;
		}

		.cus-data {
    		width: 20px;
   		 	height: 20px;
    		background-position: -5px -5px;
		}

		.cus-exit {
    		width: 20px;
    		height: 20px;
    		background-position: -35px -5px;
		}

		.cus-gongdi {
    		width: 20px;
   		 	height: 20px;
    		background-position: -65px -5px;
		}

		.cus-help {
    		width: 20px;
    		height: 20px;
    		background-position: -95px -5px;
		}

		.cus-jiankong {
   			width: 20px;
    		height: 20px;
    		background-position: -125px -5px;
		}

		.cus-renyuan {
    		width: 20px;
    		height: 20px;
    		background-position: -155px -5px;
		}

		.cus-set {
    		width: 20px;
    		height: 20px;
    		background-position: -185px -5px;
		}

		.cus-weixing {
    		width: 20px;
    		height: 20px;
    		background-position: -215px -5px;
		}

		.cus-yewu {
    		width: 20px;
    		height: 20px;
    		background-position: -245px -5px;
    	
    </style>
    
    <!-- sidebar -->
    <div id="sidebar-nav" style="background-color: #336CC1">
        <ul id="dashboard-menu">
            <li class="active">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
                <a onclick="changeContent('jsp/dataCenter.jsp');" id="slider-bar" style="background-color: transparent; border: 0;font-color:#ffffff;">
                   	<i class="cus cus-data"></i>
                    <span>数据中心</span>
                </a>
            </li>            
            <li>
                <a onclick="changeContent('jsp/businessCenter_adminServlet');">
                    <i class="cus cus-yewu"></i>
                    <span>业务中心</span>
                </a>
            </li>
            <li>
                <a onclick="changeContent('jsp/monitoringcenter_adminServlet');">
                    <i class="cus cus-data"></i>
                    <span>监控中心</span>
                </a>
            </li>
            <li>
                <a onclick="changeContent('jsp/weixing.jsp');">
                    <i class="cus cus-weixing"></i>
                    <span>卫星资源</span>
                </a>
            </li>
            <li>
                <a onclick="changeContent('');">
                    <i class="cus cus-gongdi"></i>
                    <span>工地管理</span>
                </a>
            </li>
            <li>
                <a onclick="changeContent('');">
                    <i class="cus cus-renyuan"></i>
                    <span>人员管理</span>
                </a>
            </li>
            <li>
                <a onclick="changeContent('');">
                    <i class="cus cus-set"></i>
                    <span>系统设置</span>
                </a>
            </li>
            <li>
                <a onclick="changeContent('');">
                    <i class="cus cus-help" ></i>
                    <span>使用帮助</span>
                    <i class="icon-chevron-down"></i>
                </a>
            </li>
        </ul>
    </div>
    <!-- end sidebar -->


	<!-- main container -->
    <div class="content" style="margin-bottom: 0px;" name="contentDiv">

       <!--  <div class="container-fluid">
        </div> -->
        <iframe id="frame" src="jsp/dataCenter.jsp" frameborder="0" scrolling="no" width="100%" name="frame"  height="800px"  ></iframe>
    </div>


	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-ui-1.10.2.custom.min.js"></script>
    <!-- knob -->
    <script src="js/jquery.knob.js"></script>
    <!-- flot charts -->
    <script src="js/jquery.flot.js"></script>
    <script src="js/jquery.flot.stack.js"></script>
    <script src="js/jquery.flot.resize.js"></script>
    <script src="js/theme.js"></script>

    <script type="text/javascript">
    
        function changeContent(newUrl){
        	var frame = document.getElementById('frame');
        	frame.src = newUrl;
        }
    </script>

	</div>
    
</body>
</html>