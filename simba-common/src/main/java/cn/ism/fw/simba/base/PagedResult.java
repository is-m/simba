package cn.ism.fw.simba.base;

import java.util.List;

import cn.ism.fw.simba.util.JSONUtil;

/**
 * 翻页结果对象
 * @since 2017年7月22日
 * @author Administrator
 */
public class PagedResult<T> {

	/**
	 * 翻页属性
	 */
	private PageVO page;
	
	/**
	 * 数据结果
	 */
	private List<T> result;

	public PageVO getPage() {
		return page;
	}

	public void setPage(PageVO page) {
		this.page = page;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	public PagedResult(){
		
	}

	public PagedResult(PageVO page, List<T> result) { 
		this.page = page;
		this.result = result;
	} 
	
	@Override
	public String toString() {
		return JSONUtil.toJSON(this);
	}
}
