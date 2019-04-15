package com.azz.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.PlatformIndexColumn;
import com.azz.client.pojo.vo.HomeNav;
import com.azz.client.pojo.vo.HomeNavDetail;
import com.azz.client.pojo.vo.HomeSlide;

@Mapper
public interface PlatformIndexColumnMapper {

    PlatformIndexColumn selectByPrimaryKey(Long id);

    List<HomeSlide> getHomeSlideList(String columnCode);
    
    List<HomeNav> getNavListByColumnCode(String columnCode);
    
    HomeNavDetail getColumnList(String columnCode);
}