/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月6日 上午11:51:41
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年12月6日 上午11:51:41
 */
@Data
public class AddSignUpCourseParam {
    @NotBlank(message = "姓名不允许为空")
    private String name;
    // 性别(0 男 1 女)
    @NotNull(message = "性别不允许为空")
    private Integer gender;
    @NotBlank(message = "手机不允许为空")
    private String mobilePhone;
    @NotNull(message = "文章不允许为空")
    private Long articleId;
    
    private String email;
    private String qq;
    private String company;
    private String post;
}

