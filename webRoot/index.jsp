<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>AntERP Login</title>
<meta charset="UTF-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div id="loginForm">
		<div class="formTr">
			<div class="loginInputLabel">Account:</div>
			<div class="loginInputText">
				<input type="text" size="64" />
			</div>
		</div>
		<div class="formTr">
			<div class="loginInputLabel">Password:</div>
			<div class="loginInputText">
				<input type="password" size="32" />
			</div>
		</div>
	</div>
</body>
</html>
