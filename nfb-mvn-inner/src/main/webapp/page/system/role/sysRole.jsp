<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理平台</title>
<%@include file="../../include/common.jsp"%>
<style type="text/css">
form-element-cls {
	width: 200px;
}
</style>
</head>
<body>
	<div id="mainPanel">
		<p class="nav-header-cls">菜单管理>>系统角色</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="角色名称" /></td>
					<td><button type="button" id="doSearch" data-oper="query"
							style="cursor: pointer;">查询</button>
				</tr>
				<tr>
					<td colspan="2"><wt:button /></td>
				</tr>
			</table>

		</div>
		<table id="tbList">
		</table>
	</div>
	<div class="easyui-window wrapperAddPanel "
		data-options="modal:true,
		resizable:false,closed:true,
		minimizable:false,
		maximizable:false,
		collapsible:false,
		title:'新增角色',height:150,
		draggable :false">
		<form id="ff" name="ff" method="post">
			<table class="createRole" style="width: 500px;">
				<tr>
					<th>角色名称</th>
					<td style=""><input type="hidden" id="roleid" name="roleid"
						value="" /> <input type="text" id="roleNameEdit"
						name="roleNameEdit" class="easyui-validatebox form-element-cls"
						data-options="required:true" /></td>
				</tr>
				<tr id="lvlTr">
					<th>级别</th>
					<td><select name="lvlEdit" id="lvlEdit"
						class="easyui-combobox form-element-cls">
							<option value="0">系统级别</option>
							<option value="1">公司级别</option>
							<option value="2">店铺级别</option>
					</select></td>
				</tr>
				<tr id="companyTr">
					<th>商家</th>
					<td><input id="company" name="company"
						class="easyui-combobox form-element-cls"></td>
				</tr>
				<tr id="shopTr">
					<th>店铺</th>
					<td><input id="shop" name="shop"
						class="easyui-combobox form-element-cls"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" id="btnSave"
						name="btnSave" value="保 存" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="button" id="btnCancel" name="btnCancel" value="取 消" /></td>
				</tr>
			</table>
			<div id="shopListWin" class="easyui-window" title="商铺列表"
		style="width: 600px; height: 400px">
		<table id="shopTb">
			<tr>
				<td><input type="text" id="shopKeyword" name="shopKeyword"
					style="width: 260px;" placeholder="公司名称" /></td>
				<td><button type="button" id="shopDoSearch" data-oper="query"
						style="cursor: pointer;">查询</button>
			</tr>
		</table>
		<table id="shopTbList">
		</table>
	</div>
	<div id="companyListWin" class="easyui-window" title="公司列表"
		style="width: 600px; height: 400px">
		<table id="companyTb">
			<tr>
				<td><input type="text" id="companyKeyword" name="companyKeyword"
					style="width: 260px;" placeholder="公司名称" /></td>
				<td><button type="button" id="companyDoSearch" data-oper="query"
						style="cursor: pointer;">查询</button>
			</tr>
		</table>
		<table id="companyTbList">
		</table>
	</div>
		</form>
	</div>
	<div id="roleFuncWin" class="easyui-window "
		data-options="modal:true,
		resizable:false,closed:true,
		minimizable:false,
		maximizable:false,
		collapsible:false,
		height:150,
		draggable :false">
		<form id="funcff" name="funcff" method="post"></form>
	</div>
</body>
<script type="text/javascript">
	(function() {
		$.getScript("sysRole.js");
	})();
</script>
</html>