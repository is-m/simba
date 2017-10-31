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
								return util.getDataset(_setting.dataset)
								.done(function(data){
									if(data && data.length){
										var $treeObj = $("<div class='ztree'></div>")
										var treeManager = $.fn.zTree.init($treeObj, _setting , data); 
							        	self.setContent($treeObj);
							        	if(_setting.expandLevel == -1){
											treeManager.expandAll(true); 
										} 
							        	
							        	var _defChecked = _setting.defaultChecked;
							        	if(_defChecked){
							        		var defaultNode = treeManager.getNodeByParam(_setting.data.simpleData.idKey || "id",_defChecked);
 
							        		treeManager.checkNode(defaultNode,true, true);
							        		// 解决ztree显示样式为inline导致选中图标不显示的问题
							        		$treeObj.find(".radio_true_full,.radio_false_part").css({"display":"inline-block"});
							        	}
							        	self.treeManager = treeManager;
									}else{
										self.setContent("<div style='color:red'>未发现匹配的记录!</div>");
									} 
								})
								.fail(function(e){
									self.setContent("<div style='color:red'>获取数据失败!</div>");
								}); 
							} else{
								return "<div style='color:red'>未使用dataset选项，无法加载数据!</div>";
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