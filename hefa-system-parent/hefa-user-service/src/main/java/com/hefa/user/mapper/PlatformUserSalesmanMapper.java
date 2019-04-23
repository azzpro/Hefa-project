package com.hefa.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hefa.user.pojo.PlatformUserSalesman;

@Mapper
public interface PlatformUserSalesmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformUserSalesman record);

    int insertSelective(PlatformUserSalesman record);

    PlatformUserSalesman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformUserSalesman record);

    int updateByPrimaryKey(PlatformUserSalesman record);
    
    /**
     * 
     * <p>根据平台成员编码统计记录数</p>
     * @param platformUserCode
     * @param id
     * @return
     * @author 黄智聪  2019年4月23日 下午4:55:11
     */
    int countByPlatformUserCode(@Param("platformUserCode")String platformUserCode, @Param("id")Long id);
}