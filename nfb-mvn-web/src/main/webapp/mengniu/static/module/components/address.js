define(['Vue', 'api', 'requestion'],

function(Vue, api, requestion){

    var exports = {};

    exports.add_init = function(){

        var _add = Vue.extend({

            template: '<div class="vue_addressBox">'+
                         '<div class="vue_provinceBox"><select name="" id="" v-model="provinceSelected"><option v-for="item in provinceOptions" :value="item">{{item.name}}</option></select></div>'+
                         '<div class="vue_cityBox"><select name="" id="" v-model="citySelected"><option v-for="item in cityOptions" :value="item">{{item.name}}</option></select></div>'+
                         '<div class="vue_zoneBox"><select name="" id="" v-model="zoneSelected"><option v-for="item in zoneOptions" :value="item">{{item.name}}</option></select></div>'+
                      '</div>',
            data: function(){
                return {
                    provinceSelected: '',
                    provinceOptions: [],
                    citySelected: '',
                    cityOptions: [],
                    zoneSelected: '',
                    zoneOptions: [],
                    pFirst: false,
                    cFirst: false,
                    zFirst: false,
                }
            },
            ready: function(){
                this.getAddress('province', '');
            },
            props: {
                el: {
                    type: String,
                    required: true
                },
                provinceid: {
                    type: String,
                    default: ''
                },
                cityid: {
                    type: String,
                    default: ''
                },
                zoneid: {
                    type: String,
                    default: ''
                }
            },
            methods: {
                //请求地址
                getAddress: function(type, id){
                    var _this = this;
                    requestion.ajax(api.getLinkageAddress, {
                        global: false,
                        data: {parentId: id},
                        success: function(data){
                            if(data.retcode == 0){

                                switch (type) {
                                    case 'province':
                                        _this.provinceOptions = data.addressList;
                                        if(_this.provinceOptions.length > 0){

                                            if(_this.provinceid != '' && !_this.pFirst){
                                                for(var item in _this.provinceOptions){
                                                    if(_this.provinceOptions[item].id == _this.provinceid){
                                                        _this.provinceSelected = _this.provinceOptions[item];
                                                        break;
                                                    }
                                                }
                                                _this.pFirst = true;
                                            }else{
                                                _this.provinceSelected = _this.provinceOptions[0];
                                            }

                                        }
                                        break;
                                    case 'city':
                                        _this.cityOptions = data.addressList;
                                        if(_this.cityOptions.length > 0){

                                            if(_this.cityid != '' && !_this.cFirst){
                                                for(var item in _this.cityOptions){
                                                    if(_this.cityOptions[item].id == _this.cityid){
                                                        _this.citySelected = _this.cityOptions[item];
                                                        break;
                                                    }
                                                }
                                                _this.cFirst = true;
                                            }else{
                                                _this.citySelected = _this.cityOptions[0];
                                            }

                                        }
                                        break;
                                    case 'zone':
                                        _this.zoneOptions = data.addressList;
                                        if(_this.zoneOptions.length > 0){

                                            if(_this.zoneid != '' && !_this.zFirst){
                                                for(var item in _this.zoneOptions){
                                                    if(_this.zoneOptions[item].id == _this.zoneid){
                                                        _this.zoneSelected = _this.zoneOptions[item];
                                                        break;
                                                    }
                                                }
                                                _this.zFirst = true;
                                            }else{
                                                _this.zoneSelected = _this.zoneOptions[0];
                                            }
                                            
                                        }
                                        break;
                                    default:
                                        break;
                                }

                            }
                        }
                    });
                },
            },
            watch: {
                provinceSelected: function(){
                    this.getAddress('city', this.provinceSelected.id);
                },
                citySelected: function(){
                    this.getAddress('zone', this.citySelected.id);
                },
                zoneSelected: function(){
                    this.$dispatch('address-msg', this.el, this.provinceSelected, this.citySelected, this.zoneSelected);
                }
            }

        });

        return _add;

    };

    return exports;

});