function Account() {
	var me = this;

	me.showAccountInfo = function() {
		jQuery("#accountListTable").jqGrid({
			url : null,
			datatype : "json",
			mtype : "post",
			height: "100%",
			autowidth:true,
			caption: "",
			colNames : [ "账户ID","员工姓名","员工账户","账户状态", "年龄", "性别","移动电话","紧急联系电话","地址","创建日期","最后修改日期" ],
			colModel : [ 
			    {name : "accId",hidden:true}, 
			    {name : "empName"},
			    {name : "accName"}, 
			    {name : "status"}, 
			    {name : "age"}, 
			    {name : "gender"},
			    {name : "phoneNo"},
			    {name : "urgentPhone",hidden:true},
			    {name : "address",hidden:true},
			    {name : "createTime",hidden:true},
			    {name : "lastModifyTime",hidden:true},
			    ],
			  //用于解析server传过来的数据
				jsonReader :{
					root:"dataList",//所有数据项
					page:"curPage",//当前页数
					total:"totalPageCount",//总页数
					records:"totalRecordCount",//总记录数
					repeatitems :false
				},
				//用于把前台的参数传到server
				prmNames : {
					page : "curPage", //请求的当前页码
					rows : "pageSize" //一页需要显示的行数
				},	  
				rowList:["10","50","100","500"],
				repeatitems:false,
				viewrecords:true,
				emptyrecords:"查询结果为空!",
				pager :"accountListPager",
				rowNum :10,
				//sortable:false
				onSelectRow:function(id){
					alert(id);
				},
				loadComplete : function(data) {
					 
				}
		});
	};

}

jQuery(document).ready(function() {
	new Account().showAccountInfo();

});