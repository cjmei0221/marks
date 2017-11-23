function loadHead() {
	var htmlHead = '<div class="sui-navbar navbar-inverse">'
			+ '<div class="navbar-inner">'
			+ '<a href="#" class="sui-brand">痕迹</a>'
			+ '<ul class="sui-nav" style="font-size: 16px;">'
			+ '<li id="gains"><a href="/web/note/PC/view/gains/list.html">备忘</a></li>'
			+ '<li id="diary"><a href="/web/note/PC/view/diary/list.html">日记</a></li>'
			+ '<li id="question"><a href="/web/note/PC/view/question/list.html">问题</a></li>'
			+ '<li id="plan"><a href="/web/note/PC/view/plan/list.html">计划</a></li>'
			+ '<li id="reminder"><a href="/web/note/PC/view/reminder/list.html">提醒</a></li>'
			+ '<li id="asset_log"><a href="/web/note/PC/view/asset_log/list.html">记账</a></li>'
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
