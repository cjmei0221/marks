
$(document).on('ajaxStart', function(){


}).on('ajaxComplete', function(event, xhr, status){
    if(xhr.status == 200){
    	 var _data =$.parseJSON(xhr.responseText);
        if (_data.retcode == -101) {
    		alert("访问已失效，请关闭重新进入！");
    		return;
    	}else if (_data.retcode == -100) {
    		alert("用户已失效，请重新登录！");
    		location.replace(tool.baseUrl+"/web/view/note/owner/login.html");
    	}
    }

});

function loadHead(){
   var htmlHead=	'<div class="sui-navbar navbar-inverse">'
		+'<div class="navbar-inner">'
		+'<a href="#" class="sui-brand">痕迹</a>'
		+'<ul class="sui-nav" style="font-size: 16px;">'
		+'<li class="active"><a href="./list.html">日记</a></li>'
		+'<li><a href="add.html" style="color: #f3f3f3; background-color: #e8351f;">添加</a></li>'
		+'</ul>'
		+'<ul class="sui-nav pull-right">'
		+'<li><a href="#">个人中心</a></li>'
		+'<li><a href="#">帮助</a></li>'
		+'</ul>'
		+'</div>'
		+'<div id="showMsg"></div>'
		+'</div>';
   $("#cmHead").html(htmlHead);
}
$(function(){
	loadHead();
});
