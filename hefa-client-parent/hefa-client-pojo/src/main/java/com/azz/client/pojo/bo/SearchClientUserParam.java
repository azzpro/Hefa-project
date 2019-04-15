/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月20日 上午9:59:43
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import com.azz.core.common.QueryPage;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月20日 上午9:59:43
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SearchClientUserParam extends QueryPage{

    private static final long serialVersionUID = 939905148785144826L;
    
    private String searchInput;
    
    private String companyCode;
    
}

