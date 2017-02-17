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
		<p class="nav-header-cls">用户类型>>用户类型</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td>用户级别： <input id="s_lvl" name="s_lvl"
						class="easyui-combobox"
						data-options="valueField:'id',textField:'text',url:'<%=request.getContextPath()%>/sysRole/lvl.do'"
						style="width: 200px" />
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
		style="width: 500px; height: 300px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<input type="hidden" id="roleid" name="roleid">
				<table>
					<tr id="userTypeTr">
						<th align="right" style="width: 100px">英文缩写</th>
						<td><input id="userType" name="userType"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px"></td>
					</tr>
					<tr>
						<th align="right" style="width: 100px">名称</th>
						<td><input id="rolename" name="rolename"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px"></td>
					</tr>
					<tr>
						<th align="right" style="width: 100px">级别</th>
						<td><input id="lvl" name="lvl" class="easyui-combobox"
							data-options="valueField:'id',textField:'text',url:'<%=request.getContextPath()%>/sysRole/lvl.do',required:true"
							style="width: 200px" data-options="required:true"></td>
					</tr>
					<tr>
						<th align="right" style="width: 100px">表单标识</th>
						<td><select id="showFlag" name="showFlag"
							class="easyui-combobox" data-options="required:true" style="width: 200px">
								<option value="1">是</option>
								<option value="0">否</option>
						</select></td>
					</tr>
					<tr id="companyIdTr">
						<th align="right" style="width: 100px">公司</th>
						<td><input id="companyId" name="companyId" class="easyui-combobox"
							data-options="valueField:'id',textField:'text',url:'<%=request.getContextPath()%>/orgInfo/combo.do',required:true"
							style="width: 200px"></td>
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
