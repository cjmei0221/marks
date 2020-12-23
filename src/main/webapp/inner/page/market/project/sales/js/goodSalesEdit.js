var appInfo = {
	saveUrl : top.window.urlBase + '/inner/salesInfo/save.do',// 保存新增促销方案接口
	updateUrl : top.window.urlBase + '/inner/salesInfo/update.do',// 编辑促销方案信息接口
	findByIdUrl : top.window.urlBase + '/inner/salesInfo/findById.do',// 编辑促销方案信息接口
	getProjectCodeUtl : top.window.urlBase
			+ '/inner/salesInfo/getProjectCode.do',// 删除促销方案接口
	formStatus : "new"
};
// -----------------权限控制功能 start---------------
var idNo = tool.getUrlParams("idNo");
appInfo.formStatus = tool.getUrlParams("formStatus");
// -----------------权限控制功能 end---------------
function returnParent() {
	// var url = "./salesInfo.html?&menuid=M_PROJECT_SALES_SALESINFO";
	// location.href = url;
	window.parent.location.reload();
}
function getProjectCode() {
	var parms = "";
	$.post(appInfo.getProjectCodeUtl, parms, function(data) {
		if (data.retcode == '0') {
			$("#projectCode").val(data.projectCode);
		} else {
			showMsg(data.retmsg);
		}
	});
}
$(function() {
	$("#btnTr").show();
	if ("detail" == appInfo.formStatus) {
		$("#btnTr").hide();
	}
	$("#projectCode").val(idNo);
	if ("new" != appInfo.formStatus) {
		var parms = "projectCode=" + idNo;
		$.post(appInfo.findByIdUrl, parms, function(data) {
			if (data.retcode == '0') {
				$('#ff').form('load', data.info);
				if ("quickAdd" == appInfo.formStatus) {
					getProjectCode();
				}
				initItemList(data.list);
			} else {
				showMsg(data.retmsg);
			}
		});
	}
	if ("new" == appInfo.formStatus) {
		getProjectCode();
	}
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		returnParent();
	});
	$("#typeCode").combobox({
		onSelect : function(rec) {
			var val = rec.value;
			$("#addItem").show();
			if (val == 21) {
				$("#addItem").hide();
			}
		}
	});
	$("#next1").on("click", function() {
		$("#tt").tabs("select", 1);
	});
	$("#next2").on("click", function() {
		$("#tt").tabs("select", 2);
	});
});
function initItemList(list) {
	if (null != list && list.length > 0) {
		$("#itemList").html("");
		for (var i = 0; i < list.length; i++) {
			var vo = {};
			vo.idx = i + 1;
			$("#itemList")
					.append(tool.fillTemplate($("#itemTrTmp").html(), vo));
		}
		$.parser.parse('#itemList');
		for (var i = 0; i < list.length; i++) {
			var vo = list[i];
			vo.idx = i + 1;
			$("#limitNums" + vo.idx).numberbox("setValue", vo.limitNums);
			$("#itemTypeCode" + vo.idx).combobox("setValue", vo.itemTypeCode);
			$("#itemVal" + vo.idx).val(vo.itemVal1);
		}
	}
}
function addItem() {
	var count = $("#itemList").children().length;
	var vo = {};
	vo.idx = count + 1;
	$("#itemList").append(tool.fillTemplate($("#itemTrTmp").html(), vo));
	$.parser.parse('#item' + vo.idx);
}
function removeItem(ele) {
	$("#" + ele).remove();
}
/**
 * 保存菜单
 */
function formSubmit() {
	if (!$('#ff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.formStatus == "edit" ? appInfo.updateUrl
			: appInfo.saveUrl;
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
			showMsg("保存成功");
			returnParent();
		} else {
			showMsg(data.retmsg);
		}
	});
}
