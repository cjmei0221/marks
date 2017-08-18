var id = tool.getUrlParams('id');
var appInfo = {
	formStatus : "add",
}
$(function() {
	if (id != null && id != 'undefined') {
		// 编辑
		appInfo.formStatus = "edit";
		getDetail();
	} else {
		var curr_time = new Date();
		var dateTime = curr_time.getFullYear();
		var monthVal=curr_time.getMonth() + 1+"";
		dateTime += "-";
		if(monthVal.length<2){
			dateTime += "0"+monthVal;
		}else{
			dateTime += monthVal;
		}
		var dateVal=curr_time.getDate()+"";
		dateTime += "-";
		if(dateVal.length<2){
			dateTime += "0"+dateVal;
		}else{
			dateTime += dateVal;
		}
		$('#remindDate').val(dateTime);
		$('#remindDate').datepicker({
			startDate : dateTime,
			size : "small"
		});
		appInfo.formStatus = "add";
		getID();
		$("#createtime").html(initTime());
	}
});

function getDetail() {
	$.ajax({
		url : tool.reqUrl.reminder_detail,
		type : 'POST',
		data : {
			id : id
		},
		success : function(data) {
			if (data.retcode == "0") {
				var vo = data.reminder;
				$("#planTxt").val(vo.remind_content);
				$("#remindDate").val(vo.remind_date);
			} else {
				msg.info("加载失败【" + data.retcode + "】");
			}
		},
		complete : function() {

		}
	});
}
function submitForm() {

	if (trim($("#planTxt").val()) == '' && trim($("#planTxt").val()) == '') {
		msg.info("内容不能为空");
		return;
	}

	var reqUrl = appInfo.formStatus == "edit" ? tool.reqUrl.reminder_update
			: tool.reqUrl.reminder_add;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data : {
			id : id,
			remind_content : $("#planTxt").val(),
			remind_date : $("#remindDate").val(),
			remind_type:0
		},
		success : function(data) {
			if (data.retcode == "0") {
				/* location.href="./list.html"; */
			} else {
				msg.info("加载失败【" + data.retcode + "】");
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