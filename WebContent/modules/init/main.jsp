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
<body style="height: 100%">
	<div id="topDiv">欢迎使用AntERP 系统</div>
	<div id="downWrapperDiv">
		<div id="leftMenu">
			<div id="custom_menu" class="antMenu antMenuHeightLight">客户资料</div>
			<div id="account_menu" class="antMenu">员工资料</div>
		</div>
		<div id="centerMain" style="width: 800px;">
			<iframe id="rightIframe" src="http://www.baidu.com"></iframe>
		</div>
	</div>
</body>
</html>