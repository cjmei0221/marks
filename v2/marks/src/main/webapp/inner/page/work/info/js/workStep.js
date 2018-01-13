var appInfo = {
	listUrl : top.window.urlBase + '/inner/workInfo/listByUserId.do',// 获取工作步骤列表接口																	// WorkStep
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
function showInfo(){
	$("#editWin").window({
		title : "资料"
	}).window("open");
	var path = top.window.urlBase + appInfo.selectedData.pageUrl;
    var strHtml = "<iframe style='width:100%;height:99%;' frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
    $("#postShow").append(strHtml);
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
		striped : true,
		nowrap : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		autoRowHeight : false,
		idField : 'workId',
		height : 580,
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
			showInfo();
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
