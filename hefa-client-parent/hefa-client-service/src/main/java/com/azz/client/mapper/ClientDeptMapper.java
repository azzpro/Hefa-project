package com.azz.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.ClientDept;
import com.azz.client.pojo.bo.SearchClientChildDeptParam;
import com.azz.client.pojo.bo.SearchClientDeptInfoByCodeParam;
import com.azz.client.pojo.bo.SearchClientDeptInfoParam;
import com.azz.client.pojo.bo.SearchClientDeptIsExistParam;
import com.azz.client.pojo.bo.SearchClientDeptParam;
import com.azz.client.pojo.vo.ClientDeptInfo;
import com.azz.client.pojo.vo.ClientDeptList;
@Mapper
public interface ClientDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientDept record);

    int insertSelective(ClientDept record);

    ClientDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientDept record);

    int updateByPrimaryKey(ClientDept record);
    
    ClientDept selectByDeptCode(String deptCode);
    
    List<ClientDeptList> selectFirstLevelList(SearchClientDeptParam param);
    
    List<ClientDeptList> selectChildlList(SearchClientChildDeptParam param);
 
    int selectFirstLevelExist(SearchClientDeptIsExistParam param);
    
    ClientDept selectClientDeptInfoByName(SearchClientDeptInfoParam param);
    
    ClientDept selectClientDeptInfoByCode(SearchClientDeptInfoByCodeParam param);
    
    int selectClientUserIsExistDept(String deptCode);
    
    ClientDeptInfo selectClientByCode(SearchClientDeptInfoByCodeParam param);
}