/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午2:59:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.common.constants;

import lombok.Getter;

/**
 * <P>
 * 客户端常量类
 * </P>
 * 
 * @version 1.0
 * @author 彭斌 2018年10月19日 下午2:59:26
 */
public abstract class ClientConstants {

	/**
     * 收货地址限制数量
     */
    public static final int SHIPPING_ADDRESS_AMOUNT_LIMIT = 10;
    
    /**
     * 订单有效期
     */
    public static final int ORDER_VALID_TIME_HOURS = 6;
    
    /**
     * 登录用户session key
     */
    public static final String LOGIN_USER = "loginUser";

    /**
     * 登录用户token存入redis的key的前缀
     */
    public static final String LOGIN_USER_TOKEN_REDIS_PREFIX = "userToken_";
    
    public static final String REQUEST_HEADER_USER_TOKEN_NAME = "ut";
    
    /**
     * 登录用户token存入redis的失效时间  3小时
     */
    public static final long LOGIN_USER_TOKEN_REDIS_HOURS_TIME_OUT = 3;
    
    /**
     * 	密码加密时的后缀
     */
    public static final String PASSWORD_ENCRYPT_SUFFIX = "ihf";
    
    /**
     * ASE加密的key
     */
    public final static String DEFAULT_ASE_KEY = "qlemc5GkRiPVXH88";
    
    /**
	 * 
	 * <P>开票类型 0普通 1增值</P>
	 * @version 1.0
	 * @author 黄智聪  2019年4月22日 下午1:40:40
	 */
	public enum Invoicetype {

		NORMAL(0, "普通发票"),

		VAT(1, "增值税发票");

		@Getter
		private int value;

		@Getter
		private String desc;

		Invoicetype(int value, String desc) {
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
			Invoicetype[] values = Invoicetype.values();
			for (Invoicetype invoicetype : values) {
				if (invoicetype.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
     * 
     * <P>收货地址</P>
     * @version 1.0
     * @author 黄智聪  2018年11月13日 下午5:04:16
     */
    public enum ShippingAddressStatus {

    	INVALID(0, "无效"),

    	VALID(1, "有效");

    	@Getter
    	private int value;

    	@Getter
    	private String desc;

    	ShippingAddressStatus(int value, String desc) {
    	    this.value = value;
    	    this.desc = desc;
    	}
    }
    
    /**
     * 
     * <P>收货地址</P>
     * @version 1.0
     * @author 黄智聪  2018年11月13日 下午5:04:16
     */
    public enum isDefaultShippingAddress {

    	YES(1, "是"),

    	NO(0, "否");

    	@Getter
    	private int value;

    	@Getter
    	private String desc;

    	isDefaultShippingAddress(int value, String desc) {
    	    this.value = value;
    	    this.desc = desc;
    	}
    }
	
}
