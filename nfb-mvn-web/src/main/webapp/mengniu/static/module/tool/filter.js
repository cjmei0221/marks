define(['Vue', 'orderStatus'], function(Vue, orderStatus){

    //转换单位 -- 分 -> 元
    Vue.filter('turnCNY', function(val, notNeed){

        val = Number(val);
        if(isNaN(val)){
            return notNeed ? '0.00' : '￥0.00';
        }else{
            val = (val / 100).toFixed(2);
            return notNeed ? (val) : ('￥' + val);
        }

    });
    
    //购物数量
    Vue.filter('cartNum', {

        write: function(val, oldVal){
            var regex = new RegExp('^[1-9]{1}[0-9]*$');

            if(regex.test(val)){

                val = Number(val);
                if(val >= 999){
                    return 999
                }else if(val < 1){
                    return 0
                }else{
                    return val;
                }

            }else{

                return 0;

            }
        }

    });

    //字符串为空返回 ---
    Vue.filter('emptyString', function(val){
        return (val == '') ? '---' : val;
    });

    //获取订单状态
    Vue.filter('order_status', function(val){
        return (orderStatus.status[val]) ? orderStatus.status[val] : '---';
    });

    //验证手机号码
    Vue.filter('phone', {

        write: function(val){
            var regex = new RegExp('^[1]{1}[0-9]{10}$');
            if(regex.test(val)){
                return val;
            }else{
                return '';
            }
        }

    });

    //头像是否为空
    Vue.filter('defaultHeadImg', function(val){
        return (val == '') ? '../../../assets/images/default/avatar.png' : val;
    });

    //检查邮箱地址
    Vue.filter('email', {
        write: function(val){
            var regex = new RegExp(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/);
            if(regex.test(val)){
                return val;
            }else{
                return '';
            }
        }
    });

    //银行卡no
    Vue.filter('bankCard', {

        write: function(val){
            var regex = new RegExp('^[0-9]*$');
            if(regex.test(val)){
                return val;
            }else{
                return '';
            }
        }

    });

    //身份证号
    Vue.filter('idCard', {
        write: function(val){
            var regex = new RegExp(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/);
            if(regex.test(val)){
                return val;
            }else{
                return '';
            }
        }
    });

    return;

});