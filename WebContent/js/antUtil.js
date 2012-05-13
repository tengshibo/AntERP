if (((typeof ant) == "undefined") || ant == null) {
	ant = {};
}
ant.isEmpty = function(object) {
	return (((typeof ant) == "undefined") || (object == null))
			|| (object == "");
};

ant.antAjax = function(option) {

	var errorHandler = option.error;
	var successHandler = option.success;

	function processLogOut(data) {
		if (data.ok == false) {
			if (data.errorId == "session.001") {
				top.location = "index/index.jsp";
			}
			return;
		}
		if (data.indexOf('"errorId":"session.001"') >= 0
				&& data.indexOf('"ok":false') >= 0) {
			top.location = "index/index.jsp";
		}
	}

	option.error = function(data) {
		if (data.ok == false) {
			if (data.errorId == "session.001") {
				top.location = "index/index.jsp";
			}
			return;
		}
		if (typeof errorHandler == "function") {
			var env = option.context || this;
			errorHandler.call(env, data);
		}
	};
	option.success = function(data) {
		if (data.ok == false) {
			if (data.errorId == "session.001") {
				top.location = "index/index.jsp";
			}
			return;
		}
		if (typeof successHandler == "function") {
			var env = option.context || this;
			successHandler.call(env, data);
		}
	};

	jQuery.ajax(option);

};