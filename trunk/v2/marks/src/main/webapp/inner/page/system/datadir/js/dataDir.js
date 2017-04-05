var appInfo = {
	listUrl : top.window.urlBase + '/inner/dataDir/list.do',// 获取数据字典列表接口 DataDir
	saveUrl : top.window.urlBase + '/inner/dataDir/save.do',// 保存新增数据字典接口
	updateUrl : top.window.urlBase + '/inner/dataDir/update.do',// 编辑数据字典信息接口
	deleteUrl : top.window.urlBase + '/inner/dataDir/delete.do',// 删除数据字典接口
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
		$('#tbList').treegrid('reload');
		$("#tbList").treegrid('unselectAll');
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});

	// 新增
	$("#add").on("click", function() {
		
		if (isSelectedOne(appInfo.selectedId)) {
			if(appInfo.selectedData.parentkey=='0' || appInfo.selectedData.ckey=='0'){
				$("#editWin").window({
					title : "新增"
				}).window("open");
				$('#ff').form('clear');
				appInfo.formStatus = "new";
				$("#parentkey").val(appInfo.selectedData.ckey);
				$("#ckey").removeAttr("readonly");
			}else{
				showMsg("请选择一级节点或者一级父节点");
			}
		}
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$('#ff').form('load', appInfo.selectedData);
			$("#ckey").attr("readonly","readonly");
		}
	});

	// 删除
	$("#delete").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			if(appInfo.selectedData.ckey=='0'){
				showMsg("不可删除一级父节点");
				return;
			}
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "ckey=" + appInfo.selectedId+"&parentkey="+appInfo.selectedData.parentkey;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == "0") {
							$('#tbList').treegrid('reload');
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
			if (data.retcode == "0") {
				$("#editWin").window("close");
				$('#tbList').treegrid('reload');
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
		idField : 'idKey',
		treeField : 'cvalue',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			
			title : '主键值',
			field : 'cvalue',
			width : 100,
			align : "left"	
		}, {
			title : '主键',
			field : 'ckey',
			width : 100,
			align : "center"
		}, {
			title : '排序',
			field : 'sort',
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
		}, {
			title : '创建者',
			field : 'creator',
			width : 100,
			align : "center"
		} ] ],
		onClickRow : function(rowData) {
			appInfo.selectedId = rowData.ckey;
			appInfo.selectedData = rowData;
		},
		onLoadSuccess : function(data) {
			$("#tbList").datagrid('unselectAll');
			appInfo.selectedData = {};
		}
	});
}
