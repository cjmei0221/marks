$(function() {
	
});

function resetForm() {
	$("#c_mobile").val("");
	$("#c_password").val("");
}

function summitForm() {
	var c_mobile = $("#c_mobile").val();
	if (c_mobile == '') {
		msg.error("手机号码为空");
		return false;
	}
	var c_password = $("#c_password").val();
	if (c_password == '') {
		msg.error("密码为空");
		return false;
	}
	$.ajax({
		url : tool.reqUrl.login,
		type : 'POST',
		data : {
			mobile : c_mobile,
			password : Encrypt(c_password)
		},
		success : function(data) {
			if(data.retcode==0){
				location.href = '../dairy/list.html?' + "_t="
				+ new Date().getTime();
			}else{
				msg.error(data.retmsg);
			}
			
		},
		complete : function() {

		}
	});
}