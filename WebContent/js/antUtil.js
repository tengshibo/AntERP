if (((typeof ant) == "undefined") || ant == null) {
	ant = {};
}
ant.isEmpty = function(object) {
	return (((typeof ant) == "undefined") || (object == null))
			|| (object == "");
};