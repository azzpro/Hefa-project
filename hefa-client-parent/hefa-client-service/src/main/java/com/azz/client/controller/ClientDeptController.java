/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午5:18:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azz.client.pojo.bo.AddClientDeptParam;
import com.azz.client.pojo.bo.DelDeptParam;
import com.azz.client.pojo.bo.EditClientDeptParam;
import com.azz.client.pojo.bo.EditDeptIsEnableParam;
import com.azz.client.pojo.bo.ImportClientDeptParam;
import com.azz.client.pojo.bo.SearchClientChildDeptParam;
import com.azz.client.pojo.bo.SearchClientDeptInfoByCodeParam;
import com.azz.client.pojo.bo.SearchClientDeptParam;
import com.azz.client.pojo.vo.ClientDeptInfo;
import com.azz.client.pojo.vo.ClientDeptList;
import com.azz.client.service.ClientDeptService;
import com.azz.core.common.JsonResult;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月29日 上午11:36:03
 */
@RestController
@RequestMapping("/azz/api/client/dept")
public class ClientDeptController {

    @Autowired
    private ClientDeptService clientDeptService;
    
    /**
     * <p>添加父级部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 上午11:38:30
     */
    @RequestMapping("/addFirstLevelDept")
    public JsonResult<String> addFirstLevelDept(@RequestBody AddClientDeptParam param){
        return clientDeptService.addFirstLevelDept(param);
    }
    
    /**
     * <p>添加子级部门</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午1:38:03
     */
    @RequestMapping("/addChildDept")
    public JsonResult<String> addChildDept(@RequestBody AddClientDeptParam param){
        return clientDeptService.addChildDept(param);
    }
    
    /**
     * <p>查询父级部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午1:42:14
     */
    @RequestMapping("/searchClientDeptList")
    public JsonResult<List<ClientDeptList>> searchClientDeptList(@RequestBody SearchClientDeptParam param){
        return clientDeptService.searchClientDeptList(param);
    }
    
    /**
     * <p>查询子级部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午1:42:17
     */
    @RequestMapping("/searchChildClientDeptList")
    public JsonResult<List<ClientDeptList>> searchChildClientDeptList(@RequestBody SearchClientChildDeptParam param){
        return clientDeptService.searchChildClientDeptList(param);
    }
    
    /**
     * <p>编辑部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午1:45:35
     */
    @RequestMapping("/editDept")
    public JsonResult<String> editDept(@RequestBody EditClientDeptParam param){
        return clientDeptService.editDept(param);
    }
    
    /**
     * <p>启用禁用部门</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午1:45:38
     */
    @RequestMapping("/isEnableDept")
    public JsonResult<String> isEnableDept(@RequestBody EditDeptIsEnableParam param){
        return clientDeptService.isEnableDept(param);
    }
    
    /**
     * <p>删除部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午1:45:44
     */
    @RequestMapping("/delDept")
    public JsonResult<String> delDept(@RequestBody DelDeptParam param){
        return clientDeptService.delDept(param);
    }
    
    /**
     * <p>获取部门详情</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月29日 下午4:19:00
     */
    @RequestMapping("/getDeptInfo")
    public JsonResult<ClientDeptInfo> getDeptInfo(@RequestBody SearchClientDeptInfoByCodeParam param){
        return clientDeptService.getDeptInfo(param);
    }
    
    /**
     * <p>批量导入客户部门</p>
     * @param param
     * @return
     * @throws IOException
     * @author 彭斌  2018年12月12日 下午4:03:39
     */
    @RequestMapping("/importClientDept")
    public JsonResult<String> importClientDept(@RequestBody ImportClientDeptParam param) throws IOException{
        return clientDeptService.importClientDept(param);
    }
}

