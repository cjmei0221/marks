var appInfo = {
	listUrl : top.window.urlBase + '/inner/wxUser/list.do',// 获取粉丝管理列表接口 WxUser
	useDairyUrl : top.window.urlBase + '/inner/wxUser/dairy.do',// 删除粉丝管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		s_issubscribe:"",
		s_sex:""
	},
	formStatus : "new"
};

//是否推送日记提醒模板消息
function dairyBtn() {
	if (isSelectedOne(appInfo.selectedId)) {
		$.messager.confirm('确认', '确认切换吗?', function(r) {
			if (r) {
				var parms = "openid=" + appInfo.selectedId+"&accountid="+appInfo.selectedData.accountid;
				$.post(appInfo.useDairyUrl, parms, function(data) {
					if (data.retcode == "0") {
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
}

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
		idField : 'openid',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : 'OPENID',
			field : 'openid',
			width : 100,
			align : "center"
		}, {
			title : '昵称',
			field : 'nickname',
			width : 100,
			align : "center"
		}, {
			title : '国家',
			field : 'country',
			width : 100,
			align : "center"
		}, {
			title : '省',
			field : 'province',
			width : 100,
			align : "center"
		}, {
			title : '市',
			field : 'city',
			width : 100,
			align : "center"
		}, {
			title : '性别',
			field : 'sex',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "男";
				} else if(value == 2){
					return "女";
				}
				return "未知";
			}
		}, {
			title : '头像路径',
			field : 'imageUrl',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				return '<img alt="头像" src="'+value+'" style="width:80px;height:60px;">';
			}
		}, {
			title : '关注',
			field : 'issubscribe',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "已关注";
				} 
				return "未关注";
			}
		}, {
			title : '关注时间',
			field : 'subscribetime',
			width : 100,
			align : "center"
		}, {
			title : '公众号ID',
			field : 'accountid',
			width : 100,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 100,
			align : "center"
		}, {
			title : '来源',
			field : 'qrName',
			width : 100,
			align : "center"
		}, {
			title : '日记提醒',
			field : 'dairyFlag',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "提醒";
				} else {
					return "不提醒";
				}
			}
		}, {
			title : '备注',
			field : 'remark',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.openid;
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
		appInfo.requestParam.s_sex = $("#s_sex").combobox("getValue");
		appInfo.requestParam.s_issubscribe = $("#s_issubscribe").combobox("getValue");
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
