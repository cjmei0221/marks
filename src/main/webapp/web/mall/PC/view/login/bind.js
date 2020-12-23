$(function() {
	
});

function resetForm() {
	$("#username").val("");
	$("#bind_mobile").val("");
	$("#birthday").val("");
}

function summitForm() {
	var bind_mobile = $("#bind_mobile").val();
	if (bind_mobile == '') {
		msg.info("手机号码为空");
		return false;
	}
	if(!tool.checkPhone(bind_mobile)){
		msg.info("手机号码格式错误");
		return false;
	}
	$("#bind_mobile").val("");
	$.ajax({
		url : tool.reqUrl.saveVipInfo,
		type : 'POST',
		data : {
			bind_mobile : bind_mobile,
			username : $("#username").val(),
			gender:$('input[name="gender"]:checked').val(),
			birthday:$("#birthday").val()
		},
		success : function(data) {
			if (data.retcode == "0") {
				msg.info("保存成功");
				resetForm();
			} else {
				msg.info(data.retmsg);
			}
		},
		complete : function() {
			
		}
	});
}