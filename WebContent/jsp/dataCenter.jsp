<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../css/Chart.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="width:30%">
		<div>
			<canvas id="canvas_1"></canvas>
		</div>
		<
	</div>
	
	<script>
		/* var randomScalingFactor = function(){ return Math.round(Math.random()*100)}; */
		var lineChartData = {
			labels : ["January","February","March","April","May","June","July"],
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(235, 110, 110, 1)",
					strokeColor : "rgba(235, 110, 110, 1)",
					pointColor : "rgba(235, 110, 110, 1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(235, 110, 110, 1)",
					data : [1600,2200,2100,1500,1300,1600,1730]
				},
				{
					label: "My Second dataset",
					fillColor : "rgba(40, 171, 236, 0.6)",
					strokeColor : "rgba(40, 171, 236, 0.6)",
					pointColor : "rgba(40, 171, 236, 0.6)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(40, 171, 236, 0.6)",
					data : [1000,1400,1600,1300,1000,1400,1530]
				}
			]

		}

	window.onload = function(){
		var ctx = document.getElementById("canvas_1").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}
	</script>
</body>
</html>