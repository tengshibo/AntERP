function Custom() {
	var me = this;

	me.genderFormatter = function(cellvalue, options, rowObject) {
		if (cellvalue == 0) {
			return "男";
		} else {
			return "女";
		}
	};

	me.birthdayFormatter = function(cellvalue, options, rowObject) {
		var date = new Date();
		date.setTime(cellvalue);
		return date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay();
	};

	me.cellattr = function(rowId, val, rawObject, cm, rdata) {
		return JSON.stringify(rawObject);
	};

	me.actFormatter = function(cellvalue, options, rawObject) {
		var detail = '<input type="button" value="详情" onclick="showCustomDetail('
				+ rawObject.custid + ',' + options.rowId + ')">';

		var deleteBtn = '<input type="button" value="删除" onclick="deleteCustom('
				+ rawObject.custid + ')">';

		return "&nbsp;&nbsp;&nbsp;\t" + detail + "&nbsp;&nbsp;&nbsp;\t"
				+ deleteBtn;
	};

	var jqGridOptin = {
		url : "modules/custom/getAll",
		datatype : "json",
		mtype : "post",
		height : "100%",
		autowidth : true,
		caption : "客户资料",
		colNames : [ "ID", "姓名", "性别", "年龄", "出生日期", "电话", "地址", "操作" ],
		colModel : [ {
			name : "custId",
			cellattr : me.cellattr,
			hidden : true
		}, {
			name : "custname"
		}, {
			name : "gender",
			formatter : me.genderFormatter
		}, {
			name : "age"
		}, {
			name : "birthday",
			formatter : me.birthdayFormatter
		}, {
			name : "phoneno"
		}, {
			name : "address"
		}, {
			name : "act",
			title : false,
			formatter : me.actFormatter
		} ],
		jsonReader : {
			userdata : "rows",
			root : "rows",// 所有数据项
			page : "page",// 当前页数
			total : "total",// 总页数
			records : "records",// 总记录数
			repeatitems : false
		},
		prmNames : {
			page : "page",
			rows : "rows"
		},
		rowList : [ "15", "20", "50", "100", "500" ],
		rowNum : "20",
		repeatitems : false,
		viewrecords : true,
		emptyrecords : "查询结果为空!",
		pager : "#customListPager",
		sortable : true,
		onSelectRow : function(id) {
			// alert(id);
		}
	};

	me.showAllCustom = function() {
		jQuery("#customListTable").jqGrid(jqGridOptin);
		jQuery("#customListTable").navGrid('#customListPager', {
			edit : false,
			add : false,
			del : false,
			search : false
		});
		// jQuery("#customListTable").closest(".ui-jqgrid-bdiv").css({
		// 'overflow-x' : 'hidden' });
	};

	me.attachEvents = function() {
		jQuery("#createCustom").unbind("click").bind("click", me.createCustom);
	};

	me.deleteCustom = function(custId) {
		// alert("delete custom:" + custId);
		var params = {};
		params.custId = custId;
		jQuery.ajax({
			url : "modules/custom/delete",
			type : "post",
			async : false,
			data : params,
			dataType : "json",
			success : me.refreshCustomTable
		});
	};

	me.renderCustomDetail = function(customObj) {
		jQuery("#custId").val(customObj.custid);
		jQuery("#custName").val(customObj.custname);
		jQuery("#gender").val(customObj.gender);
		jQuery("#age").val(customObj.age);
		var birth = new Date();
		birth.setTime(customObj.birthday);
		jQuery("#birthYear").val(birth.getFullYear());
		jQuery("#birthMonth").val(birth.getMonth());
		jQuery("#birthDay").val(birth.getDay());

		jQuery("#phoneNo").val(customObj.phoneno);
		jQuery("#address").val(customObj.address);
		jQuery("#familyDesc").val(customObj.familydesc);
	};

	me.doUpdateCustom = function() {
		var customObj = me.getCustomDetilForm();
		customObj = JSON.stringify(customObj);
		var params = "custom=" + customObj;
		jQuery.ajax({
			url : "modules/custom/update",
			type : "post",
			async : false,
			data : params,
			dataType : "json",
			success : me.refreshCustomTable
		});
	};

	me.showCustomDetail = function(custId, rowId) {
		// 高亮这一行
		jQuery("#customListTable").jqGrid('setSelection', rowId);
		// 按照rowId取出这行对应Custom对象
		var userData = jQuery("#customListTable").jqGrid("getGridParam",
				"userData");
		var rowCustom = userData[rowId - 1];

		jQuery
				.ajax({
					url : "modules/custom/customDetail.html",
					type : "post",
					success : function(data) {
						var content = '<div id="customDetailDialog">' + data
								+ "</div>";
						jQuery(content).dialog({
							title : "客户信息",
							modal : true,
							resizable : false,
							height : "auto",
							width : "340",
							open : function() {
								me.renderCustomDetail(rowCustom);
							},
							close : function() {
								jQuery("#customDetailDialog").remove();
							},
							buttons : [ {
								text : "保存",
								click : me.doUpdateCustom
							}, {
								text : "取消",
								click : function() {
									jQuery(this).dialog("close");
									jQuery("#customDetailDialog").remove();
								}
							} ]
						});
					}
				});
	};

	// 新建客户资料
	me.createCustom = function() {
		jQuery
				.ajax({
					url : "modules/custom/customDetail.html",
					type : "post",
					success : function(data) {
						var content = '<div id="customDetailDialog">' + data
								+ "</div>";
						jQuery(content).dialog({
							title : "客户信息",
							modal : true,
							resizable : false,
							height : "auto",
							width : "340",
							close : function() {
								jQuery("#customDetailDialog").remove();
							},
							buttons : [ {
								text : "保存",
								click : me.doCreateCustom
							}, {
								text : "取消",
								click : function() {
									jQuery(this).dialog("close");
									jQuery("#customDetailDialog").remove();
								}
							} ]
						});
					}
				});
	};

	me.doCreateCustom = function() {
		var customObj = me.getCustomDetilForm();
		customObj = JSON.stringify(customObj);
		var params = "custom=" + customObj;
		jQuery.ajax({
			url : "modules/custom/create",
			type : "post",
			async : false,
			data : params,
			dataType : "json",
			success : me.refreshCustomTable
		});
		// alert(JSON.stringify(customObj));
	};

	me.refreshCustomTable = function(data) {
		if (data.ok == false) {
			alert(data.errorDesc);
			return;
		}
		// refresh jqGrid
		jQuery("#customDetailDialog").dialog("close");
		jQuery("#customDetailDialog").remove();
		jQuery("#customListTable").clearGridData();
		jQuery("#customListTable").jqGrid("setGridParam", {
			url : "modules/custom/getAll"
		});
		jQuery("#customListTable").trigger("reloadGrid");
	};

	me.getCustomDetilForm = function() {
		var customObj = {};
		// 更新客户时，客户ID大于零， 新建的时候，默认是零
		var custId = jQuery("#custId").val();
		if (custId > 0) {
			customObj.custid = custId;
		}
		customObj.custname = jQuery("#custName").val();
		customObj.gender = jQuery("#gender").val();
		customObj.age = jQuery("#age").val();
		var birth = new Date();
		birth.setFullYear(jQuery("#birthYear").val(), jQuery("#birthMonth")
				.val(), jQuery("#birthDay").val());
		customObj.birthday = birth.getTime();
		customObj.phoneno = jQuery("#phoneNo").val();
		customObj.address = jQuery("#address").val();
		customObj.familydesc = jQuery("#familyDesc").val();
		return customObj;
	};

}

var deleteCustom = function(custId) {
	new Custom().deleteCustom(custId);
};

var showCustomDetail = function(custId, rowId) {
	new Custom().showCustomDetail(custId, rowId);
};

jQuery(document).ready(function() {
	var custom = new Custom();
	// show the custom data table
	custom.showAllCustom();
	// bind event
	custom.attachEvents();
	// jQuery("#customListTable")
});