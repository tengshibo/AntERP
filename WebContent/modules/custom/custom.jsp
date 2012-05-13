<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/modules/common/CommonHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>AntERP 客户管理</title>
<link rel="stylesheet" type="text/css" href="widget/jgUI/css/ui-lightness/jquery-ui-1.8.20.custom.css" />
<link rel="stylesheet" type="text/css" href="widget/jqGrid/css/ui.jqgrid.css" />
<script type="text/javascript">
	if (!window.accountInfoJson) {
		window.accountInfoJson = <%=session.getAttribute("accountInfoJson")%>;
	}
</script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/antUtil.js"></script>
<script type="text/javascript" src="widget/jgUI/js/jquery-ui-1.8.20.custom.js"></script>
<script src="widget/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="widget/jqGrid/js/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="widget/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

<script type="text/javascript" src="modules/custom/custom.js"></script>
<link rel="stylesheet" type="text/css" href="modules/custom/custom.css" />

</head>
<body>
	<div id="customFuncDiv">
		<div id="createCustomDiv"><input id="createCustom" type="button" value="新建客户"/></div>
		<div id="searchCustomZone">
			<div id="searchCustomDiv"><input id="searchCustomBtn" type="button" value="搜索"/></div>
			<div class="searchNameDiv">姓名:<input type="text" id="searchName"></div>
			<div class="searchPhoneNumDiv">电话:<input type="text" id="searchPhoneNum"></div>
		</div>
	</div>
	<table id="customListTable"><tr><td/></tr></table>
	<div id="customListPager"></div>
</body>
</html>