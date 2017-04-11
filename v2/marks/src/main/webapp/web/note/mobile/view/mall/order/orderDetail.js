$(function() {
	wxsdk.wx_init(["scanQRCode"]);//注册扫一扫事件
	wxsdk.wx_scan(scanQR());
});

function scanQR(resultStr){
	alert(resultStr);
}