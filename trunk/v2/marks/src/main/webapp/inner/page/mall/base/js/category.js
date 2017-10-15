var appInfo = {
	listUrl : top.window.urlBase + '/inner/category/list.do',// 获取品类管理列表接口
																// Category
	saveUrl : top.window.urlBase + '/inner/category/save.do',// 保存新增品类管理接口
	updateUrl : top.window.urlBase + '/inner/category/update.do',// 编辑品类管理信息接口
	deleteUrl : top.window.urlBase + '/inner/category/delete.do',// 删除品类管理接口
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
function topNode() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#parentName").val("总类");
	$("#parentId").val("top");
	$("#lvl").val(1);
	$("#pNameTr").hide();

}
// 新增
function add() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.lvl >= 5) {
		showMsg("只能新增5级！");
		return;
	}
	$("#pNameTr").show();
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#parentName").val(appInfo.selectedData.typeName);
	$("#parentId").val(appInfo.selectedId);
	$("#lvl").val(appInfo.selectedData.lvl + 1);
}

// 编辑
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$("#parentNameTr").show();
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
			var parms = "typeId=" + appInfo.selectedId;
			$.post(appInfo.deleteUrl, parms, function(data) {
				if (data.retcode == '0') {
					loadList();
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
			loadList();
			appInfo.selectedData = {};
			appInfo.selectedId = -1;
			showMsg("保存成功");
		} else {
			showMsg(data.retmsg);
		}
	});
}

function loadList() {
	$('#tbList').treegrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		rownumbers : true,
		idField : 'typeId',
		treeField : 'typeName',
		singleSelect : true,
		queryParams : appInfo.requestParam,
		columns : [ [ {
			title : '品类',
			field : 'typeName',
			width : 300
		}, {
			title : '品类ID',
			field : 'typeId',
			width : 200,
			align : "center"
		}, {
			
			title : '创建时间',
			field : 'createtime',
			width : 200,
			align : "center"
		} ] ],
		onBeforeExpand : function(row) {
			$("#tbList").treegrid("options").url = appInfo.listUrl
					+ "?parentId=" + row.typeId + "&_timer="
					+ new Date().getTime();
		},
		onClickRow : function(rowData) {
			appInfo.selectedId = rowData.typeId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowData) {
			appInfo.selectedId = rowData.typeId;
			appInfo.selectedData = rowData;
			edit();
		},
		onLoadSuccess : function(row, data) {
			$("#tbList").treegrid('unselectAll');
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
