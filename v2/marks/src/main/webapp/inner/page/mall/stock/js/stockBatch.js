var appInfo = {
	listUrl : top.window.urlBase + '/inner/stockBatch/list.do',// 获取库存批次列表接口
																// StockBatch
	// Brand
	supplierlistUrl : top.window.urlBase + '/inner/supplier/combobox.do',// 获取品牌管理列表接口
	batchSaveBarCodeUrl : top.window.urlBase + '/inner/stockBatch/save.do',// 获取品牌管理列表接口
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
function stockIn() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$("#barCodeWin").window({
		title : "生产条码"
	}).window("open");
	$('#barCodeff').form('load', appInfo.selectedData);
	$("#sendNums").numberbox("setValue", 0);
	$("#supplierId2").combobox("setValue", appInfo.selectedData.supplierId);
	$("#supplier2").val(appInfo.selectedData.supplier);
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

	// 生产条码
	$("#btnOKBarCode").on("click", function() {
		formSubmitForBarCode();
	});
	
	$('#supplierId2').combobox({
		url : appInfo.supplierlistUrl + "?page_number=1&page_size=1000",
		valueField : 'orgid',
		textField : 'orgname',
		onSelect : function(rec) {
			$('#supplier2').val(rec.orgname);
		}
	});
});

function formSubmitForBarCode() {
	if (!$('#barCodeff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.batchSaveBarCodeUrl;
	var parms = $("#barCodeff").serialize();
	$.post(reqUrl, parms, function(data) {
		if (typeof data === 'string') {
			try {
				data = $.parseJSON(data);
			} catch (e0) {
				showMsg("json格式错误");
				return;
			}
		}
		if (data.retcode == "0") {
			$("#barCodeWin").window("close");
			app.myreload("#tbList");
			showMsg("保存成功");
		} else {
			showMsg(data.retmsg);
		}
	});
}

function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		idField : 'batchId',
		height : 580,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '批次号',
			field : 'batchId',
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
			title : '业务类型',
			field : 'ywCodeName',
			width : 100,
			align : "center"
		}, {
			title : '进货价',
			field : 'stockPrice',
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
