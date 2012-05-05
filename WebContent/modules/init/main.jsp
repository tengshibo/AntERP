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
<script type="text/javascript">
	if (!window.accountInfoJson) {
		window.accountInfoJson = <%=session.getAttribute("accountInfoJson")%>;
	}
</script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/wresize.js"></script>
<script type="text/javascript" src="modules/init/main.js"></script>
</head>
<body style="height: 100%">
	<form id="logoutForm" name="logoutForm" style="display: none;" action="" method="post"></form>
	<div id="topDiv">欢迎使用AntERP 系统<div id="logOutDiv">您好，<label id="loginedAccName"></label> [退出]</div></div>
	<div id="downWrapperDiv">
		<div id="leftMenu">
			<div id="custom_menu" class="antMenu antMenuHighlight">客户资料</div>
			<div id="account_menu" class="antMenu">员工资料</div>
		</div>
		<div id="centerMain">
			<iframe id="rightIframe" src=""></iframe>
		</div>
	</div>
</body>
</html>