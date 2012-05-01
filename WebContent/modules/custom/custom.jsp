<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/modules/common/CommonHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>AntERP 客户管理</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	if (!window.accountInfoJson) {
		window.accountInfoJson = <%=session.getAttribute("accountInfoJson")%>;
	}
	alert(window.accountInfoJson.accname);
</script>
</head>
<body>Custom Page!
</body>
</html>