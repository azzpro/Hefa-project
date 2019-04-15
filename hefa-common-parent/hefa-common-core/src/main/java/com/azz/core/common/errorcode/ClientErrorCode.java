/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午6:57:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.common.errorcode;
/**
 * <P>客户端模块错误码</P>
 * @version 1.0
 * @author 彭斌  2018年10月29日 上午11:04:13
 */
public class ClientErrorCode extends BaseErrorCode{
    
    
    // 关于部门错误码
    public static final ClientErrorCode CLIENT_DEPT_ERROR_EXIST = new ClientErrorCode(10000, "部门已存在");
    
    public static final ClientErrorCode CLIENT_DEPT_ERROR_NO_EXIST = new ClientErrorCode(10001, "部门不存在");
    
    public static final ClientErrorCode CLIENT_DEPT_STATUS_ERROR_NO_EXIST = new ClientErrorCode(10002, "部门状态不存在");
    
    public static final ClientErrorCode CLIENT_DEPT_PARENT_CODE_ERROR_NO_EXIST = new ClientErrorCode(10003, "部门父级编码不存在");
    
    public static final ClientErrorCode CLIENT_DEPT_CLIENT_ERROR_EXIST = new ClientErrorCode(10004, "部门下存在用户");
    
    public static final ClientErrorCode CLIENT_DEPT_CLIENT_LEVEL_ERROR_EXIST = new ClientErrorCode(10005, "已是三级部门");
    
    public static final ClientErrorCode CLIENT_DEPT_CLIENT_PARENT_CODE_ERROR = new ClientErrorCode(10006, "部门父级编码重名");
    
    public ClientErrorCode(int code, String message) {
	super(code, message);
    }

    @Override
    public String getErrorType() {
	return "客户异常";
    }

}

