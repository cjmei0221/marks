var id=tool.getUrlParams('id');
var appInfo={
		formStatus:"add",
}
$(function() {
	if(id !=null && id !='undefined' ){
		//编辑
		appInfo.formStatus="edit";
		getDetail();
		$(".completeDiv").show();
	}else{
		appInfo.formStatus="add";
		getID();
		$("#createtime").html(initTime());
		$(".completeDiv").hide();
	}
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
				$("#planTxt").val(vo.planTxt);
				$("#completeTxt").val(vo.completeTxt);
				$("input[name='c_lvl'][value="+vo.isComplete+"]").attr("checked","checked"); 
				
				$("label").removeClass("checked");
				$("."+vo.isComplete).addClass("checked"); 
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
		
	}else{
		if(trim($("#planTxt").val())=='' && trim($("#planTxt").val())==''){
			msg.info("计划不能为空");
			return;
		}
	}
	var reqUrl=appInfo.formStatus=="edit"?tool.reqUrl.plan_update:tool.reqUrl.plan_add;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data:{
			id:id,
			planTxt:$("#planTxt").val(),
			completeTxt:$("#completeTxt").val(),
			isComplete:$('input[name="c_lvl"]:checked').val()
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