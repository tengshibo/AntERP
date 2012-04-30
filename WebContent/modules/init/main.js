function MainPage() {
	var me = this;

	me.doResize = function() {
		var wh = jQuery(window).height();
		var ww = jQuery(window).width();
		
	};
}

jQuery(document).ready(function() {
	var mainPage = new MainPage();
	// adjust login form position
	mainPage.doResize();

	// bind events
	var wresize = new Wresize();
	wresize.attachWindowResize(mainPage.doResize);
	
	jQuery("#topDiv").unbind().bind("click", function(){
		jQuery("#rightIframe").attr("src","http://news.163.com");
	});

});