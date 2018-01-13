var appInfo = {
	listUrl : top.window.urlBase + '/inner/workInfo/list.do',// 获取工作流查询列表接口
																// WorkInfo
	saveUrl : top.window.urlBase + '/inner/workInfo/save.do',// 保存新增工作流查询接口
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
function edit() {
	$("#editWin").window({
		title : "审核"
	}).window("open");
	$("#wrokId").val(appInfo.selectedId);
	var path = top.window.urlBase + appInfo.selectedData.pageUrl;
    var strHtml = "<iframe width='100%' height='280px'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
    $("#postShow").append(strHtml);
}// -----------------权限控制功能 end---------------
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
		formSubmit(1);
	});
	$("#btnCancel").on("click", function() {
		formSubmit(2);
	});
});
/**
 * 保存菜单
 */
function formSubmit(flag) {
	if (!$('#workff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.saveUrl;
	var parms = $("#workff").serialize();
	parms += "&operateStatus=" + flag;
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
		idField : 'workId',
		height : 560,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '工作编号',
			field : 'workId',
			width : 200,
			align : "center"
		}, {
			title : '类型名称',
			field : 'typeName',
			width : 150,
			align : "center"
		}, {
			title : '申请人',
			field : 'applyMan',
			width : 100,
			align : "center"
		}, {
			title : '所属机构',
			field : 'applyOrgName',
			width : 100,
			align : "center"
		}, {
			title : '申请时间',
			field : 'createtime',
			width : 200,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 200,
			align : "center"
		}, {
			title : '操作状态',
			field : 'operatorStatusName',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.workId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.workId;
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
