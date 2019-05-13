package com.hefa.sequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.sequence.mapper.SequenceMapper;

/**
 * @author THINK
 * 序列
 */
@RestController
@RequestMapping("/hefa/api/sequence")
public class SequenceController {
	
	@Autowired
	private SequenceMapper sm;
	
	/**
	 * @return
	 * 部门编号
	 */
	@RequestMapping("getBMSequenceNo")
	public String getBMSequenceNo() {
		return sm.getSequenceNo("BM");
	}
	
	/**
	 * @return
	 * 开票编号
	 */
	@RequestMapping("getKPSequenceNo")
	public String getKPSequenceNo() {
		return sm.getSequenceNo("KP");
	}
	
	/**
	 * @return
	 * 退款编号
	 */
	@RequestMapping("getTKSequenceNo")
	public String getTKSequenceNo() {
		return sm.getSequenceNo("TK");
	}
	
	/**
	 * @return
	 * 订单编号
	 */
	@RequestMapping("getPOSequenceNo")
	public String getPOSequenceNo() {
		return sm.getSequenceNo("PO");
	}
	
	/**
	 * @return
	 * 支付编号
	 */
	@RequestMapping("getZFSequenceNo")
	public String getZFSequenceNo() {
		return sm.getSequenceNo("ZF");
	}
	
	/**
	 * @return
	 * 会员编号
	 */
	@RequestMapping("getHYSequenceNo")
	public String getHYSequenceNo() {
		return sm.getSequenceNo("HY");
	}
	
	/**
	 * @return
	 * 业务专员编号
	 */
	@RequestMapping("getYWSequenceNo")
	public String getYWSequenceNo() {
		return sm.getSequenceNo("YW");
	}
	
	/**
	 * @return
	 * 售后专员编号
	 */
	@RequestMapping("getSHSequenceNo")
	public String getSHSequenceNo() {
		return sm.getSequenceNo("SH");
	}
	
	/**
	 * @return
	 * 成员编号
	 */
	@RequestMapping("getCYSequenceNo")
	public String getCYSequenceNo() {
		return sm.getSequenceNo("CY");
	}
	
	/**
	 * @return
	 * 角色编号
	 */
	@RequestMapping("getJSSequenceNo")
	public String getJSSequenceNo() {
		return sm.getSequenceNo("JS");
	}
	
	/**
	 * @return
	 * 售后区域编号
	 */
	@RequestMapping("getQYSequenceNo")
	public String getQYSequenceNo() {
		return sm.getSequenceNo("QY");
	}
}
