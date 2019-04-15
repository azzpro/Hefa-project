/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午3:05:46
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azz.client.pojo.bo.AddSignUpCourseParam;
import com.azz.client.pojo.bo.SearchSpecialPerformanceOfIndexParam;
import com.azz.client.pojo.vo.ArticleDetail;
import com.azz.client.pojo.vo.HomeNav;
import com.azz.client.pojo.vo.HomeNavDetail;
import com.azz.client.pojo.vo.HomeSlide;
import com.azz.client.pojo.vo.SpecialPerformanceOfIndex;
import com.azz.client.user.api.ClientIndexService;
import com.azz.core.common.JsonResult;

@RestController
@RequestMapping("/azz/api/index")
public class ClientIndexController {


    @Autowired
    ClientIndexService clientIndexService;

    /**
     * <p>获取所有轮播图片</p>
     * @return
     * @author 彭斌  2018年12月1日 下午10:17:44
     */
    @RequestMapping("/searchHomeSlide")
    public JsonResult<List<HomeSlide>> searchHomeSlide(){
        return clientIndexService.searchHomeSlide();
    }
    
    /**
     * <p>查询首页导航栏目1</p>
     * @return
     * @author 彭斌  2018年12月1日 下午10:17:36
     */
    @RequestMapping("/searchNavOne")
    public JsonResult<List<HomeNav>> searchNavOne(){
        return clientIndexService.searchNavOne();
    }
    
    /**
     * <p>查询首页导航栏目2</p>
     * @return
     * @author 彭斌  2018年12月1日 下午10:17:29
     */
    @RequestMapping("/searchNavTwo")
    public JsonResult<List<HomeNav>> searchNavTwo(){
        return clientIndexService.searchNavTwo();
    }
    
    /**
     * <p>根据栏目编码获取栏目列表</p>
     * @param columnCode
     * @return
     * @author 彭斌  2018年12月1日 下午10:17:23
     */
    @RequestMapping("/searchNavList")
    public JsonResult<HomeNavDetail> searchNavList(String columnCode) {
        return clientIndexService.searchNavList(columnCode);
    }

    /**
     * <p>获取文章详情</p>
     * @param articleId
     * @return
     * @author 彭斌  2018年12月1日 下午10:17:17
     */
    @RequestMapping("/searchNavDetail")
    public JsonResult<ArticleDetail> searchNavDetail(Long articleId) {
        return clientIndexService.searchNavDetail(articleId);
    }
    
    /**
     * <p>添加报名信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年12月6日 下午12:35:20
     */
    @RequestMapping("/addSignUpCourse")
    public JsonResult<String> addSignUpCourse(AddSignUpCourseParam param){
        return clientIndexService.addSignUpCourse(param);
    }
    
    /**
     * 
     * <p>查询首页专场详情</p>
     * @param param
     * @return
     * @author 黄智聪  2019年1月9日 下午7:04:08
     */
    @RequestMapping("/getSpecialPerformanceOfIndex")
    public JsonResult<SpecialPerformanceOfIndex> getSpecialPerformanceOfIndex(SearchSpecialPerformanceOfIndexParam param){
    	return clientIndexService.getSpecialPerformanceOfIndex(param);
    }
}
