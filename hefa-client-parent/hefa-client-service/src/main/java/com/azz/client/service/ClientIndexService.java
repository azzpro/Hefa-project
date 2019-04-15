/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月24日 下午1:24:28
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.azz.client.mapper.IndexMapper;
import com.azz.client.mapper.PlatformClientSignUpMapper;
import com.azz.client.mapper.PlatformIndexArticleMapper;
import com.azz.client.mapper.PlatformIndexColumnMapper;
import com.azz.client.pojo.PlatformClientSignUp;
import com.azz.client.pojo.PlatformSpecialPerformance;
import com.azz.client.pojo.bo.AddSignUpCourseParam;
import com.azz.client.pojo.bo.SearchCountClientSignUpParam;
import com.azz.client.pojo.bo.SearchSpecialPerformanceOfIndexParam;
import com.azz.client.pojo.vo.ArticleDetail;
import com.azz.client.pojo.vo.HomeNav;
import com.azz.client.pojo.vo.HomeNavDetail;
import com.azz.client.pojo.vo.HomeSlide;
import com.azz.client.pojo.vo.ModuleInfo;
import com.azz.client.pojo.vo.SpecialInfo;
import com.azz.client.pojo.vo.SpecialPerformanceOfIndex;
import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.JSR303ErrorCode;
import com.azz.core.common.page.Pagination;
import com.azz.core.constants.ClientConstants;
import com.azz.exception.JSR303ValidationException;
import com.azz.util.JSR303ValidateUtils;
import com.azz.util.ObjectUtils;
import com.github.pagehelper.PageHelper;

@Transactional(rollbackFor = Exception.class)
@Service
public class ClientIndexService {

    
    @Autowired
    private PlatformIndexArticleMapper platformIndexArticleMapper;
    
    @Autowired
    private PlatformIndexColumnMapper platformIndexColumnMapper;

    @Autowired
    private PlatformClientSignUpMapper platformClientSignUpMapper;
    
    @Autowired
    private IndexMapper indexMapper;
    
    
    /**
     * <p>查询首页轮播图片</p>
     * @return
     * @author 彭斌  2018年12月1日 下午5:28:31
     */
    public JsonResult<List<HomeSlide>> searchHomeSlide(){
        List<HomeSlide> list = platformIndexColumnMapper.getHomeSlideList(ClientConstants.HOME_SLIDE);
        return JsonResult.successJsonResult(list);
    }
    
    /**
     * <p>查询首页导航1栏</p>
     * @return
     * @author 彭斌  2018年12月1日 下午6:00:27
     */
    public JsonResult<List<HomeNav>> searchNavOne(){
        List<HomeNav> list = platformIndexColumnMapper.getNavListByColumnCode(ClientConstants.HOME_NAV1);
        return JsonResult.successJsonResult(list);
    }
    
    /**
     * <p>查询首页导航2栏</p>
     * @return
     * @author 彭斌  2018年12月1日 下午6:00:27
     */
    public JsonResult<List<HomeNav>> searchNavTwo(){
        List<HomeNav> list = platformIndexColumnMapper.getNavListByColumnCode(ClientConstants.HOME_NAV2);
        return JsonResult.successJsonResult(list);
    }
    
    /**
     * <p>根据栏目编码获取栏目列表</p>
     * @param columnCode
     * @return
     * @author 彭斌  2018年12月1日 下午9:40:21
     */
    public JsonResult<HomeNavDetail> searchNavList(String columnCode){
        HomeNavDetail hd = platformIndexColumnMapper.getColumnList(columnCode);
        return JsonResult.successJsonResult(hd);
    }
    
    /**
     * <p>获取文章详情</p>
     * @param articleId
     * @return
     * @author 彭斌  2018年12月1日 下午10:02:29
     */
    public JsonResult<ArticleDetail> searchNavDetail(Long articleId){
        ArticleDetail adObj = platformIndexArticleMapper.getArticleDetail(articleId);
        return JsonResult.successJsonResult(adObj);
    }
    
    /**
     * <p>添加课程报名</p>
     * @param param
     * @return
     * @author 彭斌  2018年12月6日 上午11:56:45
     */
    public JsonResult<String> addSignUpCourse(@RequestBody AddSignUpCourseParam param){
        JSR303ValidateUtils.validate(param);
        SearchCountClientSignUpParam validateObj = new SearchCountClientSignUpParam();
        validateObj.setArticleId(param.getArticleId());
        validateObj.setName(param.getName());
        int size = platformClientSignUpMapper.countClientSignUp(validateObj);
        if(size > 0) {
            throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "您已提交过了课程报名信息");
        }
        
        PlatformClientSignUp record = new PlatformClientSignUp();
        record.setArticleId(param.getArticleId());
        record.setCompany(param.getCompany());
        record.setCreateTime(new Date());
        record.setEmail(param.getEmail());
        record.setCreator(param.getName());
        record.setGender(param.getGender());
        record.setMobilePhone(param.getMobilePhone());
        record.setName(param.getName());
        record.setPost(param.getPost());
        record.setQq(param.getQq());
        platformClientSignUpMapper.insertSelective(record);
        return JsonResult.successJsonResult();
    }
    
    /**
     * 
     * <p>查询首页专场详情</p>
     * @param param
     * @return
     * @author 黄智聪  2019年1月9日 下午6:31:57
     */
    public JsonResult<SpecialPerformanceOfIndex> getSpecialPerformanceOfIndex(@RequestBody SearchSpecialPerformanceOfIndexParam param){
    	JSR303ValidateUtils.validate(param);
    	SpecialPerformanceOfIndex sp = indexMapper.getSpecialPerformanceOfIndex(param.getSpecialPerformanceCode());
    	if(ObjectUtils.isNull(sp)) {
            throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "该专场不存在");
        }
    	PageHelper.startPage(param.getPageNum(), param.getPageSize());
    	List<ModuleInfo> moduleInfos = indexMapper.getSpecialPerformanceModulesOfIndex(param);
    	sp.setModuleInfos(new Pagination<>(moduleInfos));
    	
    	// 递增访问数量
    	SpecialInfo si = indexMapper.getSpecialInfo(param.getSpecialPerformanceCode());
    	PlatformSpecialPerformance record = new PlatformSpecialPerformance();
        record.setId(si.getId());
        record.setInterviewNumber(si.getInterviewNumber()+1);
        indexMapper.updateByPrimaryKey(record);
    	    
    	return JsonResult.successJsonResult(sp);
    }
}

