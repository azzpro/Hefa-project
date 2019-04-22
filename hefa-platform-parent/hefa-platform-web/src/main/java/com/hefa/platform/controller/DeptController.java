/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月15日 下午3:05:46
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.common.base.JsonResult;
import com.hefa.platform.utils.WebUtils;
import com.hefa.user.api.UserService;
import com.hefa.user.pojo.bo.AddDeptParam;
import com.hefa.user.pojo.bo.EditDeptParam;
import com.hefa.user.pojo.bo.SearchDeptParam;
import com.hefa.user.pojo.vo.Dept;

/**
 * <P>部门管理</P>
 * @version 1.0
 * @author 彭斌  2018年10月17日 下午3:04:47
 */
@RestController
@RequestMapping("/hefa/api/dept")
public class DeptController {

	@Autowired
	UserService userService;
	
	/**
	 * <p>新增部门信息</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年10月17日 下午3:17:05
	 */
	@RequestMapping("/addDeptInfo")
	public JsonResult<String> addDeptInfo(AddDeptParam param) {
		param.setCreator(WebUtils.getLoginUser().getUserInfo().getUserCode());
		return userService.addDeptInfo(param);
	}

	/**
	 * <p>获取父级部门下的信息</p>
	 * @param deptId
	 * @return
	 * @author 彭斌  2018年10月18日 下午1:42:11
	 */
	@RequestMapping("/getDeptParentList")
	public JsonResult<List<Dept>> getDeptParentList(@RequestParam("parentCode") String parentCode){
	    return userService.getDeptParentInfo(parentCode);
	}
	
	/**
	 * <p>获取部门列表</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年10月18日 下午1:45:17
	 */
	@RequestMapping("/getDeptList")
	public JsonResult<List<Dept>> getDeptList(SearchDeptParam param){
	    return userService.getDeptList(param);
	}
	
	/**
	 * <p>修改部门信息</p>
	 * @param param
	 * @return
	 * @author 彭斌  2018年10月18日 下午1:47:23
	 */
	@RequestMapping("/editDeptInfo")
	public JsonResult<String> editDeptInfo(EditDeptParam param){
	    param.setModifier(WebUtils.getLoginUser().getUserInfo().getUserCode());
	    return userService.editDeptInfo(param);
	}
	
	/**
	 * <p>删除部门信息</p>
	 * @param id
	 * @return
	 * @author 彭斌  2018年10月18日 下午1:49:02
	 */
	@RequestMapping("/delDeptInfo")
	JsonResult<String> delDeptInfo(@RequestParam("deptCode") String deptCode){
	    String modifier = WebUtils.getLoginUser().getUserInfo().getUserCode();
	    return userService.delDeptInfo(deptCode,modifier);
	}
	
	/**
	 * <p>禁用部门信息</p>
	 * @param deptCode
	 * @return
	 * @author 彭斌  2018年10月20日 下午5:01:35
	 */
    @RequestMapping("/disableDeptInfo")
    JsonResult<String> disableDeptInfo(@RequestParam("deptCode") String deptCode){
        String modifier = WebUtils.getLoginUser().getUserInfo().getUserCode();
        return userService.disableDeptInfo(deptCode, modifier);
    }
    
    /**
     * <p>启用部门信息</p>
     * @param deptCode
     * @return
     * @author 彭斌  2018年10月20日 下午5:01:35
     */
    @RequestMapping("/enableDeptInfo")
    JsonResult<String> enableDeptInfo(@RequestParam("deptCode") String deptCode){
        String modifier = WebUtils.getLoginUser().getUserInfo().getUserCode();
        return userService.enableDeptInfo(deptCode, modifier);
    }
    
}
