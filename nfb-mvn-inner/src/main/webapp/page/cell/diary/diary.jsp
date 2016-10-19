<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- Diary.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/diary.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<div id="tb">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="statedate" name="statedate" type="text" editable="false" class="easyui-datebox" style="width: 120px;">
					</td>
					<td>至<input type="text" id="enddate" name="enddate"
						class="easyui-datebox" editable="false" style="width: 120px;" /></td>
					<td><button type="button" id="doSearch" data-oper="query"
							style="cursor: pointer;">查询</button>
				</tr>
				<tr>
					<td colspan="4"><wt:button /></td>
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
		style="width: 920px; height: 500px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="ID" name="ID">
			<table class="out-win-cls" border="1">
				<tr>
					<th width="50px">日记时间</th>
					<td width="600px" align="left"><input id="time" name="time"
						class="easyui-datetimebox"></td>
				</tr>
				<tr>
					<th width="50px">标题</th>
					<td width="600px" align="left"><input id="title" name="title"
						class="easyui-validatebox" data-options="required:true"
						style="width: 800px;"></td>
				</tr>
				<tr>
					<td colspan="2" width="650px"><textarea id="content"
							name="content" class="easyui-validatebox"
							data-options="required:true"
							style="width: 872px; height: 310px; text-align: top;"
							placeholder="正文" maxlength="2000">
						</textarea></td>
				</tr>


				<tr>
					<td colspan="2" style="text-align: center"><input
						type="button" id="btnCancel" name="btnCancel" value=" 取 消 " />&nbsp;&nbsp;&nbsp;
						<input type="button" id="btnOK" name="btnOK" value=" 保 存 " /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
<script src="js/diary.js"></script>
</html>
