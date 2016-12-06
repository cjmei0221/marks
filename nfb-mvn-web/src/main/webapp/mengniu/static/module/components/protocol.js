define(['Vue'],

function(Vue){

    var exports = {};

    exports.protocol_init = function(){

        var protocolTag = Vue.extend({
            template: '<div class="protocolBox">'+
                        '<div class="protocolMain">'+
                            '协议内容'+
                        '</div>'+
                        '<footer class="protocolFooter">'+
                            '<a href="javascript:void(0)" class="f-16 btnShadow" @click="close">关闭</a>'+
                        '</footer>'+
                      '</div>',

            methods: {
                close: function(){
                    this.$dispatch('close-protocol');
                }
            }
        });

        return protocolTag;

    }

    return exports;

});