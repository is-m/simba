package cn.ism.fw.simba.util;

/**
 * 字符串工具类
 * 
 * @since 2017年5月7日
 * @author Administrator
 */
public class StringUtil {
 
	/**
	 * 数组合并
	 * 
	 * @param source
	 * @param more
	 * @return
	 * @since 2017年5月7日
	 * @author Administrator
	 */
	public static String[] merge(String[] source, String... more) {
		int sourceLength = source == null ? 0 : source.length;
		int moreLength = more == null ? 0 : more.length;
		String[] result = new String[sourceLength + moreLength];
		if (result.length > 0) {
			int resultIndex = 0;
			for (String sourceItem : source) {
				result[resultIndex++] = sourceItem;
			}
			for (String moreItem : more) {
				result[resultIndex++] = moreItem;
			}
		}
		return result;
	}
	
	public static boolean isEmpty(String string){
		return string == null || string.trim().length() == 0;
	}  
	
	/**
	 * 连接字符串
	 * @param array
	 * @return
	 * @since 2017年8月7日
	 * @author Administrator
	 */
	public static String join(String... array){
		if(ObjectUtil.isEmpty(array)) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder(array[0]);
		
		for(String item : array){
			sb.append(",").append(item);
		}
	    return sb.toString();
	}

}
