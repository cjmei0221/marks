<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- DataDir.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/dataDir.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">数据字典>>数据字典</p>
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
		style="width: 400px; height: 450px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<table>
					<tr>
						<th style="width: 80px; text-align: right;">主键&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="ckey" name="ckey" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;" readonly="readonly"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">父主键&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="parentkey" name="parentkey"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" readonly="readonly"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">主键值&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="cvalue" name="cvalue"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">排序&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="sort" name="sort" class="easyui-numberbox"
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
<script src="js/dataDir.js"></script>
</html>
