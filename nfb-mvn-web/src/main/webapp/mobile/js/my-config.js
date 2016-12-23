
$(document).on('ajaxStart', function(){


}).on('ajaxComplete', function(event, xhr, status){
    if(xhr.status == 200){
    	 var _data = xhr.responseText;
         //_data = xhr.response;
        if (_data.retcode == -101) {
    		alert("访问已失效，请关闭重新进入！")
    		return false;
    	}
    }

});