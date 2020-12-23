var appInfo = {
	listUrl : top.window.urlBase + '/inner/goodShop/list.do',// 获取门店商品列表接口
	// GoodShop
	saveUrl : top.window.urlBase + '/inner/goodShop/save.do',// 保存新增门店商品接口
	updateUrl : top.window.urlBase + '/inner/goodShop/update.do',// 编辑门店商品信息接口
	deleteUrl : top.window.urlBase + '/inner/goodShop/delete.do',// 删除门店商品接口
	findGoodInfoUrl : top.window.urlBase + '/inner/goodShop/findGoodInoById.do',// 删除门店商品接口
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
// 新增

function add() {
	var path = "goodPrice.html?formStatus=new&returnType=0&idNo=1";
	location.href = path;

}
function edit(){
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}
	$("#editWin").window({
		title : "编辑"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "edit";
	$('#ff').form('load', appInfo.selectedData);
}
// 删除
function del() {
	if (!isSelectedOne(appInfo.selectedId)) {
		return;
	}

	$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
		if (r) {
			var parms = "goodShopId=" + appInfo.selectedId;
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
function queryGood() {
	var shopId = $("#shopId").combobox("getValue");
	if (shopId == null || shopId == '') {
		showMsg('请先选择门店！');
		return;
	}
	var goodNo = $("#goodNo").val();
	if (goodNo == null || goodNo == '') {
		showMsg('商品编号不能为空！');
		return;
	}
	var parms = "shopId=" + shopId;
	parms += "&goodNo=" + goodNo;
	$.post(appInfo.findGoodInfoUrl, parms, function(data) {
		if (data.retcode == '0') {
			$('#ff').form('load', data.info);
		} else {
			showMsg(data.retmsg);
		}
	});
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
//	$('#goodNo').bind('blur', function() {
//		queryGood();
//	});
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

function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped : true,
		// nowrap : true,
		// animate : true,
		// collapsible : true,
		// fitColumns : true,
		// autoRowHeight : false,
		idField : 'goodId',
		height : tool.screenHeight,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '主键',
			field : 'goodId',
			width : 100,
			align : "center",
			hidden : true
//		}, {
//			title : '上架状态',
//			field : 'onsale_status',
//			width : 80,
//			align : "center",
//			formatter : function(value, row, index) {
//				if (value == 1) {
//					return "<span style='color:green;'>上架</span>";
//				} else if (value == 2) {
//					return "<span style='color:red;'>未上架</span>";
//				} else if (value == 3) {
//					return "<span style='color:gray;'>下架</span>";
//				}
//				return '';
//			}
		// },
		// {
		// title : '商品主图',
		// field : 'imageUrl',
		// width : 100,
		// align : "center",
		// formatter : function(value, row, index) {
		// if (value == '') {
		// return '';
		// }
		// return ' <img class="picUrl" src="'
		// + value
		// + '" style="width: 100px; height: 80px;" />';
		// }
		}, {
			title : '门店编码',
			field : 'shopId',
			width : 100,
			align : "center"
		}, {
			title : '门店名称',
			field : 'shopName',
			width : 100,
			align : "center"
		}, {
			title : '编码',
			field : 'goodNo',
			width : 100,
			align : "center"
		}, {
			title : '助记码',
			field : 'helpCode',
			width : 100,
			align : "center"
		}, {
			title : '条码',
			field : 'barNo',
			width : 100,
			align : "center"
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 100,
			align : "center"
		}, {
			title : '售价',
			field : 'salePrice',
			width : 100,
			align : "center"
		}, {
			title : '会员价',
			field : 'vipPrice',
			width : 100,
			align : "center"
		}, {
			title : '最低价',
			field : 'minPrice',
			width : 100,
			align : "center"
		}, {
			title : '进货价',
			field : 'costPrice',
			width : 100,
			align : "center"
		}, {
			title : '积分',
			field : 'point',
			width : 100,
			align : "center"
		}, {
			title : '兑换积分',
			field : 'needPoint',
			width : 100,
			align : "center"
		}, {
			title : '类目',
			field : 'typeName',
			width : 100,
			align : "center"
		}, {
			title : '品牌',
			field : 'brandName',
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
			title : '商品类别',
			field : 'goodType',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 2) {
					return '赠品';
				} else if (value == 1) {
					return '商品&赠品';
				}
				return '商品';
			}
		}, {
			title : '库存管理类别',
			field : 'stockManageType',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if (value == 1) {
					return '数量管理';
				}
				return '一瓶一码';
			}
		}, {
			title : '重量',
			field : 'model',
			width : 100,
			align : "center"
		}, {
			title : '材质',
			field : 'material',
			width : 100,
			align : "center"
		}, {
			title : '产地',
			field : 'madeIn',
			width : 100,
			align : "center"
		}, {
			title : '备注',
			field : 'remark',
			width : 100,
			align : "center"
		}, {
			title : '特色描述',
			field : 'description',
			width : 100,
			align : "center"
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 180,
			align : "center"
		} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.goodId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.goodId;
			appInfo.selectedData = rowData;
			edit();
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
		appInfo.requestParam.shopId = $("#s_shopId").combobox("getValue");
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
