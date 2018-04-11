var appInfo = {
	listUrl : top.window.urlBase + '/inner/orderGood/list.do',// 获取订单商品列表接口															// OrderGood
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 1000,
		keyword : "",
		orderId : ""
	},
	formStatus : "new"
};
appInfo.requestParam.orderId=tool.getUrlParams("id");
// -----------------权限控制功能 start---------------

// -----------------权限控制功能 end---------------
$(function() {
	// 加载列表
	loadList();

});

function loadList() {
	$('#tbListGood').datagrid({
		url : appInfo.listUrl,
		idField : 'orderGoodId',
		height : 500,
		rownumbers : true,
		singleSelect : true,
		columns : [ [ {
			title : '订单商品编号',
			field : 'orderGoodId',
			width : 200,
			align : "center"
		}, {
			title : '订单编号',
			field : 'orderId',
			width : 200,
			align : "center"
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
			title : '类别编号',
			field : 'typeId',
			width : 100,
			align : "center"
		}, {
			title : '类别名称',
			field : 'typeName',
			width : 100,
			align : "center"
		}, {
			title : '品牌编号',
			field : 'brandId',
			width : 100,
			align : "center"
		}, {
			title : '品牌名称',
			field : 'brandName',
			width : 100,
			align : "center"
		}, {
			title : '数量',
			field : 'nums',
			width : 100,
			align : "center"
		}, {
			title : '售价',
			field : 'salePrice',
			width : 100,
			align : "center"
		}, {
			title : '现价',
			field : 'nowPrice',
			width : 100,
			align : "center"
		}, {
			title : '售价金额',
			field : 'countAmt',
			width : 100,
			align : "center"
		}, {
			title : '现价金额',
			field : 'nowPriceAmt',
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
			title : '其他金额',
			field : 'otherAmt',
			width : 100,
			align : "center"
		}, {
			title : '促销金额',
			field : 'saleAmt',
			width : 100,
			align : "center"
		}, {
			title : '折扣金额',
			field : 'discountAmt',
			width : 100,
			align : "center"
		}, {
			title : '满减金额',
			field : 'fullCutAmt',
			width : 100,
			align : "center"
		}, {
			title : '优惠券金额',
			field : 'couponAmt',
			width : 100,
			align : "center"
//		}, {
//			title : '积分抵扣金额',
//			field : 'pointAmt',
//			width : 100,
//			align : "center"
		}, {
			title : '抹零金额',
			field : 'mlAmt',
			width : 100,
			align : "center"
		}, {
			title : '议价金额',
			field : 'simpleDiscountAmt',
			width : 100,
			align : "center"
		}, {
			title : '进货价',
			field : 'costPrice',
			width : 100,
			align : "center"
		}, {
			title : '进货金额',
			field : 'costAmt',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.orderGoodId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.orderGoodId;
			appInfo.selectedData = rowData;
			edit();
		},
		onLoadSuccess : function(data) {
			$("#tbListGood").datagrid('unselectAll');
			appInfo.selectedData = {};
		}
	});
	// 请求加载数据
	function loader(that, params, success, loadError) {
		var opts = that.datagrid("options");
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
