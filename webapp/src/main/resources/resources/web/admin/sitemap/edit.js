// TODO: 1.pageContext 需要预加载 ，2.widget/data/datable 需要在使用时加载
require(["rt/pageContext","widget/data/datatable","widget/container/tab"],function(pageContext){
	pageContext.define("admin.sitemap.edit",function(page){
		
		page.ready = function(){  
			console.log("你来把，我准备好了");
		}
		
		page.exit = function(){
			console.log("壮士，别杀我");
		}
	});
});