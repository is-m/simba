package cn.ism.fw.simba.security.service;

import java.io.Serializable;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.security.UserVO;
 
public interface IUserService {

	UserVO findObj(Serializable id);
	
	int createObj(UserVO obj);
	 
	/**
	 * 分页查询用户
	 * @param page
	 * @param userVO
	 * @return
	 * @since 2017年8月27日
	 * @author Administrator
	 */
	PagedResult<UserVO> findPagedList(PageVO page,UserVO userVO);
}
