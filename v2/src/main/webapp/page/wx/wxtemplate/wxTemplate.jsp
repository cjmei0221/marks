<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxTemplate.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/wxTemplate.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">微信模板>>微信模板</p>
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
		style="width: 400px; height: 450px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<table>
					<tr>
						<th style="width: 100px; text-align: right;">服务号&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="accountid" name="accountid"
							class="easyui-combobox"
							data-options="required:true,valueField:'accountId',textField:'accountname',url:'<%=request.getContextPath()%>/wxAccount/combox.do'"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 100px; text-align: right;">主键ID&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="ywType" name="ywType"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">微信模板ID&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="template_id" name="template_id"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">微信模板标题&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="template_name" name="template_name"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">首行内容&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="first_content" name="first_content"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">尾行内容&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="remark_content" name="remark_content"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">访问URL&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="detailUrl" name="detailUrl"
							class="easyui-validatebox" style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">启用标识&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><select id="status" class="easyui-combobox" name="status"
							style="width: 200px;" data-options="required:true">
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
	</div>

</body>
<script src="js/wxTemplate.js"></script>
</html>
