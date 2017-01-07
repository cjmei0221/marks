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
		url : tool.reqUrl.question_detail,
		type : 'POST',
		data : {
			id:id
		},
		success : function(data) {
			if(data.retcode==0){
				var vo=data.question;
				$("#c_title").val(vo.question);
				$("#c_label").val(vo.labels);
				$("#c_content").val(vo.solution.replace(/<br\/>/g, "\n"));
				$("input[name='c_lvl'][value="+vo.lvl+"]").attr("checked","checked"); 
				
				$("label").removeClass("checked");
				$("."+vo.lvl).addClass("checked"); 
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
		if(trim($("#c_title").val())==''){
			msg.info("问题不能为空");
			return;
		}
	}else{
		if(trim($("#c_content").val())=='' && trim($("#c_title").val())==''){
			/*msg.info("您还未添加任何内容哦");*/
			return;
		}
	}
	var reqUrl=appInfo.formStatus=="edit"?tool.reqUrl.question_update:tool.reqUrl.question_add;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data:{
			id:id,
			question:$("#c_title").val(),
			solution:$("#c_content").val(),
			lvl:$('input[name="c_lvl"]:checked').val(),
			labels:$("#c_label").val()
		},
		success : function(data) {
			if(data.retcode==0){	
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
			if(data.retcode==0){
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