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
					<td>用户类型
						<ul id="s_role" name="s_role" class="easyui-combobox"
							data-options="valueField:'roleid',textField:'rolename',url:'<%=request.getContextPath()%>/sysRole/combo.do'"
							style="width: 200px"></ul>
					</td>
					<td>所属组织
						<ul id="ssorgid" name="ssorgid" class="easyui-combotree"
							data-options="url:'<%=request.getContextPath()%>/orgInfo/tree.do'"
							style="width: 200px"></ul>
					</td>
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
			<input type="hidden" id="userid" name="userid">
			<table class="out-win-cls">
				<tr>
					<th>用户类型</th>
					<td><input
						id="roleid" name="roleid" class="easyui-combobox"
						data-options="required:true,valueField:'roleid',textField:'rolename',url:'<%=request.getContextPath()%>/sysRole/combo.do'"
						style="width: 175px"></td>
				</tr>
				<tr>
					<th>所属组织</th>
					<td><a href="javascript:;" id="chooseRole">选择组织</a></td>
				</tr>
				<tr>
					<th>手机号码</th>
					<td><input id="bind_mobile" name="bind_mobile"
						class="easyui-numberbox"
						data-options="required:true,min:10000000000,precision:0"></td>
				</tr>
				<tr>
					<th>用户名称</th>
					<td><input id="username" name="username"
						class="easyui-validatebox" data-options="required:true"
						maxlength="50"></td>
				</tr>
				<tr>
					<th>激活标识</th>
					<td><select id="activeFlag" class="easyui-combobox"
						name="activeFlag" style="width: 170px;"
						data-options="required:true">
							<option value="1">启用</option>
							<option value="0">禁用</option>


					</select></td>
				</tr>

				<tr style="display: none;">
					<th>口令</th>
					<td><input id="token" name="token" class="easyui-validatebox"></td>
				</tr>


				<tr>
					<td colspan="2" style="text-align: center"><input
						type="button" id="btnOK" name="btnOK" value=" 保 存 " />
						&nbsp;&nbsp;&nbsp; <input type="button" id="btnCancel"
						name="btnCancel" value=" 取 消 " /></td>
				</tr>
			</table>

			<div id="roleWin" class="easyui-window"
				data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false,inline:false"
				style="width: 800px; height: 500px; padding: 10px;">
				<table id="roleList"></table>
				已选：
				<div id="inputDiv" style="height: 80px;">
					公司：<input id="companyId" name="companyId" readonly="readonly">
					<div id="inputRoleDiv"></div>
					<div align="center">
						<input type="button" id="roleBtn" name="roleBtn" value="确定" />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
<script src="js/sysUser.js"></script>
</html>
