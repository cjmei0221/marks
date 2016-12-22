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
		$.toast("手机号码为空");
		return false;
	}
	var c_password = $("#c_password").val();
	if (c_password == '') {
		$.toast("密码为空");
		return false;
	}
	$("#isLoading").hide();
	$.ajax({
		url : '../data/dairyData.json',
		type : 'POST',
		data : {
			mobile : c_mobile,
			password : c_password
		},
		success : function(data) {
			location.href = '../dairy/list.html?' + "_t="
					+ new Date().getTime();
		},
		complete : function() {
			$("#isLoading").show();
		}
	});
}