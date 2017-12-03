package cn.ism.fw.simba.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 集合工具类
 * 
 * @since 2017年11月11日
 * @author Administrator
 */
public class CollectionUtil {

  /**
   * 判断集合是否为空
   * 
   * @param iterable
   * @return
   * @since 2017年7月25日
   * @author Administrator
   */
  public static boolean isEmpty(Iterable<?> iterable) {
    return iterable == null || !iterable.iterator().hasNext();
  }

  /**
   * 判断Map是否为空
   * 
   * @param map
   * @return
   * @since 2017年7月25日
   * @author Administrator
   */
  public static boolean isEmpty(Map<?, ?> map) {
    return map == null || map.isEmpty();
  }

  /**
   * 判断数组是否为空
   * 
   * @param array
   * @return
   * @since 2017年7月25日
   * @author Administrator
   */
  public static boolean isEmpty(Object array) {
    if (array == null)
      return true;
    Assert.isFalse(array.getClass().isArray(), "cann't support not array type");
    return Array.getLength(array) == 0;
  }

  /**
   * 获取list
   * 
   * @return
   * @since 2017年11月11日
   * @author Administrator
   */
  public static <T> List<T> list() {
    return new ArrayList<>();
  }

  public static <T> Map<Object, T> map() {
    return new HashMap<>();
  }

  public static <T> void each(List<T> list, Consumer<T> consumer) {
    if (!isEmpty(list) || consumer != null) {
      list.forEach(consumer);
    }
  }

  public <T> Map<Object, T> list2Map(List<T> list, Function<T, Object> keyProvider) {
    Map<Object,T> result = map();
    if (!isEmpty(list) && keyProvider != null) { 
      list.forEach(item -> result.put(keyProvider.apply(item), item)); 
    }
    return result;
  }
}
