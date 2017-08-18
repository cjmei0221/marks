<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理平台</title>
<%@include file="../../include/common.jsp"%>
</head>
<body>
	<div id="mainPanel">
		<p class="nav-header-cls">菜单管理>>操作按钮</p>
		<div id="tb" style="padding: 5px 0;">
		<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword" style="width:260px;" placeholder="按钮名称/按钮ID"/></td>
					<td><a id="doSearch" href="javascript:void(0)"
						class="easyui-linkbutton menuBtnCls"
						data-options="iconCls:'icon-search'">查询</a></td>
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
			<table class="out-win-cls">
				<tr>
					<th>按钮ID</th>
					<td><input id="operid" name="operid"
						class="easyui-validatebox" data-options="required:true"
						maxlength="60"></td>
				</tr>
				<tr>
					<th>按钮名称</th>
					<td><input id="opername" name="opername" class="easyui-validatebox"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th>图标</th>
					<td><input id="picicon" name="picicon"
						class="easyui-validatebox" data-options="required:true" value="#">
					</td>
				</tr>
				<tr>
					<th>排序</th>
					<td><input id="sort" name="sort" type="text" class="easyui-numberbox" value="10"
						data-options="max:99,min:0,precision:0"></td>
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
<script type="text/javascript"
	src="sysOperate.js?gt=<%=new Date().getTime()%>"></script>
</html>