var id=tool.getUrlParams('id');
$(function() {
	getDetail();
});

function getDetail(){
	$.ajax({
		url : tool.reqUrl.question_detail,
		type : 'POST',
		data : {
			id:id
		},
		success : function(data) {
			if(data.retcode==0){
				var vo=data.question;
				$("#c_title").html(vo.question);
				$("#c_createtime").html(vo.createtime);
				$("#c_lvl").html(vo.lvlName);
				$("#c_label").html(vo.labels);
				$("#c_content").html(splitStrToP(vo.solution));
			}else{
				msg.info("加载失败【"+data.retcode+"】");
			}
		},
		complete : function() {
			
		}
	});
}
function splitStrToP(str){
	var retStr="";
	var strs= new Array(); //定义一数组 
	strs=str.split("<br/>"); //字符分割 
	for (i=0;i<strs.length ;i++ ) 
	{ 
		retStr +="<p>"+strs[i]+"<p>" //分割后的字符输出 
	} 
	return retStr;
}
function toEdit(){
	location.replace("./add.html?id="+id);
}