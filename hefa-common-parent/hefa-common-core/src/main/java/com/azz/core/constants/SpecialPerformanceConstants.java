/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月7日 上午11:52:52
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.constants;

import lombok.Getter;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年1月7日 上午11:52:52
 */
public abstract class SpecialPerformanceConstants {
	
	/**
	 * 
	 * <P>专场推荐状态  0删除 1上架 2下架</P>
	 * @version 1.0
	 * @author 黄智聪  2019年1月4日 下午6:32:09
	 */
	public enum RecommendStatus {
		INVALID(0, "无效"),

		PUT_ON(1, "上架"),

		PUT_OFF(2, "下架");

		@Getter
		private int value;

		@Getter
		private String desc;

		RecommendStatus(int value, String desc) {
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
			RecommendStatus[] values = RecommendStatus.values();
			for (RecommendStatus status : values) {
				if (status.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}

}

