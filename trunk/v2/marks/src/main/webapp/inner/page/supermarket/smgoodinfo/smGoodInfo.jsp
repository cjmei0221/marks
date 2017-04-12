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
						style="width: 260px;" placeholder="条形码/商品名称/更新时间/创建者/最后更新者" /></td>
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
						<td><input id="barCode" name="barCode"
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
						<th style="width: 120px; text-align: right;">商品价格&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="goodPrice" name="goodPrice"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="50"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">图片路径&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="imgUrl" name="imgUrl"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="512"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">上架状态&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="onsale" name="onsale" class="easyui-numberbox"
							data-options="required:true" style="width: 200px;"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">创建者&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="creator" name="creator"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="250"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">最后更新者&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="updator" name="updator"
							class="easyui-validatebox" data-options="required:true"
							style="width: 200px;" maxlength="250"></td>
					</tr>
					<tr>
						<th style="width: 120px; text-align: right;">超市ID&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input id="smId" name="smId" class="easyui-validatebox"
							data-options="required:true" style="width: 200px;" maxlength="50"></td>
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

	<div id="excelWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 600px; height: 450px; padding: 10px;">
		<div align="center" style="width: 100%;">
			<a id="downloadExcel"
							name="downloadExcel" href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;">下载模板</a>
							<div style="height:10px;"></div>
			<form id="upload" name="upload" method="post"
				enctype="multipart/form-data">
				<input type="hidden" id="goodId" name="goodId">
				<table>
					<tr>
						<th style="width: 120px; text-align: right;">文件&nbsp;&nbsp;:&nbsp;&nbsp;</th>
						<td><input name="fileBuildInfo" id="fileBuildInfo" class="big"  type="file" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center">
						
						<div style="height:5px;"></div>
							
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center">
						
						<a id="btnOKExcel"
							name="btnOK" href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;" data-options="iconCls:'icon-save'">上传</a>
							
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
<script src="js/smGoodInfo.js"></script>
</html>
