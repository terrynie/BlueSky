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
		var mianChart = ec.init(document.getElementById('one-charts'));
		var lieStyle = {
			normal: {
				label: {
					show: false
				},
				labelLine: {
					show: false
				}
			}

		};
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
				formatter: "{a} <br/>{b}为 : {c}"
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
				}
			}],
			toolbox: {
				show: false
			},
			series: [{
				name: '有效举报',
				type: 'line',
				stack:'总数',
				itemStyle: {
					normal: {
						color: '#4a90e2',
						//borderColor:"#000",
						borderWidth: 4,
						lineStyle: {
							color: '#4a90e2',
							width:3,
						},
						areaStyle: {
							type: 'default'
						}
					}
				},
				data: [1010, 1400, 1514, 1130, 902, 1110, 1330, 910, 790, 1011, 1044, 1010]
			}, {
				name: '举报总数',
				type: 'line',
				stack:'总数',
				itemStyle: {
					normal: {
						color: '#eb6e6e',
						areaStyle: {
							type: 'default'
						}
					}
				},
				
				data: [1503, 1622, 1831, 1534, 1000, 1230, 1510, 1090, 910, 1245, 1134, 1314]
			}]
		};
		// 为echarts对象加载数据 
		mianChart.setOption(option);
		window.addEventListener("resize", function() {
			mianChart.resize();
		});
	}
);