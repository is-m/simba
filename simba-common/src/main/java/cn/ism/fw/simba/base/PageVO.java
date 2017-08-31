package cn.ism.fw.simba.base;

import cn.ism.fw.simba.util.JSONUtil;
import cn.ism.fw.simba.util.NumUtil;

/**
 * 翻页对象 任何提供集合类查询结果的都要考虑是否需要翻页，否则可能存在内存泄漏的风险
 * 
 * @since 2017年7月22日
 * @author Administrator
 */
public class PageVO {

	/**
	 * 最大页大小
	 */
	public static final int MAX_PAGE_SIZE = 3000;

	/**
	 * 最小页大小
	 */
	public static final int MIN_PAGE_SIZE = 1;

	/**
	 * 最小页
	 */
	public static final int MIN_PAGE = 1;

	/**
	 * 当前页
	 */
	private int curPage = 1;

	/**
	 * 页大小
	 */
	private int pageSize = 15;

	/**
	 * 总记录数
	 */
	private int totalRecord;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage < MIN_PAGE ? MIN_PAGE : curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < MIN_PAGE_SIZE ? MIN_PAGE_SIZE : (pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize);
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 * @since 2017年7月29日
	 * @author Administrator
	 */
	public int getTotalPage() {
		return NumUtil.divides(totalRecord, pageSize);
	}

	/**
	 * 获取页起始位置，首页为 1  (curPage - 1 ) * pageSize + 1
	 * 注意:mysql获取起始位置需要-1
	 * @return
	 * @since 2017年7月29日
	 * @author Administrator
	 */
	public int getPageStartIndex() {
		return (curPage - 1) * pageSize + 1;
	} 

	/**
	 * 获取页结束位置
	 * 
	 * @return
	 * @since 2017年7月29日
	 * @author Administrator
	 */
	public int getPageEndIndex() {
		return curPage * pageSize;
	}

	public PageVO() {
	}

	public PageVO(int curPage, int pageSize) {
		this(curPage, pageSize, 0);
	}

	public PageVO(int curPage, int pageSize, int totalRecord) {
		setCurPage(curPage);
		setPageSize(pageSize);
		setTotalRecord(totalRecord);
	}

	@Override
	public String toString() { 
		return JSONUtil.toJSON(this);
	}
}
