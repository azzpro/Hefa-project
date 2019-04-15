/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午2:37:44
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.azz.core.common;


import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QueryPage implements Serializable{

    private static final long serialVersionUID = -2736927232050618484L;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    /**
     * 页数，第几页
     */
    private Integer pageNum = 1;
    /**
     * 排序字段
     */
    private String sort;

    /**
     * 升序asc ,降序desc
     */
    private String order;
}
