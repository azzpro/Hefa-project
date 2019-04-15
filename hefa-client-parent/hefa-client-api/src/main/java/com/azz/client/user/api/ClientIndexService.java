/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午5:18:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.user.api;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.azz.client.pojo.bo.AddSignUpCourseParam;
import com.azz.client.pojo.bo.SearchSpecialPerformanceOfIndexParam;
import com.azz.client.pojo.vo.ArticleDetail;
import com.azz.client.pojo.vo.HomeNav;
import com.azz.client.pojo.vo.HomeNavDetail;
import com.azz.client.pojo.vo.HomeSlide;
import com.azz.client.pojo.vo.SpecialPerformanceOfIndex;
import com.azz.core.common.JsonResult;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年12月1日 下午10:06:12
 */
@FeignClient("azz-client-service")
public interface ClientIndexService {

    /**
     * <p>获取所有轮播图片</p>
     * @return
     * @author 彭斌  2018年12月1日 下午10:06:09
     */
    @RequestMapping("/azz/api/index/searchHomeSlide")
    JsonResult<List<HomeSlide>> searchHomeSlide();
    
    /**
     * <p>查询首页导航栏目1</p>
     * @return
     * @author 彭斌  2018年12月1日 下午10:08:10
     */
    @RequestMapping("/azz/api/index/searchNavOne")
    JsonResult<List<HomeNav>> searchNavOne();
    
    /**
     * <p>查询首页导航栏目2</p>
     * @return
     * @author 彭斌  2018年12月1日 下午10:08:13
     */
    @RequestMapping("/azz/api/index/searchNavTwo")
    JsonResult<List<HomeNav>> searchNavTwo();
    
    /**
     * <p>根据栏目编码获取栏目列表</p>
     * @param columnCode
     * @return
     * @author 彭斌  2018年12月1日 下午10:09:19
     */
    @RequestMapping("/azz/api/index/searchNavList")
    JsonResult<HomeNavDetail> searchNavList(@RequestParam("columnCode") String columnCode);
    
    /**
     * <p>获取文章详情</p>
     * @param articleId
     * @return
     * @author 彭斌  2018年12月1日 下午10:10:39
     */
    @RequestMapping("/azz/api/index/searchNavDetail")
    JsonResult<ArticleDetail> searchNavDetail(@RequestParam("articleId") Long articleId);
    
    /**
     * <p>提交报名信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年12月6日 下午12:34:15
     */
    @RequestMapping("/azz/api/index/addSignUpCourse")
    JsonResult<String> addSignUpCourse(@RequestBody AddSignUpCourseParam param);
    
    /**
     * 
     * <p>查询首页专场详情</p>
     * @param param
     * @return
     * @author 黄智聪  2019年1月9日 下午7:04:08
     */
    @RequestMapping("/azz/api/index/getSpecialPerformanceOfIndex")
    JsonResult<SpecialPerformanceOfIndex> getSpecialPerformanceOfIndex(@RequestBody SearchSpecialPerformanceOfIndexParam param);
    
}

