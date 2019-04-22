/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年12月7日 上午1:28:38
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.sequence.sequence.quartz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年12月7日 上午1:28:38
 */
//@Component
public class UpdateOrderNumber {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	
	private final static String SEQUENCE_CONFIG_DELETE_TEMPLATE_MYSQL = "DELETE FROM system_sequence_config WHERE id=?";
	
	private final static String SEQUENCE_CREATE_TEMPLATE = "INSERT INTO system_sequence_config (id, maximum, current) VALUES (?, ?, ?)";
	
	@Autowired DataSourceTransactionManager transactionManager;
	
	private  final String ORDERPERSONLSEQUENCE = "PO";
	private  final String ORDERCOMPANYSEQUENCE = "CO";
	private  final String ORDERMERCHANTSEQUENCE = "MO";
	private  final String CLIENTINVOICEAPPLYSEQUENCE = "CB";
	private  final String MERCHANTINVOICEAPPLYCODESEQUENCE = "MB";
	
	/**
	 * <p>订单 发票 序号重置</p>
	 * @author 刘建麟  2018年12月7日 上午1:33:32
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void updateOrderNumber() {
		LOG.info("重置订单序列自动任务开始.................");
		List<String> st = new ArrayList<String>();
		st.add(CLIENTINVOICEAPPLYSEQUENCE);
		st.add(MERCHANTINVOICEAPPLYCODESEQUENCE);
		st.add(ORDERCOMPANYSEQUENCE);
		st.add(ORDERMERCHANTSEQUENCE);
		st.add(ORDERPERSONLSEQUENCE);
        DataSource dataSource = transactionManager.getDataSource();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        PreparedStatement ps = null;
		try {
			for (String string : st) {
				ps = connection.prepareStatement(SEQUENCE_CONFIG_DELETE_TEMPLATE_MYSQL);
				ps.setString(1, string);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		try {
			for (String string : st) {
				ps = connection.prepareStatement(SEQUENCE_CREATE_TEMPLATE);
				ps.setString(1, string);
		        ps.setInt(2, 99999);
		        ps.setInt(3, 5);
		        ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
	}
}

