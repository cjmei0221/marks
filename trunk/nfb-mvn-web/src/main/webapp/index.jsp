<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>定制商城</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap -->
<link href="./framework/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="./css/common.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="./framework/bootstrap/js/bootstrap.min.js"></script>
<script src="./js/my-config.js"></script>
<style type="text/css">

</style>
</head>
<body class="my-body-cls">
	<div class="my-main-cls" style="text-indent: 2em;">
		<div class="col-md-9 col-md-push-3">
			<a href="javascript:;">注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:;">登陆</a>
		</div>
	</div>
	<div class="my-main-cls search-cls">
		<div class="row-fluid">
			<input type="text" placeholder="搜索" class="my-idx-cls">
			<button class="btn my-btn-cls" type="button">查询</button>
		</div>
	</div>

	<div class="my-main-cls" style="text-align: center;">
		<h3 style="color: #ffffff;">
			<span class="my-head-cls"><&nbsp;&nbsp;<a href="javascript:;"
				id="newMcBtn">新增定制</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:;" id="myMcBtn">我的定制</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:;" id="myRaiseBtn">募集商品</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:;" id="myGoodBtn">热销商品</a>&nbsp;&nbsp;>
			</span>
		</h3>
	</div>
	<div id="myContent"></div>

</body>
<script type="text/javascript">
	$(function() {
		$("#myContent").load("./makeGood/main/main.jsp");
		$("#myMcBtn").on("click", function() {
			$("#myContent").load("./makeGood/myMc/myMake.jsp");
		});
		$("#myRaiseBtn").on("click", function() {
			$("#myContent").load("./makeGood/raise/raiseGood.jsp");
		});
		$("#myGoodBtn").on("click", function() {
			$("#myContent").load("./makeGood/good/goodList.jsp");
		});
	});
</script>
</html>