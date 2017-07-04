var appInfo = {
	listUrl : top.window.urlBase + '/inner/smGoodInfo/list.do',// 获取超市商品列表接口
																// SmGoodInfo
	saveUrl : top.window.urlBase + '/inner/smGoodInfo/save.do',// 保存新增超市商品接口
	updateUrl : top.window.urlBase + '/inner/smGoodInfo/update.do',// 编辑超市商品信息接口
	deleteUrl : top.window.urlBase + '/inner/smGoodInfo/delete.do',// 删除超市商品接口
	uploadExcelUrl : top.window.urlBase + '/inner/smGoodInfo/uploadExcel.do',// 删除超市商品接口
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
	$("#editWin").window({
		title : "新增"
	}).window("open");
	$('#ff').form('clear');
	appInfo.formStatus = "new";
	img.deleteImageDiv("addMainImg");
}

// 编辑
function edit() {
	if (isSelectedOne(appInfo.selectedId)) {
		$("#editWin").window({
			title : "编辑"
		}).window("open");
		appInfo.formStatus = "edit";
		$('#ff').form('load', appInfo.selectedData);
		img.deleteImageDiv("addMainImg");
		img.editImage("addMainImg", appInfo.selectedData.imageUrl);
	}
}
// 删除
function del() {
	if (isSelectedOne(appInfo.selectedId)) {
		$.messager.confirm('确认', '确认要删除该记录吗?', function(r) {
			if (r) {
				var parms = "goodId=" + appInfo.selectedId;
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
}
function importExcel() {
	$("#excelWin").window({
		title : "导入Excel"
	}).window("open");
	 $("#uploadInfo").html("");
}
// -----------------权限控制功能 end---------------
$(function() {
	// 加载列表
	loadList();
	excel.init(appInfo.uploadExcelUrl);
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
	var imageUrlPut=img.getImageVal("addMainImg");
	if(imageUrlPut ==''){
		showMsg("请添加图片");
		return;
	}
	var reqUrl = appInfo.formStatus == "new" ? appInfo.saveUrl
			: appInfo.updateUrl;
	var parms = $("#ff").serialize();
	parms += "&formStatus=" + appInfo.formStatus;
	parms += "&imageUrl=" + imageUrlPut;
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
		nowrap : false,
		rownumbers : true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		autoRowHeight : true,
		idField : 'goodId',
		pagination : true,
		pageNumber : appInfo.requestParam.page_number,
		pageSize : appInfo.requestParam.page_size,
		singleSelect : true,
		columns : [ [ {
			title : '商品ID',
			field : 'goodId',
			width : 100,
			align : "center",
			hidden : true
		}, {
			title : '图片',
			field : 'imageUrl',
			width : 100,
			align : "center",
			formatter : function(value, row, index) {
				if(value==null || value.length<5){
					return "";
				}
				return ' <img class="picUrl" src="'+value+'" style="width: 100px; height: 80px;" />';
			}
		
		}, {
			title : '条形码',
			field : 'sku_num',
			width : 100,
			align : "center"
		}, {
			title : '商品名称',
			field : 'goodName',
			width : 250,
		}, {
			title : '商品价格(分)',
			field : 'goodPrice',
			width : 80,
			align : "center",
			formatter : function(value, row, index) {
				if(value==null || value.length<5){
					return "";
				}
				return value;
			}
		}, {
			
			title : '更新时间',
			field : 'updatetime',
			width : 100,
			align : "center"
		}, {
			title : '最后更新者',
			field : 'updator',
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
		onDblClickRow : function(rowIndex, rowData) {
			appInfo.selectedId = rowData.id;
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
