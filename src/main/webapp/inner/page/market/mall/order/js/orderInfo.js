var appInfo = {
	listUrl : top.window.urlBase + '/inner/orderInfo/list.do',// 获取订单管理列表接口
	// OrderInfo
	deleteUrl : top.window.urlBase + '/inner/orderInfo/delete.do',// 删除订单管理接口
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};
// -----------------权限控制功能 start---------------

// 删除
function del() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "orderId=" + appInfo.selectedId;
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
// 退货
function refund() {
	if (appInfo.selectedId == -1) {
		$.messager.confirm(
						'确认',
						'确认无订单退货吗?',
						function(r) {
							if (r) {
								var path = "./orderRefund.html?formStatus=edit&returnType=0&idNo=1";
								location.href = path;
							}
						});
	} else {
		var path = "./orderRefund.html?formStatus=refund&returnType=0&idNo="
				+ appInfo.selectedId;
		location.href = path;
	}
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
});
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
function detail(id) {
	$("#goodWin").window({
		title : "商品明细"
	}).window("open");
	var path = '/inner/page/mall/order/orderGood.html?id=' + id;
	var strHtml = "<iframe width='100%' height='500px'  frameborder='0' scrolling='auto' src='"
			+ path + "'></iframe>";
	$("#postShow").html(strHtml);
}
function loadList() {
	$('#tbList')
			.datagrid(
					{
						url : appInfo.listUrl,
						toolbar : "#tb",
						idField : 'orderId',
						height : tool.screenHeight,
						rownumbers : true,
						pagination : true,
						striped:true,
						pageNumber : appInfo.requestParam.page_number,
						pageSize : appInfo.requestParam.page_size,
						singleSelect : true,
						columns : [ [
								{
									title : '订单编号',
									field : 'orderId',
									width : 200,
									align : "center",
									formatter : function(value, row, index) {
										return '<a href="javascript:void(0)" onclick="detail(\''
												+ value
												+ '\')">'
												+ value
												+ '</a>';
									}
								}, {
									title : '订单状态',
									field : 'orderStatusName',
									width : 100,
									align : "center"
								}, {
									title : '机构名称',
									field : 'orgName',
									width : 100,
									align : "center"

								}, {
									title : '收银日期',
									field : 'cashDate',
									width : 100,
									align : "center"
								}, {
									title : '收银类型',
									field : 'cashTypeName',
									width : 100,
									align : "center"
								}, {
									title : '数量',
									field : 'nums',
									width : 100,
									align : "center"
								}, {
									title : '售价总额',
									field : 'salePriceAmt',
									width : 100,
									align : "center"
								}, {
									title : '应付金额',
									field : 'payableAmt',
									width : 100,
									align : "center"
								}, {
									title : '实付金额',
									field : 'payAmt',
									width : 100,
									align : "center"
								}, {
									title : '进货金额',
									field : 'costAmt',
									width : 100,
									align : "center"
								}, {
									title : '理论收益',
									field : 'balAmt',
									width : 100,
									align : "center",
									formatter : function(value, row, index) {
										return ((row.payAmt*100-row.costAmt*100)/100).toFixed(2);
									}
								}, {
									title : '促销总额',
									field : 'saleAmt',
									width : 100,
									align : "center"
								}, {
									title : '折扣总额',
									field : 'discountAmt',
									width : 100,
									align : "center"
								}, {
									title : '满减总额',
									field : 'fullCutAmt',
									width : 100,
									align : "center"
								}, {
									title : '议价总额',
									field : 'simpleDiscountAmt',
									width : 100,
									align : "center"
								}, {
									title : '优惠券金额',
									field : 'couponAmt',
									width : 100,
									align : "center"
								}, {
									title : '抹零金额',
									field : 'malingAmt',
									width : 100,
									align : "center"
								}, {
									title : '年份',
									field : 'i_year',
									width : 100,
									align : "center"
								}, {
									title : '月份',
									field : 'i_month',
									width : 100,
									align : "center"
								}, {
									title : '季度',
									field : 'i_season',
									width : 100,
									align : "center"
								}, {
									title : '下单时间',
									field : 'commitTime',
									width : 200,
									align : "center"

								}, {
									title : '支付方式',
									field : 'payTypeName',
									width : 100,
									align : "center"
								}, {
									title : '现金金额',
									field : 'cashAmt',
									width : 100,
									align : "center"
								}, {
									title : '微信金额',
									field : 'wxAmt',
									width : 100,
									align : "center"
								}, {
									title : '支付宝金额',
									field : 'alipayAmt',
									width : 100,
									align : "center"
								}, {
									title : '储值卡金额',
									field : 'storedAmt',
									width : 100,
									align : "center"
								}, {
									title : '积分抵扣金额',
									field : 'pointAmt',
									width : 100,
									align : "center"
								}, {
									title : '其他金额',
									field : 'otherAmt',
									width : 100,
									align : "center"
								}, {
									title : '创建时间',
									field : 'createtime',
									width : 100,
									align : "center"
								}, {
									title : '更新时间',
									field : 'updatetime',
									width : 100,
									align : "center"
								// }, {
								// title : '积分抵扣金额',
								// field : 'pointAmt',
								// width : 100,
								// align : "center"
								// }, {
								// title : '积分',
								// field : 'point',
								// width : 100,
								// align : "center"
								}, {
									title : '收银员编号',
									field : 'cashManCode',
									width : 100,
									align : "center"
								}, {
									title : '收银员名称',
									field : 'cashMan',
									width : 100,
									align : "center"
								}, {
									title : '导购员编号',
									field : 'guiderCode',
									width : 100,
									align : "center"
								}, {
									title : '导购员名称',
									field : 'guiderName',
									width : 100,
									align : "center"
								}, {
									title : '会员编号',
									field : 'vipCode',
									width : 100,
									align : "center"
								}, {
									title : '会员名称',
									field : 'vipName',
									width : 100,
									align : "center"
								}, {
									title : '会员手机号',
									field : 'vipMobile',
									width : 100,
									align : "center"
								}, {
									title : '收货手机号',
									field : 'receiveTel',
									width : 100,
									align : "center"
								}, {
									title : '收货人',
									field : 'receiver',
									width : 100,
									align : "center"
								}, {
									title : '收货地址',
									field : 'receiveAddr',
									width : 100,
									align : "center"
								}, {
									title : '备注',
									field : 'remarks',
									width : 100,
									align : "center"
								} ] ],
						loader : function(params, success, loadError) {
							var that = $(this);
							loader(that, params, success, loadError);
						},
						onClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.orderId;
							appInfo.selectedData = rowData;
						},
						onDblClickRow : function(rowIndex, rowData) {
							appInfo.selectedId = rowData.orderId;
							appInfo.selectedData = rowData;
							detail(appInfo.selectedId);
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
