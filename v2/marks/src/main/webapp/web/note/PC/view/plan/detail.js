var id=tool.getUrlParams('id');
$(function() {
	getDetail();
});

function getDetail(){
	$.ajax({
		url : tool.reqUrl.plan_detail,
		type : 'POST',
		data : {
			id:id
		},
		success : function(data) {
			if(data.retcode=="0"){
				var vo=data.plan;
				
				$("#c_createtime").html(vo.createtime);
				var isTxt="";
				if (vo.isComplete == 'noComplete') {
					isTxt= "未完成";
				}else if(o.isComplete == 'partially'){
					isTxt= "部分完成";
				}else{
					isTxt= "全部完成";
				}
				$("#c_lvl").html(isTxt);
				$("#planTxt").html(splitStrToP(vo.planTxt));
				$("#completeTxt").html(splitStrToP(vo.completeTxt));
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