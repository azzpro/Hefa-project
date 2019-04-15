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
 * 商户常量类
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月19日 下午2:59:26
 */
public abstract class ClientConstants {
    
    public static final String LOGIN_CLIENT_USER = "loginClientUser";
    
    /**
	 * 客户注册短信验证码有效时间 10分钟
	 */
	public static final long CLIENT_REGIST_SMS_TIME_OUT = 10 * 60L;
    
    /**
     * 客户头像文件大小限制
     */
    public static final long AVATAR_FILE_SIZE_LIMIT = 2 * 1024 * 1024L;
    
    /**
     * 营业执照文件大小限制
     */
    public static final long BUSINESS_LICENSE_FILE_SIZE_LIMIT = 20 * 1024 * 1024L;
    
    /**
     * 经营执照文件大小限制
     */
    public static final long TRADING_CERTIFICATE_FILE_SIZE_LIMIT = 20 * 1024 * 1024L;
    
    /**
     * 签收单文件大小限制
     */
    public static final long SIGN_FORM_FILE_SIZE_LIMIT = 10 * 1024 * 1024L;

    /**
     * 收货地址限制数量
     */
    public static final int SHIPPING_ADDRESS_AMOUNT_LIMIT = 10;
    
    /**
     * 客户订单失效时间： 6小时
     */
    public static final int CLIENT_ORDER_DEAD_TIME_HOURS = 6;
    
    //首页幻灯片：homeslide 
    public static final String HOME_SLIDE = "homeslide";
    // 首页导航1：homenav1 
    public static final String HOME_NAV1 = "homenav1";
    // 首页导航2：homenav2 
    public static final String HOME_NAV2 = "homenav2";
    
    /**
     * 
     * <P>资质申请状态（0：未申请 1：待审批 2：已通过 3：已拒绝）</P>
     * @version 1.0
     * @author 黄智聪  2018年10月23日 上午11:57:37
     */
    public enum QualificationApplyStatus {

	REFUSED(0, "已拒绝"),

	PENDING(1, "待审批"),
	
	PASSED(2, "已通过"),
	
	NOT_APPLY(3, "已拒绝");

	@Getter
	private int value;

	@Getter
	private String desc;

	QualificationApplyStatus(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}
    }
    
    /**
     * 
     * <P>是否为企业认证者</P>
     * @version 1.0
     * @author 黄智聪  2018年10月29日 下午10:11:19
     */
    public enum IsEnterpriseAuthenticator {

	YES(1, "是"),

	NO(0, "否");
	
	@Getter
	private int value;

	@Getter
	private String desc;

	IsEnterpriseAuthenticator(int value, String desc) {
	    this.value = value;
	    this.desc = desc;
	}
    }
    
    public enum DeptStatus {
        // 0无效  1有效 2禁用
        INVALID(0, "无效"),

        ENABLE(1, "启用"),
        
        DISABLE(2, "禁用");

        @Getter
        private int value;

        @Getter
        private String desc;

        DeptStatus(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
    }
    
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
    
    /**
     * 
     * <P>客户订单状态</P>
     * @version 1.0
     * @author 黄智聪  2018年11月14日 下午2:09:47
     */
	public enum ClientOrderStatus {

	    NOT_PAID(7, "待支付"),

	    NOT_CONFIRMED(8, "待确认"),

	    NOT_ALLOCATED(9, "待配货"),

	    NOT_SIGNED(10, "待签收"),

	    COMPLETED(11, "已完成"),
	    
	    CLOSED(12, "已关闭");

        @Getter
        private int value;

        @Getter
        private String desc;

        ClientOrderStatus(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
        public static boolean checkStatusExist(int value) {
        	ClientOrderStatus[] values = ClientOrderStatus.values();
            for (ClientOrderStatus status : values) {
                if (status.getValue() == value) {
                    return true;
                }
            }
            return false;
        }
        
    }
	
	 /**
     * 
     * <P>客户订单操作类型 1订单拆单 2重新拆单 3取消派单</P>
     * @version 1.0
     * @author 黄智聪  2018年11月14日 下午2:09:47
     */
	public enum ClientOrderOperationType {

	    ALLOCATE_ORDER(1, "订单拆单"),

	    REALLOCATE_ORDER(2, "重新拆单"),

	    CANCEL_ALLOCATE_ORDER(3, "取消派单");

        @Getter
        private int value;

        @Getter
        private String desc;

        ClientOrderOperationType(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
    }
	
	/**
     * 
     * <P>客户订单操作类型 1订单拆单 2重新拆单 3取消派单</P>
     * @version 1.0
     * @author 黄智聪  2018年11月14日 下午2:09:47
     */
	public enum ClientOrderType {

	    PERSONAL(1, "个人订单"),

	    ENTERPRISE(2, "企业订单");

        @Getter
        private int value;

        @Getter
        private String desc;

        ClientOrderType(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
    }
    
	public enum ClientInvoiceType {
	    // 0 待审批 1 待开票 2 待签收 3 已拒绝 4 已完成 5 已取消
	    PENDING(0, "待审批"),
	    PENDING_INVOICE(1, "待开票"),
        NOT_SIGN(2, "待签收"),
        REJECTED(3, "已拒绝"),
        COMPLETED(4, "已完成"),
        CANCELLED(5, "已取消");

        @Getter
        private int value;

        @Getter
        private String desc;

        ClientInvoiceType(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
    }
	
	public enum InvoiceType {
        // 0 普通发票 1 增值税专用发票
	    ORDINARY_INVOICE(0, "普通发票"),
	    VAT_SPECIAL_INVOICE(1, "增值税专用发票");

        @Getter
        private int value;

        @Getter
        private String desc;

        InvoiceType(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
    }
	
	/**
	 * 
	 * <P>选型记录状态</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月23日 下午6:43:19
	 */
	public enum SelectionRecordStatus {
		
		INVALID(0, "无效"),

    	VALID(1, "有效");

    	@Getter
    	private int value;

    	@Getter
    	private String desc;

    	SelectionRecordStatus(int value, String desc) {
    	    this.value = value;
    	    this.desc = desc;
    	}
        
    }
	
	/**
	 * 
	 * <P>支付方式</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月23日 下午6:43:19
	 */
	public enum PayMethod {
		
		ONLINE(1, "线上"),

    	UNDERLINE(2, "线下");

    	@Getter
    	private int value;

    	@Getter
    	private String desc;

    	PayMethod(int value, String desc) {
    	    this.value = value;
    	    this.desc = desc;
    	}
        
    }
	/**
	 * 
	 * <P>支付状态</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月23日 下午6:43:19
	 */
	public enum PayStatus {
		
		NOT_PAID(1, "待支付"),

    	PAY_SUCCESS(2, "支付成功"),
    	
		PAY_CLOSED(3, "关闭支付"),
		
		PAY_FAILED(4, "支付失败");
		
    	@Getter
    	private int value;

    	@Getter
    	private String desc;

    	PayStatus(int value, String desc) {
    	    this.value = value;
    	    this.desc = desc;
    	}
        
    }
	
	/**
	 * 
	 * <P>个人资料修改类型 1姓名 2手机号 3邮箱 4密码</P>
	 * @version 1.0
	 * @author 黄智聪  2018年12月12日 下午3:01:54
	 */
	public interface PersonalEditType{
		
		public static final int NAME = 1;

		public static final int PHONE_NUMBER = 2;

		public static final int EMAIL = 3;

		public static final int PASSWORD = 4;

	}
}
