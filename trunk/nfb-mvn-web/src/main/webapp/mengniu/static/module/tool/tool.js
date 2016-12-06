define(['zepto','sm','regex','requestion','api','link', 'dialog'],

function($,sm,regex,requestion,api,link, dialog){

    var exports = {};

    link.globalEventInit();
    exports.link = link;

    exports.getUrlParams = function(name){
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }

    exports.toTop = function(){
        $('.content').scrollTop(0);
    }

    /**
     * [获取验证码]
     * @param  {[number]} mobile [手机号码]
     * @return {[type]}       [description]
     */
    exports.sendMessage = function(e,val){
        var that = $(e.target);//按钮

        var _background = that.css('background'),
            _color = that.css('color');

        if( regex.mobile(val) ){
            if ( that.attr('data-gettingcode')=='true' ) {
                return false;
            }
            var getCodeTimer;
            requestion.ajax(api.sendMessage, {
                data: {
                    mobile: val
                },
                beforeSend : function(){
                    that.attr('data-gettingcode', 'true')
                        .css({'background': 'gray', 'color': '#fff'});
                },
                success: function(data){
                    if(data.retcode == 0){
                        $.toast('验证码已发送，请留意手机短信');
                    }else{
                        $.toast( data.retmsg );
                    }
                },
                complete : function(){
                    var time = 60;
                    var oldText = that.html();
                    getCodeTimer = setInterval(function(){
                        that.html( "重新获取(" + (time--) +")" );
                        if (time===-1) {
                         that.html( oldText ).removeAttr('data-gettingcode');
                         that.css({'background': _background, 'color': _color});
                         clearInterval(getCodeTimer); 
                     }
                    },1000);
                }
            });

        }else{
            $.toast('请输入正确的手机号码');
            return false;
        }
    }

    /**
     * [绑定]
     * @param  {[obj]} data [绑定信息]
     * data = { mobile:xxx , code:xxx , roleType:xxx }
     */
    exports.binding = function(e,data,cb){

//（绑定角色---- 合伙人  : PTR   省负责人：PIC  业务员 ：SM    财务：FD  店主：SP  导购：SG ）

        var that = $(e.target);//按钮
        if ( that.attr('data-binding')=='true' ) {return false};
        if ( !( data.mobile && data.code && data.roleType ) ) {
            $.toast('请输入完整的信息');
            return false;
        }
        var getCodeTimer;
        requestion.ajax(api.binding_peopleManage, {
            data: data,
            beforeSend : function(){
                that.attr('data-binding', 'true');
            },
            success: function(data){
                if(data.retcode == 0){
                    $.toast('绑定成功！');

                    if(typeof cb === 'function'){
                        cb(data)
                    }else{
                        dialog.showDialog({
                            num: 1,
                            msg: '绑定成功',
                            todo: function(){
                                link.toWorkbench();
                            }
                        });
                    }
                    
                }else{
                    $.toast( data.retmsg );
                }
            },
            complete : function(){
                that.removeAttr('data-binding');
            }
        });

    }

    return exports;

});