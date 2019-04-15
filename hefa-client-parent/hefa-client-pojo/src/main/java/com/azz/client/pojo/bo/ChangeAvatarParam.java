/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月29日 上午10:35:38
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月29日 上午10:35:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeAvatarParam {
    
    private String clientUserCode;

    @NotNull(message = "请上传头像")
    private Avatar avatar;
    
}

