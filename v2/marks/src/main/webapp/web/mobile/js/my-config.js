
var myConfig = {
	styleType : 0
}

function setupAjax(){
	$.ajaxSetup({cache:false
		,timeout:30000
		,beforeSend:function(xhr,opts){
			if(opts.url.indexOf("_t=")>=0){
				return;
			}
			if(opts.url.indexOf("?")>=0){
				opts.url +="&_t="+(+(new Date()))+"&device=Mobile";		
			}else{
				opts.url +="?_t="+(+(new Date()))+"&device=Mobile";		
			}	
		}
		,complete:function(xhr){				
			if(xhr.statusText!=undefined && xhr.status==0 && xhr.statusText=="timeout"){
				$.messager.alert("超时","操作超时！请返回重试！","info",function(){xhr.abort();});
			}		
		}			
	});	
}
setupAjax();
$(document).on('ajaxStart', function() {

}).on('ajaxComplete',function(event, xhr, status) {
	if (xhr.status == 200) {
		 var _data =$.parseJSON(xhr.responseText);
		if (_data.retcode == "-101") {
			alert("访问已失效，请关闭重新进入！");
			return;
		} else if (_data.retcode == "-100") {
			location.replace(tool.baseUrl+ "/web/mobile/view/note/login/login.html?ele="+tool.getCurEle());
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
				addStyle(tool.baseUrl + "/web/mobile/assets/css/marks" + myConfig.styleType
						+ ".css");
			} else {
				addStyle(tool.baseUrl + "/web/mobile/assets/css/marks0.css");
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
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    WeixinJSBridge.call('hideOptionMenu');
    WeixinJSBridge.call('hideToolbar');
});

