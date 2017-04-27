$(function() {
	$("#isLoading").show();
});

function summitForm() {
	var c_oldPwd = $("#c_oldPwd").val();
	if (c_oldPwd == '') {
		msg.info("旧密码为空");
		return false;
	}
	var c_newPwd = $("#c_newPwd").val();
	if (c_newPwd == '') {
		msg.info("新密码为空");
		return false;
	}
	var c_newPwd2 = $("#c_newPwd2").val();
	if (c_newPwd2 == '') {
		msg.info("确认密码为空");
		return false;
	}
	if (c_newPwd != c_newPwd2) {
		msg.info("新密码与确认密码不一致");
		return false;
	}
	$("#isLoading").hide();
	var createtime=initKey();
	$.ajax({
		url : tool.reqUrl.changePwd,
		type : 'POST',
		data : {
			oldPwd : Encrypt(c_oldPwd,createtime),
			newPwd : Encrypt(c_newPwd,createtime),
			createdate:createtime
		},
		success : function(data) {
			if(data.retcode=="0"){
				location.href = '../login/login.html?ele=owner' + "&_t=" + new Date().getTime();
			}else{
				msg.info(data.retmsg);
			}
		},
		complete : function() {
			// 重置加载flag
			$("#isLoading").show();
		}
	});
}
