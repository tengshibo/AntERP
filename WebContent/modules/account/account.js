function Account() {
	var me = this;

	me.showAccountInfo = function() {
		jQuery("#accountListTable").jqGrid({
			url : "modules/account/getAll",
			datatype : "json",
			mtype : "post",
			height: "100%",
			autowidth:true,
			caption: "",
			colNames : [ "账户ID","员工姓名","员工账户","账户状态", "年龄", "性别","移动电话","紧急联系电话","地址","创建日期","最后修改日期","操作" ],
			colModel : [ 
			    {name : "accid",hidden:true}, 
			    {name : "empname"},
			    {name : "accname"}, 
			    {name : "status"}, 
			    {name : "age"}, 
			    {name : "gender"},
			    {name : "phoneno"},
			    {name : "urgentPhone",hidden:true},
			    {name : "address",hidden:true},
			    {name : "createTime",hidden:true},
			    {name : "lastModifyTime",hidden:true},
			    {name : "act"}
			    ],
			  //用于解析server传过来的数据
				jsonReader :{
					root : "rows",// 所有数据项
					page : "page",// 当前页数
					total : "total",// 总页数
					records : "records",// 总记录数
					repeatitems : false
				},
				//用于把前台的参数传到server
				prmNames : {
					page : "page",
					rows : "rows"
				},	  
				rowList:["10","50","100","500"],
				repeatitems:false,
				viewrecords:true,
				emptyrecords:"查询结果为空!",
				pager :"accountListPager",
				rowNum :10,
	
				onSelectRow:function(id){
					
				},
				
				afterInsertRow:function(id,rd,data){
					jQuery("#accountListTable").jqGrid("setRowData",id,
					    {
						
						act:"&nbsp;&nbsp;&nbsp;<input type='button' class='b_foot' value='详情' onclick='createAccount()'></input>"+
							"&nbsp;&nbsp;&nbsp;<input type='button' class='b_foot' value='删除' onclick='delAccountById("+data.accid+")'></input>"
					    }
						);
					
				},
				
				loadComplete:function(data){
				}
		});
	};
	//删除账户
	me.delAccount =function(accountId){
		
		var params = {
				accId : accountId
			};
		
		jQuery.ajax({
			url : "modules/account/delAccount",
			type : "post",
			data : params,
			dataType : "json",
			success : function(data) {
				$("#accountListTable").trigger("reloadGrid");
				if (data.ok == false) {
					alert(data.errorDesc);
					return;
				} else {
					window.jsessionid = data.jsessionid;
					me.doLogin();
				}
			}
		});
		
	};
    //新建账户
	me.createAccount =function(obj){
	   // alert(obj.accid);
		jQuery.ajax({
			url : "modules/account/accountDetail.jsp",
			type : "post",
			success : function(data) {
				var content = '<div id="accountDetailDialog">'+data +"</div>";
				jQuery(content).dialog({
					title : "账户信息",
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
	
	
	
}

jQuery(document).ready(function() {
	new Account().showAccountInfo();

});

var delAccountById =function(accountId){
	new Account().delAccount(accountId);	
};

var createAccount =function(data){
	new Account().createAccount(data);	
};
