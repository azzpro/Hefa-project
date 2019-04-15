/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月1日 下午3:22:14
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年12月1日 下午3:22:14
 */
@Data
public class HomeNav {
    private Long articleId;
    private String columnCode;
    private String articleTitle;
    private String articlePicUrl;
    private Date createTime;
    private BigDecimal price;
    private String remark1;
    private String remark2;
}

