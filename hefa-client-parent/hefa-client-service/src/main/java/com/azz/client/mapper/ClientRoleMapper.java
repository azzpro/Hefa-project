package com.azz.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.azz.client.pojo.ClientRole;
import com.azz.client.pojo.bo.SearchRoleParam;
import com.azz.client.pojo.vo.RoleInfo;

@Mapper
public interface ClientRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientRole record);

    int insertSelective(ClientRole record);

    ClientRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientRole record);

    int updateByPrimaryKey(ClientRole record);

    int updateByRoleCode(ClientRole record);
   
    ClientRole selectByRoleCode(String roleCode);
    
    ClientRole hasRoleName(@Param("companyCode")String companyCode, @Param("roleName")String roleName, @Param("roleCode") String roleCode);
    
    List<RoleInfo> getRoleInfoBySearchParam(SearchRoleParam param);
    
}