
$(function() {
	wxsdk.wx_init(["scanQRCode"]);//注册扫一扫事件
	 wxsdk.wx_scan(_this.getNew);
});
function scanResult(resultStr){
	alert(resultStr);
}
