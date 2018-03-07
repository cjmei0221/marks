var appInfo = {
	goodData : [],
	vipInfo:{}
}
$(function() {
	clear();
});
function clear() {
	$('#trDiv').html("");
	appInfo.goodData=[];
	appInfo.vipInfo={};
}
function checkGood() {
	var goodNo = $("#goodNo").val();
	if (goodNo == null || goodNo == '') {
		return;
	}
	$.ajax({
		url : tool.reqUrl.findGoodInfoById,
		type : 'POST',
		data : {
			goodId : goodNo
		},
		success : function(data) {
			if (data.retcode == "0") {
				var vo = data.info;
				vo.nums = 1;
				vo.payableAmt = vo.nowPrice;
				initList(vo);
				countOrder();
			}
		},
		complete : function() {

		}
	});
}
function initList(vo) {
	var info = {};
	var flag = false;
	console.log(vo.goodNo);
	if (appInfo.goodData.length > 0) {
		for (var i = 0; i < appInfo.goodData.length; i++) {
			if (appInfo.goodData[i].goodNo == vo.goodNo) {
				appInfo.goodData[i].nums += 1;
				appInfo.goodData[i].payableAmt = (parseFloat(appInfo.goodData[i].payableAmt)*100
						+ parseFloat(vo.nowPrice)*100)/100;
				info = appInfo.goodData[i];
				$("#" + info.goodNo + " > td > .cls-nums").val(info.nums);
				$("#" + info.goodNo + " > td > .cls-payableAmt").val(
						info.payableAmt.toFixed(2));
				flag = true;
				break;
			}
		}
	}
	console.log(flag);
	if (!flag) {
		appInfo.goodData.push(vo);
		$('#trDiv').append(tool.fillTemplate($("#trDivTmp").html(), vo));
	}
}

function getGood(goodNo) {
	if (appInfo.goodData.length > 0) {
		for (var i = 0; i < appInfo.goodData.length; i++) {
			if (appInfo.goodData[i].goodNo == goodNo) {
				return appInfo.goodData[i];
			}
		}
	}
	return null;
}
function checkVip() {
	var vipMobile = $("#vipMobile").val();
	if (vipMobile == null || vipMobile == '') {
		return;
	}
	$.ajax({
		url : tool.reqUrl.findVipInfoById,
		type : 'POST',
		data : {
			mobile : vipMobile
		},
		success : function(data) {
			if (data.retcode == "0") {
				var vo = data.info;
				if (vo != null && vo != '') {
					$("#vipName").html(vo.username);
					$("#vipTel").html(vo.bind_mobile);
					appInfo.vipInfo=vo;
				}
			}
		},
		complete : function() {

		}
	});
}
function countOrder() {
	var nums = 0;
	var amount = 0;
	// 数量
	var objArr = $("#trDiv > tr > td > .cls-nums");
	if (objArr.length > 0) {
		for (var i = 0; i < objArr.length; i++) {
			nums += parseFloat($(objArr[i]).val());
		}
		$("#totalNums").html(nums);
	}
	// 金额
	var objArr = $("#trDiv > tr > td > .cls-payableAmt");
	if (objArr.length > 0) {
		for (var i = 0; i < objArr.length; i++) {
			amount = (parseFloat(amount)*100 + parseFloat($(objArr[i]).val())*100)/100;
		}
		$("#totalPayableAmt").html(amount.toFixed(2));
		$("#payAmtPut").val(amount.toFixed(2));
	}
}
function checkNums(goodNo) {
	var inputNums = $("#" + goodNo + ">td >.cls-nums").val();
	var info = getGood(goodNo);
	info.nums = inputNums;
	info.payableAmt = parseFloat(info.nums) * (parseFloat(info.nowPrice)*100)/100;
	$("#" + goodNo + ">td >.cls-payableAmt").val(info.payableAmt.toFixed(2));
	countOrder();
}
function checkPayableAmt(goodNo) {
	var vals = $("#" + goodNo + ">td >.cls-payableAmt").val();
	var info = getGood(goodNo);
	info.payableAmt = parseFloat(vals);
	$("#" + goodNo + ">td >.cls-payableAmt").val(info.payableAmt.toFixed(2));
	countOrder();
}

function summitOrder() {
	if (appInfo.goodData.length == 0) {
		return;
	}
	var goodList=JSON.stringify(appInfo.goodData);
	var vipId="";
	if(appInfo.vipInfo.userid != null){
		vipId=appInfo.vipInfo.userid;
	}
	var payAmt=$("#payAmtPut").val();
	$.ajax({
		url : tool.reqUrl.summitOrderUrl,
		type : 'POST',
		data : {
			goodList : goodList,
			vipId:vipId,
			payAmt:payAmt
		},
		success : function(data) {
			if (data.retcode == "0") {
				clear();
			}
		},
		complete : function() {

		}
	});
}