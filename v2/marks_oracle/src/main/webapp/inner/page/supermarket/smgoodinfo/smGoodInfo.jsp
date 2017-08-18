<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- SmGoodInfo.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/smGoodInfo.css" />
<%@include file="../../include/common.jsp"%>
<script type="text/javascript" src="../../../js/editImage/image.js"></script>
<script src="../../../js/uploadify/jquery.uploadify.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="../../../js/uploadify/uploadify.css">
<script type="text/javascript" src="../../../js/excel/excel.js"></script>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">
			超市商品(<span style="color: red;">双击可编辑</span>)
		</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="条形码/商品名称/更新时间/最后更新者" /></td>
					<td><a id="doSearch" href="javascript:void(0)"
						class="easyui-linkbutton menuBtnCls"
						data-options="iconCls:'icon-search'">查询</a></td>
				</tr>
			</table>
			<div>
				<wt:button />
			</div>
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
				<input type="hidden" id="goodId" name="goodId">
				<table>
					<tr>
						<th style="width: 120px; text-align: right;">条形码&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="sku_num" name="sku_num"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="50"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">商品名称&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="goodName" name="goodName"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="512"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">商品价格(分)&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="goodPrice" name="goodPrice"
							class="easyui-numberbox" data-options="required:true"
							style="width: 200px;" maxlength="50"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">商品单位&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="unit" name="unit" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;" maxlength="50"></td>
					</tr>
					<tr>
						<th style="width: 120px;height: 160px; text-align: right;">图片路径&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td valign="top" height="150px"><a
						class="uploadImage" href="javascript:void(0)"
						onclick="selectUploadImage('addMainImg',1);">选择图片 </a>
						<div id="addMainImg"></div></td>
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

	
	<!-- 图片选择窗口 -->
	<div id="imageListWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 650px; height: 450px; padding: 10px;">
		<a class="uploadImage" href="#"> <input type="file"
			onchange="selectImage(this);" />上传图片
		</a>
		<div id="pgNation" class="easyui-pagination"
			style="border: 1px solid #ccc;"
			data-options="
    		onSelectPage: function(pageNumber, pageSize){
    			loadImageList(pageNumber,pageSize);
    	}">
		</div>

		<div id="content" class="easyui-panel" style="padding: 10px;">
			<div id="ImgList"></div>
		</div>

	</div>

	<div id="excelWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 400px; height: 350px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<a id="downloadExcel" name="downloadExcel"
				href="/inner/fileUpload/excelTemplate.do?fileName=supermarket_good_info.xls"
				class="easyui-linkbutton" style="width: 100px;">下载模板</a>
			<div style="height: 10px;"></div>
			<form id="importFileForm" method="post" enctype="multipart/form-data">
				<table style="margin: 5px; height: 70px;">
					<tr>
						<td colspan="2"><input id="file_upload" name="file_upload"
							type="file" multiple="false"></td>
					</tr>
					<tr id="excelfileNameTr" style="display: none;">
						<td colspan="2"><label id="fileName" /><input
							id="excelfileName" name="excelfileName"></td>
					</tr>
					<tr>
						<td colspan="2"><span id="uploadInfo"></span></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
<script src="js/smGoodInfo.js"></script>
</html>
