define(["jquery"],function($){
	
	var Page = function(id){
		this._id = id; 
	}
	
	var pageContextStack = [];
	var pageContextMap = {};
	
	/**
	 * id:上下文ID
	 * callback:回调函数 callback(page)
	 */
	var _define = function(id,callback){
		console.log("load js module of "+id);
		var page = new Page(id);
		callback(page);
		pageContextStack.push(page);
		pageContextMap[id]=page;
		// pageContext.define 主要是加载内容到核心上下文，而非核心上下文的加载需要通过选中元素后$("xx").loadPage(url);
		var $pc = $("#__pageContext");
		var context = $pc.data("context") || {};
		$pc.data("context",$.extend(context,{ id : page }));
		
		// TODO:等页面自动渲染部分完成后触发ready函数
		page.ready && page.ready();
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

	return {
		define:_define,
		shutdown:_shutdown
	}
	
});