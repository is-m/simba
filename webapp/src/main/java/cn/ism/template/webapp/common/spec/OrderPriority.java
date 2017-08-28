package cn.ism.template.webapp.common.spec;

/**
 * 优先级
 * @since 2017年5月12日
 * @author Administrator
 */
public enum OrderPriority {

	Hight(1, "高"), Medium(5, "中"), low(10, "低");

	private String desc;
	private int value;

	private OrderPriority(int value, String desc) {
		setValue(value);
		setDesc(desc);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
