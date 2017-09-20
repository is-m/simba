define(["widget/factory","jquery"],function(widget,$){
	
	widget.define("menu",{
		template:"<h1>Hello this navbar Widget</h1>", 
		templateUri:"js/widget/common/menu.html",
		resources:{
			css:["../css/lib/metisMenu.css"],
			js:["../js/lib/metisMenu.js"]
		},
		init:function(){
			
		},
		loadData:function(){
			
		},
		beforeRender:function(html){
			return html;
		},
		afterRender:function(){
			
		},
		ready:function(){
			alert("menu ready");
		},
		destory:function(){
			
		}
	
	});
	
});