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
			<input type="hidden"  id="accountId" name="accountId">
			<table class="out-win-cls">
				<tr><th>回调路径</th><td><input id="url" name="url" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>令牌</th><td><input id="token" name="token" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>加密秘钥</th><td><input id="aeskey" name="aeskey" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>创建者</th><td><input id="creator" name="creator" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>创建时间</th><td><input id="createtime" name="createtime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>上下文</th><td><input id="server_context" name="server_context" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>微信号</th><td><input id="wx_acctno" name="wx_acctno" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>是否提供服务</th><td><input id="is_service" name="is_service" class="easyui-numberbox" data-options="required:true"></td></tr><tr><th>公众号类型</th><td><input id="accttype" name="accttype" class="easyui-numberbox" data-options="required:true"></td></tr><tr><th>更新时间</th><td><input id="updatetime" name="updatetime" class="easyui-datetimebox" data-options="required:true"></td></tr><tr><th>公众号名称</th><td><input id="accountname" name="accountname" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>机构ID</th><td><input id="orgid" name="orgid" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>APPID</th><td><input id="appid" name="appid" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>APPSECRET</th><td><input id="appsecret" name="appsecret" class="easyui-validatebox" data-options="required:true"></td></tr><tr><th>授权域名</th><td><input id="authdoman" name="authdoman" class="easyui-validatebox" data-options="required:true"></td></tr>
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
