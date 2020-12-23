var appInfo = {
	listUrl : top.window.urlBase + '/inner/moduleMsg/list.do',// 获取模板消息列表接口 ModuleMsg
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		s_resultCode:"",
		s_sendFlag:""
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
		nowrap : false,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		height : tool.screenHeight,
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
			title : '公众号ID',
			field : 'accountid',
			width : 100,
			align : "center"
		}, {
			title : '介绍者',
			field : 'nickName',
			width : 150,
			align : "center"
		}, {
			title : '内容',
			field : 'data',
			width : 700,
			align : "left",
			formatter : function(value, row, index) {
				return value.replace(/},/g,"},<br/>");
			}
		}, {
			title : '推送结果',
			field : 'sendFlag',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 0) {
					return '未发送';
				}else if(value == 2){
					return '发送失败';
				}
				return '发送成功';
			}
		}, {
			title : '推送次数',
			field : 'sendTimes',
			width : 100,
			align : "center"
		}, {
			title : '最后推送时间',
			field : 'sendtime',
			width : 150,
			align : "center"
		}, {
			title : '接受结果',
			field : 'resultCode',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == '0') {
					return '失败';
				}else if(value == '1'){
					return '成功';
				}
				return '';
			}
		}, {
			title : '接受时间',
			field : 'resultTime',
			width : 150,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 150,
			align : "center"
		}, {
			title : '备注',
			field : 'note',
			width : 150,
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
		appInfo.requestParam.s_sendFlag=$("#s_sendFlag").combobox("getValue");
		appInfo.requestParam.s_resultCode=$("#s_resultCode").combobox("getValue");
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
