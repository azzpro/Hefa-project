package com.hefa.order.mapper;

import com.hefa.order.pojo.ClientOrderLogistics;

public interface ClientOrderLogisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrderLogistics record);

    int insertSelective(ClientOrderLogistics record);

    ClientOrderLogistics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrderLogistics record);

    int updateByPrimaryKey(ClientOrderLogistics record);
}