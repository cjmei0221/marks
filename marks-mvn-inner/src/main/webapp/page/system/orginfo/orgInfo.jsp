<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- OrgInfo.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/orgInfo.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">组织管理</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				
				<tr>
					<td><wt:button /></td>
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
					<th>组织ID</th>
					<td><input id="orgid" name="orgid" class="easyui-validatebox"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th>组织名称</th>
					<td><input id="orgname" name="orgname"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>上级组织</th>
					<td><input id="parentName" name="parentName"
						class="easyui-validatebox" data-options="required:true" readonly="readonly"><input
						type="hidden" id="parentId" name="parentId"></td>
				</tr>
				<tr>
					<th>启用标识</th>
					<td><select id="useflag" class="easyui-combobox"
						name="useflag" style="width: 170px;" data-options="required:true">
							<option value="1">启用</option>
							<option value="0">禁用</option>
					</select></td>
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
<script src="js/orgInfo.js"></script>
</html>
