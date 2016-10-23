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
</head>
	
	<body>
	
	<div id="mainPanel">
		<p class="nav-header-cls">用户管理>>用户管理</p>
		<div id="tb" style="padding: 5px 0;">
		<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword" style="width:260px;" placeholder="关键字"/></td>
					<td><button type="button" id="doSearch" data-oper="query" style="cursor: pointer;">查询</button>
				</tr>
				 <tr>
					<td colspan="7">
						<wt:button />
					</td>
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
			<input type="hidden"  id="userid" name="userid">
			<table class="out-win-cls">
				<tr><th>上次登录时间</th><td><input id="lastLoginTime" name="lastLoginTime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>用户类型</th><td><input id="userType" name="userType" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>openid</th><td><input id="openid" name="openid" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>口令</th><td><input id="token" name="token" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>公司ID</th><td><input id="companyId" name="companyId" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>组织ID</th><td><input id="orgid" name="orgid" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>创建者</th><td><input id="creator" name="creator" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>更新时间</th><td><input id="updatetime" name="updatetime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>创建时间</th><td><input id="createtime" name="createtime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>激活标识</th><td><input id="activeFlag" name="activeFlag" class="easyui-numberbox" data-options="required:true"></td></tr><tr><th>绑定手机号码</th><td><input id="bind_mobile" name="bind_mobile" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>用户密码</th><td><input id="password" name="password" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>用户名称</th><td><input id="username" name="username" class="easyui-validatebox" data-options="required:true"></td></tr>
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
