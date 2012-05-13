<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/modules/common/CommonHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>AntERP 账户管理</title>
<script type="text/javascript">
	if (!window.accountInfoJson) {
		window.accountInfoJson = <%=session.getAttribute("accountInfoJson")%>;
	}
</script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/antUtil.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="widget/jgUI/css/ui-lightness/jquery-ui-1.8.20.custom.css" />
<link rel="stylesheet" type="text/css" href="modules/account/account.css" />
<script type="text/javascript" src="widget/jgUI/js/jquery-ui-1.8.20.custom.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="widget/jqGrid/css/ui.jqgrid.css" />
<script src="widget/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="widget/jqGrid/js/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="modules/account/account.js" type="text/javascript"></script>
<script type="text/javascript" src="js/validatebox.js"></script>
</head>
<body>
	<div id="accountFuncDiv">
    	<input id="createAccount" type="button"  value="新建账户"/>
    	<input id="qryBt" type="button" value="查询" />	
	</div>
  <div id="searchConditionDiv" >
   <div class="input">
   <table>
     <tr >
      <td >员工姓名:</td>
      <td ><input type="text" id="serEmpName"  ></input></td>
      <td>员工账户:</td>
      <td><input  id="serAccName" type="text" ></input></td>
      <td>移动电话:</td>
      <td><input id="serPhoneNo" type="text" ></input></td>
     </tr>
   </table>
   </div>
  </div>
	<table id="accountListTable"><tr><td/></tr></table>
	<div id="accountListPager"></div>
</body>
</html>