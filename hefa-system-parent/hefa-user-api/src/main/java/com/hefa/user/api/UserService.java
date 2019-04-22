/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午2:52:17
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.user.api;

import java.util.List;

import javax.management.relation.RoleInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.hefa.user.pojo.vo.TreePermission;
import com.hefa.user.pojo.vo.UserInfo;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 刘建麟 2018年10月15日 下午2:52:17
 */
@FeignClient("hefa-user-service")
public interface UserService {
    
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
    @PostMapping("/hefa/api/user/loginAuth")
    JsonResult<String> loginAuth(@RequestBody LoginParam param);
    
    /**
     * 
     * <p>TODO</p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年10月18日 下午1:51:00
     */
    @GetMapping("/hefa/api/user/getLoginUserInfoByPhoneNumber")
    JsonResult<LoginUserInfo> getLoginUserInfoByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber);
    
    /**
     * <p>修改用户密码</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月18日 下午2:30:58
     */
    @PostMapping("/hefa/api/user/editPassword")
    JsonResult<String> editPassword(@RequestBody EditPasswordParam param);
    
    /**
     * 
     * <p>添加用户</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午5:39:40
     */
    @PostMapping("/hefa/api/user/addUser")
    JsonResult<String> addUser(@RequestBody AddUserParam param);
    
    /**
     * 
     * <p>修改用户</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:02:11
     */
    @PostMapping("/hefa/api/user/editUser")
    JsonResult<String> editUser(@RequestBody EditUserParam param);
    
    /**
     * 
     * <p>根据条件查询用户列表</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:23:34
     */
    @PostMapping("/hefa/api/user/getUserList")
    JsonResult<Pagination<UserInfo>> getUserList(@RequestBody SearchUserParam param);
    
    /**
     * 
     * <p>启用、禁用或删除用户</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:31:52
     */
    @PostMapping("/hefa/api/user/enableOrDisableUser")
    JsonResult<String> enableOrDisableOrDelUser(@RequestBody EnableOrDisableOrDelUserParam param);
    
    /**
     * 
     * <p>查询用户详情</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月20日 上午10:31:52
     */
    @GetMapping("/hefa/api/user/getUserInfo")
    JsonResult<UserInfo> getUserInfo(@RequestParam("userCode") String userCode);
    
    /**
     * 
     * <p>修改个人资料</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:43:40
     */
    @PostMapping("/hefa/api/user/editPersonalInfo")
    JsonResult<String> editPersonalInfo(@RequestBody EditPersonalInfoParam param);
    
    /**
     * 
     * <p>发送修改个人信息的邮箱验证码</p>
     * @param email
     * @return
     * @author 黄智聪  2018年12月14日 上午11:39:01
     */
    @GetMapping("/hefa/api/user/sendEditEmailVerificationCode")
    JsonResult<String> sendEditEmailVerificationCode(@RequestParam("email")String email);
    
    /**
     * 
     * <p>发送修改个人信息的短信验证码 </p>
     * @param phoneNumber
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:42
     */
    @GetMapping("/hefa/api/user/sendEditVerificationCode")
    JsonResult<String> sendEditVerificationCode(@RequestParam("phoneNumber")String phoneNumber);
    
    /**
     * 
     * <p>校验短信验证码</p>
     * @param param
     * @return
     * @author 黄智聪  2018年12月12日 下午5:45:46
     */
    @PostMapping("/hefa/api/user/checkEditVerificationCode")
    JsonResult<String> checkEditVerificationCode(@RequestBody CheckVerificationCodeParam param);
    
    /**
     * <p>新增部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:20
     */
    @PostMapping("/hefa/api/user/addDeptInfo")
    JsonResult<String> addDeptInfo(@RequestBody AddDeptParam param);
    
    /**
     * <p>修改部门信息</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:24
     */
    @PostMapping("/hefa/api/user/editDeptInfo")
    JsonResult<String> editDeptInfo(@RequestBody EditDeptParam param);
    
    /**
     * <p>获取部门信息列表</p>
     * @param param
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:28
     */
    @PostMapping("/hefa/api/user/getDeptList")
    JsonResult<List<Dept>> getDeptList(@RequestBody SearchDeptParam param);
    
    /**
     * <p>逻辑删除部门信息</p>
     * @param id
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:31
     */
    @GetMapping("/hefa/api/user/delDeptInfo")
    JsonResult<String> delDeptInfo(@RequestParam("deptCode") String deptCode, @RequestParam("modifier") String modifier);
    
    /**
     * <p>获取该父级下的部门信息</p>
     * @param id
     * @return
     * @author 彭斌  2018年10月17日 下午2:50:34
     */
    @GetMapping("/hefa/api/user/getDeptInfo")
    JsonResult<List<Dept>> getDeptParentInfo(@RequestParam("deptCode") String deptCode);
    
    /**
     * <p>禁用部门</p>
     * @param deptCode
     * @param modifier
     * @return
     * @author 彭斌  2018年10月20日 下午4:48:26
     */
    @GetMapping("/hefa/api/user/disableDeptInfo")
    JsonResult<String> disableDeptInfo(@RequestParam("deptCode") String deptCode, @RequestParam("modifier") String modifier);
    
    /**
     * <p>启用部门</p>
     * @param deptCode
     * @param modifier
     * @return
     * @author 彭斌  2018年10月20日 下午5:47:24
     */
    @GetMapping("/hefa/api/user/enableDeptInfo")
    JsonResult<String> enableDeptInfo(@RequestParam("deptCode") String deptCode, @RequestParam("modifier") String modifier);

    /**
     * 
     * <p>查询所有权限,树状结构</p>
     * @return
     * @author 黄智聪  2018年10月19日 下午6:00:40
     */
    @GetMapping("/hefa/api/user/getTreePermissions")
    JsonResult<List<TreePermission>> getTreePermissions();
    
    /**
     * 
     * <p>查询所有权限</p>
     * @return
     * @author 黄智聪  2018年10月19日 下午6:00:40
     */
    @GetMapping("/hefa/api/user/getPermissionList")
    JsonResult<List<Permission>> getPermissionList(@RequestParam("roleCode") String roleCode);
    
    /**
     * 
     * <p>新增角色</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:00:58
     */
    @PostMapping("/hefa/api/user/addRole")
    JsonResult<String> addRole(@RequestBody AddRoleParam param);
    
    /**
     * 
     * <p>修改角色</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:10
     */
    @PostMapping("/hefa/api/user/editRole")
    JsonResult<String> editRole(@RequestBody EditRoleParam param);
    
    /**
     * 
     * <p>删除角色</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:22
     */
    @PostMapping("/hefa/api/user/delRole")
    JsonResult<String> delRole(@RequestBody DelRoleParam param);
    
    /**
     * 
     * <p>查询角色列表</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:30
     */
    @PostMapping("/hefa/api/user/getRoleList")
    JsonResult<List<RoleInfo>> getRoleList(@RequestBody SearchRoleParam param);

    /**
     * 
     * <p>查询角色权限</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月19日 下午6:01:30
     */
    @GetMapping("/hefa/api/user/getRolePermissions")
    JsonResult<List<String>> getRolePermissions(@RequestParam("roleCode") String roleCode);
    
    /**
     * 
     * <p>设置角色权限</p>
     * @param param
     * @return
     * @author 黄智聪  2018年10月22日 下午4:30:56
     */
    @PostMapping("/hefa/api/user/setRolePermissions")
    JsonResult<String> setRolePermissions(@RequestBody SetRolePermissionParam param);
    
}
