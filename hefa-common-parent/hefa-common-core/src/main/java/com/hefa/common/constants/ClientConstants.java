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
     * 商品折扣
     * <P>TODO</P>
     * @version 1.0
     * @author 黄智聪  2019年5月24日 下午5:31:22
     */
    public enum ProductDiscount {
    	
    	/**
    	 * 98折
    	 */
    	D_98(0.98, 1, 5, 0),

    	/**
    	 * 95折
    	 */
    	D_95(0.95, 6, 20, 0.5),

    	/**
    	 * 88折
    	 */
    	D_88(0.88, 21, 40, 1),

    	/**
    	 * 85折
    	 */
    	D_85(0.85, 41, null, 0);

    	@Getter
    	private double value;// 折扣率

    	@Getter
    	private Integer minProcutCount;// 产品数量左区间
    	
    	@Getter
    	private Integer maxProductCount;// 产品数量左区间
    	
    	@Getter
    	private double odd;// 零头

		private ProductDiscount(double value, Integer minProcutCount, Integer maxProductCount, double odd) {
			this.value = value;
			this.minProcutCount = minProcutCount;
			this.maxProductCount = maxProductCount;
			this.odd = odd;
		}
		/*
		*//**
		 * 
		 * <p>根据产品数量获取对应折扣</p>
		 * @param productCount
		 * @return
		 * @author 黄智聪  2019年5月24日 下午5:48:29
		 *//*
		public ProductDiscount getProductDiscount(int productCount) {
			ProductDiscount[] values = ProductDiscount.values();
			for (ProductDiscount productDiscount : values) {
				productDiscount.getMaxProductCount();
				productDiscount.getMinProcutCount();
			}
			return null;
		}*/
		
    }

	
}
