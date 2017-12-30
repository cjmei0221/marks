var appInfo = {
	listUrl : top.window.urlBase + "/inner/sysMenu/list.do",
	saveUrl : top.window.urlBase + "/inner/sysMenu/save.do",
	deleteUrl : top.window.urlBase + "/inner/sysMenu/delete.do",
	instFuncUrl : top.window.urlBase + "/inner/sysMenu/initFunc.do",
	deletefuncurl : top.window.urlBase + "/inner/sysMenu/deleteFunc.do",
	addFuncurl : top.window.urlBase + "/inner/sysMenu/addFunc.do",
	selectedId : -1,
	selectedData : {},
	formStatus : "new",
	saveStatus : 0

}

// 新增
function add() {
	appInfo.saveStatus = 0;
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	appInfo.selectedId = -1;
	$("#lvl1Menuid").combobox("reload");
	$("#lvl").combobox("setValue", 1);
	$("#status").combobox("setValue", 1);
}
// 编辑

function edit() {
	$("#lvl1Menuid").combobox("reload");
	if (isSelectedOne(appInfo.selectedId)) {
		appInfo.saveStatus = 0;
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		if (appInfo.selectedId == '1' || appInfo.selectedId == '2') {
			$("#statusTr").hide();
		} else {
			$("#statusTr").show();
		}
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

// 添加功能
function addFunc() {
	if (isSelectedOne(appInfo.selectedId)) {
		if (appInfo.selectedData.lvl == 1 || appInfo.selectedData.lvl == 2) {
			showMsg("一级菜单和二级菜单不能设置功能");
			return;
		}
		$("#funcShow").html("");
		$("#addFuncWin").window({
			title : "功能管理"
		}).window("open");
		$("#tab2TableMod").hide();
		$("#addOneRule").show();
		// 初始化已有功能
		$
				.ajax({
					url : appInfo.instFuncUrl,
					type : "post",
					data : {
						"menuid" : appInfo.selectedId
					},
					dataType : "json",
					success : function(data, status, xhr) {
						if (typeof data === "string") {
							data = $.parseJSON(data);
						}
						if (data.retcode == "0") {
							var funclist = data.list;
							if (funclist.length > 0) {
								var obj = eval(data.list);
								for (var i = 0; i < obj.length; i++) {
									var val = obj[i];
									var str = "<table id='"
											+ val.funcid
											+ "' style='border-bottom:grey 1px solid;padding:5px;width:95%'><tr><td style='width:20%;'>"
											+ val.opername
											+ "</td><td style='width:20%;'>"
											+ val.operid
											+ "</td><td style='width:40%;'>"
											+ val.url
											+ "</td><td style='width:20%;'><a class='easyui-linkbutton' href='#'  onclick=\"javascript:delfunc(\'"
											+ val.funcid + "\')\">刪除功能</a>"
											+ "</td></tr></table>";
									$("#funcShow").append(str);
								}
							}
							appInfo.operatelist = data.operatelist;
						}
					},
					error : function(err) {
						loadError.apply(this, arguments);
					}
				});
	}
}

$(function() {
	// 加载列表
	loadList();

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	// 取消保存菜单
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
		$("#tbList").treegrid('unselectAll');
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});

	// 添加一个功能
	$("#addOneRule").on("click", function(e) {
		$("#addOneRule").hide();
		clearFuncForm();
		$("#tab2TableMod").show();
		$("#operid").combobox({
			data : appInfo.operatelist,
			valueField : 'operid',
			textField : 'opername'
		});

	});

	// 保存功能
	$("#btnFuncOK").on("click", function(e) {
		submitFuncForm();
	});
	// 取消
	$("#btnFuncCancel").on("click", function(e) {
		$("#tab2TableMod").hide();
		$("#addOneRule").show();
	});
	$("#lvl").combobox({
		onSelect : function(rec) {
			$("#lvl1Menuid").combobox("clear");
			$("#lvl1Menuid").combobox("clear");
			var lvlVal = rec.value;
			if (lvlVal == 1) {
				$("#statusTr").hide();
				$("#lvl1MenuidTr").hide();
				$("#lvl2MenuidTr").hide();
			} else if (lvlVal == 2) {
				$("#statusTr").show();
				$("#lvl1MenuidTr").show();
				$("#lvl2MenuidTr").hide();
			} else if (lvlVal == 3) {
				$("#statusTr").show();
				$("#lvl1MenuidTr").show();
				$("#lvl2MenuidTr").show();
			}
		}
	});
})
// 删除功能
function delfunc(funcid) {
	$.messager.confirm("确认", "请确认是否删除此功能!", function(r) {
		if (r) {
			var parms = "funcid=" + funcid;
			$.post(appInfo.deletefuncurl, parms, function(data) {
				if (data.retcode == "0") {
					showMsg("删除成功！");
					$("#" + funcid).remove();
				} else {
					showMsg(data.retmsg);
				}
			});
		} else {
			showMsg("操作已取消!");
			return;
		}
	});
}
// 保存功能
function submitFuncForm() {
	if (!$("#funcff").form("validate")) {
		showMsg("表单校验错误");
		return false;
	}
	var url = appInfo.addFuncurl;
	var parms = $("#funcff").serialize();
	parms += "&menuid=" + appInfo.selectedId;
	$
			.post(
					url,
					parms,
					function(data) {
						if (data.retcode == "0") {
							var str = "<table id='"
									+ data.operObj.funcid
									+ "' style='border-bottom:grey 1px solid;padding:5px;width:95%'><tr><td style='width:20%;'>"
									+ data.operObj.opername
									+ "</td><td style='width:20%;'>"
									+ data.operObj.operid
									+ "</td><td style='width:40%;'>"
									+ data.operObj.url
									+ "</td><td style='width:20%;'><a class='easyui-linkbutton' href='#'   onclick=\"javascript:delfunc(\'"
									+ data.operObj.funcid + "\')\">刪除功能</a>"
									+ "</td></tr></table>";
							$("#funcShow").append(str);
							$("#tab2TableMod").hide();
							$("#addOneRule").show();
						} else {
							showMsg(data.retmsg);
							$("#tab2TableMod").hide();
							$("#addOneRule").show();
						}
					});
}

