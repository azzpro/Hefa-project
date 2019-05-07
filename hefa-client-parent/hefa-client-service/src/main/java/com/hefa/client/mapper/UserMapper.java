package com.hefa.client.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.pojo.vo.LoginUserInfo;

@Mapper
public interface UserMapper {
	
	/**
	 * 
	 * <p>查询登录用户信息</p>
	 * @param username
	 * @param password
	 * @return
	 * @author 黄智聪  2019年5月7日 下午4:58:58
	 */
	LoginUserInfo getLoginUser(@Param("username")String username, @Param("password")String password);
	
}
