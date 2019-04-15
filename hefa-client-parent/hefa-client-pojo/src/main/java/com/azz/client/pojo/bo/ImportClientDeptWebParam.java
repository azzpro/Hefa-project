/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月11日 下午3:17:44
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.pojo.bo;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年12月12日 上午11:38:26
 */
@Data
public class ImportClientDeptWebParam {
	
	@NotNull(message = "请上传文件")
	private MultipartFile file;
	
	private String companyCode;
	
	private String creator;

}

