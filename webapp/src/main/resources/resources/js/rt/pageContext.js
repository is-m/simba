define(["jquery","rt/logger"],function($,log){
	
	var Page = function(id,$dom){
		this._id = id; 
		this.$dom = $dom;
	}
	
	var pageContextStack = [];
	var pageContextMap = {};
	var pageContextElStack = [$("#__pageContext")];
	
	/**
	 * id:上下文ID
	 * callback:回调函数 callback(page)
	 */
	var _define = function(id,callback){
		log.debug("load js module of "+id) 
		var page = new Page(id);
		callback(page);
		pageContextStack.push(page);
		pageContextMap[id]=page;
		// pageContext.define 主要是加载内容到核心上下文，而非核心上下文的加载需要通过选中元素后$("xx").loadPage(url); 
		// 或者手动绑定模块 $("xx").boundModel("modelId") 未开发
		var $pc = pageContextElStack[pageContextElStack.length-1];
		//debugger
		page.$dom = $pc;
		var context = $pc.data("context") || {};
		
		$pc.data("context",$.extend(context,{ id : page }));
		
		// TODO:等页面自动渲染部分完成后触发ready函数 
		page.ready && setTimeout(page.ready,0);
	}
	
	var _get = function(id){
		return pageContextMap[id];
	}
	
	var _shutPage = function(el){ 
		var $el = $(el);
		var $waitShuts = [];
		$waitShuts.push(el);
		
		var $childModules = $el.find("[data-module]");
		for(var i=0;i<$childModules.length;i++){
			$waitShuts.push($($childModules[i])); 
		}

		var $shutItem = null;
		while($shutItem=$waitShuts.pop()){
			var context = $shutItem.data("context") || {};
			for(var pageId in context){
				var page = context[pageId]; 
				console.log("shutdown js module of "+page._id);
				page.exit && page.exit();
				delete pageContextMap[page._id]; 
				page.$dom.removeAttr("data-module");
				pageContextStack.remove(page);
			}
			$el.removeAttr("data-module");
		}
	}
	
	var _loadPage = function(el,url,callback){
		var $el = el.jquery ? el : $(el); 
		$el.load(url,function(resp,status,xhr){
			// 加载完页面，绑定上下文，
			if(status != "error"){
				$el.attr("data-module",url);
				pageContextElStack.push($el); 
				callback && callback(true);
			}else{
				$el.attr("data-module","error");
				log.error("page context load page error!"); 
				console.log("page context load page error!",resp,status,xhr)
				callback && callback(false);
			} 
		});
	}
	
	var _shutdown = function(){
		var page = null;
		while(page = pageContextStack.pop()){
			console.log("shutdown js module of "+page._id);
			page.exit && page.exit();
			delete pageContextMap[page._id]; 
		} 
		 $("#__pageContext").data("context",null);
	}
	
	var doAction = function(action){ 
		if(!action){
			log.warn("非法调用页面动作");
			return;
		}
		
		var pageAction = null; 
		for(var i=0;i<pageContextStack.length;i++){
			var page = pageContextStack[i];
			var attr = page[action];
			if(attr && !$.isFunction(attr)){
				log.warn("执行指定页面动作时，找到非Function类型属性" + action)
				continue;
			}
			if(pageAction){
				log.error("执行指定页面动作时，找到多个同名动作" + action);
				return;
			}
			pageAction = attr; 
		} 
		pageAction ? pageAction() : log.error("执行指定页面动作时，未找到页面动作" + action); 
	}

	return {
		define:_define,
		shutdown:_shutdown,
		shutPage:_shutPage,
		loadPage:_loadPage,
		get:_get,
		$do:doAction
	}
	
});