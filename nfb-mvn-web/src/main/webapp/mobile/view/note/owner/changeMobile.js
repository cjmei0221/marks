$(function() {
	$("#isLoading").show();
});

function resetForm() {
	$("#c_mobile").val("");
	$("#c_password").val("");
}

function summitForm() {
	var c_mobile = $("#c_mobile").val();
	if (c_mobile == '') {
		msg.info("新手机号码为空");
		return false;
	}
	if (!tool.checkPhone(c_mobile)) {
		msg.info("新手机号码格式错误");
		return false;
	}
	var c_password = $("#c_password").val();
	if (c_password == '') {
		msg.info("密码为空");
		return false;
	}
	$("#isLoading").hide();
	$.ajax({
		url : tool.reqUrl.changeMobile,
		type : 'POST',
		data : {
			mobile : c_mobile,
			password : Encrypt(c_password)
		},
		success : function(data) {
			if (data.retcode == 0) {
				location.replace('../login/login.html?ele=owner' + "&_t="
						+ new Date().getTime());
				return;
			} else {
				msg.info(data.retmsg);
			}
		},
		complete : function() {
			$("#isLoading").show();
		}
	});
}