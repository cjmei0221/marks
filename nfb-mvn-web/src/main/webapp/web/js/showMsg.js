
var msg={};
msg.info=function show_info(msg){
	msg_info(msg);
	//setTimeout(remove_msg,5000); 
}

msg.success=function show_success(msg){
	msg_success(msg);
	//setTimeout(remove_msg,5000); 
}

msg.error=function show_error(msg){
	alert("1");
	msg_error(msg);
	alert("2");
	//setTimeout(remove_msg,5000); 
	alert("6");
}
msg.remove=function remove_msg(){
	$("#showMsg").html("");
}
function msg_info(msg){
	var divStr='<div class="sui-msg msg-large msg-block msg-info" style="text-align:center;position:absolute;width:100%;" >'
	+'<div class="msg-con">'
	+msg
	+' </div>'
	+'<s class="msg-icon"></s>'
	+'</div>';
	$("#showMsg").html(divStr);
}

function msg_success(msg){
	var divStr='<div class="sui-msg msg-large msg-block msg-success" style="text-align:center;position:absolute;width:100%;" >'
	+'<div class="msg-con">'
	+msg
	+' </div>'
	+'<s class="msg-icon"></s>'
	+'</div>';
	$("#showMsg").html(divStr);
}


function msg_error(msg){
	var divStr='<div class="sui-msg msg-large msg-block msg-error" style="text-align:center;position:absolute;width:100%;" >'
	+'<div class="msg-con">'
	+msg
	+' </div>'
	+'<s class="msg-icon"></s>'
	+'</div>';
	$("#showMsg").html(divStr);
	alert("5");
	console.log($("#showMsg").html());
}
