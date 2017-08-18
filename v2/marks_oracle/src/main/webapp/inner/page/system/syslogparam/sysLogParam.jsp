<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- SysLogParam.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sysLogParam.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">日志参数>>日志参数</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td>来源：<select id="query_source" name="query_source"
						class="easyui-combobox" style="width: 200px;">
							<option value="">全选</option>
							<option value="1">消息中心</option>
							<option value="2">前端</option>
					</select></td>
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
						<th style="width: 80px; text-align: right;">来源&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><select id="source" name="source"
							class="easyui-combobox" style="width: 200px;"
							data-options="required:true">
								<option value="1">消息中心</option>
								<option value="2">前端</option>
						</select></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">访问链接&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="url" name="url"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">功能名称&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="menuName" name="menuName"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">操作名称&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="operName" name="operName"
							class="easyui-validatebox" data-options="required:true"
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
<script src="js/sysLogParam.js"></script>
</html>
