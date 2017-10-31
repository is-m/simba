package cn.ism.fw.simba.sitemap.service;

import java.util.List;

import cn.ism.fw.simba.sitemap.CatelogVO;

/**
 * 栏目服务
 * @since 2017年8月8日
 * @author Administrator
 */
public interface ICatelogService  {
 
	/**
	 * 查询列表
	 * @return
	 * @since 2017年10月16日
	 * @author Administrator
	 */
	public List<CatelogVO> findList();
	
	/**
	 * 创建栏目对象
	 * @param vo
	 * @return
	 * @since 2017年10月16日
	 * @author Administrator
	 */
	public int createObj(CatelogVO vo);
	
	/**
	 * 获取栏目树列表
	 * @return
	 * @since 2017年10月30日
	 * @author Administrator
	 */
	public List<CatelogVO> findTreeList();
}
