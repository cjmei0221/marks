var appInfo = {							
	// Brand
	getGoodInfoUrl : top.window.urlBase + '/inner/goodInfo/findGoodInfoById.do',// 获取品牌管理列表接口
	supplierlistUrl : top.window.urlBase + '/inner/supplier/combobox.do',// 获取品牌管理列表接口
	batchSaveBarCodeUrl : top.window.urlBase + '/inner/stockBatch/save.do',// 获取品牌管理列表接口
};
var busiId=tool.getUrlParams("goodId");
// -----------------权限控制功能 start---------------
function loadInfo() {
	$.ajax({
		url : appInfo.getGoodInfoUrl,
		type : "get",
		data :{
			"goodId":busiId
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var info=data.goodInfo;
				$('#barCodeff').form('load', info);
				$("#sendNums").numberbox("setValue", 0);
				$("#supplierId2").combobox("setValue", info.supplierId);
				$("#supplier2").val(info.supplier);
			} else {
				showMsg(data.retmsg);
			}
		},
		error : function(err) {
			loadError.apply(this, arguments);
		}
	});
	
}

// -----------------权限控制功能 end---------------
$(function() {
	
	// 生产条码
	$("#btnOKBarCode").on("click", function() {
		formSubmitForBarCode();
	});
	
	$('#supplierId2').combobox({
		url : appInfo.supplierlistUrl + "?page_number=1&page_size=1000",
		valueField : 'orgid',
		textField : 'orgname',
		onSelect : function(rec) {
			$('#supplier2').val(rec.orgname);
		}
	});
	loadInfo();
});

function formSubmitForBarCode() {
	if (!$('#barCodeff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.batchSaveBarCodeUrl;
	var parms = $("#barCodeff").serialize();
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
