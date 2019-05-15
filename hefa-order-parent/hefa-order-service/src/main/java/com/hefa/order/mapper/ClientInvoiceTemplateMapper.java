package com.hefa.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientInvoiceTemplate;

@Mapper
public interface ClientInvoiceTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientInvoiceTemplate record);

    int insertSelective(ClientInvoiceTemplate record);

    ClientInvoiceTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientInvoiceTemplate record);

    int updateByPrimaryKey(ClientInvoiceTemplate record);
}