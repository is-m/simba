package cn.ism.fw.simba.event;

public interface EventHandler<T extends EventArg> {
	
	public void handle(Object sender,T args);
	
}
