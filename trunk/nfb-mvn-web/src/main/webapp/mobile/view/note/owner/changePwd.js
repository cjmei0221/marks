$(function() {
	$("#isLoading").show();
});

function summitForm() {
	var c_oldPwd = $("#c_oldPwd").val();
	if (c_oldPwd == '') {
		$.toast("旧密码为空");
		return false;
	}
	var c_newPwd = $("#c_newPwd").val();
	if (c_newPwd == '') {
		$.toast("新密码为空");
		return false;
	}
	var c_newPwd2 = $("#c_newPwd2").val();
	if (c_newPwd2 == '') {
		$.toast("确认密码为空");
		return false;
	}
	if (c_newPwd != c_newPwd2) {
		$.toast("新密码与确认密码不一致");
		return false;
	}
	$("#isLoading").hide();
	$.ajax({
		url : '../data/dairyData.json',
		type : 'POST',
		data : {
			oldPwd : _this.c_oldPwd,
			newPwd : _this.c_newPwd,
			newPwd2 : _this.c_newPwd2
		},
		success : function(data) {
			
			location.href = './login.html?' + "_t=" + new Date().getTime();
		},
		complete : function() {
			// 重置加载flag
			$("#isLoading").show();
		}
	});
}
