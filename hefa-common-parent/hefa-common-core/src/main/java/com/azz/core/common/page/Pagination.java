/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午2:37:44
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.common.page;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>分页数据封装</P>
 * @version 1.0
 * @author 彭斌  2018年10月15日 下午2:37:44
 */
@Data
@NoArgsConstructor
public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = -3333370388316673393L;
    /**
     * 第几页
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 结果集
     */
    private List<T> rows;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 总记录数
     */
    private Long total;

    public Pagination(List<T> rows) {
        if (rows instanceof Page) {
            Page<T> page = (Page<T>) rows;
            this.rows = rows;
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.pageNum = page.getPageNum();
        }
    }

    public Pagination(Integer pageNum, Integer pageSize, List<T> rows, int pages, Long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.rows = rows;
        this.pages = pages;
        this.total = total;
    }
}

