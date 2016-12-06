define(['zepto','template'], function($, tpl) {
    
    var exports = {};

    exports.hideDialog = function(){

        $('#modalDialog').addClass('cancelDialog');

        $('body').on('webkitAnimationEnd animationEnd', '#modalDialog .dialogMain', function(){
            $('#modalDialog').remove();
            $('body').off('webkitAnimationEnd animationEnd', '#modalDialog .dialogMain');
        });

    }

    exports.showDialog = function(options, isClose){
        
        var defaultOpt = {
            num: 2,
            msg: '是否执行此操作？',
            todo: function(){},
            cancel: function(){ }
        };

        var opt = $.extend(defaultOpt, options);

        var _tpl = tpl('dialog/dialog', opt);
    
        $('.page.page-current').append(_tpl);

        $('body').off('click', '.dialog-cancelBtn').on('click', '.dialog-cancelBtn', function(){

            exports.hideDialog();

            typeof opt.cancel === 'function' && opt.cancel();

        });

        $('body').off('click', '.dialog-confirmBtn').on('click', '.dialog-confirmBtn', function(){

            var _isClose = isClose ? false : true;

            if(_isClose) exports.hideDialog();

            typeof opt.todo === 'function' && opt.todo();

        });

    }

    return exports;

});