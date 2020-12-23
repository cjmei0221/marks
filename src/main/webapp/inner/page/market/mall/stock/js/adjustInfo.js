var appInfo = {
	listUrl : top.window.urlBase + '/inner/adjustInfo/list.do',// 获取库存调整单列表接口
																// AdjustInfo
	saveUrl : top.window.urlBase + '/inner/adjustInfo/save.do',// 保存新增库存调整单接口
	updateUrl : top.window.urlBase + '/inner/adjustInfo/update.do',// 编辑库存调整单信息接口
	deleteUrl : top.window.urlBase + '/inner/adjustInfo/delete.do',// 删除库存调整单接口
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
	var path = "adjustGood.html?formStatus=new&returnType=0&idNo=1";
	location.href = path;
}

// 编辑
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.checkStatus == 1) {
		showMsg("审核通过，不可编辑");
		return;
	}
	if (appInfo.selectedData.checkStatus == 3) {
		showMsg("审核中，不可编辑");
		return;
	}
	var path = "adjustGood.html?formStatus=edit&returnType=0&idNo="
			+ appInfo.selectedId;
	location.href = path;
}
// 删除
function del() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}

	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "orderId=" + appInfo.selectedId;
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
function showDetail() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	var path = "adjustGood.html?formStatus=detail&returnType=0&idNo="
			+ appInfo.selectedId;
	location.href = path;
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
		idField : 'orderId',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '单号',
			field : 'orderId',
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
			width : 200,
			align : "center"
		}, {
			title : '单据类型',
			field : 'typeName',
			width : 100,
			align : "center"
		}, {
			title : '总数量',
			field : 'totalNums',
			width : 100,
			align : "center"
		}, {
			title : '总金额',
			field : 'totalAmt',
			width : 100,
			align : "center"
		}, {
			title : '制单时间',
			field : 'createtime',
			width : 100,
			align : "center"
		}, {
			title : '制单人',
			field : 'creatorName',
			width : 100,
			align : "center"
		}, {
			title : '单状态',
			field : 'status',
			width : 100,
			align : "center"
		}, {
			title : '审核状态',
			field : 'checkStatus',
			width : 100,
			align : "center"
		}, {
			title : '审核人',
			field : 'checker',
			width : 100,
			align : "center"
		}, {
			title : '审核时间',
			field : 'checkTime',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.orderId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.orderId;
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
