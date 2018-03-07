var appInfo = {
	listUrl: top.window.urlBase + '/inner/orderGood/list.do',//获取订单商品列表接口  OrderGood
	saveUrl: top.window.urlBase + '/inner/orderGood/save.do',//保存新增订单商品接口
	updateUrl: top.window.urlBase + '/inner/orderGood/update.do',//编辑订单商品信息接口
	deleteUrl: top.window.urlBase + '/inner/orderGood/delete.do',//删除订单商品接口
	selectedId : -1,
	selectedData : {},
	requestParam:{
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus:"new"
 };
 //-----------------权限控制功能 start---------------
	//新增
	function add(){
		$("#editWin").window({
			title : "新增"
		}).window("open");
		$('#ff').form('clear');
		appInfo.formStatus="new";
	}
	
	
	//编辑
	function edit(){
		if (!isSelectedOne(appInfo.selectedId)) {
			return;
		}
		$("#editWin").window({
				title : "编辑"
			}).window("open");
			appInfo.formStatus="edit";
			$('#ff').form('load',appInfo.selectedData);
	}
		//删除
	function del(){
		if (!isSelectedOne(appInfo.selectedId)) {
			return;
		}
		
			$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
				if (r) {
					var parms = "orderGoodId=" + appInfo.selectedId;
					$.post(appInfo.deleteUrl, parms, function(data) {
						if (data.retcode == '0') {
							app.myreload("#tbList");
							appInfo.selectedData = {};
							appInfo.selectedId=-1;
							showMsg("删除成功");
						} else {
							showMsg(data.retmsg);
						}
					});
				}
			});
		
	}
 //-----------------权限控制功能 end---------------
$(function(){
//加载列表
 	loadList();

//搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId=-1;
	});
	
		//保存菜单
	$("#btnOK").on("click",function(){
		formSubmit();
	});
	$("#btnCancel").on("click",function(){
		$("#editWin").window("close");
	});
});
/**
 * 保存菜单
 */
function formSubmit(){
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl=appInfo.formStatus=="new"?appInfo.saveUrl:appInfo.updateUrl;
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
		striped:true,
		nowrap:true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		autoRowHeight:false,
		idField : 'orderGoodId',
		height:520,
		rownumbers : true,
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [                 {title:'订单商品编号',field:'orderGoodId',width:100,align:"center",hidden:true },
                {title:'订单编号',field:'orderId',width:100,align:"center"},
                {title:'商品系统编号',field:'goodId',width:100,align:"center"},
                {title:'商品编号',field:'goodNo',width:100,align:"center"},
                {title:'商品名称',field:'goodName',width:100,align:"center"},
                {title:'商品条码',field:'barNo',width:100,align:"center"},
                {title:'列表图片',field:'picUrl',width:100,align:"center"},
                {title:'单位',field:'unit',width:100,align:"center"},
                {title:'规格',field:'rank',width:100,align:"center"},
                {title:'类别编号',field:'typeId',width:100,align:"center"},
                {title:'类别名称',field:'typeName',width:100,align:"center"},
                {title:'品牌编号',field:'brandId',width:100,align:"center"},
                {title:'品牌名称',field:'brandName',width:100,align:"center"},
                {title:'数量',field:'nums',width:100,align:"center"},
                {title:'售价',field:'salePrice',width:100,align:"center"},
                {title:'现价',field:'nowPrice',width:100,align:"center"},
                {title:'应付金额',field:'payableAmt',width:100,align:"center"},
                {title:'实付金额',field:'payAmt',width:100,align:"center"},
                {title:'现金金额',field:'cashAmt',width:100,align:"center"},
                {title:'微信金额',field:'wxAmt',width:100,align:"center"},
                {title:'支付宝金额',field:'alipayAmt',width:100,align:"center"},
                {title:'其他金额',field:'otherAmt',width:100,align:"center"},
                {title:'促销金额',field:'saleAmt',width:100,align:"center"},
                {title:'折扣金额',field:'discountAmt',width:100,align:"center"},
                {title:'满减金额',field:'fullCutAmt',width:100,align:"center"},
                {title:'优惠券金额',field:'couponAmt',width:100,align:"center"},
                {title:'积分抵扣金额',field:'pointAmt',width:100,align:"center"},
                {title:'抹零金额',field:'mlAmt',width:100,align:"center"},
                {title:'议价金额',field:'simpleDiscountAmt',width:100,align:"center"},
                {title:'创建时间',field:'createtime',width:100,align:"center"},
                {title:'更新时间',field:'updatetime',width:100,align:"center"},
                {title:'进货金额',field:'costAmt',width:100,align:"center"},
                {title:'进货价',field:'costPrice',width:100,align:"center"} ] ],
		loader : function(params, success, loadError) {
			var that = $(this);
			loader(that, params, success, loadError);
		},
		onClickRow : function(rowIndex,rowData) {
			appInfo.selectedId = rowData.orderGoodId;
			appInfo.selectedData = rowData;
		},
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.orderGoodId;
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
		appInfo.requestParam.keyword=$("#keyword").val();
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
		

