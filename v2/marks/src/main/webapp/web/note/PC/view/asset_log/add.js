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
		appInfo.formStatus = "add";
		getID();
		$("#c_tranTime").val(initTime());
	}
	$('#c_tranTime').datepicker().on("hide", function(e) {
		submitForm();
	});
});
function getDetail() {
	$.ajax({
		url : tool.reqUrl.assetlog_detail,
		type : 'POST',
		data : {
			id : id
		},
		success : function(data) {
			if (data.retcode == "0") {
				var vo = data.info;
				$("#c_tranTime").val(vo.tranTime);
				$("#c_tranAmount").val(vo.tranAmount);
				$("#c_fromer").val(vo.fromer);
				$("#c_toer").val(vo.toer);
				$("#c_remarks").val(vo.remarks);
				$("input[name='c_itemType'][value=" + vo.itemType + "]").attr(
						"checked", "checked");
				$("input[name='c_tranType'][value=" + vo.tranType + "]").attr(
						"checked", "checked");
				$("label").removeClass("checked");
				$("input[name='c_itemType'][value=" + vo.itemType + "]")
						.parent().addClass("checked");
				$("input[name='c_tranType'][value=" + vo.tranType + "]")
						.parent().addClass("checked");
			} else {
				msg.info("加载失败【" + data.retcode + "】");
			}
		},
		complete : function() {

		}
	});
}
function submitForm() {
	$("#c_tranAmount").val(toMoney($("#c_tranAmount").val()));
	if (appInfo.formStatus == "edit") {
		if (trim($("#c_tranAmount").val()) == '') {
			msg.info("问题不能为空");
			return;
		}
	} else {
		if (trim($("#c_tranAmount").val()) == '') {
			/* msg.info("您还未添加任何内容哦"); */
			return;
		}
	}
	var reqUrl = appInfo.formStatus == "edit" ? tool.reqUrl.assetlog_update
			: tool.reqUrl.assetlog_add;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data : {
			id : id,
			tranType : $('input[name="c_tranType"]:checked').val(),
			tranTime : $("#c_tranTime").val(),
			itemType : $('input[name="c_itemType"]:checked').val(),
			fromer : $("#c_fromer").val(),
			toer : $("#c_toer").val(),
			tranAmount : $("#c_tranAmount").val(),
			remarks : $("#c_remarks").val()
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
	var dateTime = curr_time.getFullYear();
	var monthVal = curr_time.getMonth() + 1 + "";
	dateTime += "-";
	if (monthVal.length < 2) {
		dateTime += "0" + monthVal;
	} else {
		dateTime += monthVal;
	}
	var dateVal = curr_time.getDate() + "";
	dateTime += "-";
	if (dateVal.length < 2) {
		dateTime += "0" + dateVal;
	} else {
		dateTime += dateVal;
	}
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