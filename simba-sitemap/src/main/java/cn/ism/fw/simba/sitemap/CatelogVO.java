package cn.ism.fw.simba.sitemap;

import cn.ism.fw.simba.base.BaseVO;

/**
 * 栏目VO
 * 
 * @since 2017年5月7日
 * @author Administrator
 */
public class CatelogVO extends BaseVO {

	private static final long serialVersionUID = 4145424803228191015L;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 访问地址
	 */
	private String url;

	/**
	 * 是否生效
	 */
	private boolean enabled;

	private int sort;

	/**
	 * 显示类型：all:全部可见，child:有子栏目时可用时可见，permission:功能可用时可见
	 */
	private String showType;

	/**
	 * 可见的权限点
	 * showMode：功能可用时可见时，会设置内容
	 */
	private String showValue;

	/**
	 * url打开方式，例如：弹出页面，还是页内跳转还是弹出层等
	 * 默认为 页内跳转
	 */
	private String openType;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}
}
