var appInfo = {
	pageNum : 1,
	pageSize : 9,
	total_count : 0,
	curNum : 0,
	leftPanel : false
}
$(function() {
	appInfo.pageNum = 1;
	appInfo.curNum = 0;
	getlist(false);
});
// 搜索
function mysearch() {
	appInfo.pageNum = 1;
	appInfo.curNum = 0;
	getlist(false);
}
function getlist(scroll) {
	$("#isLoading").hide();
	$.ajax({
		url : tool.reqUrl.gains_list+"?&_t="+new Date().getTime(),
		type : 'POST',
		data : {
			keyword : $("#search").val(),
			page_number : appInfo.pageNum,
			page_size : appInfo.pageSize
		},
		success : function(data) {
			if (data.retcode == "0") {
				if (!scroll) {
					$('#listDiv').html("");
				}
				var dairyList = data.list;
				var total_count = data.total_count;
				appInfo.total_count = total_count;
				var arr = [];
				for(var i=0;i<dairyList.length;i++){
					var o=dairyList[i];
					// 这里取到o就是上面rows数组中的值, formatTemplate是最开始定义的方法.
					o.idx = appInfo.total_count - appInfo.curNum;
					arr.push(tool.fillTemplate($("#listTrTmp").html(), o));
					appInfo.curNum++;
				}
				$('#listDiv').append(arr.join(''));

				if (appInfo.pageNum * appInfo.pageSize > appInfo.total_count) {
					$("#isLoading").hide();
				} else {
					$("#isLoading").show();
				}
			} else {
				msg.info("加载失败【" + data.retcode + "】");
			}
		},
		complete : function() {
			// 重置加载flag

		}
	});
}

function loadMore() {
	if (appInfo.pageNum * appInfo.pageSize > appInfo.total_count) {
		$("#isLoading").hide();
		return;
	} else {
		appInfo.pageNum++;
		getlist(true);
	}
}
