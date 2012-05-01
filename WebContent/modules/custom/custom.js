function Custom() {
	var me = this;

	var jqGridOptin = {

	};

	me.showAllCustom = function() {
		jQuery("#customListTable").jqGrid({
			url : "modules/custom/getAll",
			datatype : "json",
			mtype : "post",
			colNames : [ "姓名", "性别", "年龄", "出生日期", "电话", "地址" ],
			colModel : [ {
				name : "custname"
			}, {
				name : "gender"
			}, {
				name : "age"
			}, {
				name : "birthday"
			}, {
				name : "phoneno"
			}, {
				name : "address"
			} ]
		});
	};

}

jQuery(document).ready(function() {
	var custom = new Custom();
	// show the custom data table
	custom.showAllCustom();

	// jQuery("#customListTable")
});