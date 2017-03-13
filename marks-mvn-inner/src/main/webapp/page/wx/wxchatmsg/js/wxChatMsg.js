var appInfo = {
	listUrl : top.window.urlBase + '/wxChatSession/list.do',// 获取询问管理列表接口 WxChatMsg
	saveUrl : top.window.urlBase + '/wxChatMsg/save.do',// 保存新增询问管理接口
	updateUrl : top.window.urlBase + '/wxChatMsg/update.do',// 编辑询问管理信息接口
	deleteUrl : top.window.urlBase + '/wxChatMsg/delete.do',// 删除询问管理接口
	replayListUrl:top.window.urlBase + '/wxChatMsg/replayList.do',// 删除询问管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new",
	session_id:"-1"
};
//定时器定时刷新页面

$(function() {
	
	// 加载列表
	loadList();

	// 搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});

	// 搜索
	$("#refreshTable").on("click", function(e) {
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
	$("#refreshBtn").on("click", function() {
		loadReplayList($("#session_id").val);
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
//				$("#msg").prepend("<p>"+data.info.createtime+"&nbsp;&nbsp;"+data.info.username+"&nbsp;&nbsp;"+data.info.c_content+"</p>");
				$("#c_content").val("");
				loadReplayList(data.info.session_id);
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
	$("#session_id").val(sId);
	$("#c_replayType").combobox("setValue", "TEXT");
	loadReplayList(sId);
}

function loadReplayList(sId){
	$.ajax({
		url : appInfo.replayListUrl,
		type : "get",
		data : {
			"session_id":sId
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var list = data.repayList;
				if(null != list && list.length>0){
					$("#msg").html("");
					for(var i=0;i<list.length;i++){
						var sct=list[i].c_content;
						if(list[i].c_content == '0'){
							sct='请求人工服务';
						}
						var cssStr="black";
						if(list[i].c_type==0){
							cssStr="blue";
						}
						$("#msg").append("<p style='color:"+cssStr+";'>"+list[i].createtime+"&nbsp;&nbsp;"+list[i].username+"&nbsp;&nbsp;"+sct+"</p>");
					}
				}
				return true;
			} 
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});
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
									title : '回话ID',
									field : 'session_id',
									width : 150,
									align : "center"
								},
								{
									title : '粉丝ID',
									field : 'fanId',
									width : 100,
									align : "center"
								},
								{
									title : '昵称',
									field : 'username',
									width : 100,
									align : "center"
								},
								{
									title : '内容',
									field : 'c_content',
									width : 400,
									formatter : function(value, row, index) {
										if (row.flag == 1) {
											return  "<span style='color:blue;' onclick=\"javascript:replayFunc('"+row.session_id+"')\">人工服务</span>"
										} else {
											return value;
										}

									}
								}, {
									title : '询问时间',
									field : 'createtime',
									width : 150,
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
							var len=rowData.wxChatMsgList.length;
							var list=rowData.wxChatMsgList;
							if(len>0){
								tableStr.push('<table style="width:100%;"><tr><td></td><td align="center">用戶</td><td>回复内容</td><td>回复时间</td></tr><tr>');
								var str="";
								var contentstr="";
								for(var i=0;i<len;i++){
									str="回复";
									contentstr=list[i].c_content;
									if(list[i].c_type==0){
										str="询问";
									}
									/*if(list[i].c_type == 0 && list[i].is_replay == 0){
										contentstr="<span style='color:blue;' onclick=\"javascript:replayFunc('"
											+ list[i].id
											+ "','"+list[i].session_id+"')\">"+list[i].c_content+"</span>";
									}*/
									tableStr.push("<tr>"
									+"<td style='width:10%;' align='center'>" + str + "</td>" 
									+"<td style='width:15%;' align='center'>" + list[i].username + "</td>"
									+"<td style='width:60%;'>"+ contentstr+ "</td>" 
									+"<td style='width:15%;'>" + list[i].createtime + "</td>"
									+"</tr>");
								}
								tableStr.push('</tr></table>');
							}
							return tableStr.join('');
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

window.setTimeout(function() {
	console.log("myreload------------");
	
}, 100);
