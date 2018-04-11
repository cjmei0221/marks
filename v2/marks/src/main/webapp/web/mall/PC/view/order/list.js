var appInfo = {
	goodData : [],
	vipInfo : {},
	vipFlag:0,
	barCodeData : []
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
	appInfo.vipFlag=0;//不是会员
	$('#trDiv').html("");
	appInfo.goodData = [];
	appInfo.vipInfo = {};
	appInfo.barCodeData = [];
	$("#vipName").html("");
	$("#vipTel").html("");
	$("#totalPayableAmt").html("");
	$("#payAmtPut").val("");
	$("#totalNums").html("");
	$("#goodNo").val("");
	$("#vipMobile").val("");
	$("#goodNo").focus();
}
// 加商品
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
				if (vo.stockType == 0 || vo.stockType == '0') {
					var flag = checkBarCode(goodNo);
					if (flag) {
						return;
					}
					appInfo.barCodeData.push(goodNo);
				}
				initList(vo);
			}
		},
		complete : function() {

		}
	});
}
// 减商品
function lessGood() {
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
				if (vo.stockType == 0 || vo.stockType == '0') {
					var flag = checkBarCode(goodNo);
					if (!flag) {
						return;
					}
					appInfo.barCodeData.remove(goodNo);
				}
				var info = getGood(vo.goodNo);
				if (null == info) {
					return;
				}
				info.nums = info.nums - 1;
				if (info.nums < 0) {
					return;
				}
				if (info.nums <= 0) {
					appInfo.goodData.remove(info);
					$("#" + info.goodNo).remove();
					countOrder();
				} else {
					changePrice(info);
				}
			}
		},
		complete : function() {

		}
	});
}
function checkBarCode(barCode) {
	var flag = false;
	if (appInfo.barCodeData.length > 0) {
		for (var i = 0; i < appInfo.barCodeData.length; i++) {
			if (appInfo.barCodeData[i] == barCode) {
				flag = true;
				break;
			}
		}
	}
	return flag;
}
function initList(vo) {
	var info = {};
	var flag = false;
	if (appInfo.goodData.length > 0) {
		for (var i = 0; i < appInfo.goodData.length; i++) {
			if (appInfo.goodData[i].goodNo == vo.goodNo) {
				appInfo.goodData[i].nums += 1;
				changePrice(appInfo.goodData[i]);
				flag = true;
				break;
			}
		}
	}
	if (!flag) {
		vo.nums = 1;
		var nowPrice=vo.salePrice;
		console.log(appInfo.vipFlag);
		if(appInfo.vipFlag==1){
			nowPrice=vo.vipPrice;
		}
		vo.nowPrice=nowPrice;
		vo.payableAmt = vo.nowPrice;
		appInfo.goodData.push(vo);
		$('#trDiv').append(tool.fillTemplate($("#trDivTmp").html(), vo));
		countOrder();
	}
}
function changePrice(info){
	var nowPrice=info.salePrice;
	if(appInfo.vipFlag==1){
		nowPrice=info.vipPrice;
	}
	info.nowPrice=nowPrice;
	info.payableAmt = (parseFloat(nowPrice) * 100*info.nums) / 100;
	info.payableAmt=info.payableAmt.toFixed(2);
	$("#" + info.goodNo + " > td > .cls-nowPrice").val(info.nowPrice);
	$("#" + info.goodNo + " > td > .cls-nums").val(info.nums);
	$("#" + info.goodNo + " > td > .cls-payableAmt").val(
			info.payableAmt);
	countOrder();
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
					appInfo.vipFlag=1;//是会员
					appInfo.vipInfo = vo;
					$("#vipName").html(appInfo.vipInfo.username);
					$("#vipTel").html(appInfo.vipInfo.bind_mobile);
					countVipPrice();
				}
			}
		},
		complete : function() {

		}
	});
}
function countVipPrice(){
	if (appInfo.goodData.length > 0) {
		for (var i = 0; i < appInfo.goodData.length; i++) {
			changePrice(appInfo.goodData[i]);
		}
	}
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
	}
	$("#totalNums").html(nums);
	// 金额
	var objArr = $("#trDiv > tr > td > .cls-payableAmt");
	if (objArr.length > 0) {
		for (var i = 0; i < objArr.length; i++) {
			amount = (parseFloat(amount) * 100 + parseFloat($(objArr[i]).val()) * 100) / 100;
		}
	}
	$("#totalPayableAmt").html(amount.toFixed(2));
	$("#payAmtPut").val(amount.toFixed(2));
}
function checkNums(goodNo) {
	var inputNums = $("#" + goodNo + ">td >.cls-nums").val();
	var info = getGood(goodNo);
	info.nums = inputNums;
	changePrice(info);
}
function checkPayableAmt(goodNo) {
	var vals = $("#" + goodNo + ">td >.cls-payableAmt").val();
	var info = getGood(goodNo);
	info.payableAmt = parseFloat(vals);
	info.payableAmt=info.payableAmt.toFixed(2);
	$("#" + goodNo + ">td >.cls-payableAmt").val(info.payableAmt);
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
	var barCodeList = "";
	if (appInfo.barCodeData.length > 0) {
		barCodeList = JSON.stringify(appInfo.barCodeData);
	}
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
			payAmt : payAmt,
			barCodeList:barCodeList
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
// document.onkeydown = function(e) {
// var theEvent = window.event || e;
// var code = theEvent.keyCode || theEvent.which;
// if (code == 13) {
// $("#uWorkplaceContent .btn-search").click();
// }
// }
