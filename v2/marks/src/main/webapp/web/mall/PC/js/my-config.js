
$(document).on('ajaxStart', function(){


}).on('ajaxComplete', function(event, xhr, status){
    if(xhr.status == 200){
    	 var _data =$.parseJSON(xhr.responseText);
        if (_data.retcode == "-101") {
    		alert("访问已失效，请关闭重新进入！");
    		return;
    	}else if (_data.retcode == "-100") {
//    		alert("用户已失效，请重新登录！");
    		location.replace(tool.baseUrl+"/web/mall/PC/view/login/login.html?ele="+tool.getCurEle());
    	}
    }

});

function setupAjax(){
	$.ajaxSetup({cache:false
		,timeout:30000
		,beforeSend:function(xhr,opts){
			if(opts.url.indexOf("_t=")>=0){
				return;
			}
			if(opts.url.indexOf("?")>=0){
				opts.url +="&_t="+(+(new Date()))+"&device=PC";		
			}else{
				opts.url +="?_t="+(+(new Date()))+"&device=PC";		
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