package com.hefa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.PlatformUserSalesman;

@Mapper
public interface PlatformUserSalesmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformUserSalesman record);

    int insertSelective(PlatformUserSalesman record);

    PlatformUserSalesman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformUserSalesman record);

    int updateByPrimaryKey(PlatformUserSalesman record);
}