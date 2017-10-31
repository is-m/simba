define(["widget/factory","jquery","jqueryui","template"],function(widget,$,$ui,tmpl){
	// 预处理数据行渲染模版
	var _dataRowTemplate = 
		'<% for(var j=0;j<$widget.dataset.length;j++){ var dataItem = $widget.dataset[j]; %>' +
		'<tr> ' +
			'<% if($widget.showSeq !== false){%>' +
			'	<th><span><%=(j+1)%></span></th>' +
			'<%}%>' + 
			'<% if($widget.selectMode == "mutli"){%>' + 
			'<td><span><input type="checkbox" /></span></td>' + 
		'<%}%> ' + 
		
		'<% ' + 
			'for(var i=0;i<$widget.columns.length;i++){ ' + 
				'var colOp = $widget.columns[i];' + 
				'var fieldValue = colOp.field ? dataItem[colOp.field] : null;' + 
		'%>' + 
			'<td>' + 
				'<span class="table-td-text" style="width:<%= (colOp.width || 150)-17 %>px; min-width:<%= (colOp.width || 150)-17 %>px;" data-toggle="tooltip" title="Example tooltip">' + 
				'<%if(colOp.renderer){%>' + 
					'<%=# colOp.renderer(fieldValue,dataItem,colOp) %>' + 
				'<%}else{%>' +
					'<%= fieldValue %>' + 
				'<%}%>' + 
				'</span>' + 
			'</td>' + 
		'<%}%>   ' + 
		'</tr>' + 
		'<%}%> ';
	tmpl('datatable-datarows',_dataRowTemplate);
	
	
	
	
	widget.define("datatable",{
		template:"<h1>Hello this navbar Widget</h1>", 
		templateUri:"js/widget/data/datatable.html",
		init:function(){
			// 初始化表格，列部分参数
			// 计算表格总宽度
			var _op = this.op;
			console.log("init datatable",_op);
			
			var tableWidth = 0;
			for(var i=0;i<_op.columns.length;i++){
				var colOp = _op.columns[i];
				tableWidth += colOp.width || 150;
			}
			
			_op["_tableWidth"] = tableWidth;
			
			
			
		},
		loadData:function(){
			
		},
		beforeRender:function(html){
			return html;
		},
		afterRender:function(){
			var $tableHead = this.$dom.find(".table-scroll-header:eq(0)");
			var $tableBody = this.$dom.find(".table-scroll-body:eq(0)");
			
			// 生成行代码 
			debugger
			
			var rowHtml = tmpl('datatable-datarows',{ $win:window,$widget:this.op,$data:this.data });
			var $tableDataRows = this.$dom.find(".datatable-rows:eq(0)");
			$tableDataRows.html(rowHtml);
			
			//this.$dom.find("th").resizable();
			/*this.$dom.find(".table-th-resize").on("mousedown",function(e){ 
				console.log("mouse down",e);
				var $this = $(this);
				var $th = $this.closest("th");
				
				// 清理，重新绑定事件
				$this.off("mousemove mouseup");
				
				$this.data("srcPageX",e.pageX);
				$this.on("mousemove",function(e){ 
					var pageX = e.pageX;
					var srcPageX = $(this).data("srcPageX");
					var $th = $(this).closest("th");
					var width = $th.width();
					console.log("move",pageX ,srcPageX, width,e); 
					$th.width(pageX - srcPageX + width);
				});
				
				$this.on("mouseup",function(e){
					console.log("mouse up",e);
					$(this).un("mousemove").un("mouseup"); 
				})
				
			})*/
			
			// 绑定滚动条事件 
			$tableBody.on("scroll",function(){ 
				var bodyScrollLeft = $(this).scrollLeft(); 
				$tableHead.scrollLeft(bodyScrollLeft);
			}); 
			
			// 初始化提示框
			//$tableBody.find("tr>td>span",function(){
				
			//}); 
		},
		ready:function(){
			
		},
		destory:function(){
			
		}
	
	});
	
});