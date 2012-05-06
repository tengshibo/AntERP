function Index() {
	var me = this;
	var changePwdDialogId = "changePwdDialog";

	me.clickLoginButton = function() {
		// check input .
		if (!checksubmit(document.forms[0])) {
			return;
		}
		;

		var accName = jQuery("#accName").val();
		var accPwd = jQuery("#accPwd").val();

		var params = {
			accName : accName,
			accPwd : accPwd
		};

		// invoke AntERPUtil to valid form
		jQuery.ajax({
			url : "door/check",
			type : "post",
			data : params,
			dataType : "json",
			success : function(data) {
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

	me.doLogin = function() {
		document.loginForm.action = "door/in;jsessionid=" + window.jsessionid;
		document.loginForm.submit();
	};

	me.doResize = function() {
		var wh = jQuery(window).height();
		var ww = jQuery(window).width();

		var formDiv = jQuery("#loginFormDiv");
		var formH = formDiv.height();
		var formW = formDiv.width();
		var top = (wh - formH) / 2;
		var left = (ww - formW) / 2;

		formDiv.css("top", top);
		formDiv.css("left", left);

		// alert("wh:" + wh + ",ww:" + ww);
	};

	me.changeAccountPwd = function() {
		jQuery.ajax({
			url : "index/changePwd.html",
			type : "post",
			success : function(data) {
				var content = '<div id="' + changePwdDialogId + '">' + data
						+ "</div>";
				jQuery(content).dialog({
					title : "修改密码",
					modal : true,
					resizable : false,
					height : "auto",
					width : "400",
					open : function() {
						jQuery("#mAccName").val(jQuery("#accName").val());
					},
					close : function() {
						jQuery("#" + changePwdDialogId).remove();
					},
					buttons : [ {
						text : "保存",
						click : function() {
							// TODO
						}
					}, {
						text : "取消",
						click : function() {
							jQuery(this).dialog("close");
						}
					} ]
				});
			}
		});
	};

	me.doChangePwd = function() {
		
	};
}

jQuery(document).ready(function() {
	var indexObj = new Index();
	// adjust login form position
	indexObj.doResize();

	// bind events
	var wresize = new Wresize();
	wresize.attachWindowResize(indexObj.doResize);
	jQuery("#loginBtn").unbind().bind("click", indexObj.clickLoginButton);
	jQuery("#changePwdBtn").unbind().bind("click", indexObj.changeAccountPwd);

});