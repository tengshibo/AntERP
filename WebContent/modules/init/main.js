function MainPage() {
	var me = this;

	me.doResize = function() {
		var topDiv = 75;
		var leftMenu = 200;
		var wh = jQuery(window).height();
		var ww = jQuery(window).width();
		
		jQuery("#downWrapperDiv").height(wh - topDiv);
		jQuery("#centerMain").width(ww - leftMenu);
		
		//总是撑出去一点 不知道为什么 可能是page默认的margin或者padding,如果是自己的页面 估计没问题
		jQuery("#rightIframe").height(jQuery("#centerMain").height()-5);
		
	};
}

jQuery(document).ready(function() {
	var mainPage = new MainPage();
	// adjust login form position
	mainPage.doResize();

	// bind events
	var wresize = new Wresize();
	wresize.attachWindowResize(mainPage.doResize);

	jQuery("#topDiv").unbind().bind("click", function() {
		jQuery("#rightIframe").attr("src", "http://news.163.com");
	});

});