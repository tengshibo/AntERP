function Custom() {
	var me = this;

	var jqGridOptin = {
		url : "modules/custom/getAll",
		datatype : "json",
		mtype : "post",
		height : "100%",
		autowidth : true,
		caption : "",
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
		} ],
		jsonReader : {
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
		rowList : [ "5", "10", "50", "100", "500" ],
		repeatitems : false,
		viewrecords : true,
		emptyrecords : "查询结果为空!",
		pager : "#customListPager",
		rowNum : 10,
		sortable : false
	};

	me.showAllCustom = function() {
		jQuery("#customListTable").jqGrid(jqGridOptin);
		jQuery("#customListTable").navGrid('#customListPager',{edit:false,add:false,del:false,search:false});
		jQuery("#customListTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x' : 'hidden' });
	};

}

jQuery(document).ready(function() {
	var custom = new Custom();
	// show the custom data table
	custom.showAllCustom();

	// jQuery("#customListTable")
});