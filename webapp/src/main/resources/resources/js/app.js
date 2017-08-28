define(function(require, exports, module){
	
	var initilize = function(){
		// 隐藏整个页面内容
		
		// 绑定URL地址事件
		console.log("bound url event");
		
		// 初始化基础内容
		console.log("init ui context");
		initWidget();
		
		// 触发地址事件 
		console.log("trigger url default event");
	};
	
	var initWidget = function(){
		
		// 读取界面内容
		var pageElements = document.body.children;
		for(var i=0;i<pageElements.length;i++){
			var el = pageElements[i];
			
			if(el.toString() == "[object HTMLUnknownElement]"){
				var widgetName = el.tagName.toLowerCase();
				require(["widget/common/"+widgetName],$.proxy(function(widget){
					// 加载完组件则初始化组件的基本内容
					$(this.el).xWidget(this.widgetName);
				},{ el:el, widgetName:widgetName })); 
			}
		}
		
	}
	
	return { init:initilize };
	
});