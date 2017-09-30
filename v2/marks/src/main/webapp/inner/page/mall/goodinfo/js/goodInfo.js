var appInfo = {
	listUrl : top.window.urlBase + '/inner/goodInfo/list.do',// 获取商品管理列表接口 GoodInfo
	saveUrl : top.window.urlBase + '/inner/goodInfo/save.do',// 保存新增商品管理接口
	updateUrl : top.window.urlBase + '/inner/goodInfo/update.do',// 编辑商品管理信息接口
	deleteUrl : top.window.urlBase + '/inner/goodInfo/delete.do',// 删除商品管理接口
	goodImgListUrl : top.window.urlBase + '/inner/goodInfo/findGoodImgByGoodId.do',// 删除商品管理接口
	onsaleUrl: top.window.urlBase + '/inner/goodSale/onsale.do',
	selectedId : -1,
	selectedData : {},
	requestParam : {
		page_number : 1,
		page_size : 10,
		keyword : ""
	},
	formStatus : "new"
};

//新增
function add() {
	$("#remove").html("");
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	$("#weight_unit").val("Kg");
	appInfo.formStatus = "new";
	img.deleteImageDiv("addMainImg");
	img.deleteImageDiv("addMainImageDiv");
	img.deleteImageDiv("addDetailImageDiv");
}

// 编辑
function edit() {
	if (isSelectedOne(appInfo.selectedId)) {
		$("#remove").html("");
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		img.deleteImageDiv("addMainImg");
		img.editImage("addMainImg",appInfo.selectedData.imageUrl);
		loadImg(appInfo.selectedId);
	}
}

// 删除
function del() {
	if (isSelectedOne(appInfo.selectedId)) {
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "goodId=" + appInfo.selectedId;
				$.post(appInfo.deleteUrl, parms, function(data) {
					if (data.retcode == "0") {
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
}
//上下架
function onsaleBtn() {
	if (isSelectedOne(appInfo.selectedId)) {
		var cmsg="确定要上架吗？";
		if(appInfo.selectedData.onsale_status==1){
			cmsg="确定要下架吗？";
		}
		$.messager.confirm('确认', cmsg, function(r) {
			if (r) {
				var parms = "goodId=" + appInfo.selectedId;
				$.post(appInfo.onsaleUrl, parms, function(data) {
					if (data.retcode == "0") {
						app.myreload("#tbList");
						appInfo.selectedData = {};
						appInfo.selectedId = -1;
						showMsg(data.retmsg);
					} else {
						showMsg(data.retmsg);
					}
				});
			}
		});
	}
}

function importExcel(){
	$("#excelWin").window({
		title : "导入Excel"
	}).window("open");
}
$(function() {
	// 加载列表
	loadList();
//	excel.init();
	// 搜索
	$("#doSearch").on("click", function(e) {
		app.myreload("#tbList");
		appInfo.selectedData = {};
		appInfo.selectedId = -1;
	});
	// 保存菜单
	$("#btnOKExcel").on("click", function() {
		formSubmitforExcel();
	});
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		$("#editWin").window("close");
	});
	$("#imgBtnOk").on("click", function() {
		$("#imageWin").window("close");
	});
});

function formSubmitforExcel(){
	excel.upload();
	var fileName=$("#excelfileName").val();
	if(fileName !=""){
		
	}else{
		 $("#uploadInfo").html("还未上传文件");
	}
}
function loadImg(goodId,flag){
	$.ajax({
		url : appInfo.goodImgListUrl,
		type : "post",
		data : {
			"goodId":goodId
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == "0") {
				img.deleteImageDiv("addMainImageDiv");
				img.deleteImageDiv("addDetailImageDiv");
				img.deleteImageDiv("detailMainImg");
				img.deleteImageDiv("detailDetailImg");
				var list=data.goodImgList;
				if(list.length>0){
					for(var i=0;i<list.length;i++){
						if(list[i].imgType==1){
							img.editImage("addMainImageDiv", list[i].imgUrl,flag);
							img.editImage("detailMainImg", list[i].imgUrl,flag);
						}else if(list[i].imgType==2){
							img.editImage("addDetailImageDiv", list[i].imgUrl,flag);
							img.editImage("detailDetailImg", list[i].imgUrl,flag);
						}
					}
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
function addImage(){
	$("#imageWin").window({
		title : "添加图片"
	}).window("open");
}
/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var imageUrlPut=img.getImageVal("addMainImg");
	if(imageUrlPut ==''){
		showMsg("请添加列表图片");
		return;
	}
	var addMainImagePut=img.getImageVal("addMainImageDiv");
	if(addMainImagePut ==''){
		showMsg("请主副图片");
		return;
	}
	var addDetailImagePut=img.getImageVal("addDetailImageDiv");
	if(addDetailImagePut ==''){
		showMsg("请详情图片");
		return;
	}
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	parms += "&imageUrlPut=" + imageUrlPut;
	parms += "&addMainImagePut=" + addMainImagePut;
	parms += "&addDetailImagePut=" + addDetailImagePut;
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
function showDetail(){
	$("#detailWin").window({
		title : "详情"
	}).window("open");
	var info=appInfo.selectedData;
	$("#sku_num_detail").html(info.sku_num);
	$("#goodName_detail").html(info.goodName);
	$("#goodPrice_detail").html(info.goodPrice);
	$("#unit_detail").html(info.unit);
	$("#createtime_detail").html(info.createtime);
	$("#updatetime_detail").html(info.updatetime);
	$("#brand_detail").html(info.brand);
	$("#madeIn_detail").html(info.madeIn);
	$("#material_detail").html(info.material);
	$("#description_detail").html(info.description);
	$("#remark_detail").html(info.remark);
	$("#weight_detail").html(info.weight+" "+info.weight_unit);
	$("#detailListImg").html("");
	img.editImage("detailListImg", info.imageUrl,1);
	loadImg(info.goodId,1);
}
function loadList() {
	$('#tbList').datagrid({
		url : appInfo.listUrl,
		toolbar : "#tb",
		striped : true,
		nowrap : true,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		pagination : true,
		idField : 'goodId',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '商品编码',
			field : 'sku_num',
			width : 100,
			align : "center"
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 100,
			align : "center"
		}, {
			title : '商品单价',
			field : 'goodPrice',
			width : 100,
			align : "center"
		}, {
			title : '商品单位',
			field : 'unit',
			width : 100,
			align : "center"
		}, {
			title : '商品品牌',
			field : 'brand',
			width : 100,
			align : "center"
		}, {
			title : '商品主图',
			field : 'imageUrl',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				return ' <img class="picUrl" src="'+value+'" style="width: 100px; height: 80px;" />';
			}
		}, {
			title : '上架状态',
			field : 'onsale_status',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if(value==1){
					return "<span style='color:green;'>上架</span>";
				}else if(value==2){
					return "<span style='color:red;'>未上架</span>";
				}else if(value==3){
					return "<span style='color:gray;'>下架</span>";
				}
				return '';
			}
		}, {
			title : '更新时间',
			field : 'updatetime',
			width : 100,
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
		onDblClickRow:function(rowIndex, rowData){
			appInfo.selectedId = rowData.goodId;
			appInfo.selectedData = rowData;
			showDetail();
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
				checkLogin(data);
				if (data.retcode == "0") {
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
