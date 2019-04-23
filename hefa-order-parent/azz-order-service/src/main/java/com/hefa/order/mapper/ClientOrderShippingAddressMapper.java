package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientOrderShippingAddress;

@Mapper
public interface ClientOrderShippingAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrderShippingAddress record);

    int insertSelective(ClientOrderShippingAddress record);

    ClientOrderShippingAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrderShippingAddress record);

    int updateByPrimaryKey(ClientOrderShippingAddress record);
}