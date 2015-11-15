require.config({
	paths: {
		echarts: 'http://echarts.baidu.com/build/dist'
	}
});
require(
	[
		'echarts',
		'echarts/chart/line'
	],
	function(ec) {
		var areaChart = ec.init(document.getElementById('three-charts'));
		var option = {
			title: {
				text: "",
				x: "center",
				y: 'top',
				textStyle: {
					fontSize: 20,
					fontFamily: "微软雅黑",
				}
			},
			grid: {
				borderWidth: 0
			},
			tooltip: {
				trigger: "item",
				axisPointer: {
					show: false,
					type: 'cross',
					lineStyle: {
						type: 'dashed',
						width: 1
					}
				},
				formatter: "{a} <br/>{b}月份为 : {c}"
			},
			legend: {
				data: ['PM2.5(天气质量检测报告)', 'PM10(PM10数据监测站报告)'],
				x: 'center',
				y: 'bottom'
			},
			calculable: true,
			xAxis: [{
				type: 'category',
				axisLine: {
					lineStyle: {
						color: '#ccc'
					}
				},
				splitLine: {
					show: true,
					lineStyle: {
						color: '#483d8b',
						type: 'dotted',
						width: 0
					}
				},
				boundaryGap: false,
				data: ['1月份', '2月份', '3月份', '4月份', '5月份', '6月份', '7月份', '8月份', '9月份', '10月份', '11月份', '12月份']
			}],
			yAxis: [{
				name: 'PM值',
				type: 'value',
				//max:3000,
				axisLine: {
					lineStyle: {
						color: '#ccc',
						width: 2,
						type: 'solid'
					}
				},
				splitLine: {
					show: true,
					lineStyle: {
						color: '#483d8b',
						type: 'dotted',
						width: 0
					}
				},
				splitArea: {
					show: true,
					areaStyle: {

						color: 'rgba(255,255,255,1)'
					}
				}
			}],
			toolbox: {
				show: false
			},
			series: [{
				name: 'PM2.5(天气质量检测报告)',
				type: 'line',
				smooth: true,
				itemStyle: {
					normal: {
						color: '#7ed321',
						borderWidth: 4,
						areaStyle: {
							color: 'rgba(255,255,255,1)',
							width:3,
							type: 'default'
						}
					}
				},
				data: [23, 35, 45, 54, 14, 23, 56, 49, 60, 65, 36, 25]
			}, {
				name: 'PM10(PM10数据监测站报告)',
				type: 'line',
				smooth: true,
				itemStyle: {
					normal: {
						color: '#f5a623',
						borderWidth: 4,
						areaStyle: {
							color: 'rgba(245,166,35,0.6)',
							width:3,
							type: 'default'
						}
					}
				},
				data: [65, 55, 77, 72, 57, 55, 87, 78, 89, 99, 76, 56]
			}]
		};
		areaChart.setOption(option);
		window.addEventListener("resize", function() {
			areaChart.resize();
		});
	}
);