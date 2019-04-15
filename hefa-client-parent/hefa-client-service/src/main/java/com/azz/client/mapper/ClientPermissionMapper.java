package com.azz.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.azz.client.pojo.ClientPermission;
import com.azz.client.pojo.vo.ClientUserPermission;
import com.azz.client.pojo.vo.Permission;
@Mapper
public interface ClientPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientPermission record);

    int insertSelective(ClientPermission record);

    ClientPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientPermission record);

    int updateByPrimaryKey(ClientPermission record);
    
    List<ClientUserPermission> getClientUserPermissionInfoByPhoneNumber(@Param("companyCode") String companyCode, @Param("phoneNumber")String phoneNumber);
    
    List<ClientUserPermission> getClientUserPermissionByPhoneNumberAndLevel(@Param("companyCode") String companyCode, @Param("phoneNumber")String phoneNumber, @Param("level")Integer level);
    
    ClientPermission getClientPermissionByPermissionCode(String permissionCode);
    
    List<ClientPermission> getClientPermissionByParentPermissionCode(String parentPermissionCode);
    
    List<Permission> getAllPermissions();
    
}