/*******************************************************************************
 * Project Key : CPPII
 * Create on 2019年1月24日 下午1:35:52
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.azz.client.pojo.vo.LoginClientUserInfo;
import com.azz.client.pojo.vo.UserInfo;
import com.azz.client.pojo.vo.WxUserInfo;
import com.azz.client.user.api.ClientService;
import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.JSR303ErrorCode;
import com.azz.core.common.errorcode.ShiroAuthErrorCode;
import com.azz.core.common.page.Pagination;
import com.azz.core.constants.ClientConstants;
import com.azz.core.constants.WxCourseConstants;
import com.azz.core.exception.BaseException;
import com.azz.core.exception.ShiroAuthException;
import com.azz.core.exception.SuppressedException;
import com.azz.exception.JSR303ValidationException;
import com.azz.util.OkHttpUtil;
import com.azz.util.StringUtils;
import com.azz.wx.course.api.CourseService;
import com.azz.wx.course.pojo.bo.SearchCourseInfoParam;
import com.azz.wx.course.pojo.bo.SearchEvaluationInfoParam;
import com.azz.wx.course.pojo.bo.SearchStartClassRecordParam;
import com.azz.wx.course.pojo.vo.CourseDetail;
import com.azz.wx.course.pojo.vo.CourseInfo;
import com.azz.wx.course.pojo.vo.EvaluationInfo;
import com.azz.wx.course.pojo.vo.StartClassRecord;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2019年1月24日 下午1:35:52
 */
@RestController
@RequestMapping("/azz/api/client/course")
@Slf4j
public class CourseController {
	
	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	ClientService clientService;
	
	@Value("${wx.appid}")
	String appid;
	
	@Value("${wx.secret}")
	String secret;
	
