require.config({
	paths: {
		echarts: 'http://echarts.baidu.com/build/dist'
	}
});
require(
	[
		'echarts',
		'echarts/chart/bar',
		'echarts/chart/line'
	],
	function(ec) {
		var myChart1 = ec.init(document.getElementById('four-charts'));
		var zrColor = require('zrender/tool/color');
		var colorList = [
			'#ff7f50', '#87cefa', '#da70d6', '#32cd32', '#6495ed',
			'#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0', '#ffa500', '#40e0d0'
		];
		var itemStyle = {
			normal: {
				color: function(params) {
					if (params.dataIndex < 0) {
						// for legend
						return zrColor.lift(
							colorList[colorList.length - 1], params.seriesIndex * 0.1
						);
					} else {
						// for bar
						return zrColor.lift(
							colorList[params.dataIndex], params.seriesIndex * 0.1
						);
					}
				}
			}
		};
		var option = {
			tooltip: {
				trigger: 'axis',
				backgroundColor: 'rgba(255,255,255,0.7)',
				axisPointer: {
					type: 'shadow'
				},
				formatter: function(params) {
					// for text color
					var color = colorList[params[0].dataIndex];
					var res = '<div style="color:' + color + '">';
					res += '<strong>' + params[0].name + '电流过载警告：</strong>'
					for (var i = 0, l = params.length; i < l; i++) {
						res += '<br/>' + params[i].seriesName + ' : ' + params[i].value
					}
					res += '</div>';
					return res;
				}
			},
			legend: {
				data: ['二级电流过载警告', '一级电流过载警告'],
				x: 'center',
				y: 'bottom',
				//orient : 'vertical'
			},
			toolbox: {
				show: false

			},
			calculable: true,
			xAxis: [{
				type: 'category',
				data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
			}],
			yAxis: [{
				type: 'value',
				splitArea: {
					show: true
				}
			}],
			series: [{
				name: '二级电流过载警告',
				itemStyle: {
					normal: {
						color: '#28abec',
					}
				},
				type: 'bar',
				data: [37, 45, 27, 33, 28, 45, 30, 19, 29, 23, 35, 19]
			}, {
				name: '一级电流过载警告',
				itemStyle: {
					normal: {
						color: '#50d6e3',
					}
				},
				type: 'bar',
				data: [15, 21, 16, 7, 19, 40, 12, 6, 11, 17, 25, 11]
			}]

		};
		// 为echarts对象加载数据 
		myChart1.setOption(option);
		window.addEventListener("resize", function() {
			myChart1.resize();
		});
	}
);