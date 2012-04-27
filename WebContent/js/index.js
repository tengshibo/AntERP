function Index() {
	var me = this;
	me.clickLoginButton = function() {
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
		loginForm.action = "door/in;jsessionid=" + window.jsessionid;
		loginForm.submit();
	};
}

jQuery(document).ready(function() {
	var indexObj = new Index();
	jQuery("#loginBtn").unbind().bind("click", indexObj.clickLoginButton);
});