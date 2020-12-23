var appInfo = {
	getGoodUrl : top.window.urlBase + '/inner/goodShop/findGoodInoById.do',// 获取采购商品列表接口
	saveUrl : top.window.urlBase + '/inner/goodShop/save.do',// 保存新增门店商品接口
	// DispatchGood
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};
var orderId = tool.getUrlParams("idNo");
var edit = tool.getUrlParams("formStatus");
var returnType = tool.getUrlParams("returnType");
// -----------------权限控制功能 start---------------
appInfo.formStatus = edit;
// -----------------权限控制功能 end---------------
$(function() {

	// 加载列表
	loadList();
	addRow();
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#returnParent").on("click", function(e) {
		returnList();
	});
	$("#btnCheck").on("click",function(e){
		$.messager.confirm('确认', '确认提交审核吗?', function(r) {
			if (r) {
				var parms = "idNo=" +$("#orderId").val();
				$.post(appInfo.approveUrl, parms, function(data) {
					if (data.retcode == '0') {
						showMsg("操作成功");
						returnList();
					} else {
						showMsg(data.retmsg);
					}
				});
			}
		});
	});
	
});
function returnList(){
	var url = "./goodShop.html?&menuid=M_MALL_GOOD_GOODSHOP";
	location.href = url;
}

/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	endEdit();
	var attrList = [];
	var row = $("#tbList").datagrid('getRows');
	for (var i = 0; i < row.length; i++) {
		if (row[i].goodName != "") {
			var items = row[i];
			attrList.push(items);
		}
	}
	if (attrList.length < 1) {
		showMsg("至少添加一个商品！");
		return;
	}

	var reqUrl = appInfo.saveUrl;
	
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	parms += "&goodData=" + JSON.stringify(attrList);
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
			showMsg("保存成功");
		} else {
			showMsg(data.retmsg);
		}
	});
}
function endEdit() {
	var rows = $("#tbList").datagrid('getRows');
	for (var i = 0; i < rows.length; i++) {
		$("#tbList").datagrid('endEdit', i);
	}
}

function delRow(idx) {
	$('#tbList').datagrid('deleteRow', idx);
}
function addRow(){
	$.ajax({
		url : appInfo.getGoodUrl,
		type : "get",
		data : {
			"goodNo" : "",
			"shopId":"",
			"edit":"1"
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var rowData = data.info;
				$('#tbList').datagrid('appendRow',rowData);
				return true;
			} else {
				showMsg(data.retmsg);
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});
	
}
function setEditing(rowIndex) {
	var editors = $('#tbList').datagrid('getEditors', rowIndex);
	var goodCodeEditor = editors[0];
	goodCodeEditor.target.bind('change', function() {
		var goodCode = goodCodeEditor.target.val()
		getGoodInfo(rowIndex, goodCode);
	});
}

function getGoodInfo(rowIndex, goodCode) {
	var shopId = $("#shopId").combobox("getValue");
	if (shopId == null || shopId == '') {
		showMsg('请先选择门店！');
		return;
	}
	$.ajax({
		url : appInfo.getGoodUrl,
		type : "get",
		data : {
			"goodNo" : goodCode,
			"shopId":shopId,
			"edit":"0"
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var rowData = data.info;
				$('#tbList').datagrid('updateRow', {
					index : rowIndex,
					row : rowData
				});
				return true;
			} else {
				showMsg(data.retmsg);

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
						// toolbar : "#tb",
						idField : 'goodNo',
						height : 350,
						rownumbers : true,
						columns : [ [
								{
									title : '操作',
									field : 'oper',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										return "<a href='#' onclick=\"javascript:addRow()\">添加</a>&nbsp;&nbsp;<a href='#' onclick=\"javascript:delRow("
												+ index + ")\">删除</a>";
									}
								}, {

									title : '编号',
									field : 'goodNo',
									width : 100,
									align : "center",
									editor : "validatebox"
								}, {
									title : '品名',
									field : 'goodName',
									width : 300,
									align : "center"
								}, {
									title : '售价',
									field : 'salePrice',
									width : 100,
									align : "center",
									editor : {
										type : 'numberbox',
										options : {
											precision : 2
										}
									}
								
								}, {
									title : '会员价',
									field : 'vipPrice',
									width : 100,
									align : "center",
									editor : {
										type : 'numberbox',
										options : {
											precision : 2
										}
									}
								
								}, {
									title : '配送价',
									field : 'dispatchPrice',
									width : 100,
									align : "center",
//									editor : {
//										type : 'numberbox',
//										options : {
//											precision : 2
//										}
//									}
								} ] ],
//						loader : function(params, success, loadError) {
//							var that = $(this);
//							loader(that, params, success, loadError);
//						},
						onClickRow : function(rowIndex, rowData) {
							$("#tbList").datagrid("beginEdit", rowIndex);
							setEditing(rowIndex);
						},
						onClickCell : function(rowIndex, field, value) {

						},
//						onLoadSuccess : function(data) {
//							$("#tbList").datagrid('unselectAll');
//						}
					});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		appInfo.requestParam.page_number = 1;
		appInfo.requestParam.page_size = 200;
		appInfo.requestParam.orderId = orderId;
		appInfo.requestParam.formStatus=appInfo.formStatus
		$.ajax({
			url : opts.url,
			type : "get",
			data : appInfo.requestParam,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.retcode == '0') {
					$('#ff').form('load', data.info);
					var list = data.list;
					that.data().datagrid["cache"] = data;
					success({
						"total" : list.length,
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
