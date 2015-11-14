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
			var myChart = ec.init(document.getElementById('one-charts-pie'));
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
						position: 'left',
						textStyle: {
							fontSize: '20',
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
						text: '86%',
						x: 'center',
						y: 'center',
						itemGap: 20,
						textStyle: {
							color: '#999',
							fontFamily: '微软雅黑',
							fontSize: 30,
							fontWeight: 'bold'
						}
					},
					tooltip: {
						show: true,
						trigger: 'item',
						formatter: "{a} <br/>{b} 占比: {c}(%)"
					},

					toolbox: {
						show: false
					},
					calculable: false,
					series: [{
						name: '举报数',
						type: 'pie',
						startAngle: -90,
						clockWise: false,
						center: ['50%', '50%'],
						radius: [77, 102],
						clockWise: true,
						color: 'red',
						itemStyle: dataStyle,
						data: [{
							value: 68,
							name: '有效举报',
							itemStyle: {
								normal: {
									color: '#eb6e6e'
								}
							}
						}, {
							value: 32,
							name: 'invisible',
							itemStyle: placeHolderStyle
						}]
					}, {
						name: '举报数',
						type: 'pie',
						startAngle: -90,
						clockWise: false,
						radius: [50, 75],
						clockWise: true,
						itemStyle: dataStyle,
						data: [{
							value: 50,
							name: '举报总数',
							itemStyle: {
								normal: {
									color: '#4a90e2'
								}
							}
						}, {
							value: 50,
							name: 'invisible',
							itemStyle: placeHolderStyle
						}]

					}]
				};
				// 为echarts对象加载数据 
				myChart.setOption(option);
				window.addEventListener("resize", function() {
					myChart.resize();
				});
			}
		);