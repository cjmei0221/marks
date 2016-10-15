<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理平台</title>
<link rel="stylesheet" href="@{GetCssRoot}" />
<%@include file="../../include/common.jsp"%>
</head>
	
	<body>
	
	<<div id="mainPanel">
		<p class="nav-header-cls">菜单管理>>操作按钮</p>
		<div id="tb" style="padding: 5px 0;">
		<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword" style="width:260px;" placeholder="按钮名称/按钮ID"/></td>
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
	<!-- 新增和编辑窗口 -->
	<div id="editWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 400px; height: 300px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden"  id="operid" name="operid">
			<table class="out-win-cls">
				@{GetInputField}
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
<script src="@{GetJsRoot}"></script>
</html>
