var appInfo = {
	listUrl : top.window.urlBase + '/inner/orderLog/list.do',// 获取条码管理列表接口
	excelUrl : top.window.urlBase + '/inner/orderLog/listExcel.do',// 获取订单管理列表接口
	// BarCod
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : "",
		startDate : "",
		endDate : ""
	},
	formStatus : "new"
};
// -----------------权限控制功能 start---------------
function exportExcel() {
	appInfo.requestParam.keyword = $("#keyword").val();
	appInfo.requestParam.startDate = $("#startDate").datebox('getValue');
	appInfo.requestParam.endDate = $("#endDate").datebox('getValue');
	location.href = appInfo.excelUrl + '?keyword='
			+ appInfo.requestParam.keyword + "&startDate="
			+ appInfo.requestParam.startDate + "&endDate="
			+ appInfo.requestParam.endDate;
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

});

function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		idField : 'orderGoodId',
		height : 520,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '商品编号',
			field : 'goodNo',
			width : 100,
			align : "center"
		}, {
			title : '商品条码',
			field : 'barNo',
			width : 100,
			align : "center"	
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 100,
			align : "center"	
		}, {
			title : '机构编号',
			field : 'orgId',
			width : 100,
			align : "center"
		}, {
			title : '机构名称',
			field : 'orgName',
			width : 100,
			align : "center"
		}, {
			title : '下单时间',
			field : 'commitTime',
			width : 200,
			align : "center"
		}, {
			title : '业务名称',
			field : 'cashTypeName',
			width : 100,
			align : "center"
		}, {
			title : '数量',
			field : 'nums',
			width : 100,
			align : "center"
		}, {
			title : '原价',
			field : 'salePrice',
			width : 100,
			align : "center"
		}, {
			title : '原价总额',
			field : 'countAmt',
			width : 100,
			align : "center"
		}, {
			title : '售价',
			field : 'payPrice',
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
			title : '其他金额',
			field : 'otherAmt',
			width : 100,
			align : "center"
		
		}, {
			title : '积分抵扣金额',
			field : 'pointAmt',
			width : 100,
			align : "center"
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
			title : '一级类目',
			field : 'lvl1Id',
			width : 100,
			align : "center"
		}, {
			title : '一级类目',
			field : 'lvl1Name',
			width : 100,
			align : "center"
		}, {
			title : '二级类目',
			field : 'lvl2Id',
			width : 100,
			align : "center"
		}, {
			title : '二级类目',
			field : 'lvl2Name',
			width : 100,
			align : "center"
		}, {
			title : '三级类目',
			field : 'lvl3Id',
			width : 100,
			align : "center"
		}, {
			title : '三级类目',
			field : 'lvl3Name',
			width : 100,
			align : "center"
		}, {
			title : '四级类目',
			field : 'lvl4Id',
			width : 100,
			align : "center"
		}, {
			title : '四级类目',
			field : 'lvl4Name',
			width : 100,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
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
		appInfo.requestParam.startDate = $("#startDate").datebox('getValue');
		appInfo.requestParam.endDate = $("#endDate").datebox('getValue');
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
