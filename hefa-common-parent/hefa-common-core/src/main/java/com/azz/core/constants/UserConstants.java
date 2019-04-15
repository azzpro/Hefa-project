/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午2:59:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.core.constants;

import lombok.Getter;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月19日 下午2:59:26
 */
public abstract class UserConstants {
    
    public static final String LOGIN_USER = "loginUser"; 
    
    // 平台端管理员角色名称
    public static final String PLATFORM_ADMIN_ROLE_NAME = "管理员"; 

    /**
	 * 修改个人资料短信验证码有效时间 10分钟
	 */
	public static final long CHANGE_DATA_SMS_TIME_OUT = 10 * 60L;
	

    /**
	 * 修改个人资料邮箱验证码有效时间 10分钟
	 */
	public static final long CHANGE_DATA_EMAIL_TIME_OUT = 10 * 60L;

    public enum UserStatus {

	DISABLE(0, "注销"),

	VALID(1, "有效"),

	INVALID(2, "禁用");

	@Getter
	private int value;

	@Getter
	private String desc;

	UserStatus(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}

	/**
	 * 
	 * <p>
	 * 校验是否存在该状态
	 * </p>
	 * 
	 * @param value
	 * @return
	 * @author 黄智聪 2018年10月20日 上午11:29:37
	 */
	public static boolean checkStatusExist(int value) {
	    UserStatus[] values = UserStatus.values();
	    for (UserStatus userStatus : values) {
		if (userStatus.getValue() == value) {
		    return true;
		}
	    }
	    return false;
	}
    }
    
    /**
     * 
     * <P>企业类型</P>
     * @version 1.0
     * @author 黄智聪  2018年10月29日 上午10:16:24
     */
    public enum ClientType {

	PERSON(0, "个人"),

	ENTERPRISE(1, "企业");

	@Getter
	private int value;

	@Getter
	private String desc;

	ClientType(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}

    }
    
    /**
     * 
     * <P>资质申请状态（0：未申请 1：待审批 2：已通过 3：已拒绝）</P>
     * @version 1.0
     * @author 黄智聪  2018年10月23日 上午11:57:37
     */
    public enum QualificationApplyStatus {

	NOT_APPLY(0, "未申请"),

	PENDING(1, "待审批"),
	
	PASSED(2, "已通过"),

	REFUSED(3, "已拒绝");

	@Getter
	private int value;

	@Getter
	private String desc;

	QualificationApplyStatus(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}
    }

}
