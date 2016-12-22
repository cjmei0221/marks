
$.config = {
        // 路由功能开关过滤器，返回 false 表示当前点击链接不使用路由
        routerFilter: function($link) {
        	console.log("router");
            // 某个区域的 a 链接不想使用路由功能
            if ($link.is('.disable-router a')) {
                return false;
            }

            return true;
        }
    };

$.init();
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