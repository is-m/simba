// ajax 请求封装
define(["jquery"],function($){ 
	
	var ajax = function(url,data,sCallback,fCallback,method){ 
		
		if( method == "post" || method == "put" ){
			data = typeof data === 'string' ? data : JSON.stringify(data);
		}
		
		var _async = $.ajax({
			url:url,
			data:data,
			method:method,
			contentType:"application/json",
		});
		
		_async.success(function(resp){
			if(resp && resp.code && resp.msg && resp.code != '200'){
				console.log("call service error:",resp);
				fCallback && fCallback(resp);
			}else{
				sCallback && sCallback(resp.data);
			} 
		});
		
		fCallback && _async.error(fCallback); 
		
		return _async;
	}
	
	// 适用于查询
	var get = function(url,data,sCallback,fCallback){
		return ajax(url,data,sCallback,fCallback,"get");
	}
	
	// 适用于创建，或者任意其他类型请求
	var post = function(url,data,sCallback,fCallback){
		return ajax(url,typeof data === 'string' ? data : JSON.stringify(data),sCallback,fCallback,"post"); 
	}
	
	// 适用于修改
	var put = function(url,data,sCallback,fCallback){
		return ajax(url,typeof data === 'string' ? data : JSON.stringify(data),sCallback,fCallback,"put"); 
	}
	
	// 适用于删除
	var del = function(url,data,sCallback,fCallback){
		return ajax(url,data,sCallback,fCallback,"delete");
	}
	
	return {
		ajax:ajax,
		doGet:get,
		doPost:post,
		doPut:put,
		doDelete:del
	};
});