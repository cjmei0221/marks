
$(document).on('ajaxStart', function() {

}).on('ajaxComplete',function(event, xhr, status) {
	if (xhr.status == 200) {
		 var _data =$.parseJSON(xhr.responseText);
		/*if (_data.retcode == "-101") {
			alert("访问已失效，请关闭重新进入！");
			return;
		} else if (_data.retcode == "-100") {
			location.replace(tool.baseUrl+ "/web/note/mobile/view/login/login.html?ele="+tool.getCurEle());
			return;
		}*/
	}		
});

$(function() {
	if(isWeiXin()){
		alert("请在微信客户端打开！");
	}
});

function isWeiXin(){
	var ua = window.navigator.userAgent.toLowerCase(); 
      if(ua.match(/MicroMessenger/i) == 'micromessenger'){ 
      return true; }else{ return false; };
};
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    WeixinJSBridge.call('hideOptionMenu');
    WeixinJSBridge.call('hideToolbar');
});

