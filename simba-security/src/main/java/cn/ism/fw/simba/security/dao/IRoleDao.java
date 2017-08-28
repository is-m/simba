package cn.ism.fw.simba.security.dao;

import java.util.List;

import cn.ism.fw.simba.security.RoleQueryVO;
import cn.ism.fw.simba.security.RoleVO;

public interface IRoleDao {

	public List<RoleVO> findList(RoleQueryVO roleQueryVO);
}
