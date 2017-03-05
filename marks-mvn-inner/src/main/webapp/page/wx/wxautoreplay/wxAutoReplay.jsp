<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="wt" uri="/taglib/common.tld"%>
<!DOCTYPE html>
<!-- WxAutoReplay.html -->
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/wxAutoReplay.css" />

<%@include file="../../include/common.jsp"%>
</head>

<body>

	<div id="mainPanel">
		<p class="nav-header-cls">微信回复管理>>微信回复管理</p>
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
		style="width: 400px; height: 400px; padding: 10px;">
		<form id="ff" name="ff" method="post">
			<input type="hidden" id="ctype" name="ctype">
			<table class="out-win-cls">

				<tr>
					<th>名称</th>
					<td><input id="ctypeName" name="ctypeName"
						class="easyui-validatebox" data-options="required:true"
						style="width: 200px;"></td>
				</tr>
				<tr>
					<th>关键字</th>
					<td><input id="ckey" name="ckey" class="easyui-validatebox"
						data-options="required:true" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>回复方式</th>
					<td><select id="replayType" class="easyui-combobox"
						name="replayType" style="width: 200px;">
							<option value="TEXT">文字</option>
							<option value="NEWS">图文</option>
							<option value="MODULE">指令</option>
					</select></td>
				</tr>
				<tr id="newsListTr" style="display: none;">
					<th>图文</th>
					<td><input id="newsList" class="easyui-combobox"
						data-options="multiple:true,valueField:'id',textField:'text',url:'<%=request.getContextPath()%>/newsItem/combox.do'"
						name="newsList" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>回复内容</th>
					<td><textarea rows="5" cols="30" style="width: 200px;"
							id="creplay" name="creplay"></textarea></td>
				</tr>


				<tr id="accountidTr">
					<th>公众号</th>
					<td><input id="accountid" name="accountid"
						class="easyui-combobox"
						data-options="required:true,valueField:'accountId',textField:'accountname',url:'<%=request.getContextPath()%>/wxAccount/combox.do'"
						style="width: 200px;"></td>
				</tr>
				<tr id="delFlagTr">
					<th>是否可删除</th>
					<td><select id="delFlag" class="easyui-combobox"
						name="delFlag" style="width: 200px;">
							<option value="1">是</option>
							<option value="0">否</option>

					</select></td>
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
<script src="js/wxAutoReplay.js"></script>
</html>
