package com.azz.client.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.PlatformClientSignUp;
import com.azz.client.pojo.bo.SearchCountClientSignUpParam;
@Mapper
public interface PlatformClientSignUpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformClientSignUp record);

    int insertSelective(PlatformClientSignUp record);

    PlatformClientSignUp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformClientSignUp record);

    int updateByPrimaryKey(PlatformClientSignUp record);
    
    int countClientSignUp(SearchCountClientSignUpParam param);
    
}