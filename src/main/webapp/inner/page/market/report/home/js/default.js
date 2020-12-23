var appInfo = {
	coreUrl : top.window.urlBase + '/inner/home/getCodeData.do',// 获取品牌管理列表接口
																// Brand
	salesForDateUrl : top.window.urlBase + '/inner/home/getSalesForDate.do',// 获取品牌管理列表接口
	salesForSeasonUrl : top.window.urlBase + '/inner/home/getSalesForSeason.do',// 获取品牌管理列表接口		
	salesForMonthUrl : top.window.urlBase + '/inner/home/getSalesForMonth.do',// 获取品牌管理列表接口		// Brand

};
$(function() {
	// 加载核心指标
	loadCoreData(0);
	// 加载近30天销售情况
	getSalesForDate();
	//季度报表
	getSalesForSeason();
	
	getSalesForMonth();
});
function loadCoreData(dateType) {
	$.ajax({
		url : appInfo.coreUrl,
		type : "get",
		data : {
			"dateType" : dateType
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var info = data.info;
				$("#consumeCashAmt").html(info.consumeCashAmt);
				$("#consumeCostAmt").html(info.consumeCostAmt);
				$("#consumeProfixAmt").html(info.consumeProfixAmt);
				$("#incomeAmt").html(info.incomeAmt);
				$("#costAmt").html(info.costAmt);
				$("#profitAmt").html(info.profitAmt);
			} else {
				showMsg(data.retmsg);
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});
}

function getSalesForDate() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	$.ajax({
		url : appInfo.salesForDateUrl,
		type : "get",
		data : {},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var list = data.list;
				var xAxisArr = [];
				var salesNumsArr = [];
				var salesAmtArr = [];
				var costAmtArr = [];
				var profitAmtArr = [];
				if (null != list && list.length > 0) {

					for (var i = 0; i < list.length; i++) {
						var info = list[i];
						xAxisArr.push(info.xAxis);
						salesNumsArr.push(info.salesNums);
						salesAmtArr.push(info.salesAmt);
						costAmtArr.push(info.costAmt);
						profitAmtArr.push(info.profitAmt);
					}

				}
				// 指定图表的配置项和数据
				var option = {
					title : {
						text : '日报表'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '销售金额', '成本金额', '理论收益' ]
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					toolbox : {
						feature : {
							saveAsImage : {}
						}
					},
					xAxis : {
						type : 'category',
						boundaryGap : false,
						data : xAxisArr
					},
					yAxis : {
						type : 'value'
					},
					series : [ {
						name : '销售金额',
						type : 'line',
						data : salesAmtArr
					}, {
						name : '成本金额',
						type : 'line',
						data : costAmtArr
					}, {
						name : '理论收益',
						type : 'line',
						data : profitAmtArr
					} ]
				};

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			} else {
				showMsg(data.retmsg);
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});

}

function getSalesForSeason() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('seasonReport'));

	$.ajax({
		url : appInfo.salesForSeasonUrl,
		type : "get",
		data : {},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var list = data.list;
				var xAxisArr = [];
				var salesNumsArr = [];
				var salesAmtArr = [];
				var costAmtArr = [];
				var profitAmtArr = [];
				if (null != list && list.length > 0) {

					for (var i = 0; i < list.length; i++) {
						var info = list[i];
						xAxisArr.push(info.xAxis);
						salesNumsArr.push(info.salesNums);
						salesAmtArr.push(info.salesAmt);
						costAmtArr.push(info.costAmt);
						profitAmtArr.push(info.profitAmt);
					}

				}
				// 指定图表的配置项和数据
				var option = {
					title : {
						text : '季度报表'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '销售金额', '成本金额', '理论收益' ]
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					toolbox : {
						feature : {
							saveAsImage : {}
						}
					},
					xAxis : {
						type : 'category',
						boundaryGap : false,
						data : xAxisArr
					},
					yAxis : {
						type : 'value'
					},
					series : [ {
						name : '销售金额',
						type : 'line',
						data : salesAmtArr
					}, {
						name : '成本金额',
						type : 'line',
						data : costAmtArr
					}, {
						name : '理论收益',
						type : 'line',
						data : profitAmtArr
					} ]
				};

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			} else {
				showMsg(data.retmsg);
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});

}

function getSalesForMonth() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('monthReport'));

	$.ajax({
		url : appInfo.salesForMonthUrl,
		type : "get",
		data : {},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var list = data.list;
				var xAxisArr = [];
				var salesNumsArr = [];
				var salesAmtArr = [];
				var costAmtArr = [];
				var profitAmtArr = [];
				if (null != list && list.length > 0) {

					for (var i = 0; i < list.length; i++) {
						var info = list[i];
						xAxisArr.push(info.xAxis);
						salesNumsArr.push(info.salesNums);
						salesAmtArr.push(info.salesAmt);
						costAmtArr.push(info.costAmt);
						profitAmtArr.push(info.profitAmt);
					}

				}
				// 指定图表的配置项和数据
				var option = {
					title : {
						text : '月度报表'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '销售金额', '成本金额', '理论收益' ]
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					toolbox : {
						feature : {
							saveAsImage : {}
						}
					},
					xAxis : {
						type : 'category',
						boundaryGap : false,
						data : xAxisArr
					},
					yAxis : {
						type : 'value'
					},
					series : [ {
						name : '销售金额',
						type : 'line',
						data : salesAmtArr
					}, {
						name : '成本金额',
						type : 'line',
						data : costAmtArr
					}, {
						name : '理论收益',
						type : 'line',
						data : profitAmtArr
					} ]
				};

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			} else {
				showMsg(data.retmsg);
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});

}