// 清空功能表单
function clearFuncForm() {
	$("#funcurlname").val("");
	$("#funcurl").val("");
}

/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var lvlVal = $("#lvl").val();
	if (lvlVal == 2 && $("#lvl1Menuid").combobox("getValue") == '') {
		showMsg("一级菜单不能为空");
		return;
	}
	if (lvlVal == 3 && $("#lvl1Menuid").combobox("getValue") == '') {
		showMsg("一级菜单不能为空");
		return;
	}
	if (lvlVal == 3 && $("#lvl2Menuid").combobox("getValue") == '') {
		showMsg("二级菜单不能为空");
		return;
	}
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	appInfo.saveStatus = 0;
	$.post(appInfo.saveUrl, parms, function(data) {
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
			$('#tbList').treegrid('reload');
			$("#tbList").treegrid('unselectAll');
			appInfo.selectedData = data.menu;
			appInfo.selectedId = data.menu.menuid;
			appInfo.saveStatus = 1;
		} else {
			showMsg(data.retmsg);
			appInfo.saveStatus = 0;

		}
	});
}
/**
 * 加载列表
 */
function loadList() {
	$('#tbList').treegrid(
			{
				url : appInfo.listUrl,
				rownumbers : true,
				idField : 'menuid',
				treeField : 'menuitem',
				frozenColumns : [ [ {
					title : '菜单ID',
					field : 'menuid',
					width : 100,
					hidden : true
				}, {
					title : '菜单名称',
					field : 'menuitem',
					width : 200
				} ] ],
				columns : [ [ {
					title : '访问URL',
					field : 'url',
					width : 350
				}, {
					title : '菜单类型',
					field : 'lvl',
					width : 100,
					align : "center",
					formatter : function(value, row, index) {
						if (value == 1) {
							return "一级菜单";
						} else if (value == 2) {
							return "二级菜单";
						} else if (value == 3) {
							return "三级菜单";
						}
						return "";
					}
				}, {
					title : '排序',
					field : 'sort',
					width : 60
				}, {
					title : '启禁用',
					field : 'status',
					width : 100,
					align : "center",
					formatter : function(value, row, index) {
						if (value == 1) {
							return "启用";
						} else if (value == 0) {
							return "禁用";
						}
						return "";
					}
				} ] ],
				onBeforeExpand : function(row) {
					$("#tbList").treegrid("options").url = appInfo.listUrl
							+ "?parentId=" + row.menuid + "&_timer="
							+ new Date().getTime();
				},
				onClickRow : function(rowData) {
					appInfo.selectedId = rowData.menuid;
					appInfo.selectedData = rowData;
				},
				onDblClickRow : function(rowData) {
					appInfo.selectedId = rowData.menuid;
					appInfo.selectedData = rowData;
					edit();
				},
				onLoadSuccess : function(data) {
					$("#tbList").treegrid('unselectAll');
					$("#tbList").treegrid('collapseAll');
					appInfo.selectedData = {};
				}
			});
}