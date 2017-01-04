var appInfo = {
	pageNum : 1,
	pageSize : 10,
	pageTotal : 0,
	keyword : ""
}

$(function() {
	getDairylist();
});
function search(){
	appInfo.keyword=$("#keyword").val();
	appInfo.pageNum=1;
	appInfo.pageSize=10;
	appInfo.pageTotal=0;
	getDairylist();
}
function lastPage() {
	appInfo.pageNum--;
	if (appInfo.pageNum < 1) {
		appInfo.pageNum = 1;
		return;
	}
	getDairylist();
}

function nextPage() {
	appInfo.pageNum++;
	if (appInfo.pageNum > appInfo.pageTotal) {
		appInfo.pageNum = appInfo.pageTotal;
		return;
	}
	getDairylist();
}
function getDairylist() {
	appInfo.keyword = $("#keyword").val();
	$.ajax({
		url : tool.reqUrl.dairy_list,
		type : 'POST',
		dataType : "json",
		data : {
			keyword : appInfo.keyword,
			page_number : appInfo.pageNum,
			page_size : appInfo.pageSize
		},
		success : function(data) {
			if (data.retcode == 0) {
				var dairyList = data.list;
				var pageTotal = data.page_total;
				appInfo.pageTotal=pageTotal;
				$("#pageShow").html(appInfo.pageNum + "/" + pageTotal);
				var arr = [];
				$.each(dairyList, function(i, o) {
					// 这里取到o就是上面rows数组中的值, formatTemplate是最开始定义的方法.
					arr.push(tool.fillTemplate($("#trDivTmp").html(), o));
				});
				$('#trDiv').html(arr.join(''));
			} else {
				msg.error(data.retmsg);
			}
		},
		complete : function() {

		}
	});
}
