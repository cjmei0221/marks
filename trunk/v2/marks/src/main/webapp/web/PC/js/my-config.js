
$(document).on('ajaxStart', function(){


}).on('ajaxComplete', function(event, xhr, status){
    if(xhr.status == 200){
    	 var _data =$.parseJSON(xhr.responseText);
        if (_data.retcode == "-101") {
    		alert("访问已失效，请关闭重新进入！");
    		return;
    	}else if (_data.retcode == "-100") {
//    		alert("用户已失效，请重新登录！");
    		location.replace(tool.baseUrl+"/web/PC/view/note/login/login.html?ele="+tool.getCurEle());
    	}
    }

});