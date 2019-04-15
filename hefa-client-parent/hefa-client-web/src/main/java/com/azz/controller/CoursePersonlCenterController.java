/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月24日 下午1:35:52
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azz.core.common.JsonResult;
import com.azz.wx.course.api.CoursePersonalCenterService;
import com.azz.wx.course.pojo.bo.AddCourseApplyParam;
import com.azz.wx.course.pojo.bo.AddCourseSuggestionsParam;
import com.azz.wx.course.pojo.bo.BindingPhomeParam;
import com.azz.wx.course.pojo.bo.EditCourseApplyParam;
import com.azz.wx.course.pojo.vo.CourseSignUpInfo;
import com.azz.wx.course.pojo.vo.PersonalCenterInfo;

/**
 * <P>个人中心</P>
 * @version 1.0
 * @author 彭斌  2019年1月24日 下午4:49:52
 */
@RestController
@RequestMapping("/azz/api/client/center")
public class CoursePersonlCenterController {
	
	@Autowired
	private CoursePersonalCenterService coursePersonalCenterService;
	
	/**
     * <p>课程个人中心首页</p>
     * @param openId
     * @return
     * @author 彭斌  2019年1月24日 下午2:28:06
     */
	@RequestMapping(value = "/getIndexCenter", method = RequestMethod.POST)
	public JsonResult<PersonalCenterInfo> getPersonlCenter(@RequestParam("openId") String openId){
		return coursePersonalCenterService.getPersonlCenter(openId);
	}
	
	/**
     * <p>绑定手机号码</p>
     * @param param
     * @return
     * @author 彭斌  2019年1月24日 下午2:28:10
     */
	@RequestMapping(value = "/bindingPhone", method = RequestMethod.POST)
	public JsonResult<String> bindingPhone(BindingPhomeParam param){
	    return coursePersonalCenterService.bindingPhone(param);
	}

	/**
     * <p>解绑手机号码</p>
     * @param param
     * @return
     * @author 彭斌  2019年1月24日 下午2:29:43
     */
	@RequestMapping(value = "/untiedPhone", method = RequestMethod.POST)
	public JsonResult<String> untiedPhone(BindingPhomeParam param){
	    return coursePersonalCenterService.untiedPhone(param);
	}
	
	/**
     * <p>获取课程报名信息</p>
     * @param userCode
     * @return
     * @author 彭斌  2019年1月24日 下午2:31:41
     */
	@RequestMapping(value = "/getCourseSignUp", method = RequestMethod.POST)
	public JsonResult<List<CourseSignUpInfo>> getCourseSignUp(@RequestParam("userCode") String userCode){
	    return coursePersonalCenterService.getCourseSignUp(userCode);
	}
	
	/**
     * <p>新增课程报名信息</p>
     * @param param
     * @return
     * @author 彭斌  2019年1月24日 下午2:32:25
     */
	@RequestMapping(value = "/addCourseApply", method = RequestMethod.POST)
	public JsonResult<String> addCourseApply(AddCourseApplyParam param){
	    return coursePersonalCenterService.addCourseApply(param);
	}
	
	/**
     * <p>编辑申请课程信息</p>
     * @param param
     * @return
     * @author 彭斌  2019年1月24日 下午2:33:25
     */
	@RequestMapping(value = "/editCourseApply", method = RequestMethod.POST)
	public JsonResult<String> editCourseApply(EditCourseApplyParam param){
	    return coursePersonalCenterService.editCourseApply(param);
	}
	
	/**
     * <p>删除申请信息</p>
     * @param applyCode
     * @return
     * @author 彭斌  2019年1月24日 下午2:34:27
     */
	@RequestMapping(value = "/deletCourseApply", method = RequestMethod.POST)
	public JsonResult<String> deletCourseApply(@RequestParam("applyCode") String applyCode){
	    return coursePersonalCenterService.deletCourseApply(applyCode);
	}
	
	/**
     * <p>设置默认</p>
     * @param applyCode
     * @return
     * @author 彭斌  2019年1月24日 下午2:35:11
     */
	@RequestMapping(value = "/setDefault", method = RequestMethod.POST)
	public JsonResult<String> setDefault(@RequestParam("applyCode") String applyCode){
	    return coursePersonalCenterService.setDefault(applyCode);
	}
	
	/**
     * <p>获取课程申请详情</p>
     * @param applyCode
     * @return
     * @author 彭斌  2019年1月24日 下午2:36:02
     */
	@RequestMapping(value = "/getCourseSignUpInfo", method = RequestMethod.POST)
	public JsonResult<CourseSignUpInfo> getCourseSignUpInfo(@RequestParam("applyCode") String applyCode){
	    return coursePersonalCenterService.getCourseSignUpInfo(applyCode);
	}
	
	/**
     * <p>新增投诉建议</p>
     * @param param
     * @return
     * @author 彭斌  2019年1月24日 下午3:47:53
     */
	@RequestMapping(value = "/addSuggestions", method = RequestMethod.POST)
	public JsonResult<String> addSuggestions(AddCourseSuggestionsParam param){
	    return coursePersonalCenterService.addSuggestions(param);
	}
	
}

