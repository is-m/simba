package cn.ism.fw.simba.sitemap.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ism.fw.simba.base.dao.mybatis.BaseDao;
import cn.ism.fw.simba.sitemap.TestVO;
import cn.ism.fw.simba.sitemap.dao.ITestDao;

@Repository
public class TestDao extends BaseDao<TestVO, String> implements ITestDao {

}
