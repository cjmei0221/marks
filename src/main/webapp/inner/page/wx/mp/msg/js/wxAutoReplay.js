var appInfo = {
	listUrl : top.window.urlBase + '/inner/wxAutoReplay/list.do',// 获取微信回复管理列表接口
	// WxAutoReplay
	saveUrl : top.window.urlBase + '/inner/wxAutoReplay/save.do',// 保存新增微信回复管理接口
	updateUrl : top.window.urlBase + '/inner/wxAutoReplay/update.do',// 编辑微信回复管理信息接口
	deleteUrl : top.window.urlBase + '/inner/wxAutoReplay/delete.do',// 删除微信回复管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};

//新增
function add() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#ckey").removeAttr('readonly');
	$("#delFlagTr").show();
	$('#replayType').combobox("setValue","TEXT");
	$("#newsListTr").hide();
	$("#delFlag").combobox("setValues", '1');
	$("#itemType").combobox("setValues", '0');
	$('#replayType').combobox("setValue","TEXT");
	$('#newsList').combobox('reload');
	$('#newsList').combobox("clear");
}

// 编辑
function edit() {
	$('#newsList').combobox("clear");
	$('#newsList').combobox('reload');
	if (isSelectedOne(appInfo.selectedId)) {
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		if (appInfo.selectedData.delFlag == 0) {
			$("#ckey").attr('readonly', 'readonly');
			$("#delFlagTr").hide();
		} else {
			$("#ckey").removeAttr('readonly');
			$("#delFlagTr").show();
		}
		if(appInfo.selectedData.replayType=='NEWS'){
			$("#newsList").combobox("setValues", appInfo.selectedData.creplay.split(","));
		}else{
			$('#newsList').combobox("clear");
		}
	}
}

// 删除
function del() {
	if (isSelectedOne(appInfo.selectedId)) {
		if (appInfo.selectedData.delFlag == 0) {
			showMsg("此记录不可删除");
			return;
		}
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "ctype=" + appInfo.selectedId;
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
	$('#replayType').combobox({
		onChange : function(newValue, oldValue) {
			if (newValue == 'NEWS') {
				$("#creplayTr").hide();
				$("#newsListTr").show();			
				$("#creplay").attr("readonly","readonly");
			} else {
				$("#creplayTr").show();
				$("#newsListTr").hide();
				$('#newsList').combobox("clear");
				$("#creplay").removeAttr("readonly");
			}
			$("#creplay").val("");
			$("#newsTxt").val('');
		}
	});
	$('#newsList').combobox({
		onHidePanel : function() {
			var vals = $("#newsList").combobox("getValues");
			if (vals != null && vals != undefined) {
				if(vals.length>6){
					showMsg("只能选择5个图文");
					$('#newsList').combobox("clear");
					$("#creplay").val('');
					$("#newsTxt").val('');
					return;
				}
			}
		}
	})
});
/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var replayType=$("#replayType").combobox("getValue");
	if(replayType=='NEWS'){
		var vals = $("#newsList").combobox("getValues");
		if (vals != null && vals != undefined) {
			if(vals.length>5){
				showMsg("只能选择5个图文");
				$('#newsList').combobox("clear");
				$("#creplay").val('');
				$("#newsTxt").val('');
				return;
			}
		}
		$("#creplay").val(vals);
		$("#newsTxt").val($('#newsList').combobox("getText"));
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
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		autoRowHeight:true,
		height : tool.screenHeight,
		idField : 'ctype',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : 'ID',
			field : 'ctype',
			width : 100,
			align : "center",
			hidden : true
		}, {
			title : '类型',
			field : 'itemType',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "运维知识";
				} 
				return "通用知识";
			}
		}, {
			title : '业务分类',
			field : 'ctypeName',
			width : 200,
			align : "center"
		}, {
			title : '搜索词',
			field : 'ckey',
			width : 150,
			align : "center"
		}, {
			title : '问题描述',
			field : 'ckeyName',
			width : 200
		}, {
			title : '回复方式',
			field : 'replayType',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 'NEWS') {
					return "图文 (NEWS)";
				} else if (value == 'MODULE') {
					return "指令 (MODULE)";
				}
				return "文字 (TEXT)";
			}
		}, {
			title : '回复内容',
			field : 'creplay',
			width : 500,
			formatter : function(value, row, index) {
				if (row.replayType == 'NEWS') {
					return row.newsTxt;
				}
				return value;
			}
		}, {
			title : '是否可删除',
			field : 'delFlag',
			width : 80,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 0) {
					return "否";
				} 
				return "是";
			}
		}, {
			title : '公众号ID',
			field : 'accountid',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.ctype;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.ctype;
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
