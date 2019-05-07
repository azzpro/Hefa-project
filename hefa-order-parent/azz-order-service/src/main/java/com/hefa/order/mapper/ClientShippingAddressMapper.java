package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientShippingAddress;

@Mapper
public interface ClientShippingAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientShippingAddress record);

    int insertSelective(ClientShippingAddress record);

    ClientShippingAddress selectByPrimaryKey(Long id);
    
    ClientShippingAddress selectByCode(String shippingAddressCode);

    int updateByPrimaryKeySelective(ClientShippingAddress record);

    int updateByPrimaryKey(ClientShippingAddress record);
    
    int existUser(String userCode);
    
}