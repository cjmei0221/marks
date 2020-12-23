var appInfo = {
	listUrl : top.window.urlBase + '/inner/orgInfo/list.do',// 获取机构管理列表接口
	// OrgInfo
	saveUrl : top.window.urlBase + '/inner/orgInfo/save.do',// 保存新增机构管理接口
	updateUrl : top.window.urlBase + '/inner/orgInfo/update.do',// 编辑机构管理信息接口
	deleteUrl : top.window.urlBase + '/inner/orgInfo/delete.do',// 删除机构管理接口
	arealistUrl : top.window.urlBase + '/inner/area/list.do',// 获取机构管理列表接口
	// OrgInfo
	selectedId : -1,
	selectedData : {},
	requestParam : {
		parentId : ""
	},
	formStatus : "new",
	orgType : "5,4",
	orgCategory : 0
};

// 新增
function add() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#parentId").val("top");
	$("#orgid").removeAttr("readonly");
	$("#orgType").combobox("setValue", 5);
	$("#useflag").combobox("setValue", 1);
}

// 编辑
function edit() {
	if (isSelectedOne(appInfo.selectedId)) {
		if (appInfo.selectedData.orgType == 1) {
			showMsg("根节点不可编辑");
			return;
		}
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		$("#orgid").attr("readonly", "readonly");
	}
}

// 删除
function del() {
	if (isSelectedOne(appInfo.selectedId)) {
		if (appInfo.selectedId == '0') {
			showMsg("根节点不可删除");
			return;
		}
		if (appInfo.selectedData.parentId == '0') {
			showMsg("请在公司管理编辑");
			return;
		}
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "orgid=" + appInfo.selectedId;
				$.post(appInfo.deleteUrl, parms, function(data) {
					if (data.retcode == "0") {
						appInfo.requestParam.parentId = "0";
						loadList();
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
		$("#tbList").treegrid("reload");
		$("#tbList").datagrid('unselectAll');
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
			var requrl = appInfo.arealistUrl + "?parentId=" + rec.id;
			$('#cityCode').combobox({
				url : requrl,
				valueField : 'id',
				textField : 'text',
				onSelect : function(rec) {
					$("#city").val(rec.text);
					var requrl2 = appInfo.arealistUrl + "?parentId=" + rec.id;
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
			appInfo.requestParam.parentId = "0";
			loadList();
			$("#tbList").treegrid('unselectAll');
			appInfo.selectedData = {};
			appInfo.selectedId = -1;
			showMsg("保存成功");
		} else {
			showMsg(data.retmsg);
		}
	});
}

function loadList() {
	$('#tbList').treegrid(
			{
				url : appInfo.listUrl + "?orgType=" + appInfo.orgType,
				toolbar : "#tb",
				rownumbers : true,
				idField : 'orgid',
				treeField : 'orgname',
				singleSelect : true,
				// queryParams : appInfo.requestParam,
				columns : [ [ {

					title : '组织名称',
					field : 'orgname',
					width : 150,
					align : "left"
				}, {
					title : '组织ID',
					field : 'orgid',
					width : 150,
					align : "center"
				}, {
					title : '类型',
					field : 'orgTypeName',
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
					title : '区',
					field : 'area',
					width : 100,
					align : "center"
				}, {
					title : '地址',
					field : 'address',
					width : 200,
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
					title : '更新时间',
					field : 'updatetime',
					width : 180,
					align : "center"
				} ] ],
				onBeforeExpand : function(row) {
					$("#tbList").treegrid("options").url = appInfo.listUrl
							+ "?parentId=" + row.orgid + "&orgType="
							+ appInfo.orgType + "&_timer="
							+ new Date().getTime();
				},
				onClickRow : function(rowData) {
					appInfo.selectedId = rowData.orgid;
					appInfo.selectedData = rowData;
				},
				onDblClickRow : function(rowData) {
					appInfo.selectedId = rowData.orgid;
					appInfo.selectedData = rowData;
					edit();
				},
				onLoadSuccess : function(row, data) {
					$("#tbList").treegrid('unselectAll');
					appInfo.selectedData = {};
				}
			});
}
