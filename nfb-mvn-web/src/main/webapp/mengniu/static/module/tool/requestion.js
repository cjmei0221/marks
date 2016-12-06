
window._isLoading = true;

define(['zepto', 'api', 'sm'], function($, api, sm){
    
    var exports = {};

    $(document).on('ajaxStart', function(){

        $.showPreloader();

    }).on('ajaxComplete', function(event, xhr, status){
        if(xhr.status == 200){
            var _data = JSON.parse(xhr.response);
            if(_data.retcode == -100){
            	setTimeout(function(){
            		location.replace('../binding/binding.html');
            	}, 50);
//                return false;
            }
        }

        if(window._isLoading){
            $('#loadingBox').remove();
            window._isLoading = false;
        }
        
        $.hidePreloader();

    });

    exports.ajax = function(url, options){

        var ipPart = '',//ip段
            basePart = '';//基础路径段

        var defaultOpt = {
            type: 'post',
            url: ipPart + basePart + url,
            cache: false,
            success: function(data){},
            error: function(){},
            complate: function(){}
        }

        var opt = $.extend({}, defaultOpt, options);

        $.ajax(opt);

    };

    return exports;

});