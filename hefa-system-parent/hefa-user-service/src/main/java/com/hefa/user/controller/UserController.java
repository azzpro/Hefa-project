/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月27日 上午11:02:10
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.hefa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.common.page.Pagination;
import com.hefa.user.pojo.bo.AddDeptParam;
import com.hefa.user.pojo.bo.AddRoleParam;
import com.hefa.user.pojo.bo.AddUserParam;
import com.hefa.user.pojo.bo.CheckVerificationCodeParam;
import com.hefa.user.pojo.bo.DelRoleParam;
import com.hefa.user.pojo.bo.EditDeptParam;
import com.hefa.user.pojo.bo.EditPasswordParam;
import com.hefa.user.pojo.bo.EditPersonalInfoParam;
import com.hefa.user.pojo.bo.EditRoleParam;
import com.hefa.user.pojo.bo.EditUserParam;
import com.hefa.user.pojo.bo.EnableOrDisableOrDelUserParam;
import com.hefa.user.pojo.bo.LoginParam;
import com.hefa.user.pojo.bo.SearchDeptParam;
import com.hefa.user.pojo.bo.SearchRoleParam;
import com.hefa.user.pojo.bo.SearchUserParam;
import com.hefa.user.pojo.bo.SetRolePermissionParam;
import com.hefa.user.pojo.vo.Dept;
import com.hefa.user.pojo.vo.LoginUserInfo;
import com.hefa.user.pojo.vo.Permission;
import com.hefa.user.pojo.vo.RoleInfo;
import com.hefa.user.pojo.vo.TreePermission;
import com.hefa.user.pojo.vo.UserInfo;
import com.hefa.user.service.DeptService;
import com.hefa.user.service.PermissionService;
import com.hefa.user.service.UserService;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月27日 上午11:02:10
 */
