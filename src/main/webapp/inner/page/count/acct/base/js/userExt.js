var appInfo = {
	listUrl : top.window.urlBase + '/inner/userExt/list.do',// 获取用户扩展表列表接口
	saveUrl : top.window.urlBase + '/inner/acct/save.do',// 保存新增帐户信息接口
	// UserEx
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
function edit() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	$("#ywCode").combobox("setValue", "0");
	$("#tranCode").combobox("setValue", "1");
	$("#userid").val(appInfo.selectedId);
	$(".cls-point").show();
	$(".cls-amt").hide();
}
// -----------------权限控制功能 start---------------
function showAmtLog(userid) {
	$("#logWin").window({
		title : "交易记录"
	}).window("open");
	var path = '/inner/page/acct/log/acctLog.html?userid=' + userid
			+ "&ywCode=1";
	var strHtml = "<iframe width='100%' height='520px'  frameborder='0' scrolling='auto' src='"
			+ path + "'></iframe>";
	$("#postShow").html(strHtml);
}
function showPointLog(userid, ywCode) {
	$("#logWin").window({
		title : "交易记录"
	}).window("open");
	var path = '/inner/page/acct/log/acctLog.html?userid=' + userid
			+ "&ywCode=0";
	var strHtml = "<iframe width='100%' height='520px'  frameborder='0' scrolling='auto' src='"
			+ path + "'></iframe>";
	$("#postShow").html(strHtml);
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

	$("#ywCode").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			if (val == "0") {
				$(".cls-point").show();
				$(".cls-amt").hide();
			} else {
				$(".cls-point").hide();
				$(".cls-amt").show();
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
	var ywCode = $("#ywCode").combobox("getValue");
	if (ywCode == "0") {
		var tranPoint = $("#tranPoint").numberbox("getValue");
		if(tranPoint ==''){
			showMsg("积分值不能为空");
			return;
		}
		if(tranPoint == 0){
			showMsg("积分值不能为0");
			return;
		}
	} else {
		var sendAmt = $("#sendAmt").numberbox("getValue");
		if(sendAmt ==''){
			showMsg("赠送金额不能为空");
			return;
		}
		if(sendAmt == 0){
			showMsg("赠送金额不能为0");
			return;
		}
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
						// nowrap : true,
						// animate : true,
						// collapsible : true,
						// fitColumns : true,
						autoRowHeight : false,
						height : tool.screenHeight,
						striped : true,
						idField : 'userid',
						rownumbers : true,
						pagination : true,
						pageNumber : appInfo.requestParam.page_number,
						pageSize : appInfo.requestParam.page_size,
						singleSelect : true,
						columns : [ [
								{
									title : '系统编号',
									field : 'userid',
									width : 100,
									align : "center",
									hidden : true
								},
								{
									title : '用户编号',
									field : 'userCode',
									width : 100,
									align : "center"
								},
								{
									title : '用户姓名',
									field : 'username',
									width : 100,
									align : "center"
								},
								{
									title : '手机号码',
									field : 'bind_mobile',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										if (value.length == 11) {
											return value.substring(0, 3)
													+ "****"
													+ value.substring(7, 11);
										}
										return value;
									}
								},
								{
									title : '用户类型',
									field : 'roleName',
									width : 100,
									align : "center"
								},
								{
									title : '机构编号',
									field : 'orgId',
									width : 100,
									align : "center"
								},
								{
									title : '机构名称',
									field : 'orgName',
									width : 100,
									align : "center"
								},
								{
									title : '等级名称',
									field : 'lvlName',
									width : 100,
									align : "center"
								},
								{
									title : '可用积分',
									field : 'balPoint',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										return '<a href="javascript:void(0)" onclick="showPointLog(\''
												+ row.userid
												+ '\')">'
												+ value
												+ '</a>';
									}
								},
								{
									title : '余额',
									field : 'balAmt',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										return '<a href="javascript:void(0)" onclick="showAmtLog(\''
												+ row.userid
												+ '\')">'
												+ value
												+ '</a>';
									}
								}, {
									title : '首次消费时间',
									field : 'first_consume_time',
									width : 180,
									align : "center"
								}, {
									title : '最后消费时间',
									field : 'last_consume_time',
									width : 180,
									align : "center"
								}, {
									title : '创建时间',
									field : 'first_operate_time',
									width : 180,
									align : "center"
								}, {
									title : '累计积分',
									field : 'grand_total_point',
									width : 100,
									align : "center"
								}, {
									title : '累计消费金额',
									field : 'grand_total_consume_amt',
									width : 100,
									align : "center"
								}, {
									title : '累计消费次数',
									field : 'grand_total_consume_nums',
									width : 100,
									align : "center"
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							loader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.userid;
							appInfo.selectedData = rowData;
						},
						onDblClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.userid;
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
