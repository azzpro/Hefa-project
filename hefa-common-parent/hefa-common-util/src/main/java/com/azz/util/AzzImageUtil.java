/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 下午3:35:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.util;

import com.azz.core.constants.FileConstants;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月23日 下午3:35:06
 */
public class AzzImageUtil {
	
	/**
	 * <p>根据平台类型获取平台名称</p>
	 * @param plattype
	 * @return
	 * @author 刘建麟  2018年10月23日 下午3:38:27
	 */
	public static String getPlatByType(Integer plattype) {
		if(null == plattype) {
			return "";
		}
		if(FileConstants.AZZ_MERCHANT == plattype) {
			return FileConstants.MERCHANT_IMAGE_PATH;
		}
		if(FileConstants.AZZ_CLIENT == plattype) {
			return FileConstants.CLIENT_IMAGE_PATH;
		}
		if(FileConstants.AZZ_PLATFORM == plattype) {
			return FileConstants.PLATFORM_IMAGE_PATH;
		}
		if(FileConstants.AZZ_YEE == plattype) {
			return FileConstants.YEEPAY_IMAGE_PATH;
		}
		return "";
	}
	
	/**
	 * <p>根据图片类型获取图片文件夹名称</p>
	 * @param plattype
	 * @return
	 * @author 刘建麟  2018年10月23日 下午3:38:45
	 */
	public static String getImageByType(Integer imagetype) {
		if(null == imagetype) {
			return "";
		}
		if(FileConstants.AZZ_ICP_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_ICP_PATH;
		}
		if(FileConstants.AZZ_OPEN_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_OPEN_PATH;
		}
		if(FileConstants.AZZ_AVATAR_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_AVATAR_PATH;
		}
		if(FileConstants.AZZ_LEGAL_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_LEGAL_PERSON_PATH;
		}
		if(FileConstants.AZZ_BUSINESS_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_BUSINESS_LICENSE_PATH;
		}
		if(FileConstants.AZZ_OTHER_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_OTHER_PATH;
		}
		if(FileConstants.AZZ_TRADING_CERTIFICATE_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_TRADING_CERTIFICATE_PATH;
		}
		if(FileConstants.AZZ_CLASSIFICATION_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_CLASSIFICATION_PATH;
		}
		if(FileConstants.AZZ_BRAND_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_BRAND_PATH;
		}
		if(FileConstants.AZZ_MODULE_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_MODULE_PATH;
		}
		if(FileConstants.AZZ_COMBINATION_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_COMBINATION_PATH;
		}
		if(FileConstants.AZZ_CASE_IMAGE_TYPE == imagetype) {
			return FileConstants.AZZ_CASE_PATH;
		}
        if(FileConstants.AZZ_SIGN_FORM_IMAGE_TYPE == imagetype) {
            return FileConstants.AZZ_SIGN_FORM_PATH;
        }
        if(FileConstants.AZZ_SHIPMENT_FORM_IMAGE_TYPE == imagetype) {
            return FileConstants.AZZ_SHIPMENT_FORM_PATH;
        }
        if(FileConstants.AZZ_SPECIAL_PERFORMANCE_IMAGE_TYPE == imagetype) {
            return FileConstants.AZZ_SPECIAL_PERFORMANCE_PATH;
        }
        if(FileConstants.AZZ_WX_COURSE_IMAGE_TYPE == imagetype) {
            return FileConstants.AZZ_WX_COURSE_PATH;
        }
		return "";
	}
}	

