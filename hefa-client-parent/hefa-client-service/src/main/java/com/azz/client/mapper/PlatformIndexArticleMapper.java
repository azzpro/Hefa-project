package com.azz.client.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.azz.client.pojo.PlatformIndexArticle;
import com.azz.client.pojo.vo.ArticleDetail;

@Mapper
public interface PlatformIndexArticleMapper {

    PlatformIndexArticle selectByPrimaryKey(Long id);
    
    ArticleDetail getArticleDetail(Long id);

}