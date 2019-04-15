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

import com.azz.client.pojo.bo.AddRoleParam;
import com.azz.client.pojo.bo.DelRoleParam;
import com.azz.client.pojo.bo.EditRoleParam;
import com.azz.client.pojo.bo.SearchRoleParam;
import com.azz.client.pojo.bo.SetRolePermissionParam;
import com.azz.client.pojo.vo.Permission;
import com.azz.client.pojo.vo.RoleInfo;
import com.azz.core.common.JsonResult;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 黄智聪  2018年10月22日 下午5:18:06
 */
@FeignClient("azz-client-service")
public interface PermissionService {

    @RequestMapping("/azz/api/client/permission/getPermissionList")
    public JsonResult<List<Permission>> getPermissionList(@RequestParam("companyCode") String companyCode, @RequestParam("roleCode") String roleCode);
    
    @RequestMapping("/azz/api/client/permission/addRole")
    public JsonResult<String> addRole(@RequestBody AddRoleParam param);
    
    @RequestMapping("/azz/api/client/permission/editRole")
    public JsonResult<String> editRole(@RequestBody EditRoleParam param);
    
    @RequestMapping("/azz/api/client/permission/delRole")
    public JsonResult<String> delRole(@RequestBody DelRoleParam param);
    
    @RequestMapping("/azz/api/client/permission/getRoleList")
    public JsonResult<List<RoleInfo>> getRoleList(@RequestBody SearchRoleParam param);
    
    @RequestMapping("/azz/api/client/permission/getRolePermissions")
    public JsonResult<List<String>> getRolePermissions(@RequestParam("companyCode") String companyCode, @RequestParam("roleCode") String roleCode);
    
    @RequestMapping("/azz/api/client/permission/setRolePermissions")
    public JsonResult<String> setRolePermissions(@RequestBody SetRolePermissionParam param);
}

