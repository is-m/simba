define(["widget/factory","jquery","rt/pageContext"],function(widget,$,pageContext){
	
	widget.define("tab",{
		template:"<h1>Hello this navbar Widget</h1>", 
		templateUri:"js/widget/container/tab.html",
		init:function(){
			
		},
		loadData:function(){
			
		},
		beforeRender:function(html){
			return html;
		}, 
		afterRender:function(){ 
			// 加载完成后如果没有选中的项，则默认选中第一项 
			var $tabHeader = this.$dom.find(".tab-header:eq(0)");
			var $tabBody = this.$dom.find(".tab-body:eq(0)");
			
			$tabHeader.on("click",function(e){
				var $trigger = $(e.target);
				// 只处理导航点击事件
				if($trigger.is(".nav-link")){ 
					$tabHeader.find(".active").removeClass("active");
					$trigger.addClass("active");
					
					var pageId = $trigger.data("toggle");
					var pageUrl = $trigger.data("url");
					$tabBody.children().hide();
					
					var $curPage = $tabBody.children("[data-tab-id={0}]".format(pageId));
					$curPage.show();
					// 未初始化过才需要初始化
					if(!$curPage.data("init")){
						pageContext.loadPage($curPage,pageUrl);
						$curPage.data("init",true);
					} 
					return false;
				}
				
				// 如果是关闭按钮
				if($trigger.is(".icon-close")){
					var $headerEl = $trigger.closest("li");
					var pageId = $trigger.parent().data("toggle");
					$headerEl.fadeOut(100,function(){ 
						$tabBody.children("[data-tab-id={0}]".format(pageId)).remove();
						$headerEl.remove(); 
						
						// TODO:选中最后选中的页签
						$tabHeader.find("a:eq(0)").trigger("click");
					});
					
					return false;
				}
			}); 
			
			
			var selLength = $tabHeader.find("a.active").length;
			// 初始化选中项 
			if(selLength > 1){
				console.log("WARN:tabs has mutli actived page, but reserve first active tab");
				$tabHeader.find("a.active").not(":eq(1)").removeClass("active"); 
			}else if(!selLength){ 
				$tabHeader.find("a:eq(0)").addClass("active");
			}
			
			// 加载选中项的内容
			$tabHeader.find("a:eq(0)").trigger("click");
		},
		ready:function(){
			
		},
		destory:function(){
			
		}
		,selectTab:function(tab){
			if($.isNumeric(tab)){
				this.$dom.find(".tab-header:eq(0)").find(".nav-link:eq({0})".format(tab).trigger("click"))
			}
		}
		,addPage:function(op){ 
			var pageDefaultOption = {
				title:"未命名",
				allowClose:true,
				active:true,
				id:"tabItem"
			};
			
			var pageOp = $.extend(true,pageDefaultOption,op);
			
			var $tabHeader = this.$dom.find(".tab-header:eq(0)");
			// 这个要做成工具供模版调用
			var headHtml = [];
			headHtml.push("<li class='nav-item'>");
			headHtml.push("  <a class='nav-link' data-toggle='{0}' data-url='{1}'>".format(pageOp.id,pageOp.url));
			headHtml.push(pageOp.title);
			headHtml.push(pageOp.allowClose ? " <i class='iconfont icon-close'></i>" : '');
			headHtml.push("  </a>")
			headHtml.push("</ul>")
			
			var $headerEl = $(headHtml.join('')); 
			$tabHeader.append($headerEl)
			var $tabBody = this.$dom.find(".tab-body:eq(0)");
			
			var $bodyEl = $("<div data-tab-id='{0}'></div>".format(pageOp.id));
			$tabBody.append($bodyEl);
			 
			$headerEl.find(".nav-link").trigger("click");
		}
	
	});
	
});