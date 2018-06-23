var appInfo = {
	listUrl : top.window.urlBase + '/inner/adjustInfo/findById.do',// 获取采购商品列表接口
	getGoodUrl : top.window.urlBase + '/inner/adjustGood/findById.do',// 获取采购商品列表接口
	saveUrl : top.window.urlBase + '/inner/adjustInfo/save.do',// 保存新增采购单接口
	updateUrl : top.window.urlBase + '/inner/adjustInfo/update.do',// 编辑采购单信息接口
	approveUrl : top.window.urlBase + '/inner/adjustInfo/approve.do',// 编辑采购单信息接口
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
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#returnParent").on("click", function(e) {
		returnList();
	});
	$("#btnCheck").on("click", function(e) {
		$.messager.confirm('确认', '确认提交审核吗?', function(r) {
			if (r) {
				var parms = "idNo=" + $("#orderId").val();
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
	if (appInfo.formStatus == 'check') {
		showOrHide(2);
	} else if (appInfo.formStatus == 'detail') {
		showOrHide(3);
	} else {
		showOrHide(0);
	}
});

function returnList() {
	var url = "./adjustInfo.html?&menuid=M_mall_stock_adjustInfo";
	location.href = url;
}
function showOrHide(flag) {
	$("#btnDiv").show();
	if (flag == 1) {
		$("#tbList").datagrid("hideColumn", "oper");
		$("#btnCheck").hide();
	} else if (flag == 2) {

		$("#tbList").datagrid("hideColumn", "oper");
		$("#btnDiv").hide();
	} else if (flag == 3) {

		$("#tbList").datagrid("hideColumn", "oper");
		$("#btnOK").hide();
		$("#btnCheck").hide();
		$("#returnParent").show();
	} else {

		$("#tbList").datagrid("showColumn", "oper");
		$("#btnCheck").show();
	}

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
		var count = row[i].nums;
		if (row[i].goodNo != "" && count > 0) {
			var items = row[i];
			attrList.push(items);
		}
	}
	if (attrList.length < 1) {
		showMsg("至少添加一个商品！");
		return;
	}

	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	parms += "&ywCode=1";
	parms += "&typeCode=1";
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
function setEditing(rowIndex) {
	var editors = $('#tbList').datagrid('getEditors', rowIndex);
	var goodCodeEditor = editors[0];
	goodCodeEditor.target.bind('change', function() {
		var goodCode = goodCodeEditor.target.val()
		getGoodInfo(rowIndex, goodCode);
	});
}
function getGoodInfo(rowIndex, goodCode) {
	$.ajax({
		url : appInfo.getGoodUrl,
		type : "get",
		data : {
			"goodNo" : goodCode
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
						url : appInfo.listUrl,
						// toolbar : "#tb",
						striped : true,
						nowrap : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						autoRowHeight : false,
						idField : 'orderGoodId',
						height : 520,
						rownumbers : true,
						pagination : true,
						pageNumber : appInfo.requestParam.page_number,
						pageSize : appInfo.requestParam.page_size,
						singleSelect : true,
						columns : [ [
								{
									title : '主键',
									field : 'orderGoodId',
									width : 100,
									align : "center",
									hidden : true
								},
								{
									title : '操作',
									field : 'oper',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										return "<a href='#' onclick=\"javascript:delRow("
												+ index + ")\">删除</a>";
									}
								}, {
									title : '商品编号',
									field : 'goodId',
									width : 100,
									align : "center",
									editor : "validatebox"
								}, {
									title : '商品编号',
									field : 'goodNo',
									width : 100,
									align : "center"
								}, {
									title : '商品名称',
									field : 'goodName',
									width : 100,
									align : "center"
								}, {
									title : '商品条码',
									field : 'barNo',
									width : 100,
									align : "center"
								}, {
									title : '单位',
									field : 'unit',
									width : 100,
									align : "center"
								}, {
									title : '规格',
									field : 'rank',
									width : 100,
									align : "center"
								}, {
									title : '型号',
									field : 'model',
									width : 100,
									align : "center"
								}, {
									title : '品牌',
									field : 'brandName',
									width : 100,
									align : "center"
								}, {
									title : '进价',
									field : 'costPrice',
									width : 100,
									align : "center"
								}, {
									title : '数量',
									field : 'nums',
									width : 100,
									align : "center",
									editor : "validatebox"
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							loader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							if (appInfo.formStatus != 'detail'
									&& appInfo.formStatus != 'check') {
								$("#tbList").datagrid("beginEdit", rowIndex);
								setEditing(rowIndex);
							}
						},
						onLoadSuccess : function(data) {
							$("#tbList").datagrid('unselectAll');
							appInfo.selectedData = {};
						}
					});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.datagrid("options");
		appInfo.requestParam.page_number = 1;
		appInfo.requestParam.page_size = 200;
		appInfo.requestParam.orderId = orderId;
		appInfo.requestParam.formStatus = appInfo.formStatus
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
