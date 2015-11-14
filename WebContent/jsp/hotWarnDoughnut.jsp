<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Doughnut Chart</title>
		<script src="../js/Chart.Core.js"></script>
		<script src="../js/Chart.Doughnut.js"></script>
		<style>
			body{
				padding: 0;
				margin: 0;
			}
			#canvas-holder{
				width:30%;
			}
		</style>
	</head>
	<body>
		<div id="canvas-holder">
			<canvas id="chart-area" width="500" height="500"/>
		</div>


	<script>

		var doughnutData = [
				{
					value: 1,
					label: "One"
				},
				{
					value: 1,
					label: "Two"
				}

			];

			window.onload = function(){
				var ctx = document.getElementById("chart-area").getContext("2d");
				window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {responsive : true});
			};



	</script>
	</body>
</html>