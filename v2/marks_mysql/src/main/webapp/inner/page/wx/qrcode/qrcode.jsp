<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- Qrcode.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/qrcode.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">二维码管理>>二维码管理</p>
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
				<input type="hidden" id="id" name="id">
				<table style="width: 100%;">
					<tr>
						<th style="width: 80px; text-align: right;">名称&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="qrName" name="qrName"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr class="hideCls" id="qrTypeTr">
						<th style="width: 80px; text-align: right;">类型&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><select id="qrType" class="easyui-combobox" name="qrType"
							style="width: 200px;" data-options="required:true">
								<option value="0">链接</option>
								<option value="1">公众号</option>
						</select></td>
					</tr>
					<tr id="qrUrlTr" class="hideCls" style="display: none;">
						<th style="width: 80px; text-align: right;">链接URL&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="qrUrl" name="qrUrl" class="easyui-validatebox"
							style="width: 200px;"></td>
					</tr>
					<tr id="accountidTr" class="hideCls" style="display: none;">
						<th style="width: 80px; text-align: right;">公众号&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="accountid" name="accountid"
							class="easyui-combobox"
							data-options="valueField:'accountId',textField:'accountname',url:'<%=request.getContextPath()%>/inner/wxAccount/combox.do'"
							style="width: 200px;"></td>
					</tr>

					<tr id="sceneTypeTr" class="hideCls" style="display: none;">
						<th style="width: 80px; text-align: right;">场景类型&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><select id="sceneType" class="easyui-combobox"
							name="sceneType" style="width: 200px;">
								<option value="0">临时</option>
								<option value="1">永久</option>
						</select></td>
					</tr>
					<tr id="qrNoTr" class="hideCls" style="display: none;">
						<th style="width: 80px; text-align: right;">标识&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="qrNo" name="qrNo" class="easyui-numberbox"
							data-options="min:1,precision:0" style="width: 200px;"><br />(临时二维码100001开始|永久二维码1-100000)
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><input
							type="button" id="btnOK" name="btnOK" value=" 保 存 "/>
							&nbsp;&nbsp;&nbsp; <input type="button" id="btnCancel"
							name="btnCancel" value=" 取 消 " /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="showWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 400px; height: 400px; padding: 10px;">
		<div align="center" style="width: 100%; height: 100%;">
			<img alt="二维码图片" src="" id="showImage"
				style="width: 350px; height: 350px;">
		</div>
	</div>
</body>
<script src="js/qrcode.js"></script>
</html>
