/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月22日 下午5:18:06
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.user.api;
import java.io.IOException;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
import com.azz.core.common.JsonResult;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月22日 下午5:18:06
 */
@FeignClient("azz-client-service")
public interface ClientDeptService {

    @RequestMapping("/azz/api/client/dept/searchClientDeptList")
    public JsonResult<List<ClientDeptList>> searchClientDeptList(@RequestBody SearchClientDeptParam param);
    
    @RequestMapping("/azz/api/client/dept/searchChildClientDeptList")
    public JsonResult<List<ClientDeptList>> searchChildClientDeptList(@RequestBody SearchClientChildDeptParam param);
    
    @RequestMapping("/azz/api/client/dept/editDept")
    public JsonResult<String> editDept(@RequestBody EditClientDeptParam param);
    
    @RequestMapping("/azz/api/client/dept/isEnableDept")
    public JsonResult<String> isEnableDept(@RequestBody EditDeptIsEnableParam param);
    
    @RequestMapping("/azz/api/client/dept/delDept")
    public JsonResult<String> delDept(@RequestBody DelDeptParam param);
    
    @RequestMapping("/azz/api/client/dept/addFirstLevelDept")
    public JsonResult<String> addFirstLevelDept(@RequestBody AddClientDeptParam param);
    
    @RequestMapping("/azz/api/client/dept/addChildDept")
    public JsonResult<String> addChildDept(@RequestBody AddClientDeptParam param);
    
    @RequestMapping("/azz/api/client/dept/getDeptInfo")
    public JsonResult<ClientDeptInfo> getDeptInfo(@RequestBody SearchClientDeptInfoByCodeParam param);

    @RequestMapping("/azz/api/client/dept/importClientDept")
    public JsonResult<String> importClientDept(@RequestBody ImportClientDeptParam param) throws IOException;
}

