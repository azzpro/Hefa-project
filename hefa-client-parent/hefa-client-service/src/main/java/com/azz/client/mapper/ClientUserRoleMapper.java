package com.azz.client.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.ClientUserRole;
@Mapper
public interface ClientUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientUserRole record);

    int insertSelective(ClientUserRole record);

    ClientUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientUserRole record);

    int updateByPrimaryKey(ClientUserRole record);
    
    int deleteByClientUserId(Long clientUserId);
    
    int countBindingUserRole(Long roleId);
}