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
		var et_Chart = ec.init(document.getElementById('two-charts'));
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
				name: '举报总数',
				type: 'line',
				stack:'总数',
				itemStyle: {
					normal: {
						color: '#50e3c2',
						areaStyle: {
							type: 'default'
						}
					}
				},
				data: [700, 900, 1314, 1000, 1590, 1670, 1330, 1550, 1999, 1011, 1220, 900]
			}, {
				name: '有效举报',
				type: 'line',
				stack:'总数',
				itemStyle: {
					normal: {
						
						color: '#f8e71c',
						borderWidth: 3,
						lineStyle: {
							color: 'rgba(248,231,248,.6)',
							width:3,
						},
						areaStyle: {
							type: 'default'
						}
					}
				},
				
				data: [1003, 1122, 1531, 1155, 1790, 1800, 1510, 1770, 2111, 1245, 1500, 1100]
			}]
		};
		// 为echarts对象加载数据 
		et_Chart.setOption(option);
		window.addEventListener("resize", function() {
			et_Chart.resize();
		});
	}
);