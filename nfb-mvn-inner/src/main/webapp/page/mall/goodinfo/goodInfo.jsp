<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- GoodInfo.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/goodInfo.css" />
<link rel="stylesheet" type="text/css"
	href="../../../js/uploadImage/swfupload-default.css">
<%@include file="../../include/common.jsp"%>
<script type="text/javascript" src="../../../js/editImage/image.js"></script>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">商品管理>>商品管理</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td><button type="button" id="doSearch" data-oper="query"
							style="cursor: pointer;">查询</button>
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
		style="width: 500px; height: 500px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="goodId" name="goodId">
			<table>
				<tr>
					<th>商品名称</th>
					<td><input id="goodName" name="goodName"
						class="easyui-validatebox" data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>商品单价(单位分)</th>
					<td><input id="goodPrice" name="goodPrice"
						class="easyui-numberbox" data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>商品单位</th>
					<td><input id="unit" name="unit" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>商品列表图片</th>
					<td valign="top"><input id="imageUrl" name="imageUrl"
						class="easyui-validatebox" data-options="required:true"
						placeholder="图片访问路径" style="width: 200px;" readonly="readonly"> <input
						type="file" onchange="selectImage(this);"> <br/><img
						class="imageUrl" src="" style="width: 160px; height: 100px;display:none;" /> <input
						type="button" onclick="deleteImage(this);" value="删除" style="display:none;"/></td>
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
<script type="text/html" id="mainPic">

	<div>
		<span id="buttonPlaceholder"></span>	
	</div>
	<div id="errorMsg1" class="ke-dialog-content-error"></div>
	<div class="look_pic ke-swfupload-body" id="photoContainer"></div>

	
</script>
<script src="js/goodInfo.js"></script>
</html>
