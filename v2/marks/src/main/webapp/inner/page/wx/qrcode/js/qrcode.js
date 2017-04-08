var appInfo = {
	listUrl : top.window.urlBase + '/inner/qrcode/list.do',// 获取二维码管理列表接口 Qrcode
	saveUrl : top.window.urlBase + '/inner/qrcode/save.do',// 保存新增二维码管理接口
	updateUrl : top.window.urlBase + '/inner/qrcode/update.do',// 编辑二维码管理信息接口
	deleteUrl : top.window.urlBase + '/inner/qrcode/delete.do',// 删除二维码管理接口
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
	$(".hideCls").hide();
	$("#qrTypeTr").show();
	$("#btnOK").removeAttr("disabled");
}

// 编辑
function edit() {
	if (isSelectedOne(appInfo.selectedId)) {
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		$(".hideCls").hide();
		$("#btnOK").removeAttr("disabled");
	}
}

// 删除
function del() {
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

	$('#qrType').combobox({
		onChange : function(newValue, oldValue) {
			if (newValue == '0') {
				$("#qrUrlTr").show();
				$("#accountidTr").hide();
				$("#sceneTypeTr").hide();
				$("#qrNoTr").hide();
			} else {
				$("#qrUrlTr").hide();
				$("#accountidTr").show();
				$("#sceneTypeTr").show();
				$("#qrNoTr").show();
			}
		}
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
	var qrTypeVal = $("#qrType").combobox("getValue");
	if (qrTypeVal == 0) {
		var qrUrlVal = $("#qrUrl").val();
		if (qrUrlVal == '') {
			showMsg("链接URL不能为空");
			return;
		}
	} else {
		var accountidVal = $("#accountid").combobox("getValue");
		var sceneTypeVal = $("#sceneType").combobox("getValue");
		var qrNoVal = $("#qrNo").numberbox('getValue');
		if (accountidVal == '') {
			showMsg("公众号不能为空");
			return;
		}
		if (sceneTypeVal == '') {
			showMsg("场景类型不能为空");
			return;
		}
		if (qrNoVal == '') {
			showMsg("标识不能为空");
			return;
		}
		if (sceneTypeVal == 0 && qrNoVal < 100001) {
			showMsg("临时二维码的标识不能小于100000");
			return;
		}
		if (sceneTypeVal == 1 && qrNoVal > 100000) {
			showMsg("永久二维码标识不能大于100000");
			return;
		}
	}
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	$("#btnOK").attr("disabled","disabled");
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
			$("#btnOK").removeAttr("disabled");
		}
	});
}

function showImage(imagePath){
	$("#showWin").window({
		title : "二维码图片"
	}).window("open");
	$("#showImage").attr("src",imagePath);
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

			title : '名称',
			field : 'qrName',
			width : 100,
			align : "center"
		}, {
			title : '类型',
			field : 'qrType',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 0) {
					return "链接";
				} else if (value == 1) {
					return "公众号";
				}
				return "";
			}
		}, {
			title : '链接',
			field : 'qrUrl',
			width : 200,
			align : "center"
		}, {
			title : '公众号ID',
			field : 'accountid',
			width : 100,
			align : "center"
		}, {
			title : '场景类型',
			field : 'sceneType',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 0) {
					return "临时";
				} else if (value == 1) {
					return "永久";
				}
				return "";
			}
		}, {
			title : '标识',
			field : 'qrNo',
			width : 100,
			align : "center"
		}, {
			title : '图片路径',
			field : 'qrPath',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				return '<img alt="二维码" src="'+window.urlImgBase+value+'" style="width:80px;height:60px;"';
			}
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
			appInfo.selectedId = rowData.id;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.id;
			appInfo.selectedData = rowData;
			showImage(rowData.qrPath);
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
