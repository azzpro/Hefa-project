/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月7日 下午1:49:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.vo;

import java.util.Date;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2019年1月7日 下午1:49:26
 */
@Data
public class SpecialInfo {
    
    private Long id;
    
    /**
     * 专场编码
     *
     * @mbg.generated
     */
    private String specialPerformanceCode;

    /**
     * 专场名称
     *
     * @mbg.generated
     */
    private String specialPerformanceName;

    /**
     * 专场主图url
     *
     * @mbg.generated
     */
    private String specialPerformanceMainPicUrl;

    /**
     * 专场主图名称
     *
     * @mbg.generated
     */
    private String specialPerformanceMainPicName;

    /**
     * 专场背景图url
     *
     * @mbg.generated
     */
    private String specialPerformanceBgPicUrl;

    /**
     * 专场背景图名称
     *
     * @mbg.generated
     */
    private String specialPerformanceBgPicName;

    /**
     * 专场链接
     *
     * @mbg.generated
     */
    private String specialPerformanceLink;

    /**
     * 模组数量
     *
     * @mbg.generated
     */
    private Long moduleNumber;

    /**
     * 产品数量
     *
     * @mbg.generated
     */
    private Long productNumber;

    /**
     * 访问数量
     *
     * @mbg.generated
     */
    private Long interviewNumber;

    /**
     * 状态  删除0  上架1  下架2  
     *
     * @mbg.generated
     */
    private Byte status;
    
    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;
}

