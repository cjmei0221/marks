var appInfo = {
	goodData : [],
	vipInfo : {}
}
$(function() {
	clear();
	$('#vipMobile').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			$("#goodNo").focus();
		}

	});
	$('#goodNo').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			$("#goodNo").focus();
			checkGood();
		}

	});
	$('#pay_payAmt').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			payOk();
		}

	});

});
function clear() {
	$('#trDiv').html("");
	appInfo.goodData = [];
	appInfo.vipInfo = {};
	$("#vipName").html("");
	$("#vipTel").html("");
	$("#totalPayableAmt").html("");
	$("#payAmtPut").val("");
	$("#totalNums").html("");
	$("#goodNo").val("");
	$("#vipMobile").val("");
	$("#goodNo").focus();
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
				appInfo.goodData[i].payableAmt = (parseFloat(appInfo.goodData[i].payableAmt) * 100 + parseFloat(vo.nowPrice) * 100) / 100;
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
					appInfo.vipInfo = vo;
					$("#vipName").html(appInfo.vipInfo.username);
					$("#vipTel").html(appInfo.vipInfo.bind_mobile);
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
			amount = (parseFloat(amount) * 100 + parseFloat($(objArr[i]).val()) * 100) / 100;
		}
		$("#totalPayableAmt").html(amount.toFixed(2));
		$("#payAmtPut").val(amount.toFixed(2));
	}
}
function checkNums(goodNo) {
	var inputNums = $("#" + goodNo + ">td >.cls-nums").val();
	var info = getGood(goodNo);
	info.nums = inputNums;
	info.payableAmt = parseFloat(info.nums) * (parseFloat(info.nowPrice) * 100)
			/ 100;
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
function toPay() {
	$("#payModal").modal('show');
	$("#pay_payableAmt").html($("#totalPayableAmt").html());
	$("#pay_payAmt").val($("#payAmtPut").val());
	$("#pay_payAmt").focus();
}
function payCancel() {
	$("#payModal").modal('hide');
	clear();
}
function payOk() {
	summitOrder();
}
function summitOrder() {
	if (appInfo.goodData.length == 0) {
		return;
	}
	var payAmt = $("#pay_payAmt").val();
	var payableAmt = $("#pay_payableAmt").html();
	var goodList = JSON.stringify(appInfo.goodData);
	var vipId = "";
	if (appInfo.vipInfo.userid != null) {
		vipId = appInfo.vipInfo.userid;
	}
	$.ajax({
		url : tool.reqUrl.summitOrderUrl,
		type : 'POST',
		data : {
			goodList : goodList,
			vipId : vipId,
			payAmt : payAmt
		},
		success : function(data) {
			if (data.retcode == "0") {
				$("#payModal").modal('hide');
				clear();
			}
		},
		complete : function() {

		}
	});
}
//document.onkeydown = function(e) {
//	var theEvent = window.event || e;
//	var code = theEvent.keyCode || theEvent.which;
//	if (code == 13) {
//		$("#uWorkplaceContent .btn-search").click();
//	}
//}
