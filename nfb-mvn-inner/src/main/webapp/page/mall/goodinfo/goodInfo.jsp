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
		style="width: 650px; height: 500px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="goodId" name="goodId">
			<table>
				<tr>
					<th>商品编码</th>
					<td><input id="sku_num" name="sku_num"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
					<th>商品名称</th>
					<td><input id="goodName" name="goodName"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th>品牌名称</th>
					<td><input id="brand" name="brand" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
					<th>产地</th>
					<td><input id="madeIn" name="madeIn"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>

				<tr>
					<th>商品单价(单位分)</th>
					<td><input id="goodPrice" name="goodPrice"
						class="easyui-numberbox" data-options="required:true"
						style="width: 200px;"></td>
					<th>商品单位</th>
					<td><input id="unit" name="unit" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>材质</th>
					<td><input id="material" name="material"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
						<th>重量</th>
					<td><input id="weight" name="weight" class="easyui-numberbox"
						data-options="required:true" style="width: 145px;">&nbsp;<input
						id="weight_unit" name="weight_unit" class="easyui-validatebox"
						style="width: 50px;"></td>
				</tr>
				<tr>
					<th>特色描述</th>
					<td colspan="3"><input id="description" name="description"
						class="easyui-validatebox" data-options="required:true"
						style="width: 460px;"></td>
				</tr>
				
				
				<tr>
					<th>备注</th>
					<td colspan="3"><input id="remark" name="remark"
						class="easyui-validatebox" data-options="required:true"
						style="width: 460px;"></td>
				</tr>
				<tr>
					<th>列表图片</th>
					<td colspan="3" valign="top" height="150px"><a class="uploadImage"
						href="#"> <input type="file" onchange="selectImage(this,1);" />添加图片
					</a>
						<div id="addMainImg"></div></td>
				</tr>
				<tr>
					<th>详情页图片</th>
					<td colspan="3"><a href="javascript:void(0)" onclick="addImage()">添加图片</a>
					</td>
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
		style="width: 800px; height: 500px; padding: 10px;">
		<div style="width: 100%; height: 200px;">
			<h3>主图片</h3>
			<a class="uploadImage" href="#"> <input type="file"
				onchange="selectImage(this,6);" />添加图片
			</a>
			<div id="addMainImageDiv"></div>
		</div>
		<h3>详情图片</h3>
		<div style="width: 100%; height: 200px;">
			<a class="uploadImage" href="#"> <input type="file"
				onchange="selectImage(this,10);" />添加图片
			</a>
			<div id="addDetailImageDiv"></div>
		</div>
		<div style="width: 100%;" align="center">
			<input type="button" id="imgBtnOk" value="确定 " />
		</div>
	</div>

	<div id="detailWin" class="easyui-window"
		data-options="modal:true,closed:true,
		minimizable:false,
		maximizable:false,
		draggable:true,
		collapsible:false"
		style="width: 600px; height: 500px; padding: 10px;">
		<table>
			<tr>
				<td align="right"><label>商品编码</label>：</td>
				<td><span id="sku_num_detail"></span></td>
				<td align="right"><label>商品名称</label>：</td>
				<td><span id="goodName_detail"></span></td>
			</tr>
			<tr>
				<td align="right"><label>商品价格</label>：</td>
				<td><span id="goodPrice_detail"></span></td>
				<td align="right"><label>商品单位</label>：</td>
				<td><span id="unit_detail"></span></td>
			</tr>
			<tr>
				<td align="right"><label>商品品牌</label>：</td>
				<td><span id="brand_detail"></span></td>
				<td align="right"><label>商品产地</label>：</td>
				<td><span id="madeIn_detail"></span></td>
			</tr>
			<tr>
				<td align="right"><label>材质</label>：</td>
				<td><span id="material_detail"></span></td>
				<td align="right"><label>特色描述</label>：</td>
				<td><span id="description_detail"></span></td>
			</tr>
			<tr>
				<td align="right"><label>备注</label>：</td>
				<td><span id="remark_detail"></span></td>
				<td align="right"><label>重量</label>：</td>
				<td><span id="weight_detail"></span></td>
			</tr>
			<tr>
				<td align="right"><label>创建时间</label>：</td>
				<td><span id="createtime_detail"></span></td>
				<td align="right"><label>更新时间</label>：</td>
				<td><span id="updatetime_detail"></span></td>
			</tr>
			<tr>
				<td align="right"><label>列表图片</label>：</td>
				<td colspan="3"><div id="detailListImg"></div></td>
			</tr>
			<tr>
				<td align="right"><label>主图片</label>：</td>
				<td colspan="3"><div id="detailMainImg"></div></td>
			</tr>
			<tr>
				<td align="right"><label>详情图片</label>：</td>
				<td colspan="3"><div id="detailDetailImg"></div></td>
			</tr>
		</table>
	</div>
</body>
<script type="text/html" id="imageDiv">
<span>
	<input name="imageUrl" class="easyui-validatebox" data-options="required:true" placeholder="图片访问路径" style="width: 200px;" readonly="readonly"> 
	<input type="file" onchange="selectImage(this);"> <br/>
	<img class="imageUrl" src="" style="width: 160px; height: 100px;display:none;" /> <br/>
	<input type="button" onclick="deleteImage(this);" value="删除" style="display:none;"/>
</span>
	
</script>
<script src="js/goodInfo.js"></script>
</html>
