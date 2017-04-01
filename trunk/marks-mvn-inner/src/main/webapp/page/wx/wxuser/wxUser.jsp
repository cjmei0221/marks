<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxUser.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/wxUser.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">粉丝管理>>粉丝管理</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td>来源：<select id="s_issubscribe" name="s_issubscribe" class="easyui-combobox"
						style="width: 200px;">
							<option value="">全选</option>
							<option value="0">未关注</option>
							<option value="1">已关注心</option>
					</select></td>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="昵称/来源/省/市" /></td>
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
		style="width: 400px; height: 300px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="openid" name="openid">
			<table class="out-win-cls">
				<tr>
					<th>昵称</th>
					<td><input id="nickname" name="nickname"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>分组ID</th>
					<td><input id="groupid" name="groupid"
						class="easyui-numberbox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>国家</th>
					<td><input id="country" name="country"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>省</th>
					<td><input id="province" name="province"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>市</th>
					<td><input id="city" name="city" class="easyui-validatebox"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th>性别</th>
					<td><input id="sex" name="sex" class="easyui-numberbox"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th>头像路径</th>
					<td><input id="imageUrl" name="imageUrl"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>语言</th>
					<td><input id="language" name="language"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>关注</th>
					<td><input id="issubscribe" name="issubscribe"
						class="easyui-numberbox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>关注时间</th>
					<td><input id="subscribetime" name="subscribetime"
						class="easyui-datetimebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>更新时间</th>
					<td><input id="updatetime" name="updatetime"
						class="easyui-datetimebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>公众号ID</th>
					<td><input id="accountid" name="accountid"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input id="createtime" name="createtime"
						class="easyui-datetimebox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>启用标识</th>
					<td><input id="useflag" name="useflag"
						class="easyui-numberbox" data-options="required:true"></td>
				</tr>
				<tr>
					<th>二维码标识</th>
					<td><input id="qrNo" name="qrNo" class="easyui-validatebox"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th>备注</th>
					<td><input id="remark" name="remark"
						class="easyui-validatebox" data-options="required:true"></td>
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

</body>
<script src="js/wxUser.js"></script>
</html>
