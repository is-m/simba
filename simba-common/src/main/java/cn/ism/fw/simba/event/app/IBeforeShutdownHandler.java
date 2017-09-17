package cn.ism.fw.simba.event.app;

import cn.ism.fw.simba.event.EventArg;
import cn.ism.fw.simba.event.EventHandler;

/**
 * 应用停止前触发事件
 * @since 2017年9月17日
 * @author Administrator
 */
public interface IBeforeShutdownHandler extends EventHandler<EventArg> {

}
