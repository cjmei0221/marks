var appInfo = {
	listUrl : top.window.urlBase + '/wxChatMsg/list.do',// 获取询问管理列表接口 WxChatMsg
	saveUrl : top.window.urlBase + '/wxChatMsg/save.do',// 保存新增询问管理接口
	updateUrl : top.window.urlBase + '/wxChatMsg/update.do',// 编辑询问管理信息接口
	deleteUrl : top.window.urlBase + '/wxChatMsg/delete.do',// 删除询问管理接口
	listReplayUrl : top.window.urlBase + '/wxChatMsg/replayList.do',// 删除询问管理接口
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
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus = "new";
	});

	// 编辑
	$("#edit").on("click", function() {
		if (isSelectedOne(appInfo.selectedId)) {
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
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "id=" + appInfo.selectedId;
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
	var c_content=$("#c_content").val().trim();
	if(c_content==''){
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
			if (data.retcode == '0') {
				
				app.myreload("#tbList");
				appInfo.selectedData = {};
				appInfo.selectedId = -1;
				$("#addMsgDiv").append("<p>"+data.info.createtime+"&nbsp;&nbsp;"+data.info.c_content+"</p>");
				$("#c_content").val("");
			} else {
				showMsg(data.retmsg);
			}
		}
	});
}
function replayFunc(sId) {
	$("#editWin").window({
		title : "回复"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#id").val(sId);
	$("#c_replayType").combobox("setValue", "TEXT");
}
function loadList() {
	$('#tbList')
			.datagrid(
					{
						url : appInfo.listUrl,
						toolbar : "#tb",
						autoRowHeight : true,
						fitColumns : true,
						showFooter : true,
						pagination : true,
						pageNumber : 1,
						pageSize : 10,
						singleSelect : true,
						rownumbers : true,
						nowrap : false,
						singleSelect : true,
						columns : [ [
								{
									title : 'ID',
									field : 'id',
									width : 100,
									align : "center",
									hidden : true
								},
								{
									title : '粉丝ID',
									field : 'fanId',
									width : 100,
									align : "center"
								},
								{
									title : '内容',
									field : 'c_content',
									width : 400,
									formatter : function(value, row, index) {
										if (row.c_type == 0) {
											return "<span style='color:blue;' onclick=\"javascript:replayFunc(\'"
													+ row.id
													+ "\')\">"
													+ value
													+ "</span>";
										} else {
											return value;
										}

									}
								}, {
									title : '询问时间',
									field : 'createtime',
									width : 100,
									align : "center"
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							loader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.id;
							appInfo.selectedData = rowData;
						},
						onLoadSuccess : function(data) {
							$("#tbList").datagrid('unselectAll');
							appInfo.selectedData = {};
						},
						view : detailview,
						detailFormatter : function(rowIndex, rowData) {
							var tableStr=[];
							var len=rowData.replayList.length;
							if(len>0){
								tableStr.push('<table style="width:100%;"><tr><td>用戶ID</td><td>回复内容</td><td>回复时间</td></tr><tr>');
								for(var i=0;i<len;i++){
									tableStr.push('<tr><td style="width:20%;">' + rowData.replayList[i].userid + '</td>' +
									'<td style="width:60%;">' + rowData.replayList[i].c_content + '</td>' +
									'<td style="width:20%;">' + rowData.replayList[i].createtime + '</td></tr>');
								}
								tableStr.push('</tr></table>');
							}
							return tableStr.join('');;
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
