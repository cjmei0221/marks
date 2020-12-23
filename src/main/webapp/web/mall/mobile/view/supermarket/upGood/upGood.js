$(function() {
	wxsdk.wx_init([ "scanQRCode" ]);// 注册扫一扫事件
});
// 扫码
function scanGood() {
	wxsdk.wx_scan(function(url) {
		$("#c_qrCode").val(url.split(",")[1]);
	});

}
// 上传图片
function uploadImg() {
	 wxsdk.wx_chooseImg(function(imageUrl){
		 $("#showImg").attr("src",tool.reqUrl.image_baseUrl+imageUrl);
		 $("#showImg").show();
		 $("#uploadImg").hide();
		 $("#c_imgUrl").val(imageUrl);
	 });
}

function submitGood() {

	if ($.trim($("#c_qrCode").val()) == '') {
		msg.info("条形码为空");
		return;
	}

	if ($.trim($("#c_price").val()) != '' && !tool.checkNum($.trim($("#c_price").val()))) {
		msg.info("价格只能是数字");
		return;
	}
	var reqUrl = tool.reqUrl.mall_market_good_input;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data : {
			qrCode : $("#c_qrCode").val(),
			title : $("#c_title").val(),
			price : $("#c_price").val(),
			imgUrl:$("#c_imgUrl").val()
		},
		success : function(data) {
			if (data.retcode == "0") {
				
			} else {
				msg.info("请求失败【" + data.retcode + "】");
			}
		},
		complete : function() {
			
		}
	});
}