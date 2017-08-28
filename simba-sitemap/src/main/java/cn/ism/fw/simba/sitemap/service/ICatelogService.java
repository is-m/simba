package cn.ism.fw.simba.sitemap.service;

import java.util.List;

import cn.ism.fw.simba.sitemap.CatelogVO;

/**
 * 栏目服务
 * @since 2017年8月8日
 * @author Administrator
 */
public interface ICatelogService {
 
	
	public List<CatelogVO> findList();
	
}
