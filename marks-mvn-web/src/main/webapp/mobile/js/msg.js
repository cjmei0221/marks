var msg={}
msg.info=function(msg){
	$("#tooltips").show();
	$("#tooltips").html(msg);
	setTimeout("hideMsg()",5000);  
}
function hideMsg(){
	$("#tooltips").hide();
	$("#tooltips").html("");
}

msg.confirm=function(msg){
	if(confirm(msg)){
        return true;
     }else{
        return false;
    }
}