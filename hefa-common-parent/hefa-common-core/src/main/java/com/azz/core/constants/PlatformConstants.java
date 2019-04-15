/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月19日 下午2:59:26
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.core.constants;

/**
 * <P>
 * 平台常量类
 * </P>
 * 
 * @version 1.0
 * @author 彭斌 2018年10月19日 下午2:59:26
 */
public abstract class PlatformConstants {
    
    /**
     * 分类主图文件大小限制
     */
    public static final long CLASSIFICATION_FILE_SIZE_LIMIT = 2 * 1024 * 1024L;
    
    /**
     * 首页主图文件大小
     */
    public static final long INDEX_FILE_SIZE_LIMIT = 5 * 1024 * 1024L;
    
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
