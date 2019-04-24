package com.hefa.order.mapper;

import com.hefa.order.pojo.ClientInvoiceLogistics;

public interface ClientInvoiceLogisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientInvoiceLogistics record);

    int insertSelective(ClientInvoiceLogistics record);

    ClientInvoiceLogistics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientInvoiceLogistics record);

    int updateByPrimaryKey(ClientInvoiceLogistics record);
}