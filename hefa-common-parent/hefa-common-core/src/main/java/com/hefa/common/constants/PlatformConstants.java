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
 * 平台常量类
 * </P>
 * 
 * @version 1.0
 * @author 彭斌 2018年10月19日 下午2:59:26
 */
public abstract class PlatformConstants {

	public static final String LOGIN_USER = "loginUser";

	// 平台端管理员角色名称
	public static final String PLATFORM_ADMIN_ROLE_NAME = "管理员";

	/**
	 * 顶级父级编码 0
	 */
	public static final String TOP_PARENT_PERMISSION_CODE = "0";

	/**
	 * 
	 * <P>权限状态</P>
	 * @version 1.0
	 * @author 黄智聪  2019年4月22日 下午1:39:38
	 */
	public enum PermissionStatus {

		INVALID(0, "无效"),

		VALID(1, "有效");

		@Getter
		private int value;

		@Getter
		private String desc;

		PermissionStatus(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}

	}

	/**
	 * 
	 * <P>用户状态</P>
	 * @version 1.0
	 * @author 黄智聪  2019年4月22日 下午1:40:40
	 */
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
	 * <P>平台成员与业务员记录的状态</P>
	 * @version 1.0
	 * @author 黄智聪  2019年4月22日 下午1:39:38
	 */
	public enum PlatformUserSalesmanRecordStatus {

		INVALID(0, "无效"),

		VALID(1, "有效");

		@Getter
		private int value;

		@Getter
		private String desc;

		PlatformUserSalesmanRecordStatus(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}

	}
	
	/**
	 * 
	 * <P>客户端会员与业务员记录的状态</P>
	 * @version 1.0
	 * @author 黄智聪  2019年4月22日 下午1:39:38
	 */
	public enum ClientUserSalesmanRecordStatus {

		INVALID(0, "无效"),

		VALID(1, "有效");

		@Getter
		private int value;

		@Getter
		private String desc;

		ClientUserSalesmanRecordStatus(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}

	}
}
