var appInfo = {
	listUrl : top.window.urlBase + '/inner/orderInfo/findById.do',// 获取采购商品列表接口
	getGoodUrl : top.window.urlBase + '/inner/orderGood/findById.do',// 获取采购商品列表接口
	refundUrl : top.window.urlBase + '/inner/orderInfo/refund.do',// 保存新增采购单接口
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
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#returnParent").on("click", function(e) {
		returnList();
	});
});
function returnList() {
	var url = "./orderInfo.html?menuid=M_MALL_ORDER_ORDERINFO";
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
		var count = row[i].refundNums;
		if (row[i].goodNo != "" && count > 0) {
			var items = row[i];
			attrList.push(items);
		}
	}
	if (attrList.length < 1) {
		showMsg("至少添加一个商品！");
		return;
	}

	var reqUrl = appInfo.refundUrl;
	
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
function addRow(){
	getGoodInfo(0, "","1");
}
function setEditing(rowIndex,rowData) {
	var editors = $('#tbList').datagrid('getEditors', rowIndex);
	var goodCodeEditor = editors[0];
	var priceEditor = editors[1];
	var refundNumsEditor = editors[2];
	var refundAmtEditor = editors[3];
	goodCodeEditor.target.bind('change', function() {
		var goodCode = goodCodeEditor.target.val()
		getGoodInfo(rowIndex, goodCode,"0");
	});
	refundNumsEditor.target.bind('change', function() {
		var nums=refundNumsEditor.target.val();
		var count=rowData.nums+rowData.hadRefundNums;
		if(nums>count){
			showMsg("退货数量错误，只能退货"+(count));
			return;
		}
		calculateNums();
		countTotal();
	});
	$(priceEditor.target).numberbox({
		onChange : function(newVal, oldVal) {
			calculateNums();
			countTotal();
		}
	});

	function calculateNums() {
		var amt = refundNumsEditor.target.val() * priceEditor.target.val();
		$(refundAmtEditor.target).numberbox('setValue', amt);
	}
}
function countTotal() {
	endEdit();
	// 计算总额
	var totalNum = 0;
	var totalAmt = 0;
	var row = $("#tbList").datagrid('getRows');
	for (var i = 0; i < row.length; i++) {
		var count = row[i].refundNums;
		if (row[i].goodNo != "" && count > 0) {
			var items = row[i];
			totalNum = totalNum + Number(items.refundNums);
			totalAmt = totalAmt + Number(items.refundAmt);
		}
	}
	$("#refundNums").numberbox("setValue", totalNum);
	$("#refundAmt").numberbox("setValue", totalAmt);
}
function getGoodInfo(rowIndex, goodCode,edit) {
	$.ajax({
		url : appInfo.getGoodUrl,
		type : "get",
		data : {
			"goodNo" : goodCode,
			"edit":edit
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var rowData = data.info;
				if("1"==edit){
					$('#tbList').datagrid('appendRow',rowData);
				}else{
					$('#tbList').datagrid('updateRow', {
						index : rowIndex,
						row : rowData
					});
				}
				
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
						idField : 'orderGoodId',
						height : 350,
						rownumbers : true,
						columns : [ [
								{
									title : '单号',
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
									title : '条码',
									field : 'barNo',
									width : 100,
									align : "center"
								}, {
									title : '品名',
									field : 'goodName',
									width : 100,
									align : "center"
								}, {
									title : '单位',
									field : 'unit',
									width : 100,
									align : "center"
							

								}, {
									title : '购买数量',
									field : 'nums',
									width : 100,
									align : "center",
								}, {
									title : '售价',
									field : 'nowPrice',
									width : 100,
									align : "center",
								}, {
									title : '实收单价',
									field : 'payPrice',
									width : 100,
									align : "center",
									editor : {
										type : 'numberbox',
										options : {
											precision : 2
										}
									}
								}, {
									title : '退货数量',
									field : 'refundNums',
									width : 100,
									align : "center",
									editor : {
										type : 'validatebox',
									// options : {
									// precision : 0
									// }
									}
								}, {
									title : '退款现金',
									field : 'refundAmt',
									width : 100,
									align : "center",
									editor : {
										type : 'numberbox',
										options : {
											precision : 2
										}
									}

								}, {
									title : '已退数量',
									field : 'hadRefundNums',
									width : 100,
									align : "center",
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
//								}, {
//									title : '已退金额',
//									field : 'hadRefundAmt',
//									width : 100,
//									align : "center",
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							loader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							if (appInfo.formStatus != 'detail'
									&& appInfo.formStatus != 'check') {
								$("#tbList").datagrid("beginEdit", rowIndex);
								setEditing(rowIndex,rowData);
							}
						},
						onClickCell : function(rowIndex, field, value) {

						},
						onLoadSuccess : function(data) {
							$("#tbList").datagrid('unselectAll');
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
