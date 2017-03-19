<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- NewsItem.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/newsItem.css" />

<%@include file="../../include/common.jsp"%>
<script type="text/javascript" src="../../../js/editImage/image.js"></script>

</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">
			回复图文管理(<span style="color: red;">双击可编辑</span>)
		</p>
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
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="id" name="id">
			<table>
				<tr>
					<th style="width: 80px; text-align: right;">标题</th>
					<td><input id="title" name="title" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th style="width: 80px; text-align: right;">描述</th>
					<td><input id="description" name="description"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th style="width: 80px; height: 160px; text-align: right;">图片路径</th>
					<td colspan="3" valign="top" height="150px"><a
						class="uploadImage" href="javascript:void(0)" onclick="selectUploadImage('addMainImg',1);">选择图片
					</a>
						<div id="addMainImg"></div></td>
				</tr>
				<tr>
					<th style="width: 80px; text-align: right;">链接</th>
					<td><input id="url" name="url" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th style="width: 80px; text-align: right;">排序</th>
					<td><input id="sort" name="sort" class="easyui-numberbox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th style="width: 80px; text-align: right;">服务号</th>
					<td><input id="accountid" name="accountid"
						class="easyui-combobox"
						data-options="required:true,valueField:'accountId',textField:'accountname',url:'<%=request.getContextPath()%>/wxAccount/combox.do'"
						style="width: 200px;"></td>
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


	<div id="imageWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 650px; height: 450px; padding: 10px;">
		<a class="uploadImage" href="#"> <input type="file"
			onchange="selectImage(this);" />上传图片
		</a>
		<div id="ImgList"></div>
	</div>

</body>
<script src="js/newsItem.js"></script>
</html>
