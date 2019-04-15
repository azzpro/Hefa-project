/**
 * Company: 深圳市齐采科技股份有限公司 Project Name:qc-core File Name: RegexUtil.java Package
 * Name:com.qc.framework.utils Date: 2016年6月27日下午4:10:42 Author: zjj Copyright (www.17cai.com) 2016,
 * All Rights Reserved.
 */
package com.azz.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class RegexUtil {


    private static final String EMAIL_REG =
            "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    private static final String MOBILE_REG =
            "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8})|(0\\\\d{2}-\\\\d{8})|(0\\\\d{3}-\\\\d{7})$";
    private static Pattern pattern;
    private static Matcher matcher;

    /**
     * 邮箱校验,符合返回true,否则返回false isEmail:. <br/>
     * 
     * @author zjj
     * @param email
     * @return
     * @since JDK 1.7
     */
    public static boolean isEmail(String email) {
        Assert.hasText(email, "邮箱不能为空");
        pattern = Pattern.compile(EMAIL_REG);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 邮箱校验,符合返回true,否则返回false isEmail:. <br/>
     * 
     * @author zjj
     * @param email
     * @return
     * @since JDK 1.7
     */
    public static boolean isCelphone(String phoneNum) {
        Assert.hasText(phoneNum, "手机号不能为空");
        pattern = Pattern.compile(MOBILE_REG);
        matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    public static void main(String[] args) {
        try {
            System.out.println(isCelphone("18575541922"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------");
    }

}
