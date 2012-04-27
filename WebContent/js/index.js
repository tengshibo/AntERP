function Index() {
	var me = this;
	me.clickLoginButton = function() {
		var accName = jQuery("#accName").val();
		var accName = jQuery("#accPwd").val();
		// invoke AntERPUtil to valid form
	};
}

jQuery(document).ready(function() {
	var indexObj = new Index();
	jQuery("#loginBtn").unbind().bind("click", indexObj.clickLoginButton);
});