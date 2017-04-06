var appInfo = {
	listUrl : top.window.urlBase + '/inner/sysLog/list.do',// 获取内管日志列表接口 SysLog
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		source : ""
	},
	formStatus : "new"
};

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
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		idField : 'id',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : 'ID',
			field : 'id',
			width : 100,
			align : "center",
			hidden : true
		}, {
			title : '来源',
			field : 'source',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "消息中心";
				} else if (value == 2) {
					return "前端";
				}
				return "内管";
			}
		}, {
			title : 'IP',
			field : 'ip',
			width : 100,
			align : "center"
		}, {
			title : '功能名称',
			field : 'menuname',
			width : 100,
			align : "center"
		}, {
			title : '操作名称',
			field : 'opername',
			width : 100,
			align : "center"
		}, {
			title : '访问URL',
			field : 'retain2',
			width : 100,
			align : "left"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 120,
			align : "center"
		}, {
			title : '用户ID',
			field : 'userid',
			width : 100,
			align : "center"
		}, {
			title : '用户姓名',
			field : 'username',
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
		appInfo.requestParam.source = $("#source").combobox('getValue');
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				checkLogin(data);
				if (data.retcode == "0") {
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
