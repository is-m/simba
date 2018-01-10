package cn.ism.fw.simba.sitemap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.service.BaseService;
import cn.ism.fw.simba.sitemap.service.IPageService;


@Service
@RequestMapping("/page")
public class PageService extends BaseService<PageVO, String> implements IPageService {

}
