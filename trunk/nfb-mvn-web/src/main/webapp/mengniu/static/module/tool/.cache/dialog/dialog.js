/*TMODJS:{"version":7,"md5":"a49988205e109d252f5ca46564c28858"}*/
template('dialog/dialog',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,msg=$data.msg,num=$data.num,$out='';$out+='<div id="modalDialog" class="modalDialog f-14"> <div class="dialogMain"> <div class="msg">';
$out+=$escape(msg);
$out+='</div> <div class="dialogBtnGroup txtCenter"> ';
if(num > 1){
$out+=' <a href="javascript:void(0)" id="dialog-cancelBtn" class="dialog-cancelBtn">取消</a> ';
}
$out+=' <a href="javascript:void(0)" id="dialog-confirmBtn" class="dialog-confirmBtn">确认</a> </div> </div> </div>';
return new String($out);
});