/*TMODJS:{"version":2,"md5":"b9f7427462ad80d356d2fd00d8e51ce0"}*/
template('dialog/dialog',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,msg=$data.msg,$out='';$out+='<div id="modalDialog" class="modalDialog f-14"> <div class="dialogMain"> <div class="msg">';
$out+=$escape(msg);
$out+='</div> <div class="btnGroup txtCenter"> <a href="javascript:void(0)" id="dialog-cancelBtn" class="dialog-cancelBtn">取消</a> <a href="javascript:void(0)" id="dialog-confirmBtn" class="dialog-confirmBtn">确认</a> </div> </div> </div>';
return new String($out);
});