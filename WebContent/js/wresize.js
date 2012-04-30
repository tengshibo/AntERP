function Wresize() {
	var me = this;
	var widthFlag = null;
	var heightFlag = null;
	var resizeHandler = null;

	me.handleWResize = function(e) {
		var event = e || window.event;
		if (!resizeOnce()) {
			resizeHandler.apply(this, [ event ]);
		}
	};

	me.attachWindowResize = function(handler) {
		resizeHandler = handler;
		jQuery(window).resize(me.handleWResize);
	};

	var resizeOnce = function() {
		var width = jQuery(window).width();
		var height = jQuery(window).height();
		if (width != widthFlag || height != heightFlag) {
			widthFlag = width;
			heightFlag = height;
			return false;
		}
		return true;
	};
};