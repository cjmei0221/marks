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
<link href="../framework/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="../css/common.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../framework/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
</head>
<body class="my-body-cls">
	<div id="myMc">
		<jsp:include page="../makeGood/myMc/myMake.jsp" flush="true"></jsp:include>
	</div>

	<div id="raise">
		<jsp:include page="../makeGood/raise/raiseGood.jsp"></jsp:include>
	</div>

	<div id="goodList">
		<jsp:include page="../makeGood/good/goodList.jsp"></jsp:include>
	</div>
</body>
</html>