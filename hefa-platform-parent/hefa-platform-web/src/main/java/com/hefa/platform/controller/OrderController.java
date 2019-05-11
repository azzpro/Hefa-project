/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年4月25日 上午11:22:25
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.platform.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.errorcode.SystemErrorCode;
import com.hefa.common.exception.ReturnDataException;
import com.hefa.common.exception.SystemException;
import com.hefa.common.page.Pagination;
import com.hefa.order.api.platform.OrderService;
import com.hefa.order.pojo.bo.ConfirmDeliveryParam;
import com.hefa.order.pojo.bo.SearchCommissionOrderInfoParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.CommissionOrderInfo;
import com.hefa.order.pojo.vo.ExportOrderInfo;
import com.hefa.order.pojo.vo.OrderDetail;
import com.hefa.order.pojo.vo.OrderInfo;
import com.hefa.platform.utils.WebUtils;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年4月25日 上午11:22:25
 */
@RestController
@RequestMapping("/hefa/api/platform/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	/**
	 * 
	 * <p>查询订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/getOrderInfos")
	public JsonResult<Pagination<OrderInfo>> getOrderInfos(SearchOrderInfoParam param){
		return orderService.getOrderInfos(param);
	}
	
	/**
	 * 
	 * <p>查询订单详情</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/getOrderDetail")
	public JsonResult<OrderDetail> getOrderDetail(@RequestParam("orderCode") String orderCode){
		return orderService.getOrderDetail(orderCode);
	}
	
	/**
	 * 
	 * <p>确认发货</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月22日 下午8:11:14
	 */
	@RequestMapping("/confirmDelivery")
	public JsonResult<String> confirmDelivery(ConfirmDeliveryParam param){
		param.setModifier(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return orderService.confirmDelivery(param);
	}
	
	/**
	 * 
	 * <p>查询分佣订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年4月24日 下午4:43:33
	 */
	@RequestMapping("/getCommissionOrderInfos")
	public JsonResult<Pagination<CommissionOrderInfo>> getCommissionOrderInfos(SearchCommissionOrderInfoParam param){
		return orderService.getCommissionOrderInfos(param);
	}
	
	/**
	 * 
	 * <p>导出分佣订单</p>
	 * @return
	 * @author 黄智聪  2019年4月24日 下午4:46:23
	 * @throws IOException 
	 */
	@RequestMapping("/exportCommissionOrder")
	public void exportCommissionOrder(SearchCommissionOrderInfoParam param, HttpServletResponse response) throws IOException{
		List<ExportOrderInfo> orderInfos = orderService.exportCommissionOrder(param);
		HSSFWorkbook wb = null;
		try {
			if(orderInfos.size() == 0) {
				throw new ReturnDataException("无导出数据");
			}
			// 建立新的sheet对象（excel的表单）
			wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("订单");
			String[] titles = {"订单编号","下单账户","订单金额","业务人员姓名","业务人员部门","下单时间"};
			// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
			HSSFRow row0 = sheet.createRow(0);
			for (int i = 0; i < titles.length; i++) {// 添加表头
				row0.createCell(i).setCellValue(titles[i]);
			}
			int i = 1;// 数据行
			for (ExportOrderInfo orderInfo : orderInfos) {
				HSSFRow dataRow = sheet.createRow(i);
				dataRow.createCell(0).setCellValue(orderInfo.getOrderCode());
				dataRow.createCell(1).setCellValue(orderInfo.getUsername());
				dataRow.createCell(2).setCellValue(orderInfo.getGrandTotal().doubleValue());
				dataRow.createCell(3).setCellValue(orderInfo.getSalesman());
				dataRow.createCell(4).setCellValue(orderInfo.getDeptName());
				dataRow.createCell(5).setCellValue(orderInfo.getOrderTime());
				i++;
			}
	        response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=order.xls");
			response.flushBuffer();
			wb.write(response.getOutputStream());
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(SystemErrorCode.SYS_ERROR_UNKNOWN);
		}
	}

}

