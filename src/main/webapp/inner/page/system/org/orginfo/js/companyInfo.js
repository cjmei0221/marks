var appInfo = {
	listUrl : top.window.urlBase + '/inner/orgInfo/framelist.do',// 获取机构管理列表接口 OrgInfo
	saveUrl : top.window.urlBase + '/inner/orgInfo/save.do',// 保存新增机构管理接口
	updateUrl : top.window.urlBase + '/inner/orgInfo/update.do',// 编辑机构管理信息接口
	deleteUrl : top.window.urlBase + '/inner/orgInfo/delete.do',// 删除机构管理接口
	approveUrl : top.window.urlBase + '/inner/orgInfo/approve.do',// 编辑采购单信息接口
	arealistUrl : top.window.urlBase + '/inner/area/list.do',// 获取机构管理列表接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		orgCategory:1
	},
	formStatus : "new",
	orgType:1,
	orgCategory:1
};

//新增
function add() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#orgid").removeAttr("readonly");
	$("#useflag").combobox("setValue",1);
}

// 编辑
function edit() {
	if (isSelectedOne(appInfo.selectedId)) {
//		if(appInfo.selectedData.isMain==1){
//			showMsg("主公司不可编辑");
//			return;
//		}
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		$("#orgid").attr("readonly","readonly");
	}
}

// 删除
 function del() {
	if (isSelectedOne(appInfo.selectedId)) {
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "orgid=" + appInfo.selectedId;
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
function approve(){
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	if (appInfo.selectedData.checkStatus == 1) {
		showMsg("审核通过，不可编辑");
		return;
	}
	if (appInfo.selectedData.checkStatus == 3) {
		showMsg("审核中，不可编辑");
		return;
	}
	$.messager.confirm('确认', '确认提交审核吗?', function(r) {
		if (r) {
			var parms = "idNo=" +appInfo.selectedId;
			$.post(appInfo.approveUrl, parms, function(data) {
				if (data.retcode == '0') {
					showMsg("操作成功");
					app.myreload("#tbList");
					appInfo.selectedData = {};
					appInfo.selectedId = -1;
				} else {
					showMsg(data.retmsg);
				}
			});
		}
	});
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
	$('#provinceCode').combobox({
		url : appInfo.arealistUrl,
		valueField : 'id',
		textField : 'text',
		onSelect : function(rec) {
			$("#province").val(rec.text);
			var requrl = appInfo.arealistUrl + "?parentId="+ rec.id;
			$('#cityCode').combobox({
				url : requrl,
				valueField : 'id',
				textField : 'text',
				onSelect : function(rec) {
					$("#city").val(rec.text);
					var requrl2 = appInfo.arealistUrl + "?parentId="+ rec.id;
					$('#areaCode').combobox({
						url : requrl2,
						valueField : 'id',
						textField : 'text',
						onSelect : function(rec) {
							$("#area").val(rec.text);
						}
					});
				}
			});
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
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	parms += "&orgType=" + appInfo.orgType;
	parms += "&orgCategory=" + appInfo.orgCategory;
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
//		rownumbers : true,
//		animate : true,
//		collapsible : true,
//		fitColumns : true,
		height : tool.screenHeight,
		idField : 'orgid',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '组织编号',
			field : 'orgid',
			width : 150,
			align : "center"
		}, {
			title : '组织名称',
			field : 'orgname',
			width : 150,
			align : "center"
		}, {
			title : '英文logo',
			field : 'logoId',
			width : 100,
			align : "center"
		}, {
			title : '联系人',
			field : 'linkman',
			width : 100,
			align : "center"
		}, {
			title : '联系电话',
			field : 'linkTel',
			width : 100,
			align : "center"
		}, {
			title : '审核状态',
			field : 'checkStatusName',
			width : 100,
			align : "center"
		}, {
			title : '启用标识',
			field : 'useflag',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "启用";
				} else {
					return "禁用";
				}
			}
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
			title : '区',
			field : 'area',
			width : 100,
			align : "center"
		}, {
			title : '地址',
			field : 'address',
			width : 100,
			align : "center"
		}, {
			title : '公司类别',
			field : 'isMain',
			width : 50,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "主公司";
				} 
			}
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.orgid;
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
