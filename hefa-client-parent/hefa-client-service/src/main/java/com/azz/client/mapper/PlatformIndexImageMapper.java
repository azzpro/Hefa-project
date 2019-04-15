package com.azz.client.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.PlatformIndexImage;

@Mapper
public interface PlatformIndexImageMapper {

    PlatformIndexImage selectByPrimaryKey(Long id);

}