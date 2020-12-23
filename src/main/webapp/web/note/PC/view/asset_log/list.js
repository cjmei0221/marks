var appInfo = {
	pageNum : 1,
	pageSize : 15,
	pageTotal : 0,
	keyword : ""
}

$(function() {
	getlist();
});
function mysearch(){
	appInfo.pageNum=1;
	appInfo.pageTotal=0;
	getlist();
}
function lastPage() {
	appInfo.pageNum--;
	if (appInfo.pageNum < 1) {
		appInfo.pageNum = 1;
		return;
	}
	getlist();
}

function nextPage() {
	appInfo.pageNum++;
	if (appInfo.pageNum > appInfo.pageTotal) {
		appInfo.pageNum = appInfo.pageTotal;
		return;
	}
	getlist();
}
function getlist() {
	appInfo.keyword = $("#keyword").val();
	$.ajax({
		url : tool.reqUrl.assetlog_list,
		type : 'POST',
		dataType : "json",
		data : {
			keyword : appInfo.keyword,
			page_number : appInfo.pageNum,
			page_size : appInfo.pageSize
		},
		success : function(data) {
			if (data.retcode == "0") {
				//月统计
				var countList=data.countList;
				var arrCount = [];
				for(var i=0;i<countList.length;i++){
					arrCount.push("<span>"+countList[i].itemName+"</span> <span>&#65509;"+toMoney(countList[i].outAmount)+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				$("#countList").html(arrCount.join(''));
				//日统计
				var countDayList=data.countDayList;
				var arrDayCount = [];
				for(var i=0;i<countDayList.length;i++){
					arrDayCount.push("<span>"+countDayList[i].itemName+"</span> <span>&#65509;"+toMoney(countDayList[i].outAmount)+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				$("#countDayList").html(arrDayCount.join(''));
				//日志
				var dairyList = data.list;
				var pageTotal = data.page_total;
				appInfo.pageTotal=pageTotal;
				$("#pageShow").html(appInfo.pageNum + "/" + pageTotal);
				var arr = [];
				var index=1;
				for(var i=0;i<dairyList.length;i++){
					var o=dairyList[i];
					// 这里取到o就是上面rows数组中的值, formatTemplate是最开始定义的方法.
					o.idx=index;
					if(o.tranType==0){
						o.tranType="支出";
						o.tranAmount='-'+o.tranAmount;
					}else{
//						o.tranType="收入";
						o.tranType='<span style="color:gold;">收入</span>';
						o.tranAmount='<span style="color:gold;">'+o.tranAmount+'</span>';
					}
					arr.push(tool.fillTemplate($("#trDivTmp").html(), o));
					index++;
				}
				$('#trDiv').html(arr.join(''));
			} else {
				msg.error(data.retmsg);
			}
		},
		complete : function() {

		}
	});
}
