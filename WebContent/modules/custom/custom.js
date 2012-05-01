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
		rowList : [ "15", "20", "50", "100", "500" ],
		rowNum : "20",
		repeatitems : false,
		viewrecords : true,
		emptyrecords : "查询结果为空!",
		pager : "#customListPager",
		sortable : false
	};

	me.showAllCustom = function() {
		jQuery("#customListTable").jqGrid(jqGridOptin);
		jQuery("#customListTable").navGrid('#customListPager', {
			edit : true,
			add : true,
			del : true,
			search : true
		});
		// jQuery("#customListTable").closest(".ui-jqgrid-bdiv").css({
		// 'overflow-x' : 'hidden' });
	};

	me.attachEvents = function() {
		jQuery("#createCustom").bind("click", me.createCustom);
	};

	// 新建客户资料
	me.createCustom = function() {
		jQuery.ajax({
			url : "modules/custom/customDetail.html",
			type : "post",
			success : function(data) {
				var content = '<div id="customDetailDialog">'+data +"</div>";
				jQuery(content).dialog({
					title : "客户信息",
					modal : true,
					resizable : false,
					height : "auto",
					width : "340",
					buttons : [ 
					{
						text : "保存",
						click : function() {
							jQuery(this).dialog("close");
						}
					}, 
					{
						text : "取消",
						click : function() {
							jQuery(this).dialog("close");
						}
					} ]
				});
			}
		});
	};
	
	me.afterCreateCustom = function(){
		// 刷新页面
	};
}

jQuery(document).ready(function() {
	var custom = new Custom();
	// show the custom data table
	custom.showAllCustom();
	// bind event
	custom.attachEvents();
	// jQuery("#customListTable")
});