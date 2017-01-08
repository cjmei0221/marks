var appInfo = {
	leftPanel : false
}
$(function() {
	$("#headImage").attr("src", "../../../assets/image/Tulips.jpg");
	loadInfo();
});

function loadInfo() {
	$.ajax({
		url : tool.reqUrl.getVIPInfo,
		type : 'POST',
		success : function(data) {
			if (data.retcode == 0) {
				$("#stypeType").val(data.loginUser.skin);
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
			if (data.retcode == 0) {
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