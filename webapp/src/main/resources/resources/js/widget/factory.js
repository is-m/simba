define(["jquery"],function($){
	"use strict";
	/*
	 TODO:组件要考虑用户可修改，样式可定义 
	 */
	var config = {
		 allowRewrite:false /* 允许覆盖插件 */ 
	};
	
	// TODO:所有的组件都应该有AJAX的功能
	var WidgetFactory = {
		constructMap:{}, /* 组件字典 */
		define:function(name,defineContext){ /* 组件定义函数 */
			/* TODO: 需要封装 defineContext 的私有内容 */
			var Widget = this.constructMap[name];
			if(Widget){
				if(!config.allowRewrite){
					throw 'confict widget by name '+ name;
				}
				console.log('override widget by name ' + name); 
			}
			
			Widget = function(name,op,data,dom){
				this._task = [];
				this.name = name;
				this.op = op;
				this.data = data;
				this.dom = dom;
			};
			
			Widget.prototype = {
				constructor:Widget,
				on:function(eventName){
					
				},
				un:function(){
					
				},
				refresh:function(op,data){
					
				}
			} 
		},
		defineAPI:function(name,apiConstuct){
			
		} 
	} 

	$.fn.xWidget = function(name, op, data) {
		//debugger
		return this.each(function() {
			var self = $(this); 
			var $widgetBegin = $("<!-- {0} begin -->".format(name))
			$widgetBegin.data("widget",name);
			var $widgetEnd =   $("<!-- {0} end   -->".format(name))
			self.before($widgetBegin);
			self.after($widgetEnd)
			self.empty().remove(); 
			$widgetBegin.after("<b>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</b>");
			//alert($widgetBegin.data("widget"));
		});
	}

	/**
	 * 组件
	 */
	$.xWidget = function(el,name, op, data) {
		var el, name, op, data,widget;
		var args = arguments;

		switch (args.length) {
		case 1:
			name = args[0];
			break;
		case 2:
			name = args[0], op = args[1];
			break;
		case 3:
			name = args[0], op = args[1], data = args[2];
			break;
		case 4:
			el = args[0], name = args[1], op = args[2], data = args[3];
			break;
		default:
			throw 'no support arguments length by $.xWidget';
		}
		
		if(el){
			if(widget = $(el).data("__widget")){
				return widget;
			} 
		}else{
			var widgetConstruct = WidgetFactory.constructMap[name];
			if(widgetConstruct){
				
			}
		}

	}
	
	return WidgetFactory;
})