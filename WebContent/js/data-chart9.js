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
		var myChart3 = ec.init(document.getElementById('five-charts-pie'));
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
				text: '79%',
				x: 'center',
				y: 'center',
				itemGap: 20,
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
				data: ['红温警告总次数', '有效红温警告总次数']
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
					value:79,
					name: '红温警告总次数',
					itemStyle: {
						normal: {
							color: '#eb6e6e'
						}
					}
				}, {
					value: 21,
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
					value: 65,
					name: '有效红温警告总次数',
					itemStyle: {
						normal: {
							color: '#d8d8d8'
						}
					}
				}, {
					value: 35,
					name: 'invisible',
					itemStyle: placeHolderStyle
				}]

			}]
		};
		// 为echarts对象加载数据 
		myChart3.setOption(option);
		window.addEventListener("resize", function() {
			myChart3.resize();
		});
	}
);