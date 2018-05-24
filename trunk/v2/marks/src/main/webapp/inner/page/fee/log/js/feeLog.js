var appInfo = {
	listUrl : top.window.urlBase + '/inner/feeLog/list.do',// 获取费用明细列表接口 FeeLog
	saveUrl : top.window.urlBase + '/inner/feeLog/save.do',// 保存新增费用明细接口
	updateUrl : top.window.urlBase + '/inner/feeLog/update.do',// 编辑费用明细信息接口
	deleteUrl : top.window.urlBase + '/inner/feeLog/delete.do',// 删除费用明细接口
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
// 新增
function add() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
}

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
// 删除
function del() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}

	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "id=" + appInfo.selectedId;
			$.post(appInfo.deleteUrl, parms, function(data) {
				if (data.retcode == '0') {
					app.myreload("#tbList");
					appInfo.selectedData = {};
					appInfo.selectedId = -1;
					showMsg("删除成功");
				} else {
					showMsg(data.retmsg);
				}
			});
		}
	});

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
		// toolbar : "#tb",
		idField : 'id',
		height : 520,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '单号',
			field : 'id',
			width : 200,
			align : "center"
		}, {
			title : '科目编号',
			field : 'feeCode',
			width : 100,
			align : "center"
		}, {
			title : '科目名称',
			field : 'feeName',
			width : 100,
			align : "center"
		}, {
			title : '条目编号',
			field : 'itemCode',
			width : 100,
			align : "center"
		}, {
			title : '条目名称',
			field : 'itemName',
			width : 100,
			align : "center"
		}, {
			title : '交易时间',
			field : 'tranTime',
			width : 200,
			align : "center"
		}, {
			title : '交易金额',
			field : 'tranAmt',
			width : 100,
			align : "center"
		}, {
			title : '收支',
			field : 'inOrOut',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if(value==1){
					return '收入';
				}
				return '支出'
			}
		}, {
			title : '备注',
			field : 'remarks',
			width : 200,
			align : "center"
		}, {
			title : '收款人编号',
			field : 'payeeId',
			width : 100,
			align : "center"
		}, {
			title : '收款人手机号',
			field : 'payeeMobile',
			width : 100,
			align : "center"
		}, {
			title : '收款人',
			field : 'payeeName',
			width : 100,
			align : "center"
		}, {
			title : '角色类型',
			field : 'payeeRoleType',
			width : 100,
			align : "center"
		}, {
			title : '角色类型',
			field : 'payeeRole',
			width : 100,
			align : "center"
		}, {
			title : '机构编号',
			field : 'payeeOrgId',
			width : 100,
			align : "center"
		}, {
			title : '机构名称',
			field : 'payeeOrgName',
			width : 100,
			align : "center"
		}, {
			title : '编号',
			field : 'payeeCode',
			width : 100,
			align : "center"
		}, {
			title : '年',
			field : 'year',
			width : 100,
			align : "center"
		}, {
			title : '月',
			field : 'month',
			width : 100,
			align : "center"
		}, {
			title : '关联单号',
			field : 'idNo',
			width : 100,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 100,
			align : "center"
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
