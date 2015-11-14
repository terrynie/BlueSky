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
				data: ['有效举报', '举报总数'],
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
				boundaryGap: false,
				data: ['1月份', '2月份', '3月份', '4月份', '5月份', '6月份', '7月份', '8月份', '9月份', '10月份', '11月份', '12月份']
			}],
			yAxis: [{
				name: '群众举报次数',
				type: 'value',
				//				max:3000,
				axisLine: {
					lineStyle: {
						color: '#ccc',
						width: 0,
						type: 'solid'
					}
				},
				splitLine: {
					show: true,
					lineStyle: {
						color: '#483d8b',
						type: 'dotted',
						width: 1
					}
				},
				splitArea: {
					show: true,
					areaStyle: {
//						color: ['rgba(205,92,92,0.3)', 'rgba(255,215,0,0.3)']
						color:'rgba(255,255,255,.3)'
					}
				}
			}],
			toolbox: {
				show: false
			},
			series: [{
				name: '举报总数',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						areaStyle: {
							type: 'default'
						}
					}
				},
				data: [1203, 1322, 1831, 1534, 900, 1230, 2510, 790, 1000, 1245, 1234, 1413]
			}, {
				name: '有效举报',
				type: 'line',
				stack: '总量',
				itemStyle: {
					normal: {
						areaStyle: {
							type: 'default'
						}
					}
				},
				data: [1110, 1200, 1514, 960, 602, 1010, 1530, 630, 704, 1034, 944, 1210]
			}]
		};
		areaChart.setOption(option);
		window.addEventListener("resize", function() {
			areaChart.resize();
		});
	}
);