@RestController
@RequestMapping("/hefa/api/user")
public class UserController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;
	
	/**
     * <p>新增部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:20
     */
    @RequestMapping(value="addDeptInfo",method=RequestMethod.POST)
    JsonResult<String> addDeptInfo(@RequestBody AddDeptParam param){
    	return deptService.addDeptInfo(param);
    }
    
    /**
     * <p>修改部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:24
     */
    @RequestMapping(value="editDeptInfo",method=RequestMethod.POST)
    JsonResult<String> editDeptInfo(@RequestBody EditDeptParam param){
    	return deptService.editDeptInfo(param);
    }
    
    /**
     * <p>获取部门信息列表</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:28
     */
    @RequestMapping(value="getDeptList",method=RequestMethod.POST)
    JsonResult<List<Dept>> getDeptList(@RequestBody SearchDeptParam param){
    	return deptService.getDeptList(param);
    }
    
    /**
     * <p>逻辑删除部门信息</p>
     * @param id
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:31
     */
    @RequestMapping(value="delDeptInfo",method=RequestMethod.GET)
    JsonResult<String> delDeptInfo(@RequestParam("deptCode") String deptCode, @RequestParam("modifier") String modifier){
    	return deptService.delDeptInfo(deptCode, modifier);
    }
    
    /**
     * <p>获取该父级下的部门信息</p>
     * @param id
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:34
     */
    @RequestMapping(value="getDeptInfo",method=RequestMethod.GET)
    JsonResult<List<Dept>> getDeptParentInfo(@RequestParam("deptCode") String deptCode){
    	return deptService.getDeptParentInfo(deptCode);
    }
    
    /**
     * <p>禁用部门</p>
     * @param deptCode
     * @param modifier
     * @return
     * @author 彭斌  2018年10月20日 下午4:48:26
     */
    @RequestMapping(value="disableDeptInfo",method=RequestMethod.GET)
    JsonResult<String> disableDeptInfo(@RequestParam("deptCode") String deptCode, @RequestParam("modifier") String modifier){
    	return deptService.disableDeptInfo(deptCode, modifier);
    }
    
    /**
     * <p>启用部门</p>
     * @param deptCode
     * @param modifier
     * @return
     * @author 彭斌  2018年10月20日 下午5:47:24
     */
    @RequestMapping(value="enableDeptInfo",method=RequestMethod.GET)
    JsonResult<String> enableDeptInfo(@RequestParam("deptCode") String deptCode, @RequestParam("modifier") String modifier){
    	return deptService.enableDeptInfo(deptCode, modifier);
    }
    
    /**
     * 
     * <p>查询所有权限,树状结构</p>
     * @return
     * @author 黄智聪  2018年10月19日 下午6:00:40
     */
    @RequestMapping(value="getTreePermissions",method=RequestMethod.GET)
    JsonResult<List<TreePermission>> getTreePermissions(){
    	return permissionService.getTreePermissions();
    }
    
    /**
     * 
     * <p>查询所有权限</p>
     * @return
     * @author 黄智聪  2018年10月19日 下午6:00:40
     */
    @RequestMapping(value="getPermissionList",method=RequestMethod.GET)
    JsonResult<List<Permission>> getPermissionList(@RequestParam("roleCode") String roleCode){
    	return permissionService.getPermissionList(roleCode);
    }
    
    /**
     * 
     * <p>新增角色</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:00:58
     */
    @RequestMapping(value="addRole",method=RequestMethod.POST)
    JsonResult<String> addRole(@RequestBody AddRoleParam param){
    	return permissionService.addRole(param);
    }
    
    /**
     * 
     * <p>修改角色</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:10
     */
    @RequestMapping(value="editRole",method=RequestMethod.POST)
    JsonResult<String> editRole(@RequestBody EditRoleParam param){
    	return permissionService.editRole(param);
    }
    
    /**
     * 
     * <p>删除角色</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:22
     */
    @RequestMapping(value="delRole",method=RequestMethod.POST)
    JsonResult<String> delRole(@RequestBody DelRoleParam param){
    	return permissionService.delRole(param);
    }
    
    /**
     * 
     * <p>查询角色列表</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:30
     */
    @RequestMapping(value="getRoleList",method=RequestMethod.POST)
    JsonResult<List<RoleInfo>> getRoleList(@RequestBody SearchRoleParam param){
    	return permissionService.getRoleList(param);
    }

    /**
     * 
     * <p>查询角色权限</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:30
     */
    @RequestMapping(value="getRolePermissions",method=RequestMethod.GET)
    JsonResult<List<String>> getRolePermissions(@RequestParam("roleCode") String roleCode){
    	return permissionService.getRolePermissions(roleCode);
    }
    
    /**
     * 
     * <p>设置角色权限</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月22日 下午4:30:56
     */
    @RequestMapping(value="setRolePermissions",method=RequestMethod.POST)
    JsonResult<String> setRolePermissions(@RequestBody SetRolePermissionParam param){
    	return permissionService.setRolePermissions(param);
    }
    
    /**
     * 
     * <p>
     * shiro的登录认证
     * </p>
     * 
     * @param param 登录参数
     * @return
     * @author 黄智聪 2018年10月17日 下午3:06:35
     */
    @RequestMapping(value="loginAuth",method=RequestMethod.POST)
    JsonResult<String> loginAuth(@RequestBody LoginParam param){
    	return userService.loginAuth(param);
    }
    
    /**
     * 
     * <p>TODO</p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年10月18日 下午1:51:00
     */
    @RequestMapping(value="getLoginUserInfoByPhoneNumber",method=RequestMethod.GET)
    JsonResult<LoginUserInfo> getLoginUserInfoByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){
    	return userService.getLoginUserInfoByPhoneNumber(phoneNumber);
    }
    
    /**
     * <p>修改用户密码</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月18日 下午2:30:58
     */
    @RequestMapping(value="editPassword",method=RequestMethod.POST)
    JsonResult<String> editPassword(@RequestBody EditPasswordParam param){
    	return userService.editPassword(param);
    }
    
    /**
     * 
     * <p>添加用户</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午5:39:40
     */
    @RequestMapping(value="addUser",method=RequestMethod.POST)
    JsonResult<String> addUser(@RequestBody AddUserParam param){
    	return userService.addUser(param);
    }
    
    /**
     * 
     * <p>修改用户</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:02:11
     */
    @RequestMapping(value="editUser",method=RequestMethod.POST)
    JsonResult<String> editUser(@RequestBody EditUserParam param){
    	return userService.editUser(param);
    }
    
    /**
     * 
     * <p>根据条件查询用户列表</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:23:34
     */
    @RequestMapping(value="getUserList",method=RequestMethod.POST)
    JsonResult<Pagination<UserInfo>> getUserList(@RequestBody SearchUserParam param){
    	return userService.getUserList(param);
    }
    
    /**
     * 
     * <p>启用、禁用或删除用户</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:31:52
     */
    @RequestMapping(value="enableOrDisableUser",method=RequestMethod.POST)
    JsonResult<String> enableOrDisableOrDelUser(@RequestBody EnableOrDisableOrDelUserParam param){
    	return userService.enableOrDisableOrDelUser(param);
    }
    
    /**
     * 
     * <p>查询用户详情</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:31:52
     */
    @RequestMapping(value="getUserInfo",method=RequestMethod.GET)
    JsonResult<UserInfo> getUserInfo(@RequestParam("userCode") String userCode){
    	return userService.getUserInfo(userCode);
    }
    
    /**
     * 
     * <p>修改个人资料</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:43:40
     */
    @RequestMapping(value="editPersonalInfo")
    JsonResult<String> editPersonalInfo(@RequestBody EditPersonalInfoParam param){
    	return userService.editPersonalInfo(param);
    }
    
    /**
     * 
     * <p>发送修改个人信息的邮箱验证码 </p>
     * @param email
     * @return
     * @author 黄智聪  2018年12月14日 上午11:37:14
     */
    @RequestMapping(value="sendEditEmailVerificationCode")
    public JsonResult<String> sendEditEmailVerificationCode(@RequestParam("email")String email){
    	return userService.sendEditEmailVerificationCode(email);
    }
    
    /**
     * 
     * <p>发送修改个人信息的验证码 </p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:42
     */
    @RequestMapping(value="sendEditVerificationCode")
    JsonResult<String> sendEditVerificationCode(@RequestParam("phoneNumber")String phoneNumber){
    	return userService.sendEditVerificationCode(phoneNumber);
    }
    
    /**
     * 
     * <p>校验验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @RequestMapping(value="checkEditVerificationCode")
    public JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param) {
    	return userService.checkEditVerificationCode(param);
    }
}

