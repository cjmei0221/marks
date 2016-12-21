var tool={};
tool.getUrlParams = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
tool.baseUrl="";
tool.reqUrl={
		dairyList:tool.baseUrl+"/diary/list.do"//日记列表
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