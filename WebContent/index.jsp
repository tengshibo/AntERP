<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/modules/common/CommonHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>AntERP Login</title>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/site.css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/wresize.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</head>

<body>
	<form id="loginForm" name="loginForm" style="display: none;" action="" method="post"></form>
	<div id="loginFormDiv" class="loginDiv">
		<div class="formTr">
			<div class="loginInputLabel floatLeft">账 户:</div>
			<div class="loginInputText">
				<input class="inputW" id="accName" type="text" maxlength="64" size="16" />
			</div>
		</div>
		<div class="formTr">
			<div class="loginInputLabel floatLeft">密 码:</div>
			<div class="loginInputText">
				<input class="inputW" id="accPwd" type="password" maxlength="32" size="16" />
			</div>
		</div>
		<div class="formTr">
			<div id="changePwdBtn" class="floatLeft">
				<input type="button" value="修改密码" />
			</div>
			<div id="loginBtn" class="loginBtn">
				<input type="button" value="登录系统" />
			</div>
		</div>
	</div>
</body>
</html>