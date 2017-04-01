
var myConfig = {
	styleType : 0
}
$(document).on('ajaxStart', function() {

}).on(
		'ajaxComplete',
		function(event, xhr, status) {
			if (xhr.status == 200) {
				 var _data =$.parseJSON(xhr.responseText);
				if (_data.retcode == "-101") {
					alert("访问已失效，请关闭重新进入！");
					return;
				} else if (_data.retcode == "-100") {
					location.replace(tool.baseUrl+ "/mobile/view/note/login/login.html?ele="+tool.getCurEle());
					return;
				}
			}
		});

function addStyle(stylePath) {
	var container = document.getElementsByTagName("head")[0];
	var addStyle = document.createElement("link");
	addStyle.rel = "stylesheet";
	addStyle.type = "text/css";
	addStyle.media = "screen";
	addStyle.href = stylePath;
	container.appendChild(addStyle);
}
function loadStyle() {
	$.ajax({
		url : tool.reqUrl.getLoginUserInfo,
		type : 'POST',
		success : function(data) {
			if (data.retcode == "0") {
				myConfig.styleType = data.loginUser.skin;
			}
			if (myConfig.styleType != null || "" != myConfig.styleType) {
				addStyle(tool.baseUrl + "/mobile/assets/css/marks" + myConfig.styleType
						+ ".css");
			} else {
				addStyle(tool.baseUrl + "/mobile/assets/css/marks0.css");
			}
		},
		complete : function() {
		}
	});
}
$(function() {
	loadStyle();
});

function isWeiXin(){
	var ua = window.navigator.userAgent.toLowerCase(); 
      if(ua.match(/MicroMessenger/i) == 'micromessenger'){ 
      return true; }else{ return false; };
};

