define(["widget/factory","jquery"],function(widget,$){
	
	widget.define("menu",{
		template:"<h1>Hello this navbar Widget</h1>", 
		templateUri:"js/widget/common/menu.html",
		resources:{
			css:["../css/lib/metisMenu.css"] 
		},
		init:function(){
			
		},
		loadData:function(){
			
		},
		beforeRender:function(html){
			return html;
		},
		afterRender:function(){
			require(["lib/metisMenu"],function(m){
				 $('.side-nav .metismenu').metisMenu({ toggle: true }); 
			});
		},
		ready:function(){
			alert("menu ready");
		},
		destory:function(){
			
		}
	
	});
	
});