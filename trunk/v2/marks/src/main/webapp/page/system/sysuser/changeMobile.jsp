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
		<p class="nav-header-cls">个人中心>>修改密码</p>


	</div>
	<div align="center">
		<form id="ff" name="ff" method="post">
			<fieldset>
				<legend align="left">重置手机</legend>
				<table style="width: 400px;">
					<tr>
						<th align="right">新手机号码:</th>
						<td><input class="easyui-validatebox"
							data-options="required:true" id="newPhone" name="newPhone"
							value=""></td>
					</tr>
					<tr>
						<th align="right">密码:</th>
						<td><input type="password" id="pwd" name="pwd"
							class="easyui-validatebox" data-options="required:true" value=""></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><a id="btnOK"
							name="btnOK" href="#" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-save'">保存</a></td>
					</tr>
				</table>

			</fieldset>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#newPhone").val("");
		$("#pwd").val("");
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
		var newPwd = $("#pwd").val();
		var reqUrl = top.window.urlBase + '/sysUser/updateMobile.do';
		$.ajax({
			type : "POST", //提交方式  
			url : reqUrl,//路径  
			data : {
				"newPhone" : $("#newPhone").val(),
				"newPwd" : Encrypt(newPwd)
			},//数据，这里使用的是Json格式进行传输  
			success : function(data) {//返回数据根据结果进行相应的处理  
				if (data.retcode == "0") {
					alert("修改成功,请重新登录");
					top.location.replace(window.urlBase + "/login.html");
					return;
				} else {
					$("#pwd").val("");
					$("#newPhone").val("");
					showMsg(data.retmsg);
				}
			}
		});
	}
</script>

</html>