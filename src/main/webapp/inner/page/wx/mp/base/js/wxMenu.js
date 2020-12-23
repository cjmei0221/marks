var appInfo = {
	listUrl : top.window.urlBase + '/inner/wxMenu/list.do',// 获取微信菜单管理列表接口
															// WxMenu
	saveUrl : top.window.urlBase + '/inner/wxMenu/save.do',// 保存新增微信菜单管理接口
	updateUrl : top.window.urlBase + '/inner/wxMenu/update.do',// 编辑微信菜单管理信息接口
	deleteUrl : top.window.urlBase + '/inner/wxMenu/delete.do',// 删除微信菜单管理接口
	syncWxUrl :  top.window.urlBase + '/inner/wxMenu/syncWx.do',
	tagListUrl :  top.window.urlBase + '/inner/wxTags/findWxTagsByAccountid.do',
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};


// 新增
function add() {
	if (appInfo.selectedId == -1) {
		showMsg("请选择父节点，若没有父节点请先确定是否有添加服务号！");
		return;
	}
	if (appInfo.selectedData.lvl >1) {
		showMsg("只能建两级菜单！");
		return;
	}
	if(appInfo.selectedData.lvl==0 && appInfo.selectedData.childnum>=3){
		showMsg("一级菜单只能添加三个！");
		return;
	}
	if(appInfo.selectedData.lvl==1 && appInfo.selectedData.childnum>=5){
		showMsg("二级菜单只能添加五个！");
		return;
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
}

// 编辑
function edit() {
	if (isSelectedOne(appInfo.selectedId)) {
		if(appInfo.selectedData.lvl==0){
			$("#accWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$('#accff').form('load', appInfo.selectedData);
			return;
		}
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
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
}

function syncWx(){
	if (isSelectedOne(appInfo.selectedId)) {
		if(appInfo.selectedData.lvl==0){
			$.messager.confirm('确认', '确认要同步微信服务器吗?', function(r) {
				if (r) {
					var parms = "id=" + appInfo.selectedId;
					$.post(appInfo.syncWxUrl, parms, function(data) {
						if (data.retcode == "0") {
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
}
// 添加公众号菜单
function addAcc(){
	$("#accWin").window({
		title : "新增"
	}).window("open");
	appInfo.formStatus = "new";
	$('#accff').form('clear');
}
function selectMenuType(rec){
	if(rec.label=='0'){
		 $('#tagidTr').hide();
	}else{
		 $('#tagidTr').show();
	}
}
// 选择公众号后加载标签列表
function reloadtagList(rec){
	var url = appInfo.tagListUrl+'?id='+rec.accountId;
    $('#tagid').combobox('reload', url);
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
	// 保存公众号菜单
	$("#btnOKAcc").on("click", function() {
		formSubmitForAcc();
	});
	// 取消公众号菜单
	$("#btnCancelAcc").on("click", function() {
		$("#accWin").window("close");
	});
});
function formSubmitForAcc() {
	if (!$('#accff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	
	var parms = $("#accff").serialize();
	parms += "&lvl=0";
	parms += "&parent_id=0";
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
			$("#accWin").window("close");
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
	parms += "&type=" + $("input[name='type']").val();
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
	$('#tbList').treegrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
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
			width : 300
		}, {
			title : '菜单类型',
			field : 'type',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if(row.lvl==0){
					if(row.menutype==0){
						return "通用菜单";
					}
					return "个性化菜单";
				}
				return value;
				
			}
		}, {
			title : '访问内容',
			field : 'content',
			width : 450,
			formatter : function(value, row, index) {
				if(row.lvl==0 && row.menutype==1){
					return "标签："+row.tagname;
				}
				return value;
			}
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
		onBeforeExpand : function(row) {
			$("#tbList").treegrid("options").url = appInfo.listUrl
					+ "?parentId=" + row.id + "&_timer="
					+ new Date().getTime();
		},
		onClickRow : function(rowData) {
			appInfo.selectedId = rowData.id;
			appInfo.selectedData = rowData;
			
		},
		onDblClickRow : function(rowData) {
			appInfo.selectedId = rowData.id;
			appInfo.selectedData = rowData;
			edit();
		},
		onLoadSuccess : function(data) {
			$("#tbList").treegrid('unselectAll');
			appInfo.selectedData = {};
		}
	});

}
