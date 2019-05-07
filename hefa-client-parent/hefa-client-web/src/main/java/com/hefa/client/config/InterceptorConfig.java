/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午7:35:16
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.hefa.client.interceptor.SignInterceptor;

/**
 * <P>web相关配置</P>
 * @version 1.0
 * @author 黄智聪  2018年10月15日 下午7:35:16
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

	@Bean
    public SignInterceptor getSignInterceptor() {
        return new SignInterceptor();
    }
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration signInterceptor = registry.addInterceptor(getSignInterceptor());
        signInterceptor.addPathPatterns("/hefa/api/client/selection/addProductToShoppingCart");
        signInterceptor.excludePathPatterns("/actuator/health");
    }
    
}

