<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- ModuleMsg.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/moduleMsg.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">模板消息>>模板消息</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td>推送标识：<select id="s_sendFlag" class="easyui-combobox" name="s_sendFlag"
						style="width: 100px;">
							<option value="">全部</option>
							<option value="1">成功</option>
							<option value="2">失败</option>
							<option value="0">未推送</option>
					</select></td>
					<td>推送标识：<select id="s_resultCode" class="easyui-combobox" name="s_resultCode"
						style="width: 100px;">
							<option value="">全部</option>
							<option value="1">成功</option>
							<option value="0">失败</option>
					</select></td>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="昵称/备注/创建日期（YYYY-MM-DD）" /></td>
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
				<table>
					<tr>
						<th style="width: 80px; text-align: right;">公众号ID&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="accountid" name="accountid"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">模板ID&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="template_id" name="template_id"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">接受者&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="touser" name="touser"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">访问URL&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="url" name="url" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">内容&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="data" name="data" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">需要发送标识&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="needFlag" name="needFlag"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">发送标识&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="sendFlag" name="sendFlag"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">发送次数&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="sendTimes" name="sendTimes"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">创建时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="createtime" name="createtime"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">发送时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="sendtime" name="sendtime"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">消息ID&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="msgId" name="msgId" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">推送返回码&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="push_code" name="push_code"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">推送返回信息&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="push_msg" name="push_msg"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">推送结果码&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="resultCode" name="resultCode"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">推送结果消息&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="resultMsg" name="resultMsg"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">备注&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="note" name="note" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;"></td>
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
<script src="js/moduleMsg.js"></script>
</html>
