/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午6:36:05
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.core.common.constants;

import lombok.Getter;

/**
 * <P>
 * 短信常量
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月22日 下午6:36:05
 */
public abstract class MessageConstants {
    
    /**
     * 短信验证码长度
     */
    public static final  int MESSAGE_VERYFICATION_CODE_LENGTH = 6;

    /**
     * 
     * <P>
     * 短信类型
     * </P>
     * 
     * @version 1.0
     * @author 黄智聪 2018年10月22日 下午6:39:26
     */
    public enum MessageType {

	REGIST(1, "注册"),

	FIND_BACK_PASSWORD(2, "找回密码 "),

	FORGET_PASSWORD(3, "忘记密码"),

	WITHDRAW_DEPOSIT(4, "提现 "),

	MODIFY_LOGIN_PHONE(5, "修改登录手机号");

	@Getter
	private int value;

	@Getter
	private String desc;

	MessageType(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}

    }
    
    /**
     * 
     * <P>
     * 短信发送状态
     * </P>
     * 
     * @version 1.0
     * @author 黄智聪 2018年10月22日 下午6:39:26
     */
    public enum MessageSendStatus {

	SUCCESS(1, "成功"),

	FAIL(2, "失败");

	@Getter
	private int value;

	@Getter
	private String desc;

	MessageSendStatus(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}

    }
    
    /**
     * 
     * <P>短信平台</P>
     * @version 1.0
     * @author 黄智聪  2018年10月22日 下午7:17:26
     */
    public enum MessagePlatform {

	ALI(1, "阿里云");

	@Getter
	private int value;

	@Getter
	private String desc;

	MessagePlatform(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}

    }

}
