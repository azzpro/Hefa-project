/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午6:57:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.common.errorcode;

import com.hefa.common.base.BaseErrorCode;

/**
 * <P>平台用户模块错误码</P>
 * @version 1.0
 * @author 黄智聪  2018年10月16日 下午6:57:17
 */
public class PlatformUserErrorCode extends BaseErrorCode{
    
    public static final PlatformUserErrorCode PLATFORM_USER_ERROR_INVALID_USER = new PlatformUserErrorCode(20001, "无效用户");
    
    public static final PlatformUserErrorCode PLATFORM_USER_ERROR_WRONG_PHONE_OR_PASSWORD = new PlatformUserErrorCode(20002, "手机号或密码错误");

    public static final PlatformUserErrorCode PLATFORM_USER_ERROR_INCONSISTENT_PASSWORD = new PlatformUserErrorCode(20003, "两次密码不一致");
    
    // 关于部门错误码
    public static final PlatformUserErrorCode PLATFORM_DEPT_ERROR_EXIST = new PlatformUserErrorCode(30000, "部门已存在");
    
    public static final PlatformUserErrorCode PLATFORM_DEPT_ERROR_NO_EXIST = new PlatformUserErrorCode(30001, "部门编码不存在");
    
    public static final PlatformUserErrorCode PLATFORM_DEPT_STATUS_ERROR_NO_EXIST = new PlatformUserErrorCode(30002, "部门状态不存在");
    
    public static final PlatformUserErrorCode PLATFORM_DEPT_USER_EXIST = new PlatformUserErrorCode(30003, "部门下绑定成员信息，请处理后删除");
    
    public static final PlatformUserErrorCode PLATFORM_DEPT_LEVEL_ERROR = new PlatformUserErrorCode(30004, "已是三级部门");
    
    public static final PlatformUserErrorCode PLATFORM_DEPT_CODE_ERROR = new PlatformUserErrorCode(30005, "不许绑定自身编码");
    
    public static final PlatformUserErrorCode PLATFORM_DEPT_EXIST = new PlatformUserErrorCode(30006, "部门下存在子部门，请处理后删除");
    
    // 商户审核错误码
    public static final PlatformUserErrorCode PLATFORM_MERCHANT_ERROR_NO_EXIST = new PlatformUserErrorCode(40000, "商户不存在");
    
    public static final PlatformUserErrorCode PLATFORM_MERCHANT_AUDIT_STATUS_ERROR_NO_EXIST = new PlatformUserErrorCode(40001, "审核状态不存在");
    
    public static final PlatformUserErrorCode PLATFORM_MERCHANT_AUDIT_ERROR = new PlatformUserErrorCode(40002, "信息不在审核范围内，可能通过或者拒绝状态");
    
    //  客户审核错误码
    public static final PlatformUserErrorCode PLATFORM_CLIENT_NO_EXIST = new PlatformUserErrorCode(50000, "客户不存在");
    public static final PlatformUserErrorCode PLATFORM_CLIENT_ERROR_NO_EXIST = new PlatformUserErrorCode(50001, "客户不存在");
    public static final PlatformUserErrorCode PLATFORM_CLIENT_AUDIT_STATUS_ERROR_NO_EXIST = new PlatformUserErrorCode(50002, "审核状态不存在");
    public static final PlatformUserErrorCode PLATFORM_CLIENT_AUDIT_NO_EXIST = new PlatformUserErrorCode(50003, "客户可能未申请或者不在待审状态");
    public static final PlatformUserErrorCode PLATFORM_CLIENT_ENTERPRISE_NO_EXIST = new PlatformUserErrorCode(50004, "审核的企业不存在");
    
    // 商品管理错误代码
    public static final PlatformUserErrorCode PLATFORM_PRODUCT_CLASSIFICATION_NO_EXIST = new PlatformUserErrorCode(60000, "分类不存在");
    public static final PlatformUserErrorCode PLATFORM_SAME_CLASSIFICATION_ID = new PlatformUserErrorCode(60001, "分类名称已存在！");
    public static final PlatformUserErrorCode PLATFORM_PRODUCT_CHILD_CLASSIFICATION_EXIST = new PlatformUserErrorCode(60002, "存在子分类，请移除后再删除！");
    public static final PlatformUserErrorCode PLATFORM_PRODUCT_THIRD_LEVEL_CLASSIFICATION = new PlatformUserErrorCode(60003, "已是三级分类");
    public static final PlatformUserErrorCode PLATFORM_PRODUCT_CLASSIFICATION_EXIST = new PlatformUserErrorCode(60004, "分类下存在模组和参数项，请先处理后删除！");
    
    public PlatformUserErrorCode(int code, String message) {
	super(code, message);
    }

    @Override
    public String getErrorType() {
	return "平台用户异常";
    }

}

