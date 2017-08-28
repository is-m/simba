package cn.ism.fw.simba.util;

import cn.ism.fw.simba.util.support.Null;

public class DataUtil {
	
	/**
	 * 空值返回
	 * source 不为空的时返回source，为空时返回cn.ism.fw.simba.util.support.Null类型
	 * @param source
	 * @return
	 * @since 2017年8月6日
	 * @author Administrator
	 */
	public static Object nvl(Object source){
		return source == null ? source : Null.VALUE;
	}

	/**
	 * 空值返回
	 * source不为空时返回source，为空时返回target
	 * @param source
	 * @param target
	 * @return
	 * @since 2017年8月6日
	 * @author Administrator
	 */
	public static <T> T nvl(T source,T target){
		return source == null ? target : source;
	}
	
	/**
	 * 空值返回
	 * source 不为空时返回 target1,为空时返回 target2
	 * @param source
	 * @param target1
	 * @param target2
	 * @return
	 * @since 2017年8月6日
	 * @author Administrator
	 */
	public static <T> T nvl2(T source,T target1,T target2){
		return source == null ? target2 : target1;
	}
	
	/**
	 * decode(1,2,3,4,5,6)
	 * 1==2 ? 3 : 4
	 * 1==2 ? 3 : (1==4 ? 5 : (1==6 ? 7 : 8))
	 * @param objs
	 * @return
	 * @since 2017年8月6日
	 * @author Administrator
	 */
	@SuppressWarnings("unchecked")
	public static <T> T decode(Object... objs){
		if(ObjectUtil.isEmpty(objs) || objs.length < 3){
			throw new IllegalArgumentException("decode arguments length must gt 2");
		}
		
		Object source = DataUtil.nvl(objs[0]);
		for(int i=1,j=objs.length;i<j;){
			int  pos = i+1,wait= j - pos;
			if(source.equals(objs[i])){
				return (T)objs[pos];
			}
			// 判断后面参数是一位还是多位，如果多位则继续运算，如果只有1位则返回 
			if(wait > 1){
				i+=2;
				continue;
			}
			return wait < 1 ? null : (T)objs[pos+1];  
		}
		return null;
	} 
}
