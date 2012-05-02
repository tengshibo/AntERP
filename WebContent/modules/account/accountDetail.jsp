<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/modules/common/CommonHead.jsp"%>
<div id="customDetailDiv">
	<div class="divTr">
		<label class="divTdLeft">员工姓名:</label>
		<div class="divTd divTdRight">
			<input id="empName" type="text">
		</div>
	</div>
	<div class="divTr">
		<label class="divTdLeft">员工账户:</label>
		<div class="divTd divTdRight">
			<input id="accname" type="text">
		</div>
	</div>
	<div class="divTr">
		<label class="divTdLeft">账户状态:</label>
		<div class="divTd divTdRight">
			<input id="status" type="text">
		</div>
	</div>
	<div class="divTr">
		<label class="divTdLeft">年龄:</label>
		<div class="divTd divTdRight">
			<input id="age" type="text" size="1">
		</div>
	</div>
	<div class="divTr">
		<label class="divTdLeft">性别:</label>
		<div class="divTd divTdRight">
			<select id="gender">
				<option value="0">男</option>
				<option value="1">女</option>
			</select>
		</div>
	</div>
		<div class="divTr">
		<label class="divTdLeft">移动电话:</label>
		<div class="divTd divTdRight">
			<input id="phoneNo" type="text" size="1">
		</div>
	</div>
	<div class="divTr">
		<label class="divTdLeft">紧急联系电话:</label>
		<div class="divTd divTdRight">
			<input id="urgentPhone" type="text" size="1">
		</div>
	</div>
	
	<div class="divTr">
		<label class="divTdLeft">地址:</label>
		<div class="divTd">
			<textarea id="address" rows="2" cols="35"></textarea>
		</div>
	</div>
</div>