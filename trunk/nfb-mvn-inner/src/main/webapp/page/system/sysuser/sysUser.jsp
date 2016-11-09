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
		<p class="nav-header-cls">用户管理>>用户管理</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td><button type="button" id="doSearch" data-oper="query"
							style="cursor: pointer;">查询</button>
				</tr>
				<tr>
					<td colspan="7"><wt:button /></td>
				</tr>
			</table>
		</div>
		<table id="tbList">
		</table>
	</div>

	<div id="editWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 400px; height: 300px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<table class="out-win-cls">
				<tr>
					<th>登录ID</th>
					<td><input id="userid" name="userid"
						class="easyui-validatebox" data-options="required:true"
						maxlength="25"></td>
				</tr>
				<tr>
					<th>用户名称</th>
					<td><input id="username" name="username"
						class="easyui-validatebox" data-options="required:true"
						maxlength="50"></td>
				</tr>
				<tr id="passwordTr">
					<th>用户密码</th>
					<td><input id="password" name="password" type="password"
						 data-options="required:true"
						maxlength="20"></td>
				</tr>

				<tr>
					<th>激活标识</th>
					<td><select id="activeFlag" class="easyui-combobox"
						name="activeFlag" style="width: 170px;" data-options="required:true">
						<option value="1">激活</option>
							<option value="0">禁用</option>
							

					</select></td>
				</tr>

				<tr>
					<th>口令</th>
					<td><input id="token" name="token" class="easyui-validatebox"
						data-options="required:true"></td>
				</tr>


				<tr>
					<td colspan="2" style="text-align: center"><input
						type="button" id="btnOK" name="btnOK" value=" 保 存 " />
						&nbsp;&nbsp;&nbsp; <input type="button" id="btnCancel"
						name="btnCancel" value=" 取 消 " /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
<script src="js/sysUser.js"></script>
</html>
