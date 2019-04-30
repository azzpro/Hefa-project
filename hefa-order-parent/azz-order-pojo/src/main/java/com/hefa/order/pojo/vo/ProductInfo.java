/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月30日 下午3:55:24
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.order.pojo.vo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月30日 下午3:55:24
 */
@Data
public class ProductInfo {
	
	/**
     * 产品编码对应iwebshop_goods的id
     *
     * @mbg.generated
     */
    private String productCode;

    /**
     * 产品型号对应iwebshop_goods的goods_no
     *
     * @mbg.generated
     */
    private String productModelNo;

    /**
     * 产品型号对应iwebshop_goods的name
     *
     * @mbg.generated
     */
    private String productName;

    /**
     * 参考价格
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     * 产品规格（逗号隔开）
     *
     * @mbg.generated
     */
    private String specificationInfo;
    
    /**
     * 选型记录id
     */
    private Long selectionRecordId;
    
    /**
     * 选型记录编码
     */
    private String selectionRecordCode;
}

