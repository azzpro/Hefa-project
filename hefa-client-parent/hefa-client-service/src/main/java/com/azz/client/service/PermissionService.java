/*******************************************************************************
 * Project Key : CPPII Create on 2018年10月14日 上午9:27:50 Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.azz.client.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.azz.client.mapper.ClientPermissionMapper;
import com.azz.client.mapper.ClientRoleMapper;
import com.azz.client.mapper.ClientRolePermissionMapper;
import com.azz.client.mapper.ClientUserRoleMapper;
import com.azz.client.pojo.ClientPermission;
import com.azz.client.pojo.ClientRole;
import com.azz.client.pojo.ClientRolePermission;
import com.azz.client.pojo.bo.AddRoleParam;
import com.azz.client.pojo.bo.DelRoleParam;
import com.azz.client.pojo.bo.EditRoleParam;
import com.azz.client.pojo.bo.SearchRoleParam;
import com.azz.client.pojo.bo.SetRolePermissionParam;
import com.azz.client.pojo.vo.Permission;
import com.azz.client.pojo.vo.RoleInfo;
import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.JSR303ErrorCode;
import com.azz.core.constants.PermissionConstants.PermissionStatus;
import com.azz.core.constants.UserConstants;
import com.azz.exception.JSR303ValidationException;
import com.azz.system.sequence.api.DbSequenceService;
import com.azz.util.JSR303ValidateUtils;
import com.azz.util.StringUtils;
import com.azz.util.SystemSeqUtils;

/**
 * 
 * <P>权限服务相关接口实现类</P>
 * @version 1.0
 * @author 黄智聪  2018年10月22日 下午4:06:22
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PermissionService {

    @Autowired
    private ClientRoleMapper clientRoleMapper;
    
    @Autowired
    private ClientUserRoleMapper clientUserRoleMapper;

    @Autowired
    private ClientRolePermissionMapper clientRolePermissionMapper;

    @Autowired
    private ClientPermissionMapper clientPermissionMapper;
    
    @Autowired
    private DbSequenceService dbSequenceService;
    

    public JsonResult<List<Permission>> getPermissionList(String companyCode, String roleCode) {
	List<Permission> permissions = clientPermissionMapper.getAllPermissions();
	if(StringUtils.isBlank(roleCode)) {
	    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色编码不允许为空");
	}
	List<String> permissionCodes = clientRolePermissionMapper.getPermissionCodesByRoleCode(companyCode, roleCode);
	for (Permission permission : permissions) {
	    String permissionCode = permission.getPermissionCode();
	    if(permissionCodes.contains(permissionCode)) {
		permission.setIsSelected(1);
	    }
	}
	return JsonResult.successJsonResult(permissions);
    }
    
    public JsonResult<String> addRole(@RequestBody AddRoleParam param) {
	// 参数校验
	this.validateAddRoleParam(param);
	Date nowDate = new Date();
	String creator = param.getCreator();
	String code = dbSequenceService.getClientDepartmentNumber();
	ClientRole roleRecord = ClientRole.builder().createTime(nowDate)
		.creator(creator).remark(param.getRemark())
		.roleCode(SystemSeqUtils.getSeq(code))
		.companyCode(param.getCompanyCode())
		.roleName(param.getRoleName()).build();
	clientRoleMapper.insertSelective(roleRecord);
	return JsonResult.successJsonResult();
    }

    public JsonResult<String> editRole(@RequestBody EditRoleParam param) {
	// 参数校验
	this.validateEditRoleParam(param);
	if(UserConstants.PLATFORM_ADMIN_ROLE_NAME.equals(param.getRoleName())) {
	    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "管理员角色不允许修改");
	}
	Date nowDate = new Date();
	String modifier = param.getModifier();
	String roleCode = param.getRoleCode();
	ClientRole roleRecord = ClientRole.builder().lastModifyTime(nowDate).modifier(modifier)
		.remark(param.getRemark()).roleCode(roleCode)
		.roleName(param.getRoleName()).build();
	clientRoleMapper.updateByRoleCode(roleRecord);
	return JsonResult.successJsonResult();
    }
    
    public JsonResult<String> delRole(@RequestBody DelRoleParam param) {
	// 参数校验
	JSR303ValidateUtils.validate(param);
	
	ClientRole role = clientRoleMapper.selectByRoleCode(param.getRoleCode());
	if(role == null) {
		throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色不存在");
	}
	
	// 校验是否存在绑定的成员
	int count = clientUserRoleMapper.countBindingUserRole(role.getId());
	if(count > 0) {
		throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "该角色已绑定成员，请处理后删除");
	}
	
	ClientRole roleRecord = ClientRole.builder()
		.lastModifyTime(new Date())
		.modifier(param.getModifier())
		.roleCode(param.getRoleCode())
		.status(PermissionStatus.INVALID.getValue())// 无效
		.build();
	clientRoleMapper.updateByRoleCode(roleRecord);
	return JsonResult.successJsonResult();
    }
    
    
    public JsonResult<List<RoleInfo>> getRoleList(@RequestBody SearchRoleParam param) {
	return JsonResult.successJsonResult(clientRoleMapper.getRoleInfoBySearchParam(param));
    }
    
    
    public JsonResult<List<String>> getRolePermissions(String companyCode, String roleCode) {
	if(StringUtils.isBlank(roleCode)) {
	    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色编码不允许为空");
	}
	List<String> permissionCodes = clientRolePermissionMapper.getPermissionCodesByRoleCode(companyCode, roleCode);
	return JsonResult.successJsonResult(permissionCodes);
    }
    
    public JsonResult<String> setRolePermissions(@RequestBody SetRolePermissionParam param) {
	// 参数校验
	JSR303ValidateUtils.validate(param);
	// 根据角色编码查询当前角色信息
	ClientRole role = clientRoleMapper.selectByRoleCode(param.getRoleCode());
	if (role == null) {
	    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色不存在");
	}
	Long roleId = role.getId();
	// 先将原来角色绑定的权限删除
	clientRolePermissionMapper.deleteByRoleId(roleId);
	// 再重新绑定新的权限信息
	List<String> permissionCodes = param.getPermissionCodes();
	for (String permissionCode : permissionCodes) {
	    ClientPermission persmission = clientPermissionMapper.getClientPermissionByPermissionCode(permissionCode);
	    ClientRolePermission rolePermissionRecord = ClientRolePermission.builder().createTime(new Date())
		    .creator(param.getCreator()).permissionId(persmission.getId()).roleId(roleId).build();
	    clientRolePermissionMapper.insertSelective(rolePermissionRecord);
	}
	return JsonResult.successJsonResult();
    }

    /**
     * 
     * <p>
     * 校验新增角色权限参数
     * </p>
     * 
     * @param param
     * @author 黄智聪 2018年10月18日 下午5:30:23
     */
    private void validateAddRoleParam(AddRoleParam param) {
	// 参数校验
	JSR303ValidateUtils.validate(param);
	this.isExistRoleName(param.getCompanyCode(), param.getRoleName(), null);
    }

    /**
     * 
     * <p>
     * 校验编辑角色权限参数
     * </p>
     * 
     * @param param
     * @author 黄智聪 2018年10月18日 下午5:30:23
     */
    private void validateEditRoleParam(EditRoleParam param) {
	// 参数校验
	JSR303ValidateUtils.validate(param);
	this.isExistRoleName(param.getCompanyCode(), param.getRoleName(), param.getRoleCode());
    }

    /**
     * 
     * <p>
     * 角色名称是否存在
     * </p>
     * 
     * @param roleName
     *            角色名称
     * @author 黄智聪 2018年10月19日 下午1:52:51
     */
    private void isExistRoleName(String companyCode, String roleName, String roleCode) {
	// 校验角色名称是否已经存在，若是修改则需要传roleCode，用于判断是否改的为当前编码的角色名称
	ClientRole role = clientRoleMapper.hasRoleName(companyCode, roleName, roleCode);
	if (role != null) {
	    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "角色名称已存在");
	}
    }

}
