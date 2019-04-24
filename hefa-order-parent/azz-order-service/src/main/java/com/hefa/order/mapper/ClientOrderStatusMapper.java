package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientOrderStatus;

@Mapper
public interface ClientOrderStatusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrderStatus record);

    int insertSelective(ClientOrderStatus record);

    ClientOrderStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrderStatus record);

    int updateByPrimaryKey(ClientOrderStatus record);
}