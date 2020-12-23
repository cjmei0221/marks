var appInfo = {
	listUrl : top.window.urlBase + '/inner/salesInfo/list.do',// 获取促销方案列表接口
	deleteUrl : top.window.urlBase + '/inner/salesInfo/delete.do',// 删除促销方案接口
	activeBtnUrl : top.window.urlBase + '/inner/salesInfo/active.do',// 删除促销方案接口
	approveUrl : top.window.urlBase + '/inner/salesInfo/approve.do',// 删除促销方案接口
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
	$("#newWin").window({
		title : "新增"
	}).window("open");
}

function quickAdd(){
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	eidtProject(appInfo.selectedData.ywCode,"quickAdd",appInfo.selectedId);
}

// 编辑
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.checkStatus == 3) {
		showMsg("审核中不可编辑");
		return;
	}
	if (appInfo.selectedData.checkStatus == 1) {
		showMsg("审核通过不可编辑");
		return;
	}
	eidtProject(appInfo.selectedData.ywCode,"edit",appInfo.selectedId);
}
// 删除
function del() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.checkStatus == 1) {
		showMsg("审核通过不可删除");
		return;
	}
	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "projectCode=" + appInfo.selectedId;
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


//启禁用
function activeBtn() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.checkStatus != 1) {
		showMsg("未审核通过不可操作");
		return;
	}
	$.messager.confirm('确认', '确认要切换吗?', function(r) {
		if (r) {
			var parms = "projectCode=" + appInfo.selectedId;
			$.post(appInfo.activeBtnUrl, parms, function(data) {
				if (data.retcode == '0') {
					app.myreload("#tbList");
					appInfo.selectedData = {};
					appInfo.selectedId = -1;
					showMsg("操作成功");
				} else {
					showMsg(data.retmsg);
				}
			});
		}
	});
}

//审核
function approve() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.checkStatus == 3) {
		showMsg("审核中不可操作");
		return;
	}
	if (appInfo.selectedData.checkStatus == 1) {
		showMsg("审核通过不可操作");
		return;
	}
	$.messager.confirm('确认', '确认要审核吗?', function(r) {
		if (r) {
			var parms = "projectCode=" + appInfo.selectedId;
			$.post(appInfo.approveUrl, parms, function(data) {
				if (data.retcode == '0') {
					app.myreload("#tbList");
					appInfo.selectedData = {};
					appInfo.selectedId = -1;
					showMsg("操作成功");
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

	$("#couponEdit").on("click",function(e){
		eidtProject(0,"new","1111");
	});
	$("#goodSalesEdit").on("click",function(e){
		eidtProject(20,"new","1111");
	});
});

function eidtProject(ywCode,formStatus,idNo){
	var path = "";
	if(ywCode==0){
		$("#editWin").window({
			title : "优惠券"
		}).window("open");
		path="/inner/page/project/sales/couponEdit.html?formStatus="+formStatus+"&idNo="+idNo;
		var strHtml = "<iframe width='100%' height='480px'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
		    $("#frameShow").html(strHtml);
	}else if(ywCode==20){
		$("#editWin").window({
			title : "商品促销方案"
		}).window("open");
		path="/inner/page/project/sales/goodSalesEdit.html?formStatus="+formStatus+"&idNo="+idNo;
//		location.href=path;
		var strHtml = "<iframe width='100%' height='480px'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
	    $("#frameShow").html(strHtml);
	}
}
function showDetail(projectCode) {
	$("#editWin").window({
		title : "详情"
	}).window("open");
	var path = "/inner/page/project/sales/salesCheck.html?idNo=" + projectCode;
	var strHtml = "<iframe width='100%' height='480px'  frameborder='0' scrolling='auto' src='"
			+ path + "'></iframe>";
	$("#frameShow").html(strHtml);
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
		idField : 'projectCode',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '方案编号',
			field : 'projectCode',
			width : 180,
			align : "center",
			formatter : function(value, row, index) {
				return '<a href="javascript:void(0)" onclick="showDetail(\''
						+ value
						+ '\')">'
						+ value
						+ '</a>';
			}
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
			title : '类型名称',
			field : 'typeName',
			width : 100,
			align : "center"
		}, {
			title : '开始日期',
			field : 'startDate',
			width : 100,
			align : "center"
		}, {
			title : '结束日期',
			field : 'endDate',
			width : 100,
			align : "center"
		}, {
			title : '状态',
			field : 'statusName',
			width : 100,
			align : "center"
		}, {
			title : '审核状态',
			field : 'checkStatusName',
			width : 100,
			align : "center"
		}, {
			title : '备注',
			field : 'remarks',
			width : 100,
			align : "left"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 180,
			align : "center"
		
		}, {
			title : '审核时间',
			field : 'checkTime',
			width : 180,
			align : "center"
		}, {
			title : '备注',
			field : 'remarks',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.projectCode;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.projectCode;
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
