var appInfo = {
	getUrl : top.window.urlBase + '/inner/workType/findById.do',// 获取工作流查询列表接口
	saveUrl : top.window.urlBase + '/inner/workInfo/apply.do',// 保存新增工作流查询接口												// WorkInf
	userListUrl : top.window.urlBase + '/inner/sysUser/listActive.do',// 保存新增工作流查询接口	
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		roleYwType : 1
	},
};
var idNo = tool.getUrlParams("idNo");
var menuid = tool.getUrlParams("menuid");
var typeCode = tool.getUrlParams("typeCode");
var returnPage = tool.getUrlParams("returnPage");
var remarks = tool.getUrlParams("remarks");
$(function() {
	$("#idNo").val(idNo);
	$("#typeCode").val(typeCode);
	$("#remarks").val(remarks);
	loadInfo();
	
	loadList();
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit(1);
	});
	$("#chooseUser").on("click", function() {
		$("#userWin").window({
			title : "用户"
		}).window("open");
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});
	// 搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});
	$("#btnReturn").on("click", function() {
		returnList();
	});
});
function returnList(){
	var url = returnPage+"?menuid="+menuid;
	location.href = url;
}

//加载基础信息
function loadInfo(){
	$.ajax({
		url : appInfo.getUrl,
		type : "get",
		data : {
			"typeCode":typeCode
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var info=data.info;
				var path = info.linkUrl+"?idNo="+idNo+"&formStatus=check";
			    var strHtml = "<iframe style='width:100%;height:580px;'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
			    $("#postShow").html(strHtml);
				$("#checkForm").show();
				return true;
			} else {
				showMsg(data.retmsg);
				$("#checkForm").hide();
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});
}
/**
 * 保存菜单
 */
function formSubmit(flag) {
	if (!$('#workff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.saveUrl;
	var parms = $("#workff").serialize();
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
			showMsg("保存成功");
			returnList();
		} else {
			showMsg(data.retmsg);
		}
	});
}
function loadList() {
	$('#tbList').datagrid({
		url : appInfo.userListUrl,
		toolbar : "#tb",
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		height : 500,
		pagination : true,
		idField : 'userid',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '用户编号',
			field : 'userCode',
			width : 120
//		}, {
//			title : '绑定手机',
//			field : 'bind_mobile',
//			width : 100,
//			align : "center"
		}, {
			title : '用户名称',
			field : 'username',
			width : 100,
			align : "center"
		
		}, {
			title : '用户职位',
			field : 'roleName',
			width : 100,
			align : "center"
		}, {
			title : '所属组织',
			field : 'orgName',
			width : 100,
			align : "center"
		

		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			$.messager.confirm('确认', '确认吗?', function(r) {
				if (r) {
					$("#userName").val(rowData.username);
					$("#userid").val(rowData.userid);
					$("#userWin").window("close");
				}
			});
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
		appInfo.requestParam.orgId = $("#ssorgid").combotree("getValue");
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