var appInfo = {
	leftPanel : false
}
$(function() {
	$("#headImage").attr("src", "../../../assets/image/Tulips.jpg");
	loadInfo();
	$(".cm-input").attr("readonly","readonly");
	$(".cm-select").attr("disabled","disabled");
});

function loadInfo() {
	$.ajax({
		url : tool.reqUrl.getVIPInfo,
		type : 'POST',
		success : function(data) {
			if (data.retcode == "0") {
				var vo=data.vipInfo;
				$("#stypeType").val(vo.skin);
				$("#c_name").val(vo.realname);
				$("#c_gender").val(vo.gender==''?"1":vo.gender);
				$("#c_birthdate").val(vo.birthdate);
				$("#c_email").val(vo.email);
				$("#c_signature").val(vo.signature);
			}
		},
		complete : function() {
		}
	});
}
function changeStyle() {
	var styleType = $("#stypeType").val();
	$.ajax({
		url : tool.reqUrl.changeSkin,
		type : 'POST',
		data : {
			skin : styleType
		},
		success : function(data) {
			if (data.retcode == "0") {
				location.reload(true);
			} else {
				msg.info(data.retmsg);
			}
		},
		complete : function() {
		}
	});
}
/**
 * 侧栏显示控制
 */
function showLeftPanal(dvl) {

	if (!appInfo.leftPanel) {
		$("#" + dvl).show();
		appInfo.leftPanel = true;
	} else {
		$("#" + dvl).hide();
		appInfo.leftPanel = false;
	}

}
function editInfo(editFlag) {
	if (editFlag) {
		$(".cm-input").removeAttr("readonly");
		$(".cm-select").removeAttr("disabled");
		$("#edit").hide();
		$("#checkEidt").show();
		$("#stypeTypeLi").hide();
		return;
	}
	
	
	if($.trim($("#c_name").val())==''){
		msg.info("姓名不能为空");
		return;
	}
	if($.trim($("#c_email").val())==''){
		msg.info("邮箱不能为空");
		return;
	}
	if($.trim($("#c_birthdate").val())==''){
		msg.info("生日不能为空");
		return;
	}
	$(".cm-input").attr("readonly","readonly");
	$(".cm-select").attr("disabled","disabled");
	$("#edit").show();
	$("#stypeTypeLi").show();
	$("#checkEidt").hide();
	$.ajax({
		url : tool.reqUrl.vipInfo_save,
		type : 'POST',
		data : {
			realname : $("#c_name").val(),
			gender:$("#c_gender").val(),
			birthdate:$("#c_birthdate").val(),
			email:$("#c_email").val(),
			signature:$("#c_signature").val()
		},
		success : function(data) {
			if (data.retcode == "0") {
				
			} else {
				msg.info(data.retmsg);
			}
		},
		complete : function() {
		}
	});
}