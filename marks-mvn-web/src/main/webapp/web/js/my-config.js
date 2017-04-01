$(document).ajaxComplete(function(event, xhr, settings) {	
  	var data;	  	
  	if (settings.dataType=="script" || settings.dataType=="html"){
  		return;
  	}
  	if(xhr.responseText){
  		data = $.parseJSON(xhr.responseText);
  		if(data && data.retcode=="-101"){
  			alert("访问已失效，请关闭重新进入！");
    		return;
  			top.location.replace(window.urlBase + "/login.html");
  		}else if(data && data.retcode=="-100"){
  			alert("用户已失效，请重新登录！");
    		location.replace(tool.baseUrl+"/web/view/note/owner/login.html?ele="+tool.getCurEle());
  		}
  	}
});