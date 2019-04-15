/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月24日 下午1:35:52
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;
import com.azz.core.common.page.Pagination;
import com.azz.wx.course.api.OrderService;
import com.azz.wx.course.pojo.bo.ChangeOrderStatusParam;
import com.azz.wx.course.pojo.bo.EvaluateCourseParam;
import com.azz.wx.course.pojo.bo.PayOrderParam;
import com.azz.wx.course.pojo.bo.SearchCourseOrderParam;
import com.azz.wx.course.pojo.bo.SearchPersonalOrderParam;
import com.azz.wx.course.pojo.vo.CourseOrderDetail;
import com.azz.wx.course.pojo.vo.CourseOrderInfo;
import com.azz.wx.course.pojo.vo.PayOrderInfo;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年1月24日 下午1:35:52
 */
@RestController
@RequestMapping("/azz/api/client/course/order")
public class CourseOrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 
	 * <p>生成去付款的课程订单信息</p>
	 * @return
	 * @author 黄智聪  2018年11月24日 上午10:58:45
	 */
	@RequestMapping(value = "/generatePayOrderInfo", method = RequestMethod.POST)
	public JsonResult<PayOrderInfo> generatePayOrderInfo(PayOrderParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return orderService.generatePayOrderInfo(param);
	}
	
	/**
	 * 
	 * <p>查询待支付的课程订单信息</p>
	 * @return
	 * @author 黄智聪  2018年11月24日 上午10:58:45
	 */
	@RequestMapping(value = "/getPayOrderInfo", method = RequestMethod.POST)
	public JsonResult<PayOrderInfo> getPayOrderInfo(@RequestParam("orderCode")String orderCode){
		return orderService.getPayOrderInfo(orderCode);
	}
	
	/**
	 * 
	 * <p>查询个人课程订单列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年1月22日 下午6:15:33
	 */
	@RequestMapping(value = "/getCourseOrders", method = RequestMethod.POST)
	public JsonResult<Pagination<CourseOrderInfo>> getCourseOrders(SearchCourseOrderParam param){
		param.setUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return orderService.getCourseOrders(param);
	}
	
	/**
	 * 
	 * <p>查询个人报名课程信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年1月22日 下午6:15:33
	 */
	@RequestMapping(value = "/getPersonalCourseOrders", method = RequestMethod.POST)
	public JsonResult<Pagination<CourseOrderInfo>> getPersonalCourseOrders(SearchPersonalOrderParam param){
		param.setUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return orderService.getPersonalCourseOrders(param);
	}
	
	/**
	 * 
	 * <p>查询课程订单详情</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年1月22日 下午6:34:28
	 */
	@RequestMapping(value = "/getCourseOrderDetail", method = RequestMethod.POST)
	public JsonResult<CourseOrderDetail> getCourseOrderDetail(@RequestParam("orderCode")String orderCode){
		return orderService.getCourseOrderDetail(orderCode);
	}
	
	/**
	 * 
	 * <p>评价课程</p>
	 * @return
	 * @author 黄智聪  2019年1月23日 上午10:48:25
	 */
	@RequestMapping(value = "/evaluateCourse", method = RequestMethod.POST)
	public JsonResult<String> evaluateCourse(EvaluateCourseParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return orderService.evaluateCourse(param);
	}
	
	/**
	 * 
	 * <p>取消课程订单</p>
	 * @return
	 * @author 黄智聪  2019年1月23日 上午10:48:25
	 */
	@RequestMapping(value = "/cancelCourseOrder", method = RequestMethod.POST)
	public JsonResult<String> cancelCourseOrder(ChangeOrderStatusParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return orderService.cancelCourseOrder(param);
	}
	
	/**
	 * 
	 * <p>确认课程订单</p>
	 * @return
	 * @author 黄智聪  2019年1月23日 上午10:48:25
	 */
	@RequestMapping(value = "/confirmCourseOrder", method = RequestMethod.POST)
	public JsonResult<String> confirmCourseOrder(ChangeOrderStatusParam param){
		param.setClientUserCode(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
		return orderService.confirmCourseOrder(param);
	}

}

