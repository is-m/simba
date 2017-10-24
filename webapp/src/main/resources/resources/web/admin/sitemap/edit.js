// TODO: 1.pageContext 需要预加载 ，2.widget/data/datable 需要在使用时加载
require(["rt/pageContext","rt/validation","rt/request","widget/form/dateBox"],function(pageContext,validator,http,dateBox){
	pageContext.define("admin.sitemap.edit",function(page){
		
		page.ready = function(){  
			page.init();
			console.log("你来把，我准备好了");
			// 从后台获取校验内容并绑定到元素
			//validator.bind($("#formEditSitemap"),"CatelogVO",["CreateGroup"]);
			$("#createDate").xWidget("form.DateBox",{});
			 
			$("#btnSave").on("click",function(){
				// 往后台添加一个栏目
				var isValid =  true;//$("#formEditSitemap").valid();
				if(isValid){
					$("#formEditSitemap").formSubmit("post","/webapp/api/sitemap",function(resp){
						alert('success');
					},function(resp){
						alert('error');
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
				require(["ui/ui-dialog"],function(d){
					debugger
					d.popTreeDialog();
				}); 
			});
			
			$("#btnSelectParent").on("click",function(){
				require(["ui/ui-dialog"],function(d){
					debugger
					d.popTreeDialog();
				}); 
			});
		}
		
		page.init = function(){
			var initObj = {title:"测试标题"};
			$("#formEditSitemap").jsonData(initObj);
		}
		
		page.exit = function(){
			console.log("壮士，别杀我");
		}
	});
});