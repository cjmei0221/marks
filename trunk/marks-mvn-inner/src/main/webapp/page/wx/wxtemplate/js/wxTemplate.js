var appInfo = {
	listUrl : top.window.urlBase + '/wxTemplate/list.do',// 获取微信模板列表接口
	// WxTemplate
	saveUrl : top.window.urlBase + '/wxTemplate/save.do',// 保存新增微信模板接口
	updateUrl : top.window.urlBase + '/wxTemplate/update.do',// 编辑微信模板信息接口
	deleteUrl : top.window.urlBase + '/wxTemplate/delete.do',// 删除微信模板接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
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

	// 新增
	$("#add").on("click", function() {
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus = "new";
		$('#status').combobox('setValue', '1');
		$('#ywType').combobox({
			readonly : false
		});
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$('#ywType').combobox({
				readonly : true
			});
			$('#ff').form('load', appInfo.selectedData);

		}
	});

	// 删除
	$("#delete").on(
			"click",
			function() {
				if (isSelectedOne(appInfo.selectedId)) {
					$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
						if (r) {
							var parms = "ywType=" + appInfo.selectedId
									+ "&accountid="
									+ appInfo.selectedData.accountid;
							$.post(appInfo.deleteUrl, parms, function(data) {
								if (data.retcode == "0") {
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
	$('#ff').form('submit', {
		url : reqUrl,
		onSubmit : function(param) {
			param.formStatus = appInfo.formStatus;
		},
		success : function(data) {
			if (typeof data === 'string') {
				try {
					data = $.parseJSON(data);
				} catch (e0) {
					showMsg("json 格式 错误");
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
		}
	});
}

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
		idField : 'ywType',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '主键ID',
			field : 'ywType',
			width : 100,
			align : "center",
		}, {
			title : '公众号ID',
			field : 'accountid',
			width : 100,
			align : "center"
		}, {
			title : '微信模板ID',
			field : 'template_id',
			width : 100,
			align : "center" 
		}, {
			title : '微信模板标题',
			field : 'template_name',
			width : 100,
			align : "center"
		}, {
			title : '首行内容',
			field : 'first_content',
			width : 100,
			align : "left"
		}, {
			title : '尾行内容',
			field : 'remark_content',
			width : 100,
			align : "left"
		}, {
			title : '访问URL',
			field : 'detailUrl',
			width : 100,
			align : "left"
		}, {
			title : '启用标识',
			field : 'status',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if(value==0){
					return '禁用';
				}
				return '启用';
			}
		}, {
			title : '创建者',
			field : 'creator',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.ywType;
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
