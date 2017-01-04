var appInfo = {
	pageNum : 1,
	pageSize : 10,
	pageTotal : 0,
	isLoadingFlag : false,
	leftPanel : false
}
$(function() {
	appInfo.isLoadingFlag = false;
	$("#isLoading").hide();

	appInfo.pageNum = 1;
	appInfo.pageSize = 10;

	getDairylist(false);
	initScroll();
});
// 搜索
function mysearch() {
	appInfo.isLoadingFlag = false;
	appInfo.pageNum = 1;
	appInfo.pageSize = 10;
	getDairylist(false);
}
function getDairylist(scroll) {
	appInfo.isLoadingFlag = true;
	$("#isLoading").show();
	$.ajax({
		url : tool.reqUrl.dairy_list,
		type : 'POST',
		data : {
			keyword : $("#search").val(),
			page_number : appInfo.pageNum,
			page_size : appInfo.pageSize
		},
		success : function(data) {
			if (data.retcode == 0) {
				if(!scroll){
					$('#listDiv').html("");
				}
				var dairyList = data.list;
				var totalPage = data.page_total;
				appInfo.pageTotal = totalPage;
				appInfo.pageNum++;
				var arr = [];
				$.each(dairyList, function(i, o) {
					// 这里取到o就是上面rows数组中的值, formatTemplate是最开始定义的方法.
					arr.push(tool.fillTemplate($("#listTrTmp").html(), o));
				});
				$('#listDiv').append(arr.join(''));
			} else {
				msg.info("加载失败【" + data.retcode + "】");
			}
		},
		complete : function() {
			// 重置加载flag
			$("#isLoading").hide();
			appInfo.isLoadingFlag = false;
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
}
/**
 * 侧栏显示控制
 */
function showLeftPanal(dvl) {
	
	if(!appInfo.leftPanel){
		$("#"+dvl).show();
		appInfo.leftPanel = true;
	}else{
		$("#"+dvl).hide();
		appInfo.leftPanel = false;
	}
	
}