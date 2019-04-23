package com.hefa.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.user.pojo.ClientUserSalesman;

@Mapper
public interface ClientUserSalesmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientUserSalesman record);

    int insertSelective(ClientUserSalesman record);

    ClientUserSalesman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientUserSalesman record);

    int updateByPrimaryKey(ClientUserSalesman record);
}