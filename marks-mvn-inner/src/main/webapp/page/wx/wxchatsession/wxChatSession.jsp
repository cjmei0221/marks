<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxChatSession.html -->
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/wxChatSession.css" />

	<%@include file="../../include/common.jsp"%>
</head>
	
	<body>
	
	<div id="mainPanel">
		<p class="nav-header-cls">回话管理>>回话管理</p>
		<div id="tb" style="padding: 5px 0;">
		<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword" style="width:260px;" placeholder="关键字"/></td>
					<td><a id="doSearch" href="javascript:void(0)" class="easyui-linkbutton menuBtnCls" data-options="iconCls:'icon-search'">查询</a></td>
				</tr>
			</table>
			<div><wt:button /></div>
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
			<input type="hidden"  id="session_id" name="session_id">
			<table>
				<tr><th style="width: 120px;text-align: right;">公众号ID&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="accountid" name="accountid" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="50"></td></tr><tr><th style="width: 120px;text-align: right;">OPENID&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="openid" name="openid" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="50"></td></tr><tr><th style="width: 120px;text-align: right;">创建时间戳&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="createLong" name="createLong" class="easyui-numberbox" data-options="required:true" style="width: 200px;" ></td></tr><tr><th style="width: 120px;text-align: right;">内容&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="c_content" name="c_content" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="2048"></td></tr><tr><th style="width: 120px;text-align: right;">结束时间&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="endtime" name="endtime" class="easyui-datetimebox" data-options="required:true" style="width: 200px;" ></td></tr><tr><th style="width: 120px;text-align: right;">粉丝ID&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="fanId" name="fanId" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="50"></td></tr>
				<tr>
					<td colspan="2" style="text-align: center">
							<a id="btnOK"
							name="btnOK" href="javascript:void(0)"  class="easyui-linkbutton" style="width:100px;"
							data-options="iconCls:'icon-save'">保存</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a id="btnCancel"
							name="btnCancel" href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;"
							data-options="iconCls:'icon-cancel'">取消</a>
						</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	
</body>
<script src="js/wxChatSession.js"></script>
</html>
