/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月4日 下午1:35:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.constants;

import lombok.Getter;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年1月4日 下午1:35:26
 */
public abstract class WxCourseConstants {
	
	/**
	 * 课程主图文件大小限制 2M
	 */
	public static final long COURSE_PIC_FILE_SIZE_LIMIT = 2 * 1024 * 1024L;
	

	/**
	 * 课程默认购买数量
	 */
	public static final int COURSE_BUY_COUNT = 1000;
	
	/**
	 *  微信课程登录用户名的前缀，用于区分是否为微信课程端用户登录
	 */
	public static final String WX_COURSE_LOGIN_USER_NAME_PREFIX = "wx_course_login:";
	
	/**
	 * 
	 * <P>是否修改了模组图片</P>
	 * @version 1.0
	 * @author 黄智聪  2018年11月1日 下午5:29:36
	 */
	public enum IsChangeCoursePic {
		N(0, "否"),

		Y(1, "是");

		@Getter
		private int value;

		@Getter
		private String desc;

		IsChangeCoursePic(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}
	}

	/**
	 * 
	 * <P>课程状态  0删除 1上架 2下架</P>
	 * @version 1.0
	 * @author 黄智聪  2019年1月4日 下午6:32:09
	 */
	public enum CourseStatus {
		INVALID(0, "无效"),

		PUT_ON(1, "上架"),

		PUT_OFF(2, "下架");

		@Getter
		private int value;

		@Getter
		private String desc;

		CourseStatus(int value, String desc) {
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
			CourseStatus[] values = CourseStatus.values();
			for (CourseStatus status : values) {
				if (status.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 
	 * <P>开课信息记录状态  0删除 1上架 2下架</P>
	 * @version 1.0
	 * @author 黄智聪  2019年1月4日 下午6:32:09
	 */
	public enum StartClassRecordStatus {
		INVALID(0, "无效"),

		PUT_ON(1, "上架"),

		PUT_OFF(2, "下架");

		@Getter
		private int value;

		@Getter
		private String desc;

		StartClassRecordStatus(int value, String desc) {
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
			StartClassRecordStatus[] values = StartClassRecordStatus.values();
			for (StartClassRecordStatus status : values) {
				if (status.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
     * 
     * <P>课程订单状态</P>
     * @version 1.0
     * @author 黄智聪  2018年11月14日 下午2:09:47
     */
	public enum CourseOrderStatus {

	    NOT_PAID(13, "待支付"),

	    PENDING(14, "待处理"),

	    NOT_CONFIRMED(15, "待确认"),

	    FINISHED_NOT_EVALUATED(16, "已完成但未评价"),

	    FINISHED_EVALUATED(17, "已完成且已评价"),

	    CLOSED(18, "已关闭");

        @Getter
        private int value;

        @Getter
        private String desc;

        CourseOrderStatus(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
        
        public static boolean checkStatusExist(int value) {
        	CourseOrderStatus[] values = CourseOrderStatus.values();
            for (CourseOrderStatus status : values) {
                if (status.getValue() == value) {
                    return true;
                }
            }
            return false;
        }
        
    }
	
}

