define(['zepto', 'api', 'requestion'],

function($, api, requestion){

    var exports = {};

    exports.get = function(){

        var result = '';

        requestion.ajax(api.userInfo, {
            async: false,
            success: function(data){
                if(data.retcode == 0) result = data;
            }
        });

        return result;
    
    };

    exports.getBind = function(){

        var result = '';

        requestion.ajax(api.bindUserInfo, {
            async: false,
            success: function(data){
                if(data.retcode == 0) result = data;
            }
        });

        return result;

    };

    return exports;

});