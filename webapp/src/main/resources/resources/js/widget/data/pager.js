define(["widget/factory","jquery"],function(widget,$){
	
	var defulatConfig = {
		// 当前页
		curPage:1,
		// 页大小
		pageSize:15,
		// 总记录数
		totalRecords:0
	};
	
	widget.define("pager",{
		template:"<h1>Hello this navbar Widget</h1>", 
		templateUri:"js/widget/data/pager.html",
		init:function(){
			// 计算总页数
			var pageSize = this.op.pageSize || 15;
			var totalRecords = 0;
			
		},
		loadData:function(){
			
		},
		beforeRender:function(html){
			return html;
		},
		afterRender:function(){
			 
		},
		ready:function(){
			
		},
		destory:function(){
			
		},
		first:function(){
			
		},
		prev:function(){
			
		},
		go:function(){
			
		},
		next:function(){
			
		},
		last:function(){
			
		} 
	});
	
});