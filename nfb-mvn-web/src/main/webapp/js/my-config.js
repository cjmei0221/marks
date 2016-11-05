var baseUrl="/web";
var myApp={};

//当返回为-1000时，提示去登陆
function checkLogin(data) {
	
}

myApp.fillTemplate = function(tmpl, obj) {
	if(tmpl==null){
		console.error('tmpl is null,请检查"tmpl"是否为空');
	}
	var html = tmpl;
	for ( var key in obj) {
		var regexp = eval("/\{" + key + "\}/ig");
		html = html.replace(regexp, obj[key]);
	}
	return html;
};