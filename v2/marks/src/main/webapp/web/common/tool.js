var tool = {};
tool.getUrlParams = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

tool.fillTemplate = function(tmpl, obj) {
	if (tmpl == null) {
		msg.error('tmpl is null,请检查"tmpl"是否为空');
	}
	var html = tmpl;
	for ( var key in obj) {
		var regexp = eval("/\{" + key + "\}/ig");
		html = html.replace(regexp, obj[key]);
	}
	return html;
};
tool.getCurEle = function getEle() {
	var ele = '';
	var req = window.location.pathname;
	var arr = req.split('/');
	if (arr.length > 2) {
		ele = arr[arr.length - 2];
	}
	return ele;
}
tool.baseUrl = "";
tool.reqUrl = {
	image_baseUrl : tool.baseUrl + "/upload_file/",
	dairy_list : tool.baseUrl + "/web/diary/list.do",
	dairy_add : tool.baseUrl + "/web/diary/save.do",
	dairy_update : tool.baseUrl + "/web/diary/update.do",
	dairy_detail : tool.baseUrl + "/web/diary/findDiaryById.do",
	dairy_download : tool.baseUrl + "/web/diary/export.do",
	login : tool.baseUrl + "/web/login.do",
	changePwd : tool.baseUrl + "/web/sysUser/changePwd.do",
	changeSkin : tool.baseUrl + "/web/sysUser/changeSkin.do",
	getLoginUserInfo : tool.baseUrl + "/web/getInfo.do",
	getUUID : tool.baseUrl + "/web/getUUID.do",
	saveForDiary : tool.baseUrl + "/web/saveForDiary.do",
	getValidateCode : tool.baseUrl + "/web/getValidateCode.do",
	question_list : tool.baseUrl + "/web/question/list.do",
	question_add : tool.baseUrl + "/web/question/save.do",
	question_update : tool.baseUrl + "/web/question/update.do",
	question_detail : tool.baseUrl + "/web/question/findQuestionById.do",
	question_download : tool.baseUrl + "/web/question/export.do",
	gains_list : tool.baseUrl + "/web/gains/list.do",
	gains_add : tool.baseUrl + "/web/gains/save.do",
	gains_update : tool.baseUrl + "/web/gains/update.do",
	gains_detail : tool.baseUrl + "/web/gains/findGainsById.do",
	gains_download : tool.baseUrl + "/web/gains/export.do",
	plan_list : tool.baseUrl + "/web/plan/list.do",
	plan_add : tool.baseUrl + "/web/plan/save.do",
	plan_update : tool.baseUrl + "/web/plan/update.do",
	plan_detail : tool.baseUrl + "/web/plan/findPlanById.do",
	reminder_list : tool.baseUrl + "/web/reminder/list.do",
	reminder_add : tool.baseUrl + "/web/reminder/save.do",
	reminder_update : tool.baseUrl + "/web/reminder/update.do",
	reminder_detail : tool.baseUrl + "/web/reminder/findReminderById.do",

	assetlog_list : tool.baseUrl + "/web/assetLog/list.do",
	assetlog_add : tool.baseUrl + "/web/assetLog/save.do",
	assetlog_update : tool.baseUrl + "/web/assetLog/update.do",
	assetlog_detail : tool.baseUrl + "/web/assetLog/findById.do",
	assetCount_list : tool.baseUrl + "/web/assetLog/listCount.do",
	assetDay_list : tool.baseUrl + "/web/assetLog/listDayCount.do",

	bind : tool.baseUrl + "/web/bind.do",
	getVIPInfo : tool.baseUrl + "/web/sysUser/findSysUserById.do",
	changeMobile : tool.baseUrl + "/web/sysUser/changeMobile.do",
	vipInfo_save : tool.baseUrl + "/web/sysUser/update.do",
	getWxSign : '/web/jssdkConfig.do', // 获取微信签名
	mall_orderDetail : '/web/orderDetail.do',
	unionPay : '/web/unionpay/pay.do', // 银联支付接口
	aliPay : '/web/alipay/payHtml.do', // 支付宝支付接口
	wxPay : '/web/WXPay/preorder.do', // 微信支付接口
	downWxImg : "/web/js/media.do",

	findGoodInfoById : tool.baseUrl + "/web/orderGood/findById.do",
	findVipInfoById : tool.baseUrl + "/web/sysUser/findById.do",
	summitOrderUrl : tool.baseUrl + "/web/orderInfo/save.do",
	saveVipInfo : tool.baseUrl + "/web/sysUser/saveVipInfo.do",

}

tool.checkPhone = function checkPhone(val) {
	if (!(/^1[34578]\d{9}$/.test(val))) {
		return false;
	}
	return true;
}

tool.checkNum = function checkNum(val) {
	if (isNaN(val)) {
		return false;
	}
	return true;
}

function splitStrToP(str) {
	var retStr = "";
	var strs = new Array(); // 定义一数组
	strs = str.split("\n"); // 字符分割
	for (i = 0; i < strs.length; i++) {
		retStr += "<p>" + strs[i] + "<p>" // 分割后的字符输出
	}
	return retStr;
}
function toMoney(x) {
	var f = parseFloat(x);
	if (isNaN(f)) {
		return "";
	}
	var f = Math.round(x * 100) / 100;
	var s = f.toString();
	var rs = s.indexOf('.');
	if (rs < 0) {
		rs = s.length;
		s += '.';
	}
	while (s.length <= rs + 2) {
		s += '0';
	}
	return s;
}
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};