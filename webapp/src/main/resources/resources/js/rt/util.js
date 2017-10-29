define([ "rt/core", "jquery", "rt/request" ], function(core, $, http) {

	var u = {}

	// 同意数据集获取方法，返回Pormise对象
	u.getDataset = function(dataOrOption) {
		var _d = dataOrOption;
		if (typeof _d === "string") {
			return http.doGet(_d);
		} else if ($.isArray(_d)) { // data
			var dfd = $.Deferred();
			setTimeout(function() {
				dfd.resolve(_d);
			}, 0);
			return dfd;
		} else if ($.isPlainObject(_d)) { // ajax option
			return http.ajax(_d);
		} 
	};

	u.isEmpty = function() {

	};

	return u;
});