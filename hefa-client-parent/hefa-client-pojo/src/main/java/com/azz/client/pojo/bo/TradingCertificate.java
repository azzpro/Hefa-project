/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 下午9:26:19
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月23日 下午9:26:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingCertificate {
    
    private String fileName;
    
    private long fileSize;
    
    private String fileBase64Str;

}

