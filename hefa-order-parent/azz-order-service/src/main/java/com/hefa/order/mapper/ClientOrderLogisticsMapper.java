package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientOrderLogistics;

@Mapper
public interface ClientOrderLogisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrderLogistics record);

    int insertSelective(ClientOrderLogistics record);

    ClientOrderLogistics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrderLogistics record);

    int updateByPrimaryKey(ClientOrderLogistics record);
}