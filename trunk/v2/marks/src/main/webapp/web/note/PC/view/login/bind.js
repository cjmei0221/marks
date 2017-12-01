$(function() {
	changeImg();
});

function resetForm() {
	$("#c_mobile").val("");
	$("#c_password").val("");
	$("#c_password2").val("");
	$("#c_check").val("");
	changeImg();
}

function summitForm() {
	var c_mobile = $("#c_mobile").val();
	if (c_mobile == '') {
		msg.info("手机号码为空");
		return false;
	}
	if(!tool.checkPhone(c_mobile)){
		msg.info("手机号码格式错误");
		return false;
	}
	var c_check = $("#c_check").val();
	if (c_check == '') {
		msg.info("验证码为空");
		return false;
	}
	var c_password = $("#c_password").val();
	if (c_password == '') {
		msg.info("密码为空");
		return false;
	}
	var c_password2 = $("#c_password2").val();
	if (c_password2 == '') {
		msg.info("确认密码为空");
		return false;
	}
	if (c_password != c_password2) {
		msg.info("密码与确认密码不一致");
		return false;
	}
	$("#isLoading").hide();
	$.ajax({
		url : tool.reqUrl.bind,
		type : 'POST',
		data : {
			mobile : c_mobile,
			password : Encrypt(c_password),
			code:$("#c_check").val()
		},
		success : function(data) {
			if (data.retcode == "0") {
				location.replace('./login.html?' + "_t="
						+ new Date().getTime());
			} else {
				changeImg();
				msg.info(data.retmsg);
			}
		},
		complete : function() {
			$("#isLoading").show();
		}
	});
}

// 刷新图片
function changeImg() {
	var timestamp = (new Date()).valueOf();
	var reqSrc = tool.reqUrl.getValidateCode + "?width=60&height=25&tamp="+timestamp;
	$("#imgObj").attr("src",  reqSrc);
}