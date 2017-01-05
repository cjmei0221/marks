$(function() {
	$("#headImage").attr("src", "../../../assets/image/Tulips.jpg");
	loadInfo();
});

function loadInfo(){
	$.ajax({
		url : tool.reqUrl.getLoginUserInfo,
		type : 'POST',
		success : function(data) {
			console.log(data.loginUser.skin);
			$("#stypeType").val(data.loginUser.skin);
		},
		complete : function() {
		}
	});
}
function changeStyle(){
	var styleType=$("#stypeType").val();
	$.ajax({
		url : tool.reqUrl.changeSkin,
		type : 'POST',
		data : {
			skin : styleType
		},
		success : function(data) {
			if(data.retcode==0){
				location.reload(true);    
			}else{
				msg.info(data.retmsg);
			}
		},
		complete : function() {
		}
	});
}