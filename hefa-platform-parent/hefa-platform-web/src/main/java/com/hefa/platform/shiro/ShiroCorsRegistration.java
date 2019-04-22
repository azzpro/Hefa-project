/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月18日 下午5:52:55
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.platform.shiro;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月18日 下午5:52:55
 */
public class ShiroCorsRegistration extends CorsRegistration{

    public ShiroCorsRegistration(String pathPattern) {
        super(pathPattern);
    }

    @Override
    public CorsConfiguration getCorsConfiguration() {
        return super.getCorsConfiguration();
    }
}

