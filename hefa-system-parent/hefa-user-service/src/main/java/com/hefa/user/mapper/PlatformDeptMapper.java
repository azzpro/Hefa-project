package com.hefa.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.user.pojo.PlatformDept;
import com.hefa.user.pojo.bo.SearchDeptParam;
import com.hefa.user.pojo.vo.Dept;

@Mapper
public interface PlatformDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformDept record);

    int insertSelective(PlatformDept record);

    PlatformDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformDept record);

    int updateByPrimaryKey(PlatformDept record);
    
    PlatformDept selectByDeptName(String deptName);
    
    List<Dept> selectDeptList(SearchDeptParam param);
    
    List<PlatformDept> selectByParentDeptCode(String deptCode);
    
    PlatformDept selectByDeptCode(String deptCode);
    
    List<Dept> selectDeptParentList(String deptParentCode);
    
    PlatformDept selectDetailsByDeptCode(String deptCode);
    
    int selectCountByParam(@Param("deptParentCode") String deptParentCode,@Param("deptName") String deptName);
    
    int selectCountDeptUser(String deptCode);
}