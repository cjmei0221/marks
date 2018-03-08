function loadHead() {
	var htmlHead = '<div class="sui-navbar navbar-inverse">'
			+ '<div class="navbar-inner">'
			+ '<a href="#" class="sui-brand">痕迹</a>'
			+ '<ul class="sui-nav" style="font-size: 16px;">'
			+ '<li id="order"><a href="/web/mall/PC/view/order/list.html">收银</a></li>'
			+ '<li id="login"><a href="/web/mall/PC/view/login/bind.html">会员</a></li>'
			+ '</ul>' + '</div>' + '<div id="showMsg"></div>' + '</div>';
	$("#cmHead").html(htmlHead);
}
$(function() {
	loadHead();
	changeHead();
});
function changeHead() {
	var ele = tool.getCurEle();
	$("#" + ele).addClass("active");
	$("#" + ele).siblings().removeClass("active");

}
