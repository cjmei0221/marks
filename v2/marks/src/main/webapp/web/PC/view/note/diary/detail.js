var id=tool.getUrlParams('id');
$(function() {
	getDetail();
});

function getDetail(){
	$.ajax({
		url : tool.reqUrl.dairy_detail,
		type : 'POST',
		data : {
			id:id
		},
		success : function(data) {
			if(data.retcode=="0"){
				$("#c_title").html(data.diary.title);
				$("#c_createtime").html(data.diary.createtime);
				$("#c_content").html(splitStrToP(data.diary.content));
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