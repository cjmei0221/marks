var appInfo = {
	listUrl : top.window.urlBase + '/orgInfo/list.do',// 获取机构管理列表接口 OrgInfo
	saveUrl : top.window.urlBase + '/orgInfo/save.do',// 保存新增机构管理接口
	updateUrl : top.window.urlBase + '/orgInfo/update.do',// 编辑机构管理信息接口
	deleteUrl : top.window.urlBase + '/orgInfo/delete.do',// 删除机构管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		parentId : ""
	},
	formStatus : "new",
	orgType:0
};

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

	// 新增
	$("#add").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "新增"
			}).window("open");
			$('#ff').form('clear');
			appInfo.formStatus = "new";
			$("#parentName").val(appInfo.selectedData.orgname);
			$("#parentId").val(appInfo.selectedId);
		}
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			if(appInfo.selectedData.orgType==1){
				showMsg("根节点不可编辑");
				return;
			}
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
			if( appInfo.selectedId=='0'){
				showMsg("根节点不可删除");
				return;
			}
			if(appInfo.selectedData.parentId=='0'){
				showMsg("请在公司管理编辑");
				return;
			}
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "orgid=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == "0") {
							appInfo.requestParam.parentId="0";
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
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	$('#ff').form('submit', {
		url : reqUrl,
		onSubmit : function(param) {
			param.formStatus = appInfo.formStatus;
			param.orgType=appInfo.orgType;
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
				appInfo.requestParam.parentId="0";
				loadList();
				$("#tbList").treegrid('unselectAll');
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
	$('#tbList').treegrid(
			{
				url : appInfo.listUrl,
				toolbar : "#tb",
				striped : true,
				nowrap : true,
				rownumbers : true,
				animate : true,
				collapsible : true,
				fitColumns : true,
				idField : 'orgid',
				treeField : 'orgname',
				singleSelect : true,
				queryParams : appInfo.requestParam,
				columns : [ [ {

					title : '组织名称',
					field : 'orgname',
					width : 150,
					align : "left"
				}, {
					title : '组织ID',
					field : 'orgid',
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
				onBeforeExpand : function(row) {
					$("#tbList").treegrid("options").url = appInfo.listUrl
							+ "?parentId=" + row.orgid + "&_timer="
							+ new Date().getTime();
				},
				onClickRow : function(rowData) {
					appInfo.selectedId = rowData.orgid;
					appInfo.selectedData = rowData;
				},
				onLoadSuccess : function(row, data) {
					$("#tbList").treegrid('unselectAll');
					appInfo.selectedData = {};
				}
			});
}
