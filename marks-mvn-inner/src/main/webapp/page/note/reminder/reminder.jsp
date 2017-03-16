<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- Reminder.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reminder.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">事务提醒>>事务提醒</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td><a id="doSearch" href="javascript:void(0)"
						class="easyui-linkbutton menuBtnCls"
						data-options="iconCls:'icon-search'">查询</a></td>
				</tr>
			</table>
			<div>
				<wt:button />
			</div>
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
		style="width: 600px; height: 450px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<input type="hidden" id="id" name="id">
				<table>
					<tr>
						<th style="width: 120px; text-align: right;">事务类型&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input type="radio" name="remind_type" value="0"
							checked="checked" /> 普通<input type="radio" name="remind_type"
							value="1" /> 节日</td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">提醒内容&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="remind_content" name="remind_content"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="250"></td>
					</tr>

					<tr>
						<th style="width: 120px; text-align: right;">发生日期&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="remind_date" name="remind_date"
							class="easyui-datebox" data-options="required:true"
							style="width: 200px;" maxlength="50"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">提醒时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="remind_time" name="remind_time"
							class="easyui-timespinner"
							data-options="min:'08:30',showSeconds:true,required:true"
							style="width: 200px;" maxlength="20"></td>
					</tr>

					<tr>
						<th style="width: 120px; text-align: right;">是否转为农历&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input type="radio" name="calendar_type" value="0"
							checked="checked" /> 否<input type="radio" name="calendar_type"
							value="1" /> 是</td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">是否重复&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input type="radio" name="is_repeat" value="0"
							checked="checked" />否 <input type="radio" name="is_repeat"
							value="1" /> 是</td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">是否提前提醒&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input type="radio" name="is_before" value="0"
							checked="checked" />否 <input type="radio" name="is_before"
							value="1" /> 是</td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">提前天数&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="before_days" name="before_days"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><a id="btnOK"
							name="btnOK" href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-save'">保存</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a id="btnCancel" name="btnCancel"
							href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-cancel'">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
<script src="js/reminder.js"></script>
</html>
