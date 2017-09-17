package cn.ism.fw.simba.sitemap.service.impl;

import java.util.List;

import cn.ism.fw.simba.security.SecureOperation;
import cn.ism.fw.simba.security.SecureResource;
import cn.ism.fw.simba.sitemap.CatelogVO;
import cn.ism.fw.simba.sitemap.service.ICatelogService;

@SecureResource(code="sys.catelog",desc="系统管理->栏目管理")
public class CatelogService implements ICatelogService {
 
	@SecureOperation(code="",desc="")
	@Override
	public List<CatelogVO> findList() { 
		return null;
	}

}
