var appInfo = {
	listUrl : top.window.urlBase + '/inner/stockInfo/list.do',// 获取库存管理列表接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};
// -----------------权限控制功能 start---------------
function showLog(id){
	$("#logWin").window({
		title : "批次明细"
	}).window("open");
	var path = '/inner/page/mall/stock/stockBatchLog.html?id='+id;
    var strHtml = "<iframe width='100%' height='520px'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
    $("#postShow").html(strHtml);
}

// -----------------权限控制功能 end---------------
$(function() {
	// 加载列表
	loadList();

	// 搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});
});


function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		idField : 'stockId',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '库存编号',
			field : 'stockId',
			width : 150,
			align : "center",
			formatter : function(value, row, index) {
				return '<a href="javascript:void(0)" onclick="showLog(\''+value+'\')">'+value+'</a>';
			}
		}, {
			title : '机构编号',
			field : 'orgId',
			width : 100,
			align : "center"
		}, {
			title : '机构名称',
			field : 'orgName',
			width : 100,
			align : "center"
		}, {
			title : '商品编号',
			field : 'goodNo',
			width : 100,
			align : "center"
		}, {
			title : '商品条码',
			field : 'barNo',
			width : 100,
			align : "center"
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 200,
			align : "center"
		
		}, {
			title : '库存数量',
			field : 'stockNums',
			width : 100,
			align : "center"
		}, {
			title : '库存金额',
			field : 'stockAmount',
			width : 100,
			align : "center"
		}, {
			title : '售出数量',
			field : 'saleNums',
			width : 100,
			align : "center"
		}, {
			title : '售出金额',
			field : 'saleAmt',
			width : 100,
			align : "center"
		
//		}, {
//			title : '次品数量',
//			field : 'secondNums',
//			width : 100,
//			align : "center"
//		}, {
//			title : '次品金额',
//			field : 'secondAmount',
//			width : 100,
//			align : "center"
//		}, {
//			title : '预占数量',
//			field : 'holdNums',
//			width : 100,
//			align : "center"
//		}, {
//			title : '预占金额',
//			field : 'holdAmount',
//			width : 100,
//			align : "center"
		}, {
			title : '报废数量',
			field : 'scrapNums',
			width : 100,
			align : "center"
		}, {
			title : '报废金额',
			field : 'scrapAmount',
			width : 100,
			align : "center"
//		}, {
//			title : '赠品数量',
//			field : 'giftNums',
//			width : 100,
//			align : "center"
//		}, {
//			title : '赠品金额',
//			field : 'giftAmount',
//			width : 100,
//			align : "center"
		}, {
			title : '总数量',
			field : 'totalNums',
			width : 100,
			align : "center"
		}, {
			title : '总金额',
			field : 'totalAmount',
			width : 100,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 180,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.stockId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.stockId;
			appInfo.selectedData = rowData;
		},
		onLoadSuccess : function(data) {
			$("#tbList").datagrid('unselectAll');
			appInfo.selectedData = {};
		}
	});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		appInfo.requestParam.page_number = params.page;
		appInfo.requestParam.page_size = params.rows;
		appInfo.requestParam.keyword = $("#keyword").val();
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.retcode == '0') {
					var list = data.list;
					that.data().datagrid["cache"] = data;
					success({
						"total" : data.total_count,
						"rows" : list
					});
					return true;
				} else {
					showMsg(data.retmsg);
					success({
						"total" : 0,
						"rows" : []
					});
				}
			},
			error : function(err) {
				loadError.apply(this, arguments);
			}
		});
	}
}
