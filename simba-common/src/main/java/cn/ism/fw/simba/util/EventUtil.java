package cn.ism.fw.simba.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ism.fw.simba.event.EventArg;
import cn.ism.fw.simba.event.EventHandler;

public class EventUtil {

  private static final Logger LOG = LoggerFactory.getLogger(EventUtil.class);

  @SuppressWarnings("unchecked")
  public static void dispach(Class<? extends EventHandler<? extends EventArg>> eventType,
      Object sender, EventArg arg) {
    Map<String, ?> eventMap = SpringUtil.getContext().getBeansOfType(eventType);
    List<?> list = new ArrayList<>(eventMap.values());
    Collections.sort(list, new Comparator<Object>() {
      public int compare(Object o1, Object o2) {
        int h1 = o1.hashCode(), h2 = o2.hashCode();
        return h1 > h2 ? 1 : (h1 < h2 ? -1 : 0);
      };
    });
    for (Object obj : list) {
      try {
        ((EventHandler<EventArg>) obj).execute(sender, arg);
      } catch (Exception ex) {
        LOG.error(ex.getMessage(), ex);
      }
    }
  }


  public static void dispach(Class<? extends EventHandler<?>> eventType) {
    dispach(eventType, null, null);
  }
}
