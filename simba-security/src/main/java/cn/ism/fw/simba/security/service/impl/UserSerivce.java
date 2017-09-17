package cn.ism.fw.simba.security.service.impl;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.security.SecureOperation;
import cn.ism.fw.simba.security.UserVO;
import cn.ism.fw.simba.security.dao.IUserDao;
import cn.ism.fw.simba.security.service.IUserService;

@Named
public class UserSerivce implements IUserService {

	@Inject
	private IUserDao userDao;

	@Override
	public UserVO findObj(Serializable id) {
		return userDao.findObj(id);
	}

	@Override
	@SecureOperation
	public int createObj(UserVO obj) {
		return userDao.createObj(obj);
	}

	@SecureOperation(code="findPagedList")
	@Override
	public PagedResult<UserVO> findPagedList(PageVO page, UserVO userVO) {
		return userDao.findPagedList(page, userVO);
	}

}
