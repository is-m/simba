define(["jquery","jquery.confirm","rt/util"],function($,c,util){
	 
	var test = function(){
		$.confirm({ 
		    
		    title: 'Confirm!',
		    content: '确认要删除吗？',
		    buttons: {
		        confirm: function () {
		            $.alert('Confirmed!');
		        },
		        cancel: function () {
		            // $.alert('Canceled!');
		        } 
		    }
		});
	}
	
	var defaultOp = {
		draggable: true,
		closeIcon: true, 
		columnClass:"small", // xlarge 12 large 8 medium 6 small 4 xsmall 2
		// boxWidth: '30%', or '500px' 还需要设置 useBootstrap: false,
		title:"提示",
		content:"确定操作吗?" 
	};
	
	var alert = function(opOrMsg,title,icon,btns){ 
		if(typeof opOrMsg == "string"){
			var _op = $.extend(true,defaultOp,{
				title: title || '提示',
			    content: opOrMsg
			});
			$.alert(_op);
		}else{
			var _op = $.extend(true,defaultOp,opOrMsg);
			$.confirm({
			    title: 'Title',
			    content: 'url:text.txt',
			    onContentReady: function () {
			        var self = this;
			        this.setContentPrepend('<div>Prepended text</div>');
			        setTimeout(function () {
			            self.setContentAppend('<div>Appended text after 2 seconds</div>');
			        }, 2000);
			    },
			    columnClass: 'medium',
			});
		}
		
	}
	
	var confirm = function(){
		
	};
	
	// TODO:如果加载了模块，关闭时，在销毁alert前，需要先销毁模块引用
	var dialog = function(op){
		if(op){
			var _op = $.extend(true,{},defaultOp,op);
			var _format = _op.format;
			if( _format && _format.type){ 
				var _type = _format.type;
				var _setting = _format.setting;
				switch(_format.type){
					case "tree":
						if(!$.isPlainObject(_setting)) throw 'tree dialog setting no matched!'; 
						
						_op.content = function(){
							var self = this; 
							if(_setting.dataset){
								var datasetWorker = util.getDataset(_setting.dataset);
								datasetWorker.done(function(data){
									var $treeObj = $("<div class='ztree'></div>")
									$.fn.zTree.init($treeObj, _setting , data);
						        	self.setContent($treeObj);
								})
								.fail(function(e){
									self.setContent("<div style='color:red'>init Data Exception</div>");
								});
								return datasetWorker;
							} else{
								return "no found dataset option";
							}
						};
						break; 
					case "page": 
					case "table": 
					case "table2":
						alert("no implement of ui-confirm "+_type);
						return;
					default:
						alert("no support of ui-confirm "+_type);
						return;
				} 
			} else if(_op.url){
				$.extend(_op,{
					content: function(){
				        var self = this; 
				        return $.ajax({
				            url: op.url,
				            dataType: 'text',
				            method: 'get'
				        }).done(function (response) {
				            self.setContentAppend($(response));
				            // TODO 找到上级绑定js模块
				        }).fail(function(){
				            self.setContentAppend('<div>Fail!</div>');
				        });
				    }
				});  
			}
			
			$.confirm(_op);
		}else{
			window.alert('no found url');
		}
	};
	 
	return {
		test:test,
		alert:alert,
		confirm:confirm,
		dialog:dialog 
	};
	
});