package com.azz.client.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.ClientCompanyAccount;

@Mapper
public interface ClientCompanyAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientCompanyAccount record);

    int insertSelective(ClientCompanyAccount record);

    ClientCompanyAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientCompanyAccount record);

    int updateByPrimaryKey(ClientCompanyAccount record);
}