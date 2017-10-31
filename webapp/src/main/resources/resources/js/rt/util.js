define([ "rt/core", "jquery", "rt/request" ], function(core, $, http) {

	var u = {}

	var _getAjaxData = function(ajaxResult) {
		if (ajaxResult && ajaxResult["code"] && ajaxResult["msg"]
				&& ajaxResult["data"]) {
			return ajaxResult["data"];
		}
		return ajaxResult;
	};

	// 同意数据集获取方法，返回Pormise对象
	u.getDataset = function(dataOrOption) {
		var _d = dataOrOption;
		var dfd = $.Deferred();
		if ($.isArray(_d)) {
			setTimeout(function() {
				dfd.resolve(_d);
			}, 0);
		} else if (typeof _d === "string") {
			http.doGet(_d).done(function(ajaxResult) {
				var data = _getAjaxData(ajaxResult);
				dfd.resolve(data);
			});
		}
		/*
		 * if ($.isPlainObject(_d)) { return http.ajax(_d); }
		 */ 
		return dfd;
	};

	u.isEmpty = function() {

	};

	return u;
});