/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月24日 上午11:31:09
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.sequence.base.service;

import com.hefa.common.core.BaseService;
import com.hefa.sequence.config.SequenceConfig;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月24日 上午11:31:09
 */
public interface SystemSequenceService extends BaseService{

	/**
	 * <p>init</p>
	 * @param sequenceConfig
	 * @throws Exception
	 * @author 刘建麟  2018年10月24日 上午11:32:19
	 */
	void init(SequenceConfig sequenceConfig) throws Exception;

    /**
     * <p>TODO</p>
     * @return
     * @author 刘建麟  2018年10月24日 上午11:32:30
     */
    String getSequence();
}

