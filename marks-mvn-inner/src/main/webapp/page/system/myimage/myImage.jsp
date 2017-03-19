<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- MyImage.html -->
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/myImage.css" />

	<%@include file="../../include/common.jsp"%>
</head>
	
	<body>
	
	<div id="mainPanel">
		<p class="nav-header-cls">图片(<span style="color:red;">双击可编辑</span>)</p>
		<div id="tb" style="padding: 5px 0;">
		<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword" style="width:260px;" placeholder=""/></td>
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
			<input type="hidden"  id="picId" name="picId">
			<table>
				<tr><th style="width: 120px;text-align: right;">名称&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="picName" name="picName" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="50"></td></tr><tr><th style="width: 120px;text-align: right;">路径&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="picUrl" name="picUrl" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="50"></td></tr><tr><th style="width: 120px;text-align: right;">创建者&nbsp;&nbsp;:&nbsp;&nbsp;</th><td><input id="creator" name="creator" class="easyui-validatebox" data-options="required:true" style="width: 200px;" maxlength="50"></td></tr>
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
<script src="js/myImage.js"></script>
</html>
