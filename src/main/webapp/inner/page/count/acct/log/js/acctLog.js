var appInfo = {
	listUrl : top.window.urlBase + '/inner/acctLog/list.do',// 获取交易记录列表接口
															// AcctLog
	saveUrl : top.window.urlBase + '/inner/acctLog/save.do',// 保存新增交易记录接口
	updateUrl : top.window.urlBase + '/inner/acctLog/update.do',// 编辑交易记录信息接口
	deleteUrl : top.window.urlBase + '/inner/acctLog/delete.do',// 删除交易记录接口
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
var userid=tool.getUrlParams("userid");
var ywCode=tool.getUrlParams("ywCode");
// -----------------权限控制功能 end---------------
$(function() {
	$("#ywCode").combobox("setValue","0");
	$("#tb").show();
	if(userid != null && userid != ""){
		$("#ywCode").combobox("setValue",ywCode);
		$("#keyword").val(userid);
		$("#tb").hide();
	}
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
//		nowrap : true,
//		animate : true,
//		collapsible : true,
//		fitColumns : true,
//		autoRowHeight : false,
		idField : 'id',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '单号',
			field : 'id',
			width : 100,
			align : "center",
			hidden : true
		}, {
			title : '用户编号',
			field : 'userCode',
			width : 100,
			align : "center"
		}, {
			title : '用户姓名',
			field : 'userName',
			width : 100,
			align : "center"
		}, {
			title : '机构名称',
			field : 'orgName',
			width : 100,
			align : "center"
//		
//		}, {
//			title : '业务类型',
//			field : 'ywName',
//			width : 100,
//			align : "center"
//		
//		}, {
//			title : '交易类型',
//			field : 'tranName',
//			width : 100,
//			align : "center"
		}, {
			title : '交易描述',
			field : 'tranDesc',
			width : 100,
			align : "center"
		}, {
			title : '交易时间',
			field : 'updatetime',
			width : 180,
			align : "center"
		}, {
			title : '交易金额',
			field : 'tranAmt',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (row.tranCode == '0') {
					return '-'+value;
				}
				return value;
			}
		}, {
			title : '交易积分',
			field : 'tranPoint',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (row.tranCode == '0') {
					return '-'+value;
				}
				return value;
			}
		}, {
			title : '剩余金额',
			field : 'balAmt',
			width : 100,
			align : "center"
		}, {
			title : '剩余积分',
			field : 'balPoint',
			width : 100,
			align : "center"
		
		}, {
			title : '备注',
			field : 'remarks',
			width : 300,
			formatter : function(value, row, index) {
				return value + "("+row.orderId+")"
			}
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
			edit();
		},
		onLoadSuccess : function(data) {
			$("#tbList").datagrid('unselectAll');
			appInfo.selectedData = {};
			if(appInfo.requestParam.ywCode=="0"){
				$("#tbList").datagrid("showColumn", "tranPoint"); // 设置隐藏列
				$("#tbList").datagrid("showColumn", "balPoint"); // 设置隐藏列
				$("#tbList").datagrid("hideColumn", "balAmt"); // 设置隐藏列
				$("#tbList").datagrid("hideColumn", "tranAmt"); // 设置隐藏列
			}else{
				$("#tbList").datagrid("hideColumn", "tranPoint"); // 设置隐藏列
				$("#tbList").datagrid("hideColumn", "balPoint"); // 设置隐藏列
				$("#tbList").datagrid("showColumn", "balAmt"); // 设置隐藏列
				$("#tbList").datagrid("showColumn", "tranAmt"); // 设置隐藏列
			}
		}
	});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		appInfo.requestParam.page_number = params.page;
		appInfo.requestParam.page_size = params.rows;
		appInfo.requestParam.keyword = $("#keyword").val();
		appInfo.requestParam.ywCode=$("#ywCode").combobox("getValue");
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
