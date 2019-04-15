package com.azz.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.azz.client.pojo.ClientRolePermission;
@Mapper
public interface ClientRolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientRolePermission record);

    int insertSelective(ClientRolePermission record);

    ClientRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientRolePermission record);

    int updateByPrimaryKey(ClientRolePermission record);
    
    int deleteByRoleId(Long roleId);
    
    List<String> getPermissionCodesByRoleCode(@Param("companyCode")String companyCode,@Param("roleCode")String roleCode);
}