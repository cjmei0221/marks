var appInfo = {
	saveUrl : top.window.urlBase + '/inner/salesInfo/save.do',// 保存新增促销方案接口
	updateUrl : top.window.urlBase + '/inner/salesInfo/update.do',// 编辑促销方案信息接口
	findByIdUrl : top.window.urlBase + '/inner/salesInfo/findById.do',// 编辑促销方案信息接口
	getProjectCodeUtl: top.window.urlBase + '/inner/salesInfo/getProjectCode.do',// 删除促销方案接口
	formStatus : "new"
};
// -----------------权限控制功能 start---------------
var idNo = tool.getUrlParams("idNo");
appInfo.formStatus = tool.getUrlParams("formStatus");
// -----------------权限控制功能 end---------------
function getProjectCode(){
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
	if("detail"==appInfo.formStatus){
		$("#btnTr").hide();
	}
	$("#projectCode").val(idNo);
	if("new"!=appInfo.formStatus){
		var parms = "projectCode="+idNo;
		$.post(appInfo.findByIdUrl, parms, function(data) {
			if (data.retcode == '0') {
				$('#ff').form('load', data.info);
				if("quickAdd" == appInfo.formStatus){
					getProjectCode();
				}
			} else {
				showMsg(data.retmsg);
			}
		});
	}
	if("new" == appInfo.formStatus){
		getProjectCode()
	}
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit();
	});
	$("#btnCancel").on("click", function() {
		window.parent.location.reload();
	});
	$("#next1").on("click", function() {
		$("#tt").tabs("select",1);
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
			setTimeout(function() {
				window.parent.location.reload();
			}, 1500);
		} else {
			showMsg(data.retmsg);
		}
	});
}
