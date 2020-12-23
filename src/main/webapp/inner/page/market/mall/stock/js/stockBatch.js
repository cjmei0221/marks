var appInfo = {
	listUrl : top.window.urlBase + '/inner/stockBatch/list.do',// 获取库存批次列表接口
																// StockBatch
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
		title : "条码明细"
	}).window("open");
	var path = '/inner/page/mall/stock/barCodeLog.html?id='+id;
    var strHtml = "<iframe width='100%' height='420px'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
    $("#barlogShow").html(strHtml);
}
function showBatchLog(id){
	$("#logWin").window({
		title : "批次明细"
	}).window("open");
	var path = '/inner/page/mall/stock/batchTraceLog.html?id='+id;
    var strHtml = "<iframe width='100%' height='420px'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
    $("#barlogShow").html(strHtml);
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
		idField : 'batchId',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '批次号',
			field : 'batchId',
			width : 200,
			align : "center",
			formatter : function(value, row, index) {
				if(row.stockType==0){
					return '<a href="javascript:void(0)" onclick="showLog(\''+value+'\')">'+value+'</a>';
				}
				return '<a href="javascript:void(0)" onclick="showBatchLog(\''+value+'\')">'+value+'</a>';
			}
		}, {
			title : '库存编号',
			field : 'stockId',
			width : 200,
			align : "center"
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
			title : '库类型',
			field : 'goodTypeName',
			width : 100,
			align : "center"
		}, {
			title : '来源类型',
			field : 'ywName',
			width : 100,
			align : "center"
		}, {
			title : '进货价',
			field : 'costPrice',
			width : 100,
			align : "center"
		}, {
			title : '数量',
			field : 'nums',
			width : 100,
			align : "center"
		}, {
			title : '金额',
			field : 'amount',
			width : 100,
			align : "center"
		}, {
			title : '出库数量',
			field : 'outNums',
			width : 100,
			align : "center"
		}, {
			title : '出库金额',
			field : 'outAmt',
			width : 100,
			align : "center"
		}, {
			title : '剩余数量',
			field : 'balNums',
			width : 100,
			align : "center"
		}, {
			title : '剩余金额',
			field : 'balAmt',
			width : 100,
			align : "center"
		}, {
			title : '库存数量',
			field : 'stockBalNums',
			width : 100,
			align : "center"
		}, {
			title : '库存金额',
			field : 'stockBalAmt',
			width : 100,
			align : "center"
		}, {
			title : '商品编号',
			field : 'goodNo',
			width : 100,
			align : "center"
		}, {
			title : '国际条码',
			field : 'barNo',
			width : 100,
			align : "center"
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 200,
			align : "center"
		}, {
			title : '库存管理方式',
			field : 'stockTypeName',
			width : 100,
			align : "center"
		}, {
			title : '生产日期',
			field : 'productDate',
			width : 100,
			align : "center"
		}, {
			title : '到期日期',
			field : 'expireDate',
			width : 100,
			align : "center"
		}, {
			title : '供应商编号',
			field : 'supplierId',
			width : 120,
			align : "center"
		}, {
			title : '供应商',
			field : 'supplierName',
			width : 150,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 180,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 180,
			align : "center"
		}, {
			title : '备注',
			field : 'remarks',
			width : 200,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.batchId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.batchId;
			appInfo.selectedData = rowData;
			edit();
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
