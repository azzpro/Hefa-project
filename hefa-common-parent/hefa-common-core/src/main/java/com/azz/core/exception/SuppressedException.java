/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月17日 下午4:51:21
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月17日 下午4:51:21
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SuppressedException extends Exception{
    
    private int code;
    
    private static final long serialVersionUID = 6455321143107566695L;
    
    public SuppressedException(int code, String message){
	super(message);
	this.code = code;
    }

}

