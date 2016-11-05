var appInfo = {
	listUrl : top.window.urlBase + '/autoCode/list.do',// 获取自动生成代码记录列表接口
	// AutoCode
	saveUrl : top.window.urlBase + '/autoCode/save.do',// 保存新增自动生成代码记录接口
	updateUrl : top.window.urlBase + '/autoCode/update.do',// 编辑自动生成代码记录信息接口
	deleteUrl : top.window.urlBase + '/autoCode/delete.do',// 删除自动生成代码记录接口
	attrListUrl : top.window.urlBase + '/autoCode/attrList.do',// 删除自动生成代码记录接口
	autoCodeUrl : top.window.urlBase + '/autoCode/autocode.do',// 删除自动生成代码记录接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new",
	attrtypedata : [ {
		"id" : "String",
		"text" : "String"
	}, {
		"id" : "Integer",
		"text" : "Integer"
	}, {
		"id" : "Date",
		"text" : "Date"
	} ],
	attrReqParam : {
		tableName : ""
	}
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
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus = "new";
		$('#tableName').removeAttr("readonly");
		initAttrList();
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus = "edit";
			$('#ff').form('load', appInfo.selectedData);
			$('#tableName').attr("readonly","readonly");
			initAttrList();
		}
	});
	
	// 删除
	$("#delete").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('Confirm', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "tableName=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == 0) {
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
	});

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	
	$("#btnCancel").on("click",function(){
		$("#editWin").window("close");
	});

	// 弹出字段编辑框
	$("#editAttr").on("click", function() {
		$("#attrWin").window({
			title : "字段编辑"
		}).window("open");
	});
	
	//自动生成代码
	$("#autoCodeBtn").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
			$.messager.confirm('Confirm', '确认要生成记录吗?', function(r) {
				if (r) {
					var parms = "tableName=" + appInfo.selectedId;
					$.post(appInfo.autoCodeUrl, parms, function(data) {
						if (data.retcode == 0) {
							showMsg("重新编译后起效");
						} else {
							showMsg(data.retmsg);
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
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	var attrList = [];
	var row = $("#dg").datagrid('getRows');
	;
	for (var i = 0; i < row.length; i++) {
		if(row[i].attrName != ""){
			var items = row[i].attrName + "#" + row[i].attrType + "#"
			+ row[i].attrSize + "#" + row[i].attrDesc;
			attrList.push(items);
		}
		
	}
	if(attrList.length<2){
		top.G.alert("至少添加两个字段！");
		return;
	}
	attrList = attrList.join(',');

	$('#ff').form('submit', {
		url : reqUrl,
		onSubmit : function(param) {
			param.formStatus = appInfo.formStatus;
			param.attrListPut = attrList;
		},
		success : function(data) {
			if(typeof data === 'string'){
				try{
					data = $.parseJSON(data);
				}catch(e0){
					top.G.alert(window.msgs.return_json_error);
					return;
				}					
			}
			if (data.retcode == 0) {
				$("#editWin").window("close");
				app.myreload("#tbList");
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
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'tableName',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '表名称',
			field : 'tableName',
			width : 100,
			align : "center"
		}, {
			title : '实体类名称',
			field : 'beanName',
			width : 100,
			align : "center"
		}, {
			title : '上级包名',
			field : 'parentPackage',
			width : 100,
			align : "center"
		}, {
			title : '描述',
			field : 'moduleDesc',
			width : 100,
			align : "center"
		}, {
			title : '是否生成表',
			field : 'is_createtable',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "生成";
				} else {
					return "不生成";
				}
			}
		}, {
			title : '是否授权',
			field : 'is_auth',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return "是";
				} else {
					return "否";
				}
			}
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.tableName;
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
				if (data.retcode == 0) {
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
function unitformatter(value, rowData, rowIndex) {
	if (value == 0) {
		return;
	}

	for (var i = 0; i < appInfo.attrtypedata.length; i++) {
		if (appJP.salegoodtypelist[i].id == value) {
			return appInfo.attrtypedata[i].text;
		}
	}
}
function endEdit() {
	var rows = $("#dg").datagrid('getRows');
	for (var i = 0; i < rows.length; i++) {
		$("#dg").datagrid('endEdit', i);
	}
}



function initAttrList() {
	$('#dg').datagrid({
		url : appInfo.attrListUrl,
		striped : true,
		nowrap : true,
		collapsible : true,
		rownumbers : true,
		fitColumns : true,
		singleSelect : true,
		toolbar : [ {
			text : "删除",
			iconCls : "icon-remove",
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
					var rowIndex = $('#dg').datagrid('getRowIndex', row);
					$('#dg').datagrid('deleteRow', rowIndex);
				}
			}
		},'-',  {
			text : "确定",
			iconCls : "icon-save",
			handler : function() {
				endEdit();
				$("#attrWin").window("close");
			}
		} ],
		columns : [ [ {
			field : 'cks',
			checkbox : false
		}, {
			field : 'attrName',
			title : '字段ID',
			width : 150,
			editor : "validatebox"
		}, {
			field : 'attrDesc',
			title : '字段名称',
			width : 150,
			editor : "validatebox"
		}, {
			field : 'attrType',
			title : '数据类型',
			width : 150,
			
			editor : {
				type : 'combobox',
				options : {
					data : appInfo.attrtypedata,
					valueField : "id",
					textField : "text"
				}
			}
		}, {
			field : 'attrSize',
			title : '字段大小',
			width : 150,
			editor : "validatebox"
		}, {
			field : 'isPK',
			title : '是否为主键',
			width : 100,
			formatter : function(value, row, index) {
				if (value == 1) {
					return "<span style='color:red'>主键</span>";
				} else {
					return "";
				}
			}
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			attrloader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			$("#dg").datagrid("beginEdit", rowIndex);
		},
		onLoadSuccess : function(data) {
			$("#dg").datagrid('unselectAll');
			
		}
	});
	// 请求加载数据
	function attrloader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		
		appInfo.attrReqParam.tableName = $("#tableName").val();
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.attrReqParam,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.retcode == 0) {
					var list = data.attrlist;
					that.data().datagrid["cache"] = data;
					success({
						"total" : list.length,
						"rows" : list
					});
					return true;
				} else {
					showMsg( data.retmsg);
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