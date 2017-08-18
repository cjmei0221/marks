var id=tool.getUrlParams('id');
$(function() {
	getDetail();
});

function getDetail(){
	$.ajax({
		url : tool.reqUrl.reminder_detail,
		type : 'POST',
		data : {
			id:id
		},
		success : function(data) {
			if(data.retcode=="0"){
				var vo=data.reminder;
				console.log(vo);
				$("#c_createtime").html(vo.createtime);
				$("#completeTxt").html(splitStrToP(vo.remind_content));
				$("#planTxt").html(splitStrToP(vo.remind_date));
			}else{
				msg.info("加载失败【"+data.retcode+"】");
			}
		},
		complete : function() {
			
		}
	});
}
function toEdit(){
	location.replace("./add.html?id="+id);
}