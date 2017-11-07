// TODO: 1.pageContext 需要预加载 ，2.widget/data/datable 需要在使用时加载
require(["rt/pageContext","widget/data/datatable","widget/container/tab"],function(pageContext){
	pageContext.define("admin.sitemap.list",function(page){
		
		page.ready = function(){    
			var gridOption = {
				selectMode:'mutli', /* 多选：mutli,单选：single,默认：normal */
				height:300,
				treeOp:{
					async:false, 
					idKey: "id",
					pIdKey: "parentId",
					rootPId: 0,
					field:"title"
				},
				pageOp:{
					// el:"#pageDemo",
					pageSize:15,
					curPage:1,
					pageSizeRange:[10,20,50,100,200,500]
				},
				columns:[
					{
						header:"操作",
						width:100,
						renderer:function(value,record,columnOp){
							var $btnView = $('<a class="btn btn-link btn-sm" href="#">查看</a>');
							return '<a class="btn btn-link btn-sm" href="#">查看</a>'+
				      		'<a class="btn btn-link  btn-sm"  href="#">编辑</a>';//+
				      		//'<a class="btn btn-link btn-sm" href="#">删除</a>';
						}
					},{
						field:"title",
						header:"菜单标题",
						width:150,
						showTip:true,
						tip:function(value,record,columnOp){
							return value;
						},
						renderer:function(value,record,columnOp){
							return "<a>"+value+"</a>";
						},
						editor: function(){
							return "<input>";
						}
					},{
						field:"icon",
						header:"图标",
						width:50,
						renderer:function(value,record,columnOp){ 
							return value ? "<i class='fa fa-"+value+"'></i>" : "";
						}
					},{
						field:"url",
						header:"访问路径",
						width:150
					},{
						field:"showMode",
						header:"访问方式",
						width:150,
						format:{
							dict:"sitemap.showMode"
						}
					},{
						field:"parentId",
						header:"父节点",
						width:100
					},{
						field:"seq",
						header:"顺序",
						width:50
					},{
						field:"enabled",
						header:"启用",
						width:50
					},{
						field:"showMode",
						header:"显示方式",
						width:150,
						format:{
							dict:"sitemap.showMode"
						}
					},{
						field:"showValue",
						header:"显示值",
						width:150
					},{
						field:"lastUpdateBy",
						header:"最后修改人",
						width:150
					}
					
				]
				,dataset:"/webapp/api/sitemap/s/tree"
				,operation:{
					search:{
						btn:"#btnSearch",
						panel:"#formSearch"
					}
				}
			};
			
			// 绑定表格
			
			$("#gridSitemap").xWidget("datatable",gridOption); 
			
			$("#btnAdd").on("click",function(){ 
				var demoTab = $("#demoTab").xWidget();
				var page = demoTab.addPage({
					title:"添加栏目",
					url:"/webapp/web/admin/sitemap/edit.html",
					allowClose:true
				}); 
			});
			
			$("#btnDelete").on("click",function(){
				require(["ui/ui-confirm"],function(c){
					c.test();
				})
			}); 
			
			$("#btnReset").on("click",function(){
				$("#formSearch")[0].reset();
				$("#btnSearch").trigger("click");
			});
		}
		
	});
});