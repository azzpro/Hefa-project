/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 上午9:18:34
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.azz.core.common.errorcode;
/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月29日 下午5:32:33
 */
public class SystemErrorCode extends BaseErrorCode {
    
    public static final SystemErrorCode SUCCESS = new SystemErrorCode(0, "SUCCESS");
    
    public static final SystemErrorCode SYS_ERROR_UNKNOWN = new SystemErrorCode(10000, "未知错误");
    
    public static final SystemErrorCode SYS_ERROR_SERVICE_NOT_USE = new SystemErrorCode(10001, "服务暂不可用");
    
    public static final SystemErrorCode SYS_ERROR_UNKNOW_METHOD = new SystemErrorCode(10002, "未知的方法");
    
    public static final SystemErrorCode SYS_ERROR_CALL_MAX_LIMIT = new SystemErrorCode(10003, "接口调用次数已达到设定的上限"); 
    
    public static final SystemErrorCode SYS_ERROR_INVALID_IP = new SystemErrorCode(10004, "请求来自未经授权的IP地址"); 
    
    public static final SystemErrorCode SYS_ERROR_NO_PERMISSION = new SystemErrorCode(10005, "无权限访问该用户数据"); 
    
    public static final SystemErrorCode SYS_ERROR_INVALID_REQUEST_PARAM = new SystemErrorCode(10006, "请求参数无效"); 
    
    public static final SystemErrorCode SYS_ERROR_TO_MUCH_REQUEST_PARAM = new SystemErrorCode(10007, "请求参数过多"); 
    
    public static final SystemErrorCode SYS_ERROR_INVALID_COLUMN = new SystemErrorCode(10008, "无效的用户资料字段名"); 
    
    public static final SystemErrorCode SYS_ERROR_USER_NOT_VISIBLE = new SystemErrorCode(10009, "用户不可见");
    
    public static final SystemErrorCode SYS_ERROR_COLUMN_NOT_AUTH = new SystemErrorCode(10010, "获取未授权的字段"); 
    
    public static final SystemErrorCode SYS_ERROR_INVIDE_OPERATE = new SystemErrorCode(10011, "无效的操作方法"); 
    
    public static final SystemErrorCode SYS_ERROR_DATA_SPACE_OVER_LIMIT = new SystemErrorCode(10012, "数据存储空间已超过设定的上限"); 
    
    public static final SystemErrorCode SYS_ERROR_APP_NOT_EXIST = new SystemErrorCode(10013, "访问的应用不存在"); 
    
    public static final SystemErrorCode SYS_ERROR_AUTH_FAILED = new SystemErrorCode(10014, "认证失败"); 
    
    public static final SystemErrorCode SYS_ERROR_API_REQUST_TIMES = new SystemErrorCode(10015, "接口请求次数异常");
    
    public static final SystemErrorCode SYS_ERROR_NOT_ALLOWED_REQUEST_METHOD = new SystemErrorCode(10016, "不允许的请求方式");
    
    public static final SystemErrorCode SYS_ERROR_REQUEST_TIMEOUT = new SystemErrorCode(10017, "请求超时");
    
    public static final SystemErrorCode SYS_ERROR_INVILID_SIGN = new SystemErrorCode(10018, "无效签名");
    
    public static final SystemErrorCode SYS_ERROR_NO_DATA = new SystemErrorCode(10019, "暂无数据");
    
    public static final SystemErrorCode SYS_ERROR_ILLEGAL_IP = new SystemErrorCode(10020, "非法的IP地址");
    
    public static final SystemErrorCode SYS_ERROR_MESSAGE_SERVICE_CALL_ERROR = new SystemErrorCode(10021, "短信服务调用出错");
    
    public SystemErrorCode(int code, String message) {
        super(code, message);
    }

    @Override
    public String getErrorType() {
        return "系统异常";
    }
}

