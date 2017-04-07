function loadHead() {
	var htmlHead = '<div class="sui-navbar navbar-inverse">'
			+ '<div class="navbar-inner">'
			+ '<a href="#" class="sui-brand">痕迹</a>'
			+ '<ul class="sui-nav" style="font-size: 16px;">'
			+ '<li id="gains"><a href="/web/PC/view/note/gains/list.html">备忘</a></li>'
			+ '<li id="diary"><a href="/web/PC/view/note/diary/list.html">日记</a></li>'
			+ '<li id="question"><a href="/web/PC/view/note/question/list.html">问题</a></li>'
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
