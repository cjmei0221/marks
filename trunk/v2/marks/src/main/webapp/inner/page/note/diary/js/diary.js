var appInfo = {
	listUrl : top.window.urlBase + '/inner/diary/list.do',// 获取我的日记列表接口 Diary
	saveUrl : top.window.urlBase + '/inner/diary/save.do',// 保存新增我的日记接口
	updateUrl : top.window.urlBase + '/inner/diary/update.do',// 编辑我的日记信息接口
	deleteUrl : top.window.urlBase + '/inner/diary/delete.do',// 删除我的日记接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		statedate : "",
		enddate : ""
	},
	formStatus : "new"
};
//新增
function add(){
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	initTime();
}
//编辑
function edit(){
	if (isSelectedOne(appInfo.selectedId)) {
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		$("#dateStr").html(appInfo.selectedData.createtime);
		var str=del_html_tags(appInfo.selectedData.content,"<br/>","\r\n");
		$("#content").val(str);
	}
}
//删除
function del(){
	if (isSelectedOne(appInfo.selectedId)) {
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "ID=" + appInfo.selectedId;
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
		add();
	});

	// 编辑
	$("#edit").on("click", function() {
		edit();
	});

	// 删除
	$("#delete").on("click", function() {
		del();
	});

	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});
});
function initTime() {
	var curr_time = new Date();
	var strDate = curr_time.getFullYear() + "-";
	strDate += curr_time.getMonth() + 1 + "-";
	strDate += curr_time.getDate() + " ";
	strDate += curr_time.getHours() + ":";
	strDate += curr_time.getMinutes() + ":";
	strDate += curr_time.getSeconds();
	$("#dateStr").html(strDate+"");
}
/**
 * 保存菜单
 */
function formSubmit() {
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	$.post(reqUrl, parms, function(data) {
		if (typeof data === 'string') {
			try {
				data = $.parseJSON(data);
			} catch (e0) {
				top.G.alert(window.msgs.return_json_error);
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
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'ID',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '主键',
			field : 'ID',
			align : "center",
			hidden : true
		}, {
			title : '日记时间',
			field : 'createtime',
			width : 120,
			align : "center"
		}, {
			title : '标题',
			field : 'title',
			width : 150,
			align : "center"
		}, {
			title : '正文',
			field : 'content',
			width : 600,
			align : "left"
		}, {
			title : '编写手机号',
			field : 'mobile',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.ID;
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
		appInfo.requestParam.statedate = $('#statedate').datebox('getValue');
		appInfo.requestParam.enddate = $('#enddate').datebox('getValue');
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
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
