var appInfo = {
	listUrl : top.window.urlBase + '/reminder/list.do',// 获取事务提醒列表接口 Reminder
	saveUrl : top.window.urlBase + '/reminder/save.do',// 保存新增事务提醒接口
	updateUrl : top.window.urlBase + '/reminder/update.do',// 编辑事务提醒信息接口
	deleteUrl : top.window.urlBase + '/reminder/delete.do',// 删除事务提醒接口
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
		$('#remind_time').timespinner('setValue', '08:30');
		clickRemindType("0");
		$('#remind_type').combobox("setValue","0");
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$('#ff').form('load', appInfo.selectedData);
		}
	});

	// 删除
	$("#delete").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "id=" + appInfo.selectedId;
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
	$('#remind_type').combobox({
		onChange : function(newValue, oldValue) {
			clickRemindType(newValue);
		}
	});
});
function clickRemindType(rtype){
	if("1" == rtype){
		$("#holiday_type_tr").show();
		$("#calendar_type_tr").show();
		$("#is_repeat_tr").show();
		$("#is_before_tr").show();
		$("#before_days_tr").show();
	}else{
		$("#holiday_type_tr").hide();
		$("#calendar_type_tr").hide();
		$("#is_repeat_tr").hide();
		$("#is_before_tr").hide();
		$("#before_days_tr").hide();
	}
}
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
			title : '日历类型',
			field : 'calendar_type',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "农历";
				}
				return "公历";
			}
		}, {
			title : '提醒内容',
			field : 'remind_content',
			width : 100,
			align : "center"
		}, {
			title : '事务类型',
			field : 'remind_type',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "节日";
				}
				return "普通";
			}
		}, {
			title : '提醒日期',
			field : 'remind_date',
			width : 100,
			align : "center"
		}, {
			title : '提醒时间',
			field : 'remind_time',
			width : 100,
			align : "center"
		}, {
			title : '是否重复',
			field : 'is_repeat',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "是";
				}
				return "否";
			}
		}, {
			title : '是否提前提醒',
			field : 'is_before',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "是";
				}
				return "否";
			}
		}, {
			title : '提前天数',
			field : 'before_days',
			width : 100,
			align : "center"
		}, {
			title : '创建时间',
			field : 'createtime',
			width : 100,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
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
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
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
