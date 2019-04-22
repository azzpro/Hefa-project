/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 下午1:47:30
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefa.common.base.JsonResult;
import com.hefa.system.bo.UploadImageParam;

/**
 * <P>图片上传</P>
 * @version 1.0
 * @author 刘建麟  2018年10月23日 下午1:47:30
 */
@FeignClient("hefa-system-service")
public interface SystemImageUploadService {
	
	/**
	 * <p>上传图片</p>
	 * @param bucketname
	 * @param filename
	 * @param suffix
	 * @param filedata
	 * @param plattype
	 * @param imagetype
	 * @return
	 * @author 刘建麟  2018年10月23日 下午4:31:52
	 */
	@RequestMapping(value="/hefa/api/imageUpload")
	JsonResult<String> uploadImage(@RequestBody UploadImageParam up);
}

