define(["jquery"], function($) {

	"use strict";
	// copy of http://blog.csdn.net/sunxinty/article/details/52586556
	function Router() {
		this.routes = {};
		this.currentUrl = '';
	}

	Router.prototype.route = function(path, callback) {
		this.routes[path] = callback;
	};

	Router.prototype.refresh = function() {
		this.currentUrl = location.hash.slice(1) || '/';
		(this.routes[this.currentUrl] || (function(path) {
			return function() { 
				console.log("no register router of path "+path);
				$("#__pageContext").load(path,null,function(response,status,xhr){ 
					if(status == "error"){
						if(xhr.status == "404"){
							$("#__pageContext").html("<h2 class='center'>Page NotFound 404</h2>")
						}
					} 
				});
				//$("#__pageContext").render();
			};
		}(this.currentUrl)))();
	};

	Router.prototype.init = function() {
		window.addEventListener('load', this.refresh.bind(this), false);
		window.addEventListener('hashchange', this.refresh.bind(this), false);
	}

	return new Router();
});