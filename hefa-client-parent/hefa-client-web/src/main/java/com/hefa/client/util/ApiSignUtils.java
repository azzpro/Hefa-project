/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年8月24日 下午3:32:34
 * Copyright (c) 2008 - 2011.深圳市齐采科技有限公司版权所有. 粤ICP备16034195号
 * 注意：本内容仅限于深圳市齐采科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.util;

import java.util.TreeMap;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.hefa.common.errorcode.ApiSignErrorCode;
import com.hefa.common.exception.ApiSignException;

/**
 * <P>Redis基础API签名工具类</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月24日 下午3:32:34
 */
public class ApiSignUtils {
    
    public static final String DEFAULT_CHATSET = "UTF-8";
    
    /**
     * 
     * <p>签名的值：根据调用参数和加签时间进行md5的加密</p>
     * @param sortedParamMap 参数集合
     * @param timestamp 加签时间
     * @param signTime 加签时间
     * @return
     * @author 黄智聪（13510946256）  2018年8月27日 下午2:22:32
     */
    public static String getSign(TreeMap<String, String> sortedParamMap, long timestamp, String key) {
        return getSign(JSON.toJSONString(sortedParamMap), timestamp, key);
    }
    
    /**
     * 
     * <pre>
     *  获取redis-api调用的签名
     *    签名的值：根据按照传入参数的json字符串、加签时间timestamp和key的顺序进行md5的加密
     *      注：json字符串的中各项key必须按字母从小到大的顺序排序
     * </pre>
     * @param sortedParamJsonStr 根据key按照字母从小到大的顺序排序的json字符串
     * @param timestamp 加签时间
     * @param key 约定的key（为固定值）
     * @return 签名
     * @author 黄智聪（13510946256）  2018年8月24日 下午3:50:53
     */
    public static String getSign(String sortedParamJsonStr, long timestamp, String key) {
        if(StringUtils.isEmpty(sortedParamJsonStr) || StringUtils.isEmpty(key)) {
            throw new ApiSignException(ApiSignErrorCode.API_SIGN_ERROR_INVALID_SIGNATURE);
        }
        // 按照jsonStr + signTime + key顺序以md5加密方式生成签名
        return MD5Encrypt.encryptMD5(sortedParamJsonStr + timestamp + key, DEFAULT_CHATSET);
    }
    
}

