/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年8月30日 上午10:54:04
 * Copyright (c) 2008 - 2011.深圳市齐采科技有限公司版权所有. 粤ICP备16034195号
 * 注意：本内容仅限于深圳市齐采科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.hefa.common.exception.ValidationException;

import lombok.experimental.UtilityClass;

/**
 * <P>JSR303校验</P>
 * @version 1.0
 * @author 黄智聪（13510946256）  2018年8月30日 上午10:54:04
 */
@UtilityClass
public class JSR303ValidateUtils {

	/**
	 * 
	 * <p>校验对象是否为空或为空字符串，并默认提示“输入参数为空或空字符串”</p>
	 * @param input 校验参数
	 * @throws ValidationException
	 * @author 黄智聪  2019年3月25日 下午3:05:32
	 */
    public static <T> void validateNullOrBlank(Object input) throws ValidationException {
    	validateNullOrBlank(input, "输入参数为空或空字符串");
    }
    
    /**
	 * 
	 * <p>校验对象是否为空或为空字符串，并提示相应错误</p>
	 * @param input 校验参数
	 * @param errorMsg 提示的相应错误
	 * @throws ValidationException
	 * @author 黄智聪  2019年3月25日 下午3:05:32
	 */
    public static <T> void validateNullOrBlank(Object input, String errorMsg) throws ValidationException {
    	if(input == null) {
    		throw new ValidationException(errorMsg);
    	}
    	if(input instanceof String) {
    		if(StringUtils.isBlank((String)input)) {
    			throw new ValidationException(errorMsg);
    		}
    	}
    }
	
	/**
     * 
     * <p>验证符合JSR303规范的对象</p>
     * @param input 需被校验的参数
     * @throws JSR303ValidationException 验证不通过时,抛出此异常
     * @author 黄智聪（13510946256）  2018年8月30日 上午10:57:59
     */
    public static <T> void validateInputParam(T input) throws ValidationException {
    	if (input == null) {
            throw new ValidationException("输入参数为空");
        }
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(input);
        if (0 < violations.size()) {
            for (ConstraintViolation<T> violation : violations) {
                throw new ValidationException(violation.getMessage());
            }
        }
    }

    /**
     * 
     * <p>验证符合JSR303规范的对象 </p>
     * @param input 需被校验的参数
     * @param ignoreFields  忽略校验的字段
     * @throws JSR303ValidationException   验证不通过时,抛出此异常
     * @author 黄智聪（13510946256）  2018年8月30日 上午11:29:22
     */
    public static <T> void validateInputParam(T input, String... ignoreFields) throws ValidationException {
    	if (input == null) {
            throw new ValidationException("输入参数为空");
        }
        if (ignoreFields == null || ignoreFields.length == 0) {
        	throw new ValidationException("忽略校验字段为空");
        } else {
            Collection<String> coll = Arrays.asList(ignoreFields);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(input);
            if (0 < violations.size()) {
                for (ConstraintViolation<T> violation : violations) {
                    if (!coll.contains(violation.getPropertyPath().toString())) {
                        throw new ValidationException(violation.getMessage());
                    }
                }
            }
        }
    }
    
}

