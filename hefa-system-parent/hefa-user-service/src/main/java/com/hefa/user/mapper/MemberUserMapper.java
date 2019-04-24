package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.bo.MemberParam;
import com.hefa.user.pojo.vo.MemberInfo;

@Mapper
public interface MemberUserMapper {
	
	/**
	 * 获取会员列表
	 * @param param
	 * @return
	 */
	List<MemberInfo> getMemberUserList(MemberParam param);
}
