require.config({
	paths: {
		echarts: 'http://echarts.baidu.com/build/dist'
	}
});
require(
	[
		'echarts',
		'echarts/chart/pie'
	],
	function(ec) {
		var pie_Chart = ec.init(document.getElementById('two-charts-pie'));
		var dataStyle = {
			normal: {
				label: {
					show: false
				},
				labelLine: {
					show: false
				}
			},
			emphasis: {
				label: {
					show: false,
					position: 'center',
					textStyle: {
						fontSize: '30',
						fontWeight: 'bold'
					}
				}
			}
		};
		var placeHolderStyle = {
			normal: {
				color: 'rgba(0,0,0,0)',
				label: {
					show: false
				},
				labelLine: {
					show: false
				}
			},
			emphasis: {
				color: 'rgba(0,0,0,0)'
			}
		};
		var option = {
			title: {
				text: '72%',
				x: 'center',
				y: 'center',
				textStyle: {
					color: 'rgba(30,144,255,0.8)',
					fontFamily: '微软雅黑',
					fontSize: 30,
					fontWeight: 'bold'
				}
			},
			tooltip: {
				show: true,
				trigger: 'item',
				formatter: "{a} <br/>{b}占比 : {c}%"
			},
			legend: {
				show:false,
				x: 'center',
				y: 'bottom',
				data: ['有效出勤', '出勤总数']
			},
			toolbox: {
				show: false
			},
			calculable: false,
			series: [{
				name: '出勤总数',
				type: 'pie',
				clockWise: true,
				startAngle: -90,
				center: ['50%', '50%'],
				radius: [77, 102],
				itemStyle: dataStyle,
				data: [{
					value: 72,
					name: '出勤总数',
					itemStyle: {
						normal: {
							color: '#f8e71c',
							
						}
					}
				}, {
					value: 23,
					name: 'invisible',
					itemStyle: placeHolderStyle
				}]
			}, {
				name: '有效出勤',
				type: 'pie',
				clockWise: true,
				startAngle: -90,
				radius: [50, 75],
				itemStyle: dataStyle,
				data: [{
					value: 59,
					name: '有效出勤',
					itemStyle: {
						normal: {
							color: '#50e3c2'
						}
					}
				}, {
					value: 41,
					name: 'invisible',
					itemStyle: placeHolderStyle
				}]

			}]
		};
		// 为echarts对象加载数据 
		pie_Chart.setOption(option);
		window.addEventListener("resize", function() {
			pie_Chart.resize();
		});
	}
);