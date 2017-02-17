<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- Gains.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/gains.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">工作>>心得记录</p>
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
		style="width: 950px; height: 500px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<form id="ff" name="ff" method="post">
				<input type="hidden" id="id" name="id">
				<table>
					<tr>
						<th>级别&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="lvl" name="lvl" class="easyui-combobox"
							data-options="required:true,valueField:'ckey',textField:'cvalue',url:'<%=request.getContextPath()%>/dataDir/combox.do?parentId=gains_level'"
							style="width: 300px;"></td>
					</tr>
					<tr>
						<th>标题&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="600px" align="left"><input id="title" name="title"
							class="easyui-validatebox" style='width: 800px; height: 30px;'
							data-options="required:true"></td>
					</tr>
					<tr>

						<td colspan="2" width="600px"><textarea id="content"
								name="content" class="easyui-validatebox"
								data-options="required:true"
								style="width: 872px; height: 310px; text-align: top;"
								placeholder="正文" maxlength="2000">
						</textarea></td>
					</tr>
					<tr>
						<th>标签&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="600px" align="left"><input id="labels"
							name="labels" class="easyui-validatebox"
							style='width: 800px; height: 30px;' data-options="required:true"></td>

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
<script src="js/gains.js"></script>
</html>
