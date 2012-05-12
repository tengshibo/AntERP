function Account() {
	var me = this;
	me.showAccountInfo = function() {
		jQuery("#accountListTable").jqGrid({
			url :"modules/account/getAll",
			datatype : "json",
			mtype : "post",
			height: "280px",
			autowidth:true,
			caption: "",
			colNames : [ "账户ID","员工姓名","员工账户","账户状态", "年龄", "性别","角色","移动电话","紧急联系电话","地址","创建日期","最后修改日期","操作" ],
			colModel : [ 
			    {name : "accid",hidden:true}, 
			    {name : "empname"},
			    {name : "accname"}, 
			    {name : "status"}, 
			    {name : "age"}, 
			    {name : "gender"},
			    {name : "roleid"},
			    {name : "phoneno"},
			    {name : "urgentphone",hidden:true},
			    {name : "address",hidden:true},
			    {name : "createtime",hidden:true},
			    {name : "lastmodifytime",hidden:true},
			    {name : "act"}
			    ],
			  //用于解析server传过来的数据
				jsonReader :{
					userdata : "rows",
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
						status:codeValue.statusValue(data.status),
						gender:codeValue.genderValue(data.gender),
						roleid:codeValue.roleValue(data.roleid),
						act:"&nbsp;&nbsp;&nbsp;<input type='button'  value='详情' onclick='createAccount("+id+")'></input>"+
							"&nbsp;&nbsp;&nbsp;<input type='button'  value='删除' onclick='delAccountById("+data.accid+")'></input>"
					    }
						);
					
				},
				
				loadComplete:function(data){
				}
		});
	};
	//删除账户
	me.delAccount =function(accountId){
		
		var doDel = window.confirm("确定删除该账户资料吗？");
     if (doDel == true) {		
		var params = {
				accId : accountId
			};
		
		jQuery.ajax({
			url : "modules/account/delAccount",
			type : "post",
			data : params,
			dataType : "json",
			success : function(data) {
				if (data.ok == false) {
					alert(data.errorDesc);
					return;
				} else {
					alert("删除成功!");
					refreshDate();
				}
			}
		});
		}	
	};
    //新建账户
	me.createAccount =function(){
		jQuery.ajax({
			url : "modules/account/accountDetail.html",
			type : "post",
			async : false,
			success : function(data) {
				var content = '<div id="accountDetailDialog">'+data +"</div>";
				jQuery(content).dialog({
					title : "账户信息",
					modal : true,
					resizable : false,
					height : "auto",
					width : "340",
					close : function(){
						jQuery("#accountDetailDialog").remove();
					},
					buttons : [ 
					{
						text : "保存",
						click : me.saveAccount
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
	
	//保存账户信息
	me.saveAccount =function(){
		//check
		if(!checksubmit(document.forms[0]))
			return false;
		//账户信息.
		var account ={};
		  account.accid= jQuery("#accountDetailDiv #accid").val(); 
		  account.empname=jQuery("#accountDetailDiv #empName").val();
		  account.accname=jQuery("#accountDetailDiv #accname").val();
		  account.status=jQuery("#accountDetailDiv #status").val();
		  account.age= jQuery("#accountDetailDiv #age").val();
		  account.gender=jQuery("#accountDetailDiv #gender").val();
		  account.phoneno=jQuery("#accountDetailDiv #phoneNo").val();
		  account.urgentphone=jQuery("#accountDetailDiv #urgentPhone").val();
		  account.address=jQuery("#accountDetailDiv #address").val();
        //角色
		var accRole ={};
		  accRole.roleid=jQuery("#accountDetailDiv #roleid").val();

	      var url ="modules/account/updateAccount";
		  if(account.accid=="-1"){
			  account.accid="";
			  url="modules/account/addAccount"; 
		   }

		  var params = {
					 account:JSON.stringify(account),
					 accrole:JSON.stringify(accRole)
				  } ;
		  
		  jQuery.ajax({
				url : url,
				type : "post",
				data : params,
				dataType : "json",
				success : function(data) {
					if (data.ok == false) {
						alert(data.errorDesc);
						return;
					} else {
						alert
						if(account.accid==""){
							alert("添加账户成功!");
						}else{
							alert("修改账户成功!");
						}
						jQuery(this).dialog("close");
						jQuery("#accountDetailDialog").remove();
						refreshDate();
					}
				}
			});		  
	};
	//查询
	me.search = function(){
	  
	  var account ={};
	   account.empname=jQuery("#serEmpName").val();
	   account.accname=jQuery("#serAccName").val();   	
	   account.phoneno=jQuery("#serPhoneNo").val();
	   
	   var params ={
			account:JSON.stringify(account)		
	   };
	   
	   $("#accountListTable").clearGridData();
	   jQuery("#accountListTable").jqGrid("setGridParam", {
			url : "modules/account/getAll"
		});
	   $("#accountListTable").jqGrid("setGridParam",{postData:params});
	   $("#accountListTable").trigger("reloadGrid");
	};
	
}
//默认查询显示账户信息.
jQuery(document).ready(function() {
	var acc = new Account();
	acc.showAccountInfo();
	//新建按钮绑定事件.
	jQuery("#createAccount").unbind().bind("click", acc.createAccount);
	//查询按钮绑定时间
	jQuery("#qryBt").unbind().bind("click", acc.search);
});
//删除账户.
var delAccountById =function(accountId){
	new Account().delAccount(accountId);	
};
//查看账户详细.
var createAccount =function(rowid){
	// 高亮这一行
	jQuery("#accountListTable").jqGrid('setSelection', rowid);
	// 按照rowId取出这行对应Custom对象
	var userData = jQuery("#accountListTable").jqGrid("getGridParam",
			"userData");
	var data = userData[rowid - 1];
	new Account().createAccount();	
	jQuery("#accountDetailDiv #accid").val(data.accid);
	jQuery("#accountDetailDiv #empName").val(data.empname);
	jQuery("#accountDetailDiv #accname").val(data.accname);
	jQuery("#accountDetailDiv #status").val(data.status);
	jQuery("#accountDetailDiv #age").val(data.age);
	jQuery("#accountDetailDiv #gender").val(data.gender);
	jQuery("#accountDetailDiv #phoneNo").val(data.phoneno);
	jQuery("#accountDetailDiv #urgentPhone").val(data.urgentphone);
	jQuery("#accountDetailDiv #address").val(data.address);
	jQuery("#accountDetailDiv #roleid").val(data.roleid);
	
};
//刷新查询结果.
var refreshDate = function(){
	
	jQuery("#accountListTable").clearGridData();
	jQuery("#accountListTable").jqGrid("setGridParam", {
		url : "modules/account/getAll"
	});
	jQuery("#accountListTable").trigger("reloadGrid");
	
};


//代码表转换.
var codeValue=new CodeToValue();

function CodeToValue(){
	var me =this;
	//获取角色值.
	me.roleValue=function(code){
		switch(code){
		case 1:  {return "超级用户";}
		case 2:  {return "管理层";	}
		case 3:  { return "财务人员";}
		case 4:  {return "库管";}
		case 5:  {return "业务员";}
		default: {return code;}
	  }
	};	
	
   //获取性别	
	me.genderValue=function(code){
		switch(code){
		case 0:  {return "男";	}
		case 1:  { return "女";}
		default: {return code;   }
	    }		
	};
	//获取账户状态.
	me.statusValue = function(code){		
	 switch(code){
		case 0:  {return "正常";	}
		case 1:  { return "冻结";}
		default: {return code;   }
	  }
	};
	
};





