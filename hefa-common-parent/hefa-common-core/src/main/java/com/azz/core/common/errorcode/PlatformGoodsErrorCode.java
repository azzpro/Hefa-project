/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月16日 下午6:57:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.core.common.errorcode;
/**
 * <P>平台商品模块错误码</P>
 * @version 1.0
 * @author 黄智聪  2018年10月16日 下午6:57:17
 */
public class PlatformGoodsErrorCode extends BaseErrorCode{
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_INVALID_NULL = new PlatformGoodsErrorCode(20001, "参数不存在");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_INVALID_PARAMS = new PlatformGoodsErrorCode(20003, "参数名相同");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_INVALID_VALUES = new PlatformGoodsErrorCode(20009, "参数值相同");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_CODE_NOTEXIST = new PlatformGoodsErrorCode(20004, "CODE不存在");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_UPDATE_ERROR = new PlatformGoodsErrorCode(20005, "更新失败");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_TOOMANY = new PlatformGoodsErrorCode(20005, "分类已关联参数项，不可再次选择此分类！");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_BRAND_NOT_EXIST = new PlatformGoodsErrorCode(20008, "品牌不存在");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_PRODUCT_EXIST = new PlatformGoodsErrorCode(20006, "关联分类存在产品");
    
    public static final PlatformGoodsErrorCode PLATFORM_GOODS_ERROR_ASSORTMENT_EXIST = new PlatformGoodsErrorCode(20007, "分类不存在");
    
    public PlatformGoodsErrorCode(int code, String message) {
	super(code, message);
    }

    @Override
    public String getErrorType() {
	return "平台用户异常";
    }

}

