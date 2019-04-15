/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月1日 下午9:53:45
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年12月1日 下午9:53:45
 */

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ArticleDetail {
    private Long articleId;
    private String articleContent;
    private String articleTitle;
    private String articlePicUrl;
    private String remark;
    private BigDecimal price;
}

