/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月14日 上午10:09:49
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.common;

import com.azz.core.common.errorcode.SystemErrorCode;

import lombok.Data;

/**
 * <P>返回的数据</P>
 * @version 1.0
 * @author 黄智聪  2018年10月14日 上午10:09:49
 */
@Data
public class JsonResult<T> {
    /**
     *  错误码
     */
    private int code = SystemErrorCode.SUCCESS.getCode();
    
    /**
     *  错误码对应的信息
     */
    private String msg = SystemErrorCode.SUCCESS.getMessage();
    
    /**
     *  返回的数据
     */
    private T data;
    
    public JsonResult() {
    }

    public JsonResult(T data) {
        this.data = data;
    }
    
    /**
     * 
     * <p>成功（无数据返回）</p>
     * @return
     * @author 黄智聪（13510946256）  2018年8月21日 下午4:30:55
     */
    public static JsonResult<String> successJsonResult(){
        return new JsonResult<>();
    }
    
    /**
     * 
     * <p>成功并返回数据</p>
     * @param data 返回的数据
     * @return
     * @author 黄智聪（13510946256）  2018年8月21日 下午4:31:15
     */
    public static <T> JsonResult<T> successJsonResult(T data){
        return new JsonResult<>(data);
    }
}

