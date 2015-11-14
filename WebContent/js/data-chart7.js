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
					show: true,
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
				text: '举报数占比',
				x: 'left',
				y: 'left',
				itemGap: 20,
				textStyle: {
					color: 'rgba(30,144,255,0.8)',
					fontFamily: '微软雅黑',
					fontSize: 16,
					fontWeight: 'nomal'
				}
			},
			tooltip: {
				show: true,
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			legend: {
				x: 'center',
				y: 'bottom',
				data: ['有效举报', '举报总数']
			},
			toolbox: {
				show: false
			},
			calculable: false,
			series: [{
				name: '举报数',
				type: 'pie',
				clockWise: false,
				center:['50%','50%'],
				radius: [77, 102],
				itemStyle: dataStyle,
				data: [{
					value: 68,
					name: '有效举报'
				}, {
					value: 32,
					name: 'invisible',
					itemStyle: placeHolderStyle
				}]
			}, {
				name: '3',
				type: 'pie',
				clockWise: false,
				radius: [50, 75],
				itemStyle: dataStyle,
				data: [{
					value: 32,
					name: '举报总数'
				}, {
					value: 68,
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