var appInfo = {
	getUrl : top.window.urlBase + '/inner/workInfo/findById.do',// 获取工作流查询列表接口
	saveUrl : top.window.urlBase + '/inner/workInfo/save.do',// 保存新增工作流查询接口												// WorkInf
};
var workId = tool.getUrlParams("workId");

$(function() {
	loadInfo();
	// 保存菜单
	$("#btnOK").on("click", function() {
		formSubmit(1);
	});
	$("#btnCancel").on("click", function() {
		formSubmit(2);
	});
	$("#btnReturn").on("click", function() {
		returnList();
	});
});
function returnList(){
	var url = "./workInfo.html?&menuid=M_work_info_workInfo";
	location.href = url;
}

//加载基础信息
function loadInfo(){
	$.ajax({
		url : appInfo.getUrl,
		type : "get",
		data : {
			"workId":workId
		},
		dataType : "json",
		success : function(data, status, xhr) {
			if (data.retcode == '0') {
				var info=data.info;
				$("#wrokId").val(info.workId);
				$("#remarks").val("");
				var path = info.pageUrl;
			    var strHtml = "<iframe style='width:100%;height:580px;'  frameborder='0' scrolling='auto' src='" + path + "'></iframe>";
			    $("#postShow").html(strHtml);
			    if(info.dealModel==2){
					$("#checkForm").hide();
				}else{
					$("#checkForm").show();
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
/**
 * 保存菜单
 */
function formSubmit(flag) {
	if (!$('#workff').form('validate')) {
		showMsg("表单校验不通过");
		return;
	}
	var reqUrl = appInfo.saveUrl;
	var parms = $("#workff").serialize();
	parms += "&operateStatus=" + flag;
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
			returnList();
		} else {
			showMsg(data.retmsg);
		}
	});
}
