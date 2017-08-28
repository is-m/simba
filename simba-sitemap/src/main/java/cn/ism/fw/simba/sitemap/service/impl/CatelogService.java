package cn.ism.fw.simba.sitemap.service.impl;

import java.util.List;

import cn.ism.fw.simba.sitemap.CatelogVO;
import cn.ism.fw.simba.sitemap.service.ICatelogService;
import cn.ism.fw.simba.specs.SOperation;
import cn.ism.fw.simba.specs.SResource;

@SResource(code="sys.catelog",desc="系统管理->栏目管理")
public class CatelogService implements ICatelogService {
 
	@SOperation(code="",desc="")
	@Override
	public List<CatelogVO> findList() { 
		return null;
	}

}
