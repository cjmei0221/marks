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
		msg.info("手机号码为空");
		return false;
	}
	var c_password = $("#c_password").val();
	if (c_password == '') {
		msg.info("密码为空");
		return false;
	}
	$("#isLoading").hide();
	$.ajax({
		url : tool.reqUrl.login,
		type : 'POST',
		data : {
			mobile : c_mobile,
			password : Encrypt(c_password)
		},
		success : function(data) {
			if(data.retcode==0){
				location.replace('../dairy/list.html?' + "_t="
						+ new Date().getTime());
			}else if(data.retcode==4003){
				if(msg.confirm("您尚未绑定，去绑定吗？")){
					location.replace("./bind.html");
				}
			}else{
				msg.info(data.retmsg);
			}
		},
		complete : function() {
			$("#isLoading").show();
		}
	});
}