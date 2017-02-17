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
tool.getCurEle=function getEle(){
	var ele ='';
	var req=window.location.pathname;
	var arr=req.split('/'); 
	if(arr.length>2){
		ele = arr[arr.length-2];
	}
	return ele;
}
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
		getValidateCode:tool.baseUrl+"/getValidateCode.do",
		question_list:tool.baseUrl+"/question/list.do",
		question_add:tool.baseUrl+"/question/save.do",
		question_update:tool.baseUrl+"/question/update.do",
		question_detail:tool.baseUrl+"/question/findQuestionById.do",
		gains_list:tool.baseUrl+"/gains/list.do",
		gains_add:tool.baseUrl+"/gains/save.do",
		gains_update:tool.baseUrl+"/gains/update.do",
		gains_detail:tool.baseUrl+"/gains/findGainsById.do",
		bind:tool.baseUrl+"/bind.do",
		getVIPInfo:tool.baseUrl+"/vipInfo/findVipInfoById.do",
		changeMobile:tool.baseUrl+"/sysUser/changeMobile.do",
		vipInfo_save:tool.baseUrl+"/vipInfo/save.do"
		
}

tool.checkPhone=function checkPhone(val) {
	if (!(/^1[34578]\d{9}$/.test(val))) {
		return false;
	}
	return true;
}