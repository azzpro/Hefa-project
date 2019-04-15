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

import com.azz.client.pojo.bo.AddRoleParam;
import com.azz.client.pojo.bo.DelRoleParam;
import com.azz.client.pojo.bo.EditRoleParam;
import com.azz.client.pojo.bo.SearchRoleParam;
import com.azz.client.pojo.bo.SetRolePermissionParam;
import com.azz.client.pojo.vo.Permission;
import com.azz.client.pojo.vo.RoleInfo;
import com.azz.client.user.api.PermissionService;
import com.azz.controller.utils.WebUtils;
import com.azz.core.common.JsonResult;

/**
 * 
 * <P>
 * 登录控制器
 * </P>
 * 
 * @version 1.0
 * @author 黄智聪 2018年10月17日 下午1:42:55
 */
@RestController
@RequestMapping("/azz/api/client/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    
    @RequestMapping("/getPermissionList")
    public JsonResult<List<Permission>> getPermissionList(String roleCode) {
	return permissionService.getPermissionList(WebUtils.getLoginClientUser().getClientUserInfo().getCompanyCode(), roleCode);
    }
    
    @RequestMapping("/addRole")
    public JsonResult<String> addRole(AddRoleParam param) {
	param.setCompanyCode(WebUtils.getLoginClientUser().getClientUserInfo().getCompanyCode());
	param.setCreator(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	return permissionService.addRole(param);
    }
    
    @RequestMapping("/editRole")
    public JsonResult<String> editRole(EditRoleParam param) {
	param.setCompanyCode(WebUtils.getLoginClientUser().getClientUserInfo().getCompanyCode());
	param.setModifier(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	return permissionService.editRole(param);
    }
    
    @RequestMapping("/delRole")
    public JsonResult<String> delRole(DelRoleParam param) {
	param.setModifier(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	return permissionService.delRole(param);
    }
    
    @RequestMapping("/getRoleList")
    public JsonResult<List<RoleInfo>> getRoleList(SearchRoleParam param) {
	param.setCompanyCode(WebUtils.getLoginClientUser().getClientUserInfo().getCompanyCode());
	return permissionService.getRoleList(param);
    }
    
    @RequestMapping("/getRolePermissions")
    public JsonResult<List<String>> getRolePermissions(String roleCode) {
	return permissionService.getRolePermissions(WebUtils.getLoginClientUser().getClientUserInfo().getCompanyCode(), roleCode);
    }
    
    @RequestMapping("/setRolePermissions")
    public JsonResult<String> setRolePermissions(SetRolePermissionParam param) {
	param.setCreator(WebUtils.getLoginClientUser().getClientUserInfo().getClientUserCode());
	return permissionService.setRolePermissions(param);
    }

}
