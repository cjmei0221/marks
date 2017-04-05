<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxAccount.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/wxAccount.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">公众号管理>>公众号管理</p>
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
		style="width: 400px; height: 450px; padding: 10px; margin: 10px;">
		<form id="ff" name="ff" method="post">
			<table class="out-win-cls">
				<tr>
					<th>公众号ID</th>
					<td><input id="accountId" name="accountId"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th>公众号名称</th>
					<td><input id="accountname" name="accountname"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th>公众号类型</th>
					<td><select id="accttype" class="easyui-combobox"
						name="accttype" style="width: 200px;">
							<option value="0">服务号</option>
							<option value="1">企业号</option>
							<option value="2">订阅号</option>
					</select></td>
				</tr>

				<tr>
					<th>机构</th>
					<td><input id="orgid" name="orgid" class="easyui-combobox"
						data-options="valueField:'id',textField:'text',url:'<%=request.getContextPath()%>/orgInfo/combo.do',required:true"
						style="width: 200px" data-options="required:true"></td>
				</tr>

				<tr>
					<th>APPID</th>
					<td><input id="appid" name="appid" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>APPSECRET</th>
					<td><input id="appsecret" name="appsecret"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th>令牌</th>
					<td><input id="token" name="token" class="easyui-validatebox"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th>加密秘钥</th>
					<td><input id="aeskey" name="aeskey"
						class="easyui-validatebox" style="width: 200px;"></td>
				</tr>

				<tr>
					<th>微信号</th>
					<td><input id="wx_acctno" name="wx_acctno"
						class="easyui-validatebox" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>授权域名</th>
					<td><input id="authdomain" name="authdomain"
						class="easyui-validatebox" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>上下文</th>
					<td><input id="server_context" name="server_context"
						class="easyui-validatebox" value="/" style="width: 200px;"></td>
				</tr>

				<tr>
					<th>是否提供服务</th>
					<td><select id="is_service" class="easyui-combobox"
						name="is_service" style="width: 200px;">
							<option value="1">提供</option>
							<option value="0">不提供</option>
					</select></td>
				</tr>
				<tr id="urlTr">
					<th>回调路径</th>
					<td id="urlTd"></td>
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
<script src="js/wxAccount.js"></script>
</html>
