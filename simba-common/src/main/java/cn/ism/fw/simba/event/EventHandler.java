package cn.ism.fw.simba.event;

public interface EventHandler<T extends EventArg> {
	
	public void execute(Object sender,T args);
	
}
