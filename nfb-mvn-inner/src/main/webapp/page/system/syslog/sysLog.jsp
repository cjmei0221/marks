<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- SysLog.html -->
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/sysLog.css" />

	<%@include file="../../include/common.jsp"%>
</head>
	
	<body>
	
	<div id="mainPanel">
		<p class="nav-header-cls">内管日志>>内管日志</p>
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
		style="width: 400px; height: 450px; padding: 10px;">
		<div align="center" style="width: 100%;">
		<form id="ff" name="ff" method="post">
			<input type="hidden"  id="id" name="id">
			<table>
				<tr><th style="width:80px;text-align: right;">用户ID&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="userid" name="userid" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr><tr><th style="width:80px;text-align: right;">用户姓名&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="username" name="username" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr><tr><th style="width:80px;text-align: right;">创建时间&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="createtime" name="createtime" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr><tr><th style="width:80px;text-align: right;">IP&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="ip" name="ip" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr><tr><th style="width:80px;text-align: right;">菜单名称&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="menuname" name="menuname" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr><tr><th style="width:80px;text-align: right;">操作名称&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="opername" name="opername" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr><tr><th style="width:80px;text-align: right;">访问URL&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="retain2" name="retain2" class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td></tr>
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
<script src="js/sysLog.js"></script>
</html>
