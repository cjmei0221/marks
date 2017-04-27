<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- SysUser.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sysUser.css" />

<%@include file="../../include/common.jsp"%>
<script type="text/javascript" src="../../../js/encrypt/aes.js"></script>
<script type="text/javascript" src="../../../js/encrypt/mode-ecb.js"></script>
<script type="text/javascript" src="../../../js/encrypt/aes_u.js"></script>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">个人中心>>重置手机</p>
	</div>
	<div align="center">
		<form id="ff" name="ff" method="post">
			<fieldset>
				<legend align="left">重置手机</legend>
				<table>
					<tr>
						<th align="right">旧密码:</th>
						<td><input type="password" id="oldPhome" name="oldPhome"
							value="" class="easyui-validatebox" data-options="required:true"></td>
					</tr>
					<tr>
						<th align="right">新密码:</th>
						<td><input type="password" id="newPhome" name="newPhome"
							value="" class="easyui-validatebox" data-options="required:true"></td>
					</tr>
					<tr>
						<th align="right">确认密码:</th>
						<td><input type="password" id="newPhome2" name="newPhome2"
							value="" class="easyui-validatebox" data-options="required:true"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><a id="btnOK"
							name="btnOK" href="javascript:;" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-save'">保存</a></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#oldPhome").val("");
		$("#newPhome").val("");
		$("#newPhome2").val("");
		$("#btnOK").on("click", function() {
			formSubmit();
		});
	});
	/**
	 * 保存菜单
	 */
	function formSubmit() {
		if (!$('#ff').form('validate')) {
			showMsg("表单校验不通过");
			return;
		}
		var oldPwd = $("#oldPhome").val();
		var newPwd = $("#newPhome").val();
		var newPwd2 = $("#newPhome2").val();
		if (newPwd != newPwd2) {
			showMsg("确认密码与新密码不一致");
			return;
		}
		var reqUrl = top.window.urlBase + '/inner/sysUser/updatePwd.do';
		var createtime=initKey();
		$.ajax({
			type : "POST", //提交方式  
			url : reqUrl,//路径  
			data : {
				"newPwd" : Encrypt(newPwd,createtime),
				"oldPwd" : Encrypt(oldPwd,createtime),
				createdate:createtime
			},//数据，这里使用的是Json格式进行传输  
			success : function(data) {//返回数据根据结果进行相应的处理  
				if (data.retcode == "0") {
					alert("修改成功,请重新登录");
					top.location.replace(window.urlBase + "/login.html");
					return;
				} else {
					showMsg(data.retmsg);
				}
			}
		});
	}
</script>
</html>