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

<link rel="stylesheet" type="text/css" media="screen" href="widget/jqUI/css/ui-lightness/jquery-ui-1.7.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="widget/jggrid/css/ui.jqgrid.css" />
<script src="widget/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="widget/jqGrid/js/jquery.jqGrid.src.js" type="text/javascript"></script>
<script type="text/javascript">
	if (!window.accountInfoJson) {
		window.accountInfoJson = <%=session.getAttribute("accountInfoJson")%>;
	}
</script>
</head>
<body>
	<table id="customListTable"><tr><td/></tr></table>
	<div id="customListPager"></div>
</body>
</html>