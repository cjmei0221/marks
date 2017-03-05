<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- VipInfo.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/vipInfo.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">会员信息>>会员信息</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
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
				<input type="hidden" id="userid" name="userid">
				<table style="width: 100%;">
					<tr>
						<th style="width: 80px; text-align: right;">真实姓名&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="realname" name="realname"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">性别&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="gender" name="gender"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">生日&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="birthdate" name="birthdate"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">邮箱&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="email" name="email"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">签名&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="signature" name="signature"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">创建时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="createtime" name="createtime"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 80px; text-align: right;">更新时间&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td width="250px"><input id="updatetime" name="updatetime"
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
<script src="js/vipInfo.js"></script>
</html>
