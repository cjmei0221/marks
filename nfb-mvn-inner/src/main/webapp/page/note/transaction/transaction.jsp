<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- Transaction.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/transaction.css" />

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
					<td><button type="button" id="doSearch" data-oper="query"
							style="cursor: pointer;">查询</button>
				</tr>
				<tr>
					<td colspan="2"><wt:button /></td>
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
		style="width: 600px; height: 450px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<input type="hidden" id="id" name="id">
				<table>
					<tr>
						<th style="text-align: right;">事务类型&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="tranType" name="tranType"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">特殊日期&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="tranDate" name="tranDate"
							class="easyui-datetimebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">是否重复&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="isRepeat" name="isRepeat"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">提醒内容&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="tranContent" name="tranContent"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">提前天数&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="aheadDays" name="aheadDays"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">提醒时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="tranTime" name="tranTime"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">是否提前提醒&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="isAhead" name="isAhead"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">创建时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="createtime" name="createtime"
							class="easyui-datetimebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">更新时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="updatetime" name="updatetime"
							class="easyui-datetimebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="text-align: right;">创建者&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="creator" name="creator"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><a id="btnOK"
							name="btnOK" href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-save'">保存</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a id="btnCancel" name="btnCancel"
							href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-remove'">取消</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
<script src="js/transaction.js"></script>
</html>
