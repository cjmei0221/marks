<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- NewsItem.html -->
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/newsItem.css" />

	<%@include file="../../include/common.jsp"%>
</head>
	
	<body>
	
	<div id="mainPanel">
		<p class="nav-header-cls">回复图文管理>>回复图文管理</p>
		<div id="tb" style="padding: 5px 0;">
		<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword" style="width:260px;" placeholder="关键字"/></td>
					<td><button type="button" id="doSearch" data-oper="query" style="cursor: pointer;">查询</button>
				</tr>
				 <tr>
					<td colspan="7">
						<wt:button />
					</td>
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
		style="width: 400px; height: 300px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden"  id="id" name="id">
			<table class="out-win-cls">
				<tr><th>标题</th><td><input id="title" name="title" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>描述</th><td><input id="description" name="description" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>图片路径</th><td><input id="picUrl" name="picUrl" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>链接</th><td><input id="url" name="url" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>排序</th><td><input id="sort" name="sort" class="easyui-numberbox" data-options="required:true"></td></tr><tr><th>服务号ID</th><td><input id="accountid" name="accountid" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>创建时间</th><td><input id="createtime" name="createtime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>更新时间</th><td><input id="updatetime" name="updatetime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>创建者</th><td><input id="creator" name="creator" class="easyui-validatebox" data-options="required:true"></td></tr>
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
<script src="js/newsItem.js"></script>
</html>
