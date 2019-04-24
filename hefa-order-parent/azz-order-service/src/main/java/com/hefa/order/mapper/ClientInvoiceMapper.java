package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientInvoice;

@Mapper
public interface ClientInvoiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientInvoice record);

    int insertSelective(ClientInvoice record);

    ClientInvoice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientInvoice record);

    int updateByPrimaryKey(ClientInvoice record);
}