package cn.ism.fw.simba.security.dao;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.security.UserVO;

public interface IUserDao {

	UserVO findObj(Serializable id);

	int createObj(UserVO obj);

	UserVO findUserByName(@Param("username") String username);

	/**
	 * 用户分页查询
	 * @param page
	 * @param vo
	 * @return
	 * @since 2017年8月27日
	 * @author Administrator
	 */
	PagedResult<UserVO> findPagedList(@Param("page") PageVO page,@Param("vo") UserVO vo);
}
