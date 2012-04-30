<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/modules/common/CommonHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>AntERP</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/wresize.js"></script>
<script type="text/javascript" src="modules/init/main.js"></script>
</head>
<body style="height: 700px;">
	<div id="topDiv">This is top div, you can put common widgets or
		banner.</div>
	<div id="centerMain">
		<div id="rightContentWrapper">
			<div id="rightContentDiv">
				<iframe id="rightIframe" src="http://www.baidu.com"></iframe>
			</div>
		</div>
		<div id="leftMenu">你好</div>
	</div>
</body>
</html>