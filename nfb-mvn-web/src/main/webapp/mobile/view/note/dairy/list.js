var appInfo = {
	pageNum : 1,
	pageSize : 10,
	pageTotal : 0,
	isLoadingFlag : false
}
console.log("2");
$(function() {
	console.log("1");
	appInfo.isLoadingFlag = false;
	$("#isLoading").hide();
	
	appInfo.pageNum=1;
	appInfo.pageSize=10;
	
	getDairylist(false);
	initScroll();
	
});
function getDairylist(scroll) {
	appInfo.isLoadingFlag=true;
	$("#isLoading").show();
	$.ajax({
		url : '../data/dairyData.json',
		type : 'GET',
		success : function(data) {
			var dairyList = data.list;
			var totalPage = data.list.length;
			appInfo.pageTotal = totalPage;
			appInfo.pageNum++;
			var arr = [];
			$.each(dairyList, function(i, o) {
				// 这里取到o就是上面rows数组中的值, formatTemplate是最开始定义的方法.
				arr.push(tool.fillTemplate($("#listTrTmp").html(), o));
			});
			$('#listDiv').append(arr.join(''));
		},
		complete : function() {
			// 重置加载flag
			$("#isLoading").hide();
			appInfo.isLoadingFlag=false;
		}
	});
}

function initScroll() {
	$(document).off('infinite', '#content').on('infinite', '#content',
			function() {
				if (appInfo.isLoadingFlag)
					return false;
				if (appInfo.pageNum * appInfo.pageSize > appInfo.pageTotal)
					return false;
				getDairylist(true);
			});
	$.init();
}