/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年8月31日 下午6:36:55
 * Copyright (c) 2008 - 2011.深圳市齐采科技有限公司版权所有. 粤ICP备16034195号
 * 注意：本内容仅限于深圳市齐采科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * <P>额外配置</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月31日 下午6:36:55
 */
//@Component
public class ExtraConfig {
    
    @Getter
    @Value("${api_call.allowed_timeout}")
    private Long allowedTimeout;
    

    @Getter
    @Value("${api_call.url.base_db_auth}")
    private String baseDbAuthUrl;
    
    @Getter
    @Value("${public.add_redis_key}")
    private String addRedisKey;
    
    @Getter
    @Value("${public.auth_key}")
    private String authKey;
    
}

