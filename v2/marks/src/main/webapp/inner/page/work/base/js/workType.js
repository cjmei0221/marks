var appInfo = {
	listUrl : top.window.urlBase + '/inner/workType/list.do',// 获取工作类型列表接口
	// WorkType
	saveUrl : top.window.urlBase + '/inner/workType/save.do',// 保存新增工作类型接口
	updateUrl : top.window.urlBase + '/inner/workType/update.do',// 编辑工作类型信息接口
	deleteUrl : top.window.urlBase + '/inner/workType/delete.do',// 删除工作类型接口
	saveStepUrl : top.window.urlBase + '/inner/workTypeStep/save.do',// 保存新增工作流步骤配置接口
	listItemUrl : top.window.urlBase + '/inner/workTypeStep/list.do',// 删除工作流步骤配置接口
	listRoleUrl : top.window.urlBase + '/inner/sysRole/combo.do',// 删除工作流步骤配置接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	requestParam2 : {
		page_number : 1,
		page_size : 10,
		typeId : ""
	},
	formStatus : "new"
};
var editRow = undefined; // 定义全局变量：当前编辑的行
// -----------------权限控制功能 start---------------
// 新增
function add() {
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#isAuto").combobox("setValue", 0);
}

// 编辑
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$("#editWin").window({
		title : "编辑"
	}).window("open");
	appInfo.formStatus = "edit";
	$('#ff').form('load', appInfo.selectedData);
}
// 删除
function del() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}

	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "typeId=" + appInfo.selectedId;
			$.post(appInfo.deleteUrl, parms, function(data) {
				if (data.retcode == '0') {
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
function addStep(typeId, status) {
	editRow = undefined;
	loadItemList(typeId);
	$("#stepWin").window({
		title : "步骤"
	}).window("open");
	$("#status").combobox("setValue", status);
	$("#stepTypeId").val(typeId);
}
function loadItemList(typeId){
	var reqUrl=appInfo.listItemUrl;
	var parms="typeId="+typeId;
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
			console.log(data);
			if(data.total_count>0){
				var infolist=data.list;
				for(var i=0;i<infolist.length;i++){
					var idx=i+1;
					$("#stepName"+idx).val(infolist[i].stepName);
					$("#dealType"+idx).combobox("setValue",infolist[i].dealType);
					$("#roleId"+idx).combobox("setValue",infolist[i].roleId);
				}
			}
		} else {
			showMsg(data.retmsg);
		}
	});
}

// -----------------权限控制功能 end---------------
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
	$("#isAuto").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			if (val == '0') {
				$(".noAutoDiv").hide();
				$(".autoDiv").show();
			} else if (val == '1') {
				$(".noAutoDiv").show();
				$(".autoDiv").hide();
			}else{
				$(".noAutoDiv").hide();
				$(".autoDiv").hide();
			}
		}
	});
	$("#saveStep").on("click", function() {
		saveStep();
	});

	$("#dealType1").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(1,val);
		}
	});
	$("#dealType2").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(2,val);
		}
	});
	$("#dealType3").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(3,val);
		}
	});
	$("#dealType4").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(4,val);
		}
	});
	$("#dealType5").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(5,val);
		}
	});
	$("#dealType6").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(6,val);
		}
	});
	$("#dealType7").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(7,val);
		}
	});
	$("#dealType8").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(8,val);
		}
	});
	$("#dealType9").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(9,val);
		}
	});
	$("#dealType10").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			loadRole(10,val);
		}
	});
});

function loadRole(idx,val){
	if(val == ""){
		return;
	}
	var url=appInfo.listRoleUrl+"?roleYwType=2&edit=edit";
	if(0== val) {
		url=appInfo.listRoleUrl+"?roleYwType=0,1&edit=edit";
	}
	$.ajax({
        type: "POST",
        url: url,
        cache: false,
        dataType: "json",
        success: function (data) {
            $("#roleId"+idx).combobox("loadData", data);
        }
    });
}

function saveStep() {
	var parms = $("#stepff").serialize();
	parms += "&typeId=" + $("#stepTypeId").val();
	var reqUrl = appInfo.saveStepUrl;
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
			$("#stepWin").window("close");
			app.myreload("#tbList");
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
	$('#tbList')
			.datagrid(
					{
						url : appInfo.listUrl,
						toolbar : "#tb",
						idField : 'typeId',
						height : 580,
						rownumbers : true,
						pagination : true,
						pageNumber : appInfo.requestParam.page_number,
						pageSize : appInfo.requestParam.page_size,
						singleSelect : true,
						columns : [ [
								{
									title : '工作主键',
									field : 'typeId',
									width : 100,
									align : "center",
									hidden : true
								},
								{
									title : '工作编号',
									field : 'typeCode',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										return '<a href="javascript:void(0)" onclick="addStep(\''
												+ row.typeId
												+ '\','
												+ row.status
												+ ')">'
												+ value
												+ '</a>';
									}
								}, {
									title : '工作名称',
									field : 'typeName',
									width : 250,
									align : "center"
								}, {
									title : '启禁用',
									field : 'status',
									width : 100,
									formatter : function(value, row, index) {
										if (value == 0) {
											return "禁用";
										} else if (value == 1) {
											return '启用';
										}
										return '';
									}
								}, {
									title : '更新时间',
									field : 'updatetime',
									width : 250,
									align : "center"
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							loader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.typeId;
							appInfo.selectedData = rowData;
						},
						onDblClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.typeId;
							appInfo.selectedData = rowData;
							edit();
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