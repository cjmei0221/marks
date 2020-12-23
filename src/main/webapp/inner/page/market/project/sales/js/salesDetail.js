var appInfo = {
	listUrl : top.window.urlBase + '/inner/salesDetail/list.do',// 获取促销明细列表接口
																// SalesDetail
	updateUrl : top.window.urlBase + '/inner/salesDetail/update.do',// 编辑促销明细信息接口
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

// 编辑
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$("#editWin").window({
		title : "编辑"
	}).window("open");
	appInfo.formStatus = "edit";
	$('#ff').form('load', appInfo.selectedData);
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

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});
});
/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
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
			$("#editWin").window("close");
			app.myreload("#tbList");
			appInfo.selectedData = {};
			appInfo.selectedId = -1;
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
		striped : true,
//		nowrap : true,
//		animate : true,
//		collapsible : true,
//		fitColumns : true,
//		autoRowHeight : false,
		idField : 'id',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '编号',
			field : 'id',
			width : 180,
			align : "center"
		}, {
			title : '方案编号',
			field : 'projectCode',
			width : 180,
			align : "center"
		}, {
			title : '方案名称',
			field : 'projectName',
			width : 200,
			align : "center"
		
		}, {
			title : '业务名称',
			field : 'ywName',
			width : 100,
			align : "center"
		
		}, {
			title : '是否有奖品',
			field : 'isAward',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if(value==0){
					return "否";
				}
				return "是";
			}
		}, {
			title : '奖项类型',
			field : 'awardTypeName',
			width : 100,
			align : "center"
		}, {
			title : '奖品类型',
			field : 'typeName',
			width : 100,
			align : "center"
		}, {
			title : '奖项',
			field : 'itemName',
			width : 100,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 180,
			align : "center"
		}, {
			title : '备注',
			field : 'remarks',
			width : 100,
			align : "center"
		}, {
			title : '用户编号',
			field : 'userCode',
			width : 100,
			align : "center"
		}, {
			title : '用户名称',
			field : 'userName',
			width : 100,
			align : "center"
		}, {
			title : '用户角色',
			field : 'roleName',
			width : 100,
			align : "center"
		}, {
			title : '机构名称',
			field : 'orgName',
			width : 100,
			align : "center"
		}, {
			title : '批次号',
			field : 'batchId',
			width : 100,
			align : "center"
		}, {
			title : '状态',
			field : 'statusName',
			width : 100,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 180,
			align : "center"
		}, {
			title : '销售金额',
			field : 'saleAmt',
			width : 100,
			align : "center"
		}, {
			title : '成本金额',
			field : 'costAmt',
			width : 100,
			align : "center"
//		}, {
//			title : '收货电话',
//			field : 'receiveTel',
//			width : 100,
//			align : "center"
//		}, {
//			title : '收货人',
//			field : 'receiveUser',
//			width : 100,
//			align : "center"
//		}, {
//			title : '收货地址',
//			field : 'receiveAddr',
//			width : 100,
//			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.id;
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
