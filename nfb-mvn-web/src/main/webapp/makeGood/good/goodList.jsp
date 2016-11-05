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
<link href="./makeGood/good/goodList.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
</style>
</head>
<body class="my-body-cls">
	<div class="my-main-cls">
		<h3 class="item-cls">
			<a>热销商品&nbsp;&nbsp;</a>
		</h3>
		<h4 style="color: #ffffff; text-align: center; float: none;">
			<span><&nbsp;&nbsp;<a href="javascript:;" id="first">首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:;" id="last">上一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:;" id="next">下一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:;" id="end">末页</a>&nbsp;&nbsp;>
			</span>
		</h4>
		<div style="text-align: center;">
			<div id="myGoodList" class="my-good-table-cls">

				<div class="list--item-cls my-good-cls">
					<p>
						<img class="my-img-cls" src="./images/aa.jpg">
					</p>
					<p>价格：100 ￥</p>
					<p>上线日期：2016-11-12</p>
				</div>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./makeGood/good/goodList.js"></script>

<script type="text/html" id="goodListTpl">
			<div class="list--item-cls my-good-cls" onclick="getGoodDetail('{goodId}')">
				<p>
					<img class="my-img-cls" src="{imageUrl}">
				</p>
				<p>价格：{goodPrice} ￥</p>
				<p>上线日期：{createdate}</p>
			</div>
</script>
</html>