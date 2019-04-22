/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月23日 上午10:40:47
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.system.controller;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.system.bo.UploadImageParam;
import com.hefa.system.service.SystemImageService;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月23日 上午10:40:47
 */
@RestController
@RequestMapping("/hefa/api")
public class SystemUploadController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SystemUploadController.class);
	
	@Autowired
	private SystemImageService imageService;
	
	
	/**
	 * <p>上传图片</p>
	 * @param bucketname
	 * @param filename
	 * @param suffix
	 * @param filedata
	 * @param plattype
	 * @param imagetype
	 * @return
	 * @throws FileNotFoundException
	 * @author 刘建麟  2018年10月23日 下午4:19:44
	 */
	@RequestMapping(value="imageUpload")
	public JsonResult<String> imageUpload(@RequestBody UploadImageParam up) throws FileNotFoundException {
		//JSR303ValidateUtils.validate(up);
		return imageService.uploadImage(up);
	}
	
}

