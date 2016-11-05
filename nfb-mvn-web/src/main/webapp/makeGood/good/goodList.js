var appInfo = {
	list : baseUrl + "/goodInfo/list.do",// 查询商品列表
	reqParams : {
		page_number : 1,
		page_size : 5,
		keyword : ""
	},
	page_total:1
}
// 页面加载方法
$(function() {
	// 加载商品列表
	loadList();
	
	$("#first").on("click",function(){
		appInfo.reqParams.page_number=1;
		loadList();
	});
	$("#last").on("click",function(){
		if(appInfo.reqParams.page_number>1){
			appInfo.reqParams.page_number=appInfo.reqParams.page_number-1;
		}else{
			appInfo.reqParams.page_number=1;
		}
		loadList();
	});
	$("#next").on("click",function(){
		if(appInfo.reqParams.page_number<appInfo.page_total){
			appInfo.reqParams.page_number=appInfo.reqParams.page_number+1;
		}else{
			appInfo.reqParams.page_number=appInfo.page_total;
		}
		loadList();
	});
	$("#end").on("click",function(){
		appInfo.reqParams.page_number=appInfo.page_total;
		loadList();
	});
});
// 加载商品列表
function loadList() {
	$.ajax({
		url : appInfo.list,
		type : "post",
		data : appInfo.reqParams,
		dataType : "json",
		success : function(data, status, xhr) {
			checkLogin(data);
			if (data.retcode == 0) {
				var list = data.list;
				var tmplist = [];
				var html = "";
				for (var i = 0; i < list.length; i++) {
					html += myApp.fillTemplate($("#goodListTpl").html(), list[i]);
				}
				tmplist.push(html);
				appInfo.page_total=data.page_total;
				$("#myGoodList").html(tmplist.join(""));
			} else {

			}
		}
	});
}