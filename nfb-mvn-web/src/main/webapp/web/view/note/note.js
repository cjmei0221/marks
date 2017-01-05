function loadHead(){
   var htmlHead=	'<div class="sui-navbar navbar-inverse">'
		+'<div class="navbar-inner">'
		+'<a href="./list.html" class="sui-brand">痕迹</a>'
		+'<ul class="sui-nav" style="font-size: 16px;">'
		+'<li class="active"><a href="./list.html">日记</a></li>'
		+'<li><a href="add.html" style="color: #f3f3f3; background-color: #e8351f;">添加</a></li>'
		+'</ul>'
		+'</div>'
		+'<div id="showMsg"></div>'
		+'</div>';
   $("#cmHead").html(htmlHead);
}
$(function(){
	loadHead();
});
