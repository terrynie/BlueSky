<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=cH8uK7fOCA20DYCMHVftHUQt"></script>
	<title>传递事件参数</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(113.65, 34.78), 11);
	function showInfo(e){
		/* alert("这个点的经纬度是："+e.point.lng + ", " + e.point.lat);  e.point.lng为经度，e.point.lat是纬度*/
		window.open("vedio.jsp");
	}
	map.addEventListener("click", showInfo);
	var point = new BMap.Point(113.65, 34.78);
	var marker = new BMap.Marker(point); // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中

	var label = new BMap.Label("名称：一号工地；负责人：XXX；",{offset:new BMap.Size(20,-10)});
	marker.setLabel(label);
	
</script>
