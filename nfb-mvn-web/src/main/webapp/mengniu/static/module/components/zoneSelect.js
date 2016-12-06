define(['Vue', 'api', 'requestion', 'dialog'],

function(Vue, api, requestion, dialog){

    var exports = {};

    exports.zoneSelect_init = function(){

        Vue.filter('isNext', function(val){
            return (val <= 0) ? '' : 'next';
        });

        var _zoneSelet = Vue.extend({

            template: '<div class="zoneSelectBox">'+
                        '<div class="zoneSelectBody">'+
                            '<ul class="f-16">'+
                                '<li v-for="item in list" class="{{item.amount | isNext}}" @click="clickItem($index, item.amount, item.id, item.name, item.parentid, item.busUnitCode)">{{item.name}}</li>'+
                            '</ul>'+
                        '</div>'+
                        '<footer class="zoneSelectFooter">'+
                            '<a v-if="isBackBtn" href="javascript:void(0)" class="f-20 dumexBtn" @click="backList">←</a>'+
                            '<a href="javascript:void(0)" class="f-16 btnShadow" @click="close">取消</a>'+
                        '</footer>'+
                      '</div>',

            data: function(){
                return {
                    oldId: '0',
                    oldName: '',
                    list: []
                }
            },

            ready: function(){
                this.getList({parentId: ''}, false);
            },

            methods: {
                close: function(){
                    this.$dispatch('zone_select_close');
                },
                //获取列表
                getList: function(opt, isBack){
                    var _this = this;

                    var _url = isBack ? api.getZoneNodeList : api.getAllZoneList;

                    requestion.ajax(_url, {
                        data: opt,
                        success: function(data){
                            if(data.retcode == 0){
                                _this.handle(data);
                            }else{
                                dialog.showDialog({num: 1, msg: data.retmsg});
                            }
                        }
                    });
                },
                //处理列表数据
                handle: function(data){
                    this.list = data.sysBusUnitList;
                    if(this.list.length > 0) this.oldId = this.list[0].parentid;
                },
                //点击条目
                clickItem: function(index, amount, id, name, parentid, busUnitCode){

                    if(amount > 0) this.oldName = this.list[index].name;

                    if(amount <= 0){
                        this.chooseZone(id, name, busUnitCode, this.oldName);
                    }else{
                        this.getList({parentId: id}, false);
                    }
                },
                //返回
                backList: function(){
                    this.getList({id: this.oldId}, true);
                },
                //选择区域
                chooseZone: function(id, name, parentid, busUnitCode){
                    this.$dispatch('choose-zone', id, name, parentid, busUnitCode);
                }
            },

            computed: {
                isBackBtn: function(){
                    return this.oldId == '0' ? false : true;
                }
            }

        });

        return _zoneSelet;

    };

    return exports;

});