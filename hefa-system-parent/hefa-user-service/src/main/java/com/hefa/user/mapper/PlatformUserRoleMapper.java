package com.hefa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.PlatformUserRole;

@Mapper
public interface PlatformUserRoleMapper {
    int deleteByPrimaryKey(Long id);
    
    int deleteByUserId(Long userId);

    int insert(PlatformUserRole record);

    int insertSelective(PlatformUserRole record);

    PlatformUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformUserRole record);

    int updateByPrimaryKey(PlatformUserRole record);
    
    int countBindingUserRole(Long roleId);
}