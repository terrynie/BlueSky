<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/Chart.Doughnut.js"></script> 
<script src="../js/Chart.js"></script>
<script src="../js/Chart.Core.js"></script> 
<title>Insert title here</title>
</head>
<body>
	<div style="width:30%">
		<div>
			<canvas id="canvas_1"></canvas>
			
		</div>
		<div id="canvas-holder">
				<canvas id="chart-area1" width="150" height="150"/>
		</div>
		
		<div>
			<canvas id="canvas_2"></canvas>
		</div>
		<div id="canvas-holder">
			<canvas id="chart-area2" width="150" height="150"/>
		</div>
		
		<div>
			<canvas id="canvas_3"></canvas>
		</div>
		<div id="canvas-holder">
			<canvas id="chart-area3" width="150" height="150"/>
		</div>
		
		<div>
			<canvas id="canvas_4" height="450" width="600"></canvas>
		</div>
	</div>
	
	<script>
		/* var randomScalingFactor = function(){ return Math.round(Math.random()*100)}; */
		var lineChartData1 = {
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
		
		var lineChartData2 = {
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
		
		var lineChartData3 = {
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
		
		var doughnutData1 = [
		    				{
		    					value: 1,
		    					label: "One"
		    				},
		    				{
		    					value: 1,
		    					label: "Two"
		    				}

		    			];
		
		var doughnutData2 = [
			    				{
			    					value: 1,
			    					label: "One"
			    				},
			    				{
			    					value: 1,
			    					label: "Two"
			    				}

			    			];
		
		var doughnutData3 = [
			    				{
			    					value: 1,
			    					label: "One"
			    				},
			    				{
			    					value: 1,
			    					label: "Two"
			    				}

			    			];
		
		
		var barChartData1 = {
				labels : ["January","February","March","April","May","June","July"],
				datasets : [
					{
						fillColor : "rgba(220,220,220,0.5)",
						strokeColor : "rgba(220,220,220,0.8)",
						highlightFill: "rgba(220,220,220,0.75)",
						highlightStroke: "rgba(220,220,220,1)",
						data : [38,45,35,50,32,37]
					},
					{
						fillColor : "rgba(151,187,205,0.5)",
						strokeColor : "rgba(151,187,205,0.8)",
						highlightFill : "rgba(151,187,205,0.75)",
						highlightStroke : "rgba(151,187,205,1)",
						data : [14,8,20,3,32,36]
					}
				]

			}

		window.onload = function(){
			var ctx1 = document.getElementById("canvas_1").getContext("2d");
			window.myLine = new Chart(ctx1).Line(lineChartData1, {responsive: true});
		
			var ctx2  = document.getElementById("canvas_2").getContext("2d");
			window.myLine = new Chart(ctx2).Line(lineChartData2, {responsive:true});
			
			var ctx3  = document.getElementById("canvas_3").getContext("2d");
			window.myLine = new Chart(ctx3).Line(lineChartData3, {responsive:true});
			
			var ctx1_1 = document.getElementById("chart-area1").getContext("2d");
		    window.myDoughnut = new Chart(ctx1_1).Doughnut(doughnutData1, {responsive : true});
		    
		    var ctx2_1 = document.getElementById("chart-area2").getContext("2d");
		    window.myDoughnut = new Chart(ctx2_1).Doughnut(doughnutData2, {responsive : true});
		    
		    var ctx3_1 = document.getElementById("chart-area3").getContext("2d");
		    window.myDoughnut = new Chart(ctx3_1).Doughnut(doughnutData3, {responsive : true});
			
		    var ctx4 = document.getElementById("canvas_4").getContext("2d");
			window.myBar = new Chart(ctx4).Bar(barChartData1, {
				responsive : true
			});
		
	}
	</script>
</body>
</html>