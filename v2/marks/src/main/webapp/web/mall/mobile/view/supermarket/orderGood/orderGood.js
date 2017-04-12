var orderId="";

$(function(){
	wxsdk.wx_init(["chooseWXPay"]);//注册扫一扫事件
});
$(document).on('click','#payOrder', function () {
      var buttons1 = [
        {
          text: '微信支付',
          bold: true,
          onClick: function() {
        	  toWxPay();
          }
        },
        {
          text: '支付宝支付',
          onClick: function() {
        	  aliPay();
          }
        },
        {
            text: '银联支付',
            bold: true,
            onClick: function() {
            	unionPay();
            }
          }
      ];
      var buttons2 = [
        {
          text: '取消',
          bg: 'danger'
        }
      ];
      var groups = [buttons1, buttons2];
      $.actions(groups);
  });
function aliPay(){
	$.ajax({
		url :tool.reqUrl.aliPay,
		type : 'POST',
		data : {
			orderId:orderId
		},
		success : function(data) {
			 var _html = data.payHtml;
             $('#aliBox').html(_html);
		},
		complete : function() {
			
		}
	});
}
function toWxPay(){
	wxPay.wx_pay(tool.reqUrl.wxPay, {orderId:orderId}, function(){
         
    });
}
 
function unionPay(){
	$.ajax({
		url : tool.reqUrl.unionPay,
		type : 'POST',
		data : {
			orderId:orderId
		},
		success : function(data) {
			 var _html = data.unionpayHtml;
             $('#unionBox').html(_html);
		},
		complete : function() {
			
		}
	});
}