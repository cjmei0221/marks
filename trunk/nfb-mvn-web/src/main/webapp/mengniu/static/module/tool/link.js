/**
 * 公共跳转模块
 */

define(['zepto','sm'],function($,sm){
    var exports = {};

    //工作台页面
    exports.toWorkbench = function(){
        var par = window.location.search;
        window.location.href = '../workbench/workbench.html'+par;
    }

    exports.globalEventInit = function(){

        //返回按钮
        $(document).on('click','.backBtn',function(e){
            e.preventDefault();
            e.stopPropagation();
            window.history.go(-1);
        })

        $(document).on('click','.js_toWorkbench',function(e){
            e.preventDefault();
            e.stopPropagation();
            exports.toWorkbench();
        })

    }

    return exports;

})