// TODO: 1.pageContext 需要预加载 ，2.widget/data/datable 需要在使用时加载
require(["rt/pageContext","widget/data/datatable","widget/tab","widget/form/dateBox"],function(pageContext,dt,tab,dateBox){
	pageContext.define("admin.sitemap.list",function(page){
		
		page.ready = function(){    
			//debugger
			$("#createDate1").xWidget("form.DateBox",{ showIconButton:false ,format : 'yyyy-mm-dd hh:ii',minView : "hour"});
			$("#createDate2").xWidget("form.DateBox",{ showIconButton:false ,format : 'yyyy-mm-dd hh:ii',minView : "hour"});
			
			var gridOption = {
				selectMode:'mutli', /* 多选：mutli,单选：single,默认：normal */
				height:300, 
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
						type:"operate",
						renderer:function(value,record,columnOp){
							var $btnView = $('<span><a class="btn btn-link btn-sm" >查看</a><a class="btn btn-link  btn-sm"  >编辑</a></span>');
							var rowData = record;
							
							$btnView.find("a:eq(0)").on("click",function(){
								page.doEdit(rowData);
							});
							
							$btnView.find("a:eq(1)").on("click",function(){
								page.doEdit(rowData);
							});
							return $btnView;
						}
					},{
						field:"id",
						header:"ID",
						width:120
					},{
						field:"username",
						header:"用户名",
						width:120
					} 
				]
				,dataset:"/webapp/api/user/page/10/1"
				,operation:{
					search:{
						btn:"#btnSearch",
						panel:"#formSearch"
					}
				}
			};
			
			// 绑定表格 
			$("#gridSitemap").xWidget("datatable",gridOption);   
		}
		
		page.doDelete = function(){
			require(["ui/ui-confirm"],function(c){
				c.confirm("确定删除吗?",function(isOk){
					if(isOk){
						
					}
				});
			})
		}
		
		page.doImport = function(){
			require(["ui/ui-confirm"],function(msg){
				msg.dialog({
					title:"导入数据", 
					columnClass:"medium",
					format:{
						type:"fileUpload", 
						setting:{
							uploadUrl:"/webapp/api/sitemap/import"
						}
					}
				}); 
			});
		}
		
		page.doEdit = function(record){
			var isCreate = !record;
			var tab =  $("#demoTab").xWidget();
			
			if(!isCreate){
				tab.on("afterLoad",function(page){
					debugger
					alert("afterTab");
					page.fillData(record);
				},true);
			}
			
			tab.addPage({
				title: (isCreate ? "添加" : "编辑" ) + "栏目",
				url:"/webapp/web/admin/sitemap/edit.html",
				allowClose:true,
				afterLoad:function(){
					
				}
			}); 
			
		
		}
		
	});
});