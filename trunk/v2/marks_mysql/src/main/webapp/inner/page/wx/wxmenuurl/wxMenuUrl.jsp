<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxMenuUrl.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/wxMenuUrl.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">微信菜单URL>>微信菜单URL</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td><a id="doSearch" href="javascript:void(0)"
						class="easyui-linkbutton menuBtnCls"
						data-options="iconCls:'icon-search'">查询</a></td>
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
		style="width: 520px; height: 300px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="id" name="id">
			<table class="out-win-cls">
				<tr>
					<th>菜单名称</th>
					<td><input id="menuName" name="menuName"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>菜单URL</th>
					<td><input id="menuUrl" name="menuUrl"
						class="easyui-validatebox" data-options="required:true" style="width:400px;"></td>
				</tr>
				<tr>
					<th style="width:100px;">公众号ID</th>
					<td><input  id="accountid" name="accountid" class="easyui-combobox" 
						data-options="required:true,valueField:'accountId',textField:'accountname',url:'<%=request.getContextPath()%>/inner/wxAccount/combox.do'">
						</td>
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
<script src="js/wxMenuUrl.js"></script>
</html>
