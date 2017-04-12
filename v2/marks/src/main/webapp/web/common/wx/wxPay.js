
    var wxPay = {};

    var onBridgeReady = function(data, cb){

        WeixinJSBridge.invoke('getBrandWCPayRequest', {
            'appId': data.appId,
            'timeStamp': data.timeStamp,
            'nonceStr': data.nonceStr,
            'package': data.packageParams,
            'signType': data.signType,
            'paySign': data.paySign
        }, function(res){

            if(res.err_msg == 'get_brand_wcpay_request:ok'){
                typeof cb === 'function' && cb();
            }

        });

    };

    var toPay = function(data, cb){

        if(typeof WeixinJSBridge == 'undefined'){
			if(document.addEventListener){
				document.addEventListener('WeixinJSBridgeReady', onBridgeReady(data, cb), false);
			}else if(document.attachEvent) {
				document.attachEvent('WeixinJSBridgeReady', onBridgeReady(data, cb));
				document.attachEvent('onWeixinJSBridgeReady', onBridgeReady(data, cb));
			}
		}else{
			onBridgeReady(data, cb);
		}

    };

    var initWxPay = function(url, opt, cb){

        $.ajax({
        	url:url,
            data: opt,
            success: function(data){
                if(data.retcode == 0){
                    var _result = JSON.parse(data.json);
                    toPay(_result, cb);
                }else{
                    alert(data.retmsg);
                }
            }
        });

    };

    wxPay.wx_pay = function(url, options, cb){

        var defaults = {
            trade_type: 'JSAPI',
            body: '蒙牛订单',
        };

        var opt = $.extend({}, defaults, options);

        initWxPay(url, opt, cb);

    };