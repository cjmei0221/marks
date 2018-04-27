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
	$('#pay_returnAmt').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			payOk();
		}

	});
	$('#pay_cashAmt').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			var pay_cashAmt=$("#pay_cashAmt").val();
			if(null != pay_cashAmt && pay_cashAmt !=''){
				countReturnAmt();
			}
		}

	});
	$('#pay_pointAmt').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			var pay_cashAmt=$("#pay_cashAmt").val();
			var pay_pointAmt=$("#pay_pointAmt").val();
			var pay_useBalAmt=$("#pay_useBalAmt").val();
			var pay_payAmt=$("#pay_payAmt").val();
			var pay_payableAmt=$("#pay_payableAmt").html();
			var amt=parseFloat(pay_payAmt)-parseFloat(pay_pointAmt)-parseFloat(pay_useBalAmt);
			
			$("#pay_cashAmt").val(amt.toFixed(2));
		}

	});
	$('#pay_useBalAmt').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			var pay_cashAmt=$("#pay_cashAmt").val();
			var pay_pointAmt=$("#pay_pointAmt").val();
			var pay_useBalAmt=$("#pay_useBalAmt").val();
			var pay_payAmt=$("#pay_payAmt").val();
			var pay_payableAmt=$("#pay_payableAmt").html();
			var amt=parseFloat(pay_payAmt)-parseFloat(pay_pointAmt)-parseFloat(pay_useBalAmt);		
			$("#pay_cashAmt").val(amt.toFixed(2));
		}

	});
	
	$('#recharge_cashAmt').bind('keypress', function(event) {

		if (event.keyCode == 13)

		{
			var pay_cashAmt=$("#recharge_cashAmt").val();
			if(null != pay_cashAmt && pay_cashAmt !=''){
				countRechargeAmt();
			}
		}

	});

});
//积分抵扣金额
function pointAmt(){
	var pay_usePoint=$("#pay_usePoint").val();
	if(parseFloat(pay_usePoint)>0){
		$("#pay_pointAmt").val("0");
	}
}
function countReturnAmt(){
	var pay_cashAmt=$("#pay_cashAmt").val();
	var pay_pointAmt=$("#pay_pointAmt").val();
	var pay_useBalAmt=$("#pay_useBalAmt").val();
	var pay_payAmt=$("#pay_payAmt").val();
	var pay_payableAmt=$("#pay_payableAmt").html();
	var amt=parseFloat(pay_cashAmt)-parseFloat(pay_payAmt)+parseFloat(pay_useBalAmt)+parseFloat(pay_pointAmt);
	$("#pay_returnAmt").val(amt.toFixed(2));
}
//积分抵扣金额
function balAmt(){
	var balAmt=$("#pay_balAmt").html();
	var pay_useBalAmt=$("#pay_useBalAmt").val();
	var flagAmt=parseFloat(balAmt)-parseFloat(pay_useBalAmt);
	if(flagAmt >= 0 ){
		$("#pay_useBalAmt").val("0");
	}
}
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
	$("#vipPoint").html("");
	$("#vipBalAmt").html("");
	$("#toRecharge").hide();
	$(".pay-vip-cls").hide();
	$("#recharge_Amt").val("");
	$("#recharge_sendAmt").val("0");
	$("#recharge_cashAmt").val("");
	$("#recharge_returnAmt").val("");
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
					$("#vipPoint").html(appInfo.vipInfo.balPoint);
					$("#vipBalAmt").html(appInfo.vipInfo.balAmt);
					$("#pay_point").html(appInfo.vipInfo.balPoint);
					$("#pay_balAmt").html(appInfo.vipInfo.balAmt);
					$("#toRecharge").show();
					$(".pay-vip-cls").show();
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
}
function payCancel() {
	$("#payModal").modal('hide');
	clear();
}
function payOk() {
	var pay_cashAmt=$("#pay_cashAmt").val();
	if(null != pay_cashAmt && pay_cashAmt !=''){
		summitOrder();
	}else{
		alert("尚未填写收款金额！");
	}
}
function summitOrder() {
	if (appInfo.goodData.length == 0) {
		return;
	}

	var pay_pointAmt=$("#pay_pointAmt").val();
	var pay_useBalAmt=$("#pay_useBalAmt").val();

	var payAmt = $("#pay_payAmt").val();
	var payableAmt = $("#pay_payableAmt").html();
	
	var pay_usePoint = $("#pay_usePoint").val();
	
	var pay_cashAmt=$("#pay_cashAmt").val();
	var pay_returnAmt=$("#pay_returnAmt").val();
	var cashAmt=(parseFloat(pay_cashAmt)-parseFloat(pay_returnAmt)).toFixed(2);
	
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
			usePoint:pay_usePoint,
			payAmt : payAmt,
			payableAmt:payableAmt,
			pointAmt:pay_pointAmt,
			storedAmt:pay_useBalAmt,
			cashAmt:cashAmt,
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

function toRecharge(){
	$("#rechargeModal").modal('show');
}
function rechargeCancel(){
	$("#rechargeModal").modal('hide');
	clear();
}
function countRechargeAmt(){
	var recharge_cashAmt = $("#recharge_cashAmt").val();
	var recharge_Amt = $("#recharge_Amt").val();
	var recharge_sendAmt = $("#recharge_sendAmt").val();
	var payableAmt=(parseFloat(recharge_cashAmt)-parseFloat(recharge_Amt)).toFixed(2);
	$("#recharge_returnAmt").val(payableAmt);
}
function rechargeOk(){
	var pay_cashAmt=$("#recharge_cashAmt").val();
	if(null != pay_cashAmt && pay_cashAmt !=''){
		summitRechargeOrder();
	}else{
		alert("尚未填写收款金额！");
		return;
	}
	
}
function summitRechargeOrder(){
	var vipId = "";
	if (appInfo.vipInfo.userid != null) {
		vipId = appInfo.vipInfo.userid;
	}
	var recharge_cashAmt = $("#recharge_cashAmt").val();
	var recharge_Amt = $("#recharge_Amt").val();
	var recharge_sendAmt = $("#recharge_sendAmt").val();
	var recharge_returnAmt = $("#recharge_returnAmt").val();
	var payableAmt=(parseFloat(recharge_Amt)+parseFloat(recharge_sendAmt)).toFixed(2);
	var payAmt=(parseFloat(recharge_cashAmt)-parseFloat(recharge_returnAmt)).toFixed(2);
	$.ajax({
		url : tool.reqUrl.summitRechargeOrderUrl,
		type : 'POST',
		data : {
			vipId : vipId,
			payAmt : payAmt,
			payableAmt:payableAmt,
			cashAmt:payAmt
		},
		success : function(data) {
			if (data.retcode == "0") {
				$("#rechargeModal").modal('hide');
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
