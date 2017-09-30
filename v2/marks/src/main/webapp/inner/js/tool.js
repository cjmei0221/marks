var tool={};
tool.urlMenuOperate= top.window.urlBase + '/inner/sys/menuOperate.do'
tool.getUrlParams = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

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