var appInfo = {
	listUrl : top.window.urlBase + '/inner/area/list.do',// 获取区域管理列表接口 Area
	saveUrl : top.window.urlBase + '/inner/area/save.do',// 保存新增区域管理接口
	updateUrl : top.window.urlBase + '/inner/area/update.do',// 编辑区域管理信息接口
	deleteUrl : top.window.urlBase + '/inner/area/delete.do',// 删除区域管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		parentId : ""
	},
	formStatus : "new"
};
// -----------------权限控制功能 start---------------
// 新增
function topNode() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#parentName").val("总区");
	$("#parentId").val("top");
	$("#lvl").val(1);
	$("#parentNameTr").hide();

}
function add() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.lvl >= 5) {
		showMsg("只能新增5级！");
		return;
	}
	$("#parentNameTr").show();
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#parentName").val(appInfo.selectedData.areaName);
	$("#parentId").val(appInfo.selectedId);
	$("#lvl").val(appInfo.selectedData.lvl + 1);

}

// 编辑
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.lvl == 0) {
		showMsg("根节点不可编辑！");
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
	if (appInfo.selectedData.lvl == 0) {
		showMsg("根节点不可删除！");
		return;
	}
	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "areaId=" + appInfo.selectedId;
			$.post(appInfo.deleteUrl, parms, function(data) {
				if (data.retcode == '0') {
					appInfo.requestParam.parentId = "";
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
			appInfo.requestParam.parentId = "";
			loadList();
			$("#tbList").treegrid('unselectAll');
			appInfo.selectedData = {};
			appInfo.selectedId = -1;
			showMsg("保存成功");
		} else {
			showMsg(data.retmsg);
		}
	});
}

function loadList() {
	$('#tbList').treegrid(
			{
				url : appInfo.listUrl,
				toolbar : "#tb",
				rownumbers : true,
				idField : 'areaId',
				treeField : 'areaName',
				height:580,
				singleSelect : true,
				queryParams : appInfo.requestParam,
				columns : [ [ {
					title : '区域名称',
					field : 'areaName',
					width : 300
				}, {
					title : '区域编号',
					field : 'areaId',
					width : 200,
					align : "center"
				} ] ],
				onBeforeExpand : function(row) {
					$("#tbList").treegrid("options").url = appInfo.listUrl
							+ "?parentId=" + row.areaId + "&_timer="
							+ new Date().getTime();
				},
				onClickRow : function(rowData) {
					appInfo.selectedId = rowData.areaId;
					appInfo.selectedData = rowData;
				},
				onDblClickRow : function(rowData) {
					appInfo.selectedId = rowData.areaId;
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
