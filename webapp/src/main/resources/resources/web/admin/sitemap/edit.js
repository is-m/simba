// TODO: 1.pageContext 需要预加载 ，2.widget/data/datable 需要在使用时加载
require(["rt/pageContext","rt/validation","rt/request"],function(pageContext,validator,http){
	pageContext.define("admin.sitemap.edit",function(page){
		
		page.ready = function(){  
			console.log("你来把，我准备好了");
			
			$("#btnSave").on("click",function(){
				// 往后台添加一个栏目
				var isValid =  true;//$("#formEditSitemap").valid();
				if(isValid){
					var jsonData = {icon:"123"};//$("#formEditSitemap").jsonData();
					http.doPost("/webapp/api/sitemap",jsonData,function(res){
						alert('后台取数据完成');
					});
				}
			});
			
			$("#btnSaveDraft").on("click",function(){
				alert("你点击了保存草稿");
			});
			
			$("#btnCancel").on("click",function(){
				console.log("click cancel");
				$("#demoTab").xWidget().closeTab();
			});
			
			$("#btnSelectIcon").on("click",function(){
				alert('弹出选择图标对话框');
			});
			
			$("#btnSelectParent").on("click",function(){
				alert('弹出栏目单项选择树');
			});
		}
		
		page.exit = function(){
			console.log("壮士，别杀我");
		}
	});
});