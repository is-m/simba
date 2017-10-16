// 校验器，提供校验相关接口，并能提供外部扩展
define(["jquery"],function($){
	
	var defaultValidation = {
		"required":{
			expr:/^\S+$/,
			message:"不能为空"
		}
	}
	
	var valid = function(){
		
	}
	
	var addValidMethod = function(methodName,callback){
		
	} 
	
	return {
		valid:valid,
		addMethod:addValidMethod
	};
});