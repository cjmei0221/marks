var appInfo = {
	getUrl : top.window.urlBase + '/inner/diary/findDiaryById.do',// 获取我的日记列表接口 Diary
};
var idNo=tool.getUrlParams("idNo");

$(function() {
	// 加载列表
	var parms = "id=" + idNo;
	$.post(appInfo.getUrl, parms, function(data) {
		if (data.retcode == "0") {
			$('#ff').form('load', data.diary);
		} else {
			showMsg(data.retmsg);
		}
	});

});
