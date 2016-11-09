<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- SysRole.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sysRole.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">角色管理>>角色管理</p>
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
		style="width: 500px; height: 300px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<input type="hidden" id="roleid" name="roleid">
				<table>

					<tr>
						<th align="right">角色名称&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="rolename" name="rolename"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px"></td>
					</tr>
					<tr>
						<th align="right">公司&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><ul id="orgid" name="orgid" class="easyui-combotree"
								data-options="url:'<%=request.getContextPath()%>/orgInfo/tree.do'"
								style="width: 200px"></ul></td>
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
	</div>

	<div id="funcWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 800px; height: 500px; padding: 10px;">
		<form id="funcff" name="funcff" method="post">
			<input type="hidden" id="roleid" name="roleid">
			<table id="tbFuncList">
			</table>
		</form>
	</div>

</body>
<script src="js/sysRole.js"></script>
</html>
