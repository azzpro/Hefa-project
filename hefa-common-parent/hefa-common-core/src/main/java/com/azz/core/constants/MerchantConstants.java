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
public abstract class MerchantConstants {

	public static final String LOGIN_MERCHANT_USER = "loginMerchantUser";

	/**
	 * 营业执照文件大小限制
	 */
	public static final long BUSINESS_LICENSE_FILE_SIZE_LIMIT = 20 * 1024 * 1024L;

	/**
	 * 经营执照文件大小限制
	 */
	public static final long TRADING_CERTIFICATE_FILE_SIZE_LIMIT = 20 * 1024 * 1024L;
	
	/**
	 * 模组主图文件大小限制
	 */
	public static final long GOODS_MODULE_FILE_SIZE_LIMIT = 2 * 1024 * 1024L;
	
	/**
	 * 品牌主图文件大小限制
	 */
	public static final long GOODS_BRAND_FILE_SIZE_LIMIT = 2 * 1024 * 1024L;

	/**
	 * 推荐组合主图文件大小限制
	 */
	public static final long COMBINATION_FILE_SIZE_LIMIT = 2 * 1024 * 1024L;
	
	/**
	 * 商户注册短信验证码有效时间 10分钟
	 */
	public static final long MERCHANT_REGIST_SMS_TIME_OUT = 10 * 60L;
	
	/**
	 * 商户提现单号前缀
	 */
	public static final String MERCHANT_WITHDRAW_DEPOSIT_APPLY_CODE_PREFIX = "19";

	/**
	 * 
	 * <P>
	 * 资质申请状态（0：未申请 1：待审批 2：已通过 3：已拒绝）
	 * </P>
	 * 
	 * @version 1.0
	 * @author 黄智聪 2018年10月23日 上午11:57:37
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

	public enum DeptStatus {
		// 0无效 1有效 2禁用
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

	public enum IsMerchantRegister {
		N(0, "否"),

		Y(1, "是");

		@Getter
		private int value;

		@Getter
		private String desc;

		IsMerchantRegister(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}
	}
	
	/**
	 * 
	 * <P>是否修改了模组图片</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月1日 下午5:29:36
	 */
	public enum IsChangeGoodsModulePic {
		N(0, "否"),

		Y(1, "是");

		@Getter
		private int value;

		@Getter
		private String desc;

		IsChangeGoodsModulePic(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}
	}
	
	/**
	 * 
	 * <P>是否修改了品牌图片</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月1日 下午5:29:36
	 */
	public enum IsChangeGoodsBrandPic {
		N(0, "否"),

		Y(1, "是");

		@Getter
		private int value;

		@Getter
		private String desc;

		IsChangeGoodsBrandPic(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}
	}
	
	/**
	 * 
	 * <P>是否修改了推荐组合图片</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月1日 下午5:29:36
	 */
	public enum IsChangeCombinationPic {
		N(0, "否"),

		Y(1, "是");

		@Getter
		private int value;

		@Getter
		private String desc;

		IsChangeCombinationPic(int value, String desc) {
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
	
	public enum GoodsModuleStatus {

		DISABLE(0, "无效"),

		PUT_ON(1, "上架"),

		PUT_OFF(2, "下架");

		@Getter
		private int value;

		@Getter
		private String desc;

		GoodsModuleStatus(int value, String desc) {
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
			GoodsModuleStatus[] values = GoodsModuleStatus.values();
			for (GoodsModuleStatus status : values) {
				if (status.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 
	 * <P>品牌状态</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月2日 下午4:39:19
	 */
	public enum GoodsBrandStatus {

		INVALID(0, "无效"),

		VALID(1, "有效");


		@Getter
		private int value;

		@Getter
		private String desc;

		GoodsBrandStatus(int value, String desc) {
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
			GoodsBrandStatus[] values = GoodsBrandStatus.values();
			for (GoodsBrandStatus status : values) {
				if (status.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 
	 * <P>推荐组合状态</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月6日 下午3:02:40
	 */
	public enum CombinationStatus {

		DISABLE(0, "无效"),

		PUT_ON(1, "上架"),

		PUT_OFF(2, "下架");

		@Getter
		private int value;

		@Getter
		private String desc;

		CombinationStatus(int value, String desc) {
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
			CombinationStatus[] values = CombinationStatus.values();
			for (CombinationStatus status : values) {
				if (status.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * <P>商户订单状态</P>
	 * @version 1.0
	 * @author 彭斌  2018年11月14日 上午10:46:37
	 */
	public enum MerchantOrderStatusEnum {

	    NOT_CONFIRMED(1, "待确认"),

	    NOT_SENT_OUT(2, "待发货"),

	    NOT_SIGNED(3, "待签收"),

	    COMPLETED(4, "已完成"),
        
	    CANCELLED(5, "已取消");

        @Getter
        private int value;

        @Getter
        private String desc;

        MerchantOrderStatusEnum(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
        public static boolean checkStatusExist(int value) {
        	MerchantOrderStatusEnum[] values = MerchantOrderStatusEnum.values();
            for (MerchantOrderStatusEnum status : values) {
                if (status.getValue() == value) {
                    return true;
                }
            }
            return false;
        }
        
    }
	
	// 0 待确认 1 待开票 2 待签收 3 已完成
	public enum MerchantInvoiceApplyStatusEnum {

        NOT_CONFIRMED(0, "待确认"),

        NOT_INVOICED(1, "待开票"),

        NOT_SIGNED(2, "待签收"),

        COMPLETED(3, "已完成");

        @Getter
        private int value;

        @Getter
        private String desc;

        MerchantInvoiceApplyStatusEnum(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
    }
	
	/**
	 * 
	 * <P>商户订单状态</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月14日 下午5:51:32
	 */
	public enum MerchantOrderType {

	    PERSON(1, "个人"),

	    ENTERPRISE(2, "企业");

        @Getter
        private int value;

        @Getter
        private String desc;

        MerchantOrderType(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
        public static boolean checkStatusExist(int value) {
        	MerchantOrderType[] values = MerchantOrderType.values();
            for (MerchantOrderType status : values) {
                if (status.getValue() == value) {
                    return true;
                }
            }
            return false;
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
	
	/**
     * 
     * <P>资质申请状态（0：未申请 1：待审批 2：已通过 3：已拒绝）</P>
     * @version 1.0
     * @author 黄智聪  2018年10月23日 上午11:57:37
     */
    public enum WithdrawDepositApplyStatus {

    	PENDING(1, "待审核"),
	
		NOT_PAID_WITH(2, "待打款"),
		
		PAID_WITH(3, "已打款"),
		
		CLOSED(4, "已关闭"),
    	
    	PROCCESSING(5, "处理中");
	
		@Getter
		private int value;
	
		@Getter
		private String desc;
	
		WithdrawDepositApplyStatus(int value, String desc) {
		    this.value = value;
		    this.desc = desc;
		}
    }
	
}
