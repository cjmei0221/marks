var id=tool.getUrlParams('id');
var appInfo={
		formStatus:"add",
}
$(function() {
	if(id !=null && id !='undefined' ){
		//编辑
		appInfo.formStatus="edit";
		getDetail();
	}else{
		appInfo.formStatus="add";
		getID();
		$("#createtime").html(initTime());
	}
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
				$("#c_title").val(data.diary.title);
				$("#createtime").html(data.diary.createtime);
				$("#c_content").val(data.diary.content.replace(/<br\/>/g, "\n"));
			}else{
				msg.info("加载失败【"+data.retcode+"】");
			}
		},
		complete : function() {
			
		}
	});
}
function submitForm(){
	if(appInfo.formStatus=="edit"){
		if(trim($("#c_content").val())=='' && trim($("#c_title").val())==''){
			msg.info("您还未添加任何内容哦");
			return;
		}
	}else{
		if(trim($("#c_content").val())=='' && trim($("#c_title").val())==''){
			/*msg.info("您还未添加任何内容哦");*/
			return;
		}
	}
	var reqUrl=appInfo.formStatus=="edit"?tool.reqUrl.dairy_update:tool.reqUrl.dairy_add;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data:{
			id:id,
			title:$("#c_title").val(),
			content:$("#c_content").val()
		},
		success : function(data) {
			if(data.retcode=="0"){	
				/*location.href="./list.html";*/
			}else{
				msg.info("加载失败【"+data.retcode+"】");
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

function getID(){
	id=initTimeID();
	$.ajax({
		url : tool.reqUrl.getUUID,
		type : 'GET',
		success : function(data) {
			if(data.retcode=="0"){
				id=data.id;
			}
		},
		complete : function() {
			
		}
	});
}
function initTimeID() {
	var curr_time = new Date();
	var dateTime = curr_time.getFullYear() ;
	dateTime += curr_time.getMonth() + 1;
	dateTime += curr_time.getDate();
	dateTime += curr_time.getHours() ;
	dateTime += curr_time.getMinutes();
	dateTime += curr_time.getSeconds();
	return dateTime;
}