define(function(require, exports, module){
	
	var initilize = function(){
		// 隐藏整个页面内容
		
		// 绑定URL地址事件
		require(["rt/router"],function(router){
			router.init();
		});
		
		// 初始化基础内容
		console.log("init ui context");
		initWidget();
		
		// 触发地址事件 
		console.log("trigger url default event");
	};
	
	var getAllChildrens = function(dom,collector){
		var domArray = typeof dom.length == 'undifined' ? [dom] : dom; 
		for(var i=0;i<domArray.length;i++){
			var currentDom = domArray[i];
			if(currentDom.children.length > 0){
				getAllChildrens(currentDom.children,collector);
			}else{
				collector.push(currentDom);
			}
		}
	}
	
	var initWidget = function(){
		// 读取界面内容
		var allEls = [];
		getAllChildrens(document.body.children,allEls);
		var pageElements = allEls;
		for(var i=0;i<pageElements.length;i++){
			var el = pageElements[i];
			console.log("load js widget -- "+el + "    "+ el.toString() );
			//var tagName = el.tagName;
			if(el.toString() == "[object HTMLUnknownElement]"){
				var widgetName = el.tagName.toLowerCase();
				if(widgetName.indexOf(":")){
					widgetName = widgetName.substring(widgetName.indexOf(":")+1);
				}
				console.log("load js widget -- "+widgetName);
				require(["widget/common/"+widgetName],$.proxy(function(widget){
					// 加载完组件则初始化组件的基本内容
					$(this.el).xWidget(this.widgetName);
				},{ el:el, widgetName:widgetName })); 
			}
		}
		
	}
	
	return { init:initilize };
	
});