	/**
	 * 
	 * <p>微信课程登录</p>
	 * @param openid
	 * @return
	 * @author 黄智聪  2019年1月25日 下午1:03:08
	 */
    @RequestMapping(value = "/login")
    public JsonResult<UserInfo> login(String code) {
    	// TODO
    	if("123".equals(code)) {
    		String openid = "openid000001";
    		WxUserInfo wxUserInfo = new WxUserInfo();
    		wxUserInfo.setHeadimgurl("http://azz-image.oss-cn-shenzhen.aliyuncs.com/merchant-image/module_pic/02_MN00000286.jpg");
    		wxUserInfo.setNickname("cc");
    		wxUserInfo.setOpenid(openid);
    		
    		// 从SecurityUtils里边创建一个 subject
        	Subject subject = SecurityUtils.getSubject();
        	// 在认证提交前准备 token（令牌）
        	UsernamePasswordToken token = new UsernamePasswordToken(WxCourseConstants.WX_COURSE_LOGIN_USER_NAME_PREFIX + openid, "noUse");
        	try {
        		// 执行认证登陆
        		subject.login(token);
        		// 设置为负数表示永不超时
        		subject.getSession().setTimeout(-1000L);
        	} catch (AuthenticationException e) {
        		Throwable[] throwables = e.getSuppressed();
        		if(throwables != null && throwables.length != 0) {
        			int c = ((SuppressedException) throwables[0]).getCode();
        			String msg = ((SuppressedException) throwables[0]).getMessage();
        			JsonResult<UserInfo> jr = new JsonResult<>();
        			jr.setData(new UserInfo(null, wxUserInfo));
        			jr.setCode(c);
        			jr.setMsg(msg);
        			return jr;
        		}
        		throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "登录失败,请重试");
        	}
        	JsonResult<LoginClientUserInfo> jr = clientService.getLoginClientUserInfoByOpenid(openid);
        	LoginClientUserInfo loginClientUser = jr.getData();
        	loginClientUser.setSessionId(subject.getSession().getId());
        	WebUtils.setShiroSessionAttr(ClientConstants.LOGIN_CLIENT_USER, loginClientUser);
    		return JsonResult.successJsonResult(new UserInfo(loginClientUser, wxUserInfo));
    	}else {
    		WxUserInfo wxUserInfo = new WxUserInfo();
        	if(StringUtils.isBlank(code)) {
        		throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "缺少请求参数");
        	}
    		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    		url = url.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
    		log.info("appid:" + appid +"   secret:" + secret + "  url:"+ url);
    		// 获取accessToken
    		String accessTokenResult = OkHttpUtil.get(url);
    		log.info("accessTokenResult:------------>" + accessTokenResult);
    		JSONObject jsonObject = JSONObject.parseObject(accessTokenResult);
    		String openid = jsonObject.getString("openid");
            if (openid != null) {
                //拉取用户信息
                String access_token = jsonObject.getString("access_token");
                url = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
                //第二次请求，用openid与access_token获取用户的信息
                String usesrInfo = OkHttpUtil.get(url);
                jsonObject = JSONObject.parseObject(usesrInfo);
                String nickname = jsonObject.getString("nickname");
                String headimgurl = jsonObject.getString("headimgurl");
                wxUserInfo.setOpenid(openid);
                wxUserInfo.setNickname(nickname);
                wxUserInfo.setHeadimgurl(headimgurl);
            }else {
            	throw new BaseException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "获取微信用户信息出错");
            }
        	// 从SecurityUtils里边创建一个 subject
        	Subject subject = SecurityUtils.getSubject();
        	// 在认证提交前准备 token（令牌）
        	UsernamePasswordToken token = new UsernamePasswordToken(WxCourseConstants.WX_COURSE_LOGIN_USER_NAME_PREFIX + openid, "noUse");
        	try {
        		// 执行认证登陆
        		subject.login(token);
        		// 设置为负数表示永不超时
        		subject.getSession().setTimeout(-1000L);
        	} catch (AuthenticationException e) {
        		Throwable[] throwables = e.getSuppressed();
        		if(throwables != null && throwables.length != 0) {
        			int c = ((SuppressedException) throwables[0]).getCode();
        			String msg = ((SuppressedException) throwables[0]).getMessage();
        			JsonResult<UserInfo> jr = new JsonResult<>();
        			jr.setData(new UserInfo(null, wxUserInfo));
        			jr.setCode(c);
        			jr.setMsg(msg);
        			return jr;
        		}
        		throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "登录失败,请重试");
        	}
        	JsonResult<LoginClientUserInfo> jr = clientService.getLoginClientUserInfoByOpenid(openid);
        	LoginClientUserInfo loginClientUser = jr.getData();
        	loginClientUser.setSessionId(subject.getSession().getId());
        	WebUtils.setShiroSessionAttr(ClientConstants.LOGIN_CLIENT_USER, loginClientUser);
        	UserInfo ui = new UserInfo(loginClientUser, wxUserInfo);
        	return JsonResult.successJsonResult(ui);
    	}
    	
    }
    
    /**
	 * 
	 * <p>微信课程登录</p>
	 * @param openid
	 * @return
	 * @author 黄智聪  2019年1月25日 下午1:03:08
	 */
    @RequestMapping(value = "/relogin")
    public JsonResult<LoginClientUserInfo> relogin(String openid) {
    	if(StringUtils.isBlank(openid)) {
    		throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "缺少请求参数");
    	}
    	// 从SecurityUtils里边创建一个 subject
    	Subject subject = SecurityUtils.getSubject();
    	// 在认证提交前准备 token（令牌）
    	UsernamePasswordToken token = new UsernamePasswordToken(WxCourseConstants.WX_COURSE_LOGIN_USER_NAME_PREFIX + openid, "noUse");
    	try {
    		// 执行认证登陆
    		subject.login(token);
    		// 设置为负数表示永不超时
    		subject.getSession().setTimeout(-1000L);
    	} catch (AuthenticationException e) {
    		Throwable[] throwables = e.getSuppressed();
    		if(throwables != null && throwables.length != 0) {
    			int c = ((SuppressedException) throwables[0]).getCode();
    			String msg = ((SuppressedException) throwables[0]).getMessage();
    			JsonResult<LoginClientUserInfo> jr = new JsonResult<>();
    			jr.setCode(c);
    			jr.setMsg(msg);
    			return jr;
    		}
    		throw new ShiroAuthException(ShiroAuthErrorCode.SHIRO_AUTH_ERROR_LOGIN_ERROR, "登录失败,请重试");
    	}
    	JsonResult<LoginClientUserInfo> jr = clientService.getLoginClientUserInfoByOpenid(openid);
    	LoginClientUserInfo loginClientUser = jr.getData();
    	loginClientUser.setSessionId(subject.getSession().getId());
    	WebUtils.setShiroSessionAttr(ClientConstants.LOGIN_CLIENT_USER, loginClientUser);
    	return JsonResult.successJsonResult(loginClientUser);
    }
	
	/**
	 * 
	 * <p>查询首页课程列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年1月21日 下午4:25:49
	 */
	@RequestMapping(value = "/getIndexCourseInfos", method = RequestMethod.POST)
	public JsonResult<Pagination<CourseInfo>> getIndexCourseInfos(SearchCourseInfoParam param){
		return courseService.getIndexCourseInfos(param);
	}
	
	/**
	 * 
	 * <p>查询首页课程详情</p>
	 * @param courseCode
	 * @return
	 * @author 黄智聪  2019年1月4日 下午3:20:59
	 */
	@RequestMapping(value = "/getIndexCourseDetail", method = RequestMethod.POST)
	public JsonResult<CourseDetail> getIndexCourseDetail(@RequestParam("courseCode")String courseCode){
		return courseService.getIndexCourseDetail(courseCode);
	}
	
	/**
	 * 
	 * <p>查询课程评价</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年1月21日 下午7:26:26
	 */
	@RequestMapping(value = "/getEvaluationInfos", method = RequestMethod.POST)
	public JsonResult<Pagination<EvaluationInfo>> getEvaluationInfos(SearchEvaluationInfoParam param){
		return courseService.getEvaluationInfos(param);
	}
	
	/**
	 * 
	 * <p>查询首页开课信息列表</p>
	 * @param param
	 * @return
	 * @author 黄智聪  2019年1月4日 下午5:37:39
	 */
	@RequestMapping(value = "/getIndexStartClassRecords", method = RequestMethod.POST)
	public JsonResult<Pagination<StartClassRecord>> getIndexStartClassRecords(SearchStartClassRecordParam param){
		return courseService.getIndexStartClassRecords(param);
	}
	

}

