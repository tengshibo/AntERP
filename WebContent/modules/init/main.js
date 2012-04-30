function MainPage() {
	var me = this;

	me.doResize = function() {
		var topDiv = 75;
		var leftMenu = 200;
		var wh = jQuery(window).height();
		var ww = jQuery(window).width();
//		var wh = window.document.body.offsetHeight;
//		var ww = window.document.body.offsetWidth;
		jQuery("#downWrapperDiv").height(wh - topDiv);
		jQuery("#centerMain").width(ww - leftMenu);

		// 总是撑出去一点 不知道为什么 可能是page默认的margin或者padding,如果是自己的页面 估计没问题
		jQuery("#rightIframe").height(jQuery("#centerMain").height() - 5);
	};
	
	me.attachEvents = function(){
		var wresize = new Wresize();
		wresize.attachWindowResize(me.doResize);
		
		jQuery("#custom_menu").bind("click", function(){
			jQuery("#rightIframe").attr("src", "modules/custom/custom.jsp");
		});
		jQuery("#account_menu").bind("click", function(){
			jQuery("#rightIframe").attr("src", "modules/account/account.jsp");
		});
		
		jQuery("#topDiv").unbind().bind("click", function() {
			jQuery("#rightIframe").attr("src", "http://news.163.com/");
		});
	};
}

jQuery(document).ready(function() {
	var mainPage = new MainPage();
	// do resize
	mainPage.doResize();

	// bind events
	mainPage.attachEvents();	

});