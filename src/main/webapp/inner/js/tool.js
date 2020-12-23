var tool={};
tool.screenHeight=window.screen.height-300;
tool.availHeight=window.screen.availHeight-300;
tool.urlMenuOperate= top.window.urlBase + '/inner/sys/menuOperate.do'
tool.getUrlParams = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
tool.fillTemplate = function(tmpl, obj) {
	if (tmpl == null) {
		msg.error('tmpl is null,请检查"tmpl"是否为空');
	}
	var html = tmpl;
	for ( var key in obj) {
		var regexp = eval("/\{" + key + "\}/ig");
		html = html.replace(regexp, obj[key]);
	}
	return html;
};

function loadMenuOperator(){
	var menuid=tool.getUrlParams("menuid");
	var parms = "menuid=" +menuid;
	$.post(tool.urlMenuOperate, parms, function(data) {
		if (data.retcode == "0") {
			var operlist=data.operList;
			$('#operateBtns').html("");
			if(operlist.length>0){
				var icon='icon-edit';
				var mod='';
				for(var j=0;j<operlist.length;j++){
					if(operlist[j].operid=='query'){
						continue;
					}
					mod=operlist[j].operid;
					if(operlist[j].operid=='delete'){
						mod='del';
					}
					if(operlist[j].picicon !=null && operlist[j].picicon !=''){
						icon=operlist[j].picicon;
					}
					var htmlStr="<a id=\""+operlist[j].operid+"\" href=\"javascript:void(0)\" onclick=\""+mod+"();\" class=\"easyui-linkbutton menuBtnCls\" data-options=\"iconCls:'"+icon+"'\">"+operlist[j].opername+"</a>";
					$('#operateBtns').append($(htmlStr));
				}
				$.parser.parse($('#operateBtns'));
			}
		} else {
			showMsg(data.retmsg);
		}
	});
}
loadMenuOperator();