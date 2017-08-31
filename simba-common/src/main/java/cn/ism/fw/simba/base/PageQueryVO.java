package cn.ism.fw.simba.base;

public class PageQueryVO<T> extends PageVO {

	private T queryVO;

	public T getQueryVO() {
		return queryVO;
	}

	public void setQueryVO(T queryVO) {
		this.queryVO = queryVO;
	}
	 
}
