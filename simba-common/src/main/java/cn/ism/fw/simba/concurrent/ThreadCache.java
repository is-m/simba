package cn.ism.fw.simba.concurrent;

import java.util.Map;

/**
 * 线程级别的缓存
 * @since 2017年7月27日
 * @author Administrator
 */
public class ThreadCache {

	/**
	 * 线程缓存
	 */
	private ThreadLocal<Map<String,Object>> _cache = new ThreadLocal<>();
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key){
		Map<String,Object> map = _cache.get();
		if(map != null && map.containsKey(key)){
			return (T)map.get(key);
		}
		return null;
	}
	
	public void set(String key){
		
	}
}
