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

<title>AntERP Login</title>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/site.css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</head>

<body>
	<div id="loginForm" class="loginDiv">
		<div class="formTr">
			<div class="loginInputLabel floatLeft">Account:</div>
			<div class="loginInputText">
				<input type="text" maxlength="64" size="24" />
			</div>
		</div>
		<div class="formTr">
			<div class="loginInputLabel floatLeft">Password:</div>
			<div class="loginInputText">
				<input type="password" maxlength="32" size="24" />
			</div>
		</div>
		<div class="formTr">
			<div class="floatLeft" id="loginBtn">
				<input type="button" value="Login">
			</div>
			<div id="changePwdBtn">
				<input type="button" value="Change Password">
			</div>
		</div>
	</div>
</body>
</html>
