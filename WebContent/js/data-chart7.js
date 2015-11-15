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
		var myChart2 = ec.init(document.getElementById('four-charts-pie'));
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
				text: '90%',
				x: 'center',
				y: 'center',
				center: 20,
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
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			legend: {
				show:false,
				x: 'center',
				y: 'bottom',
				data: ['二级电流过载警告', '一级电流过载警告']
			},
			toolbox: {
				show: false
			},
			calculable: false,
			series: [{
				name: '事故避免概率',
				type: 'pie',
				clockWise: true,
				startAngle: -90,
				center:['50%','50%'],
				radius: [77, 102],
				itemStyle: dataStyle,
				data: [{
					value: 90,
					name: '二级电流过载警告',
					itemStyle: {
						normal: {
							color: '#28abec'
						}
					}
				}, {
					value: 10,
					name: 'invisible',
					itemStyle: placeHolderStyle
				}]
			}, {
				name: '事故避免概率',
				type: 'pie',
					clockWise: true,
				startAngle: -90,
				radius: [50, 75],
				itemStyle: dataStyle,
				data: [{
					value: 79,
					name: '一级电流过载警告',
					itemStyle: {
						normal: {
							color: '#50d6e3'
						}
					}
				}, {
					value: 21,
					name: 'invisible',
					itemStyle: placeHolderStyle
				}]

			}]
		};
		// 为echarts对象加载数据 
		myChart2.setOption(option);
		window.addEventListener("resize", function() {
			myChart2.resize();
		});
	}
);