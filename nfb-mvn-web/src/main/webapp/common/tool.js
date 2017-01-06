var tool={};
tool.getUrlParams = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

tool.fillTemplate = function(tmpl, obj) {
	if(tmpl==null){
		msg.error('tmpl is null,请检查"tmpl"是否为空');
	}
	var html = tmpl;
	for ( var key in obj) {
		var regexp = eval("/\{" + key + "\}/ig");
		html = html.replace(regexp, obj[key]);
	}
	return html;
};

tool.baseUrl="";
tool.reqUrl={
		dairy_list:tool.baseUrl+"/diary/list.do",
		dairy_add:tool.baseUrl+"/diary/save.do",
		dairy_update:tool.baseUrl+"/diary/update.do",
		dairy_detail:tool.baseUrl+"/diary/findDiaryById.do",
		login:tool.baseUrl+"/login.do",
		changePwd:tool.baseUrl+"/sysUser/changePwd.do",
		changeSkin:tool.baseUrl+"/sysUser/changeSkin.do",
		getLoginUserInfo:tool.baseUrl+"/getInfo.do",
		getUUID:tool.baseUrl+"/getUUID.do",
		saveForDiary:tool.baseUrl+"/saveForDiary.do",
		getValidateCode:tool.baseUrl+"/getValidateCode.do"
}