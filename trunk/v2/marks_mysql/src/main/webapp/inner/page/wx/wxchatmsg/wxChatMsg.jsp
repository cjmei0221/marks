<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxChatMsg.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/wxChatMsg.css" />

<%@include file="../../include/common.jsp"%>
<script type="text/javascript"
	src="../../../easyui/js/extend/datagrid-detailview.js"></script>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">询问管理>>询问管理</p>
		<div id="tb" style="padding: 5px 0;">
			<table>
				<tr>
					<td><input type="text" id="keyword" name="keyword"
						style="width: 260px;" placeholder="关键字" /></td>
					<td><a id="doSearch" href="javascript:void(0)"
						class="easyui-linkbutton menuBtnCls"
						data-options="iconCls:'icon-search'">查询</a><a id="refreshTable"
						href="javascript:void(0)" class="easyui-linkbutton menuBtnCls"
						data-options="iconCls:'icon-reload'">刷新</a></td>
				</tr>
			</table>
			<div>
				<%-- <wt:button /> --%>
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
			<div align="right" style="width: 100%;">
			   <img id="refreshBtn" alt="" src="../../../easyui/css/themes/icons/reload.png">&nbsp;&nbsp;
			</div>
			<div id="msg"
				style="overflow: auto; text-align: left; height: 150px;"></div>
			<form id="ff" name="ff" method="post">
				<input type="hidden" id="session_id" name="session_id">
				<table id="msgTable">
					<tr style="display: none;">
						<th>回复方式</th>
						<td><select id="c_replayType" class="easyui-combobox"
							name="c_replayType" style="width: 200px;">
								<option value="TEXT">文字</option>
								<!-- <option value="NEWS">图文</option> -->
						</select></td>
					</tr>
					<tr>
						<td align="left"><textarea
								style="width: 550px; height: 150px;" id="c_content"
								name="c_content" data-options="required:true" maxlength="1024"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;"><a id="btnOK"
							name="btnOK" href="javascript:void(0)" class="easyui-linkbutton"
							style="width: 100px;" data-options="">发送</a></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

</body>
<script src="js/wxChatMsg.js"></script>
</html>
