package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.vo.MemberInfo;

@Mapper
public interface MemberUserMapper {
	
	/**
	 * 
	 * <p>用户是否存在</p>
	 * @param id
	 * @return
	 * @author 黄智聪  2019年4月24日 下午3:03:31
	 */
	int countUserById(Integer id);
	
	/**
	 * 获取会员列表
	 * @param param
	 * @return
	 */
	List<MemberInfo> getMemberUserList(MemberParam param);
}
