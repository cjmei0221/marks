var appInfo = {
	listUrl : top.window.urlBase + '/wxMenu/list.do',// 获取微信菜单管理列表接口 WxMenu
	saveUrl : top.window.urlBase + '/wxMenu/save.do',// 保存新增微信菜单管理接口
	updateUrl : top.window.urlBase + '/wxMenu/update.do',// 编辑微信菜单管理信息接口
	deleteUrl : top.window.urlBase + '/wxMenu/delete.do',// 删除微信菜单管理接口
	syncWxUrl :  top.window.urlBase + '/wxMenu/syncWx.do',
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
		if (appInfo.selectedId == -1) {
			showMsg("请选择父节点，若没有父节点请先确定是否有添加服务号！");
			return;
		}
		if (appInfo.selectedData.lvl >1) {
			showMsg("只能建两级菜单！");
			return;
		}
		if(appInfo.selectedData.lvl==0 && appInfo.selectedData.childnum>3){
			showMsg("一级菜单只能添加三个！");
		}
		if(appInfo.selectedData.lvl==1 && appInfo.selectedData.childnum>5){
			showMsg("一级菜单只能添加五个！");
		}
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus = "new";
		$("#parent_id").val(appInfo.selectedId);
		$("#lvl").val(appInfo.selectedData.lvl+1);
		if(appInfo.selectedData.lvl==0){
			$("#accountid").val(appInfo.selectedId);
		}else{
			$("#accountid").val(appInfo.selectedData.accountid);
		}
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			if(appInfo.selectedData.lvl==0){
				showMsg("此记录不可编辑！");
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
		if(appInfo.selectedData.lvl==0){
			showMsg("此记录不可编辑！");
			return;
		}
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('Confirm', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "id=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == 0) {
							loadList();
							$("#tbList").treegrid('unselectAll');
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
	
	$("#syncWx").on("click",function(){
		if (isSelectedOne(appInfo.selectedId)) {
			if(appInfo.selectedData.lvl==0){
				$.messager.confirm('Confirm', '确认要同步微信服务器吗?', function(r) {
					if (r) {
						var parms = "accountid=" + appInfo.selectedId;
						$.post(appInfo.syncWxUrl, parms, function(data) {
							if (data.retcode == 0) {
								showMsg("同步成功，稍有延迟！");
							} else {
								showMsg(data.retmsg);
							}
						});
					}
				});
			}else{
				showMsg("请选择公众号");
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
			if (data.retcode == 0) {
				$("#editWin").window("close");
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
	$('#tbList').treegrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		idField : 'id',
		treeField : 'name',
		singleSelect : true,
		columns : [ [ {
			title : 'ID',
			field : 'id',
			width : 100,
			align : "center",
			hidden : true
	
		}, {
			title : '菜单名称',
			field : 'name',
			width : 100,
			align : "center"
		}, {
			title : '菜单类型',
			field : 'type',
			width : 100,
			align : "center"
		}, {
			title : '访问内容',
			field : 'content',
			width : 100,
			align : "center"
		}, {
			title : '级别',
			field : 'lvl',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 0) {
					return "公众号";
				} else if (value == 1) {
					return "一级菜单";
				} else if (value == 2) {
					return "二级菜单";
				}
				return "";
			}
		}, {
			title : '排序',
			field : 'sort',
			width : 100,
			align : "center"
		} ] ],
		onClickRow : function(rowData) {
			appInfo.selectedId = rowData.id;
			appInfo.selectedData = rowData;
			
		},
		onLoadSuccess : function(data) {
			$("#tbList").datagrid('unselectAll');
			appInfo.selectedData = {};
		}
	});

}
