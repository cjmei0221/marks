var id = "";
var appInfo = {
	formStatus : "add",
}
$(function() {
	appInfo.formStatus = "add";
	getID();
	$("#t_title").html("添加");
	$("#createtime").val(initTime());

});

function getID() {
	id = initTimeID();
	$.ajax({
		url : tool.reqUrl.getUUID,
		type : 'GET',
		success : function(data) {
			if (data.retcode == "0") {
				id = data.id;
			}
		},
		complete : function() {

		}
	});
}
function summitForm() {
	if ($.trim($("#c_mobile").val()) == '') {
		 msg.info("手机号码不能为空哦"); 
		return;
	}
	if ($.trim($("#c_content").val()) == '') {
		//msg.info("您还未添加任何内容哦");
		return;
	}
	var reqUrl = tool.reqUrl.saveForDiary;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data : {
			id : id,
			title : $("#c_title").val(),
			content : $("#c_content").val(),
			mobile:$("#c_mobile").val()
		},
		success : function(data) {
			if (data.retcode == "0") {
				/* location.href="./list.html"; */
			} else {
				msg.info("请求失败【" + data.retcode + "】");
			}
		},
		complete : function() {
			// 重置加载flag
			$("#isLoading").hide();
		}
	});
}
function initTime() {
	var curr_time = new Date();
	var dateTime = curr_time.getFullYear() + "-";
	dateTime += curr_time.getMonth() + 1 + "-";
	dateTime += curr_time.getDate() + " ";
	dateTime += curr_time.getHours() + ":";
	dateTime += curr_time.getMinutes() + ":";
	dateTime += curr_time.getSeconds();
	return dateTime;
}
function initTimeID() {
	var curr_time = new Date();
	var dateTime = curr_time.getFullYear();
	dateTime += curr_time.getMonth() + 1;
	dateTime += curr_time.getDate();
	dateTime += curr_time.getHours();
	dateTime += curr_time.getMinutes();
	dateTime += curr_time.getSeconds();
	return dateTime;
}