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
<style type="text/css">
.my-body-cls {
	background-color: lightsalmon;
}

.my-main-cls {
	position: relative;
	margin: 5px;
	width: 100%;
	right: 5px;
}

.my-idx-cls {
	position: relative;
	width: 800px;
	left: 5px;
	top: 5px;
	margin: 0px;
	padding: 0px;
	line-height: 100px;
}

.my-btn-cls {
	position: relative;
	left: 10px;
	height: 32px;
	width: 100px;
	vertical-align: middle;
}

.search-cls {
	text-align: center;
}

.item-cls {
	border-bottom: 1px solid #ffffff;
}

.list-item-cls {
	padding: 20px;
	text-indent: 2em;
}

.my-img-cls {
	width: 380px;
	height: 400px;
}

.my-good-cls {
	padding: 10px;
}

.my-good-table-cls {
	position: relative;
	left: 10;
}

.my-head-cls {
	padding: 5px;
	border-bottom: 2px solid #ffffff;
}
</style>
</head>
<body class="my-body-cls">
	<div class="my-main-cls" style="text-indent: 2em;">
		<div class="col-md-9 col-md-push-3">
			<a href="">注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">登陆</a>
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
				id="newMcBtn">新增定制</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#"
				id="myMcBtn">我的定制</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">募集商品</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="#">热销商品</a>&nbsp;&nbsp;>
			</span>
		</h3>
	</div>
	<div id="myContent">
		
	</div>

</body>
<script type="text/javascript">
	$(function() {
		$("#myContent").load("./makeGood/main.jsp");
		$("#myMcBtn").on("click", function() {
			$("#myContent").load("./makeGood/myMc/myMake.jsp");
		});
	});
</script>
</html>