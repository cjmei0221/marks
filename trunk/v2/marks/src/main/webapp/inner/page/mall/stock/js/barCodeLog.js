var appInfo = {
	listUrl : top.window.urlBase + '/inner/trace/list.do',// 获取追踪码管理列表接口 Trace
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		batchId:""
	},
	formStatus : "new"
};
appInfo.requestParam.batchId=tool.getUrlParams("id");
// -----------------权限控制功能 start---------------
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

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});
});
function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		idField : 'traceId',
		height : 400,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '追踪码',
			field : 'traceId',
			width : 250,
			align : "center"
		}, {
			title : '条码',
			field : 'barcode',
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
			width : 100,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 150,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 150,
			align : "center"
		}, {
			title : '库存状态',
			field : 'stockStatusName',
			width : 100,
			align : "center"
		}, {
			title : '采购单号',
			field : 'cgNo',
			width : 100,
			align : "center"
		}, {
			title : '原价',
			field : 'price',
			width : 100,
			align : "center"
		}, {
			title : '售价',
			field : 'salePrice',
			width : 100,
			align : "center"
		}, {
			title : '进货价',
			field : 'costPrice',
			width : 100,
			align : "center"
		}, {
			title : '订单号',
			field : 'orderId',
			width : 100,
			align : "center"
		}, {
			title : '是否为赠品',
			field : 'isGift',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "赠品";
				}
				return '非赠品';
			}
		}, {
			title : '原追踪码',
			field : 'oriTraceId',
			width : 100,
			align : "center"
		}, {
			title : '机构',
			field : 'orgname',
			width : 100,
			align : "center"

		}, {
			title : '类别',
			field : 'typeName',
			width : 100,
			align : "center"

		}, {
			title : '品牌',
			field : 'brandName',
			width : 100,
			align : "center"
		}, {
			title : '生产日期',
			field : 'productDate',
			width : 100,
			align : "center"
		}, {
			title : '供应商',
			field : 'supplierName',
			width : 100,
			align : "center"
		}, {
			title : '会员名称',
			field : 'username',
			width : 100,
			align : "center"
		}, {
			title : '会员手机号',
			field : 'mobile',
			width : 100,
			align : "center"
		}, {
			title : '入库日期',
			field : 'stockInDate',
			width : 100,
			align : "center"
		}, {
			title : '结束日期',
			field : 'endDate',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.traceId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.id;
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
