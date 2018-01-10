package cn.ism.fw.simba.sitemap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ism.fw.simba.base.service.BaseService;
import cn.ism.fw.simba.sitemap.TestVO;
import cn.ism.fw.simba.sitemap.service.ITestService;

@Service
@RequestMapping("/test")
public class TestService extends BaseService<TestVO, String> implements ITestService {
 
}
