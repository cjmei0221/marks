
$(function() {
	wxsdk.wx_init(["scanQRCode"]);//注册扫一扫事件
	function scanQR(){
		wxsdk.wx_scan(function(url){
			$.ajax({
				url : tool.reqUrl.mall_orderDetail,
				type : 'POST',
				data : {
					url:url
				},
				success : function(data) {
					
				},
				complete : function() {
					
				}
			});
			
		});
		/*wx.scanQRCode({
			needResult :1, // 默认为1，扫描直接返回扫描结果，0则结果由微信处理，
			scanType : [ "qrCode", "barCode" ], // 可以指定扫二维码还是一维码，默认二者都有
			success : function(res) {
				var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
				scanResult(result);
				alert(result);
			},
			cancel : function() {
				
			}
		});*/
	}
	/*function scanResult(url){
		$.ajax({
			url : tool.reqUrl.mall_orderDetail,
			type : 'POST',
			data : {
				url:url
			},
			success : function(data) {
				
			},
			complete : function() {
				
			}
		});
	}*/
	function wxPay(){
		wxPay.wx_pay(tool.reqUrl.wxPay, {orderId: params.order_id}, function(){
	         
	    });
	}
	 
	function unionPay(){
		$.ajax({
			url : tool.reqUrl.unionPay,
			type : 'POST',
			data : {
				url:url
			},
			success : function(data) {
				 var _html = data.unionpayHtml;
                 $('#unionBox').html(_html);
			},
			complete : function() {
				
			}
		});
	}
	function aliPay(){
		$.ajax({
			url :tool.reqUrl.aliPay,
			type : 'POST',
			data : {
				url:url
			},
			success : function(data) {
				 var _html = data.payHtml;
                 $('#aliBox').html(_html);
			},
			complete : function() {
				
			}
		});
	}
});