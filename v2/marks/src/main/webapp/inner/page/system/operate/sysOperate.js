var appInfo = {
	listUrl : top.window.urlBase + "/inner/sysOperate/list.do",
	saveUrl : top.window.urlBase + "/inner/sysOperate/save.do",
	deleteUrl : top.window.urlBase + "/inner/sysOperate/delete.do",
	selectedId : -1,
	selectedData : {},
	requestParam:{
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus:"new"
}

//新增
function add(){
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus="new";
	$("#operid").removeAttr("disabled");
}
//编辑
function edit(){
	if(isSelectedOne(appInfo.selectedId)){
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus="edit";
		$('#ff').form('load',appInfo.selectedData);
		$("#operid").attr("disabled","disabled");
	}
}
//删除
function del(){
	if(isSelectedOne(appInfo.selectedId)){
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "id=" + appInfo.selectedId;
				$.post(appInfo.deleteUrl, parms, function(data) {
					if (data.retcode == "0") {
						app.myreload("#tbList");
						appInfo.selectedData = {};
						appInfo.selectedId=-1;
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
	//加载列表
	loadList();
	//搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId=-1;
	});
	
	//保存菜单
	$("#btnOK").on("click",function(){
		$("#operid").removeAttr("disabled");
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});
})

/**
 * 保存菜单
 */
function formSubmit(){
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
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
			app.myreload("#tbList");
			appInfo.selectedData = {};
			appInfo.selectedId=-1;
		} else {
			showMsg(data.retmsg);
		}
	});
}
/**
 * 加载列表
 */
function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped:true,
		nowrap:true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'operid',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '按钮ID',
			field : 'operid',
			width : 100
		}, {
			title : '按钮名称',
			field : 'opername',
			width : 150
		}, {
			title : '图标',
			field : 'picicon',
			width : 100
		}, {
			title : '排序',
			field : 'sort',
			width : 100
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex,rowData) {
			appInfo.selectedId = rowData.operid;
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
		appInfo.requestParam.keyword=$("#keyword").val();
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
					$.messager.alert("系统提示", data.retmsg);
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