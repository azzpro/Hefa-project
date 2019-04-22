/*******************************************************************************
 * Project Key : CPPII Create on 2018年10月17日 上午9:17:00 Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/

package com.hefa.user.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.common.collect.Lists;
import com.hefa.common.base.BaseException;
import com.hefa.common.base.JsonResult;
import com.hefa.common.errorcode.PlatformUserErrorCode;
import com.hefa.system.sequence.api.DbSequenceService;
import com.hefa.user.mapper.PlatformDeptMapper;
import com.hefa.user.pojo.PlatformDept;
import com.hefa.user.pojo.bo.AddDeptParam;
import com.hefa.utils.JSR303ValidateUtils;
import com.hefa.utils.ObjectUtils;

import lombok.Cleanup;
import sun.misc.BASE64Decoder;

/**
 * <P>
 * 部门服务接口
 * </P>
 * 
 * @version 1.0
 * @author 彭斌 2018年10月17日 上午9:17:00
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DeptService{

    @Autowired
    private PlatformDeptMapper deptMapper;

    @Autowired
    private DbSequenceService dbSequenceService;
    
    public JsonResult<String> addDeptInfo(@RequestBody AddDeptParam param) {
        // 部门信息非空校验
        JSR303ValidateUtils.validateInputParam(param);
        String deptParentCode = param.getParentCode();
        
        PlatformDept dept = new PlatformDept();
        
        if(!"".equals(deptParentCode) && !"0".equals(deptParentCode)) {
            PlatformDept deptObjCode = deptMapper.selectByDeptCode(deptParentCode);
            if(ObjectUtils.isNull(deptObjCode)) {
                throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
            }
            dept.setParentCode(deptParentCode);
            
            if(deptObjCode.getDescription().equals("0")) {
                dept.setDescription("1");
            } else if(deptObjCode.getDescription().equals("1")) {
                dept.setDescription("2");
            } else if(deptObjCode.getDescription().equals("2")) {
                throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_LEVEL_ERROR);
            }
        } else {
            // 系统自动生成部门编码
            dept.setParentCode("0");
            deptParentCode = "0";
            // 部门等级 0 一级 1 二级 2 三级
            dept.setDescription("0");
        }
        
        int count = deptMapper.selectCountByParam(deptParentCode, param.getDeptName());
        if(count>0) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_EXIST);
        }
        
        String code = dbSequenceService.getPlatDepartmentNumber();
        dept.setDeptCode(SystemSeqUtils.getSeq(code));
        dept.setDeptName(param.getDeptName());
        dept.setStatus(param.getStatus());
        dept.setCreator(param.getCreator());
        dept.setCreateTime(new Date());

        deptMapper.insertSelective(dept);
        return JsonResult.successJsonResult();
    }

    public JsonResult<String> editDeptInfo(@RequestBody EditDeptParam param) {
        JSR303ValidateUtils.validate(param);

        PlatformDept dept = deptMapper.selectByDeptCode(param.getDeptCode());
        if (ObjectUtils.isNull(dept)) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }
        String parentCode = param.getParentCode();
        
        if(!parentCode.equals("0")) {
            PlatformDept deptObjCode = deptMapper.selectByDeptCode(parentCode);
            if(ObjectUtils.isNull(deptObjCode)) {
                throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
            }
        }
        
        if (!dept.getDeptName().equals(param.getDeptName().trim())) {
            int count = deptMapper.selectCountByParam(parentCode, param.getDeptName().trim());
            if(count>0) {
                throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_EXIST);
            }
        }
        
        List<PlatformDept> pd = deptMapper.selectByParentDeptCode(parentCode);
        if(pd.size()>0) {
            if(pd.get(0).getDescription().equals("2")) {
                throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_LEVEL_ERROR);
            }
        }
        
        dept.setParentCode(parentCode);
        dept.setDeptName(param.getDeptName());
        dept.setLastModifyTime(new Date());
        dept.setModifier(param.getModifier());
        dept.setStatus(param.getStatus());

        deptMapper.updateByPrimaryKeySelective(dept);
        return JsonResult.successJsonResult();
    }

    public JsonResult<List<Dept>> getDeptList(@RequestBody SearchDeptParam param) {
        List<Dept> infos = deptMapper.selectDeptList(param);
        return JsonResult.successJsonResult(infos);
    }

    public JsonResult<String> delDeptInfo(String deptCode, String modifier) {
        if (ObjectUtils.isNull(deptCode) ) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }
        PlatformDept dept = deptMapper.selectByDeptCode(deptCode);
        if (ObjectUtils.isNull(dept)) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }

        // 校验是否绑定成员信息
        int count = deptMapper.selectCountDeptUser(deptCode);
        if(count>0) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_USER_EXIST);
        }
        
        // 校验是否有子级部门
        List<PlatformDept> list = deptMapper.selectByParentDeptCode(deptCode);
        if(list.size() > 0) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_EXIST);
        }
        
        dept.setStatus(0);
        dept.setModifier(modifier);
        dept.setLastModifyTime(new Date());
        
        deptMapper.updateByPrimaryKeySelective(dept);
        return JsonResult.successJsonResult();
    }

    public JsonResult<List<Dept>> getDeptParentInfo(String deptCode) {
        if (ObjectUtils.isNull(deptCode)) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }
        List<Dept> dept = deptMapper.selectDeptParentList(deptCode);
        return JsonResult.successJsonResult(dept);
    }
    
    public JsonResult<String> disableDeptInfo(String deptCode, String modifier) {
        if (ObjectUtils.isNull(deptCode) ) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }
        PlatformDept dept = deptMapper.selectByDeptCode(deptCode);
        if (ObjectUtils.isNull(dept)) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }

        dept.setStatus(2);
        dept.setModifier(modifier);
        dept.setLastModifyTime(new Date());
        
        deptMapper.updateByPrimaryKeySelective(dept);
        return JsonResult.successJsonResult();
    }

    public JsonResult<String> enableDeptInfo(String deptCode, String modifier) {
        if (ObjectUtils.isNull(deptCode) ) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }
        PlatformDept dept = deptMapper.selectByDeptCode(deptCode);
        if (ObjectUtils.isNull(dept)) {
            throw new BaseException(PlatformUserErrorCode.PLATFORM_DEPT_ERROR_NO_EXIST);
        }

        dept.setStatus(1);
        dept.setModifier(modifier);
        dept.setLastModifyTime(new Date());
        
        deptMapper.updateByPrimaryKeySelective(dept);
        return JsonResult.successJsonResult();
    }

   /* public boolean parentCodeLevel(String parentCode) {
        PlatformDept platformDept = deptMapper.selectByParentDeptCode(parentCode);
        if(ObjectUtils.isNotNull(platformDept)) {
            PlatformDept  platformDeptObj = deptMapper.selectByParentDeptCode(platformDept.getDeptCode());
            if(ObjectUtils.isNotNull(platformDeptObj)) {
                
            }
        } else {
            PlatformDept pdByParentCode = deptMapper.selectByDeptCode(parentCode);
            if(ObjectUtils.isNotNull(pdByParentCode) && !pdByParentCode.getParentCode().equals("0")) {
                // 该部门编码为三级部门
                return false;
            }
        }
        return true;
    }*/
    
    /**
     * <p>平台端部门导入</p>
     * @param param
     * @return
     * @throws IOException
     * @author 彭斌  2018年12月12日 上午11:41:08
     */
    public JsonResult<String> importPlatformDept(@RequestBody ImportPlatformDeptParam param) throws IOException{
     // 记录出错行数
        int errorRowNum = 1;
        String creator = param.getCreator();
        
        String base64Str = param.getBase64Str();
        //将字符串转换为byte数组
        byte[] bytes = new BASE64Decoder().decodeBuffer(base64Str);
        //转化为输入流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        
        @Cleanup
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        if(lastRowNum == 0) {// 未填写数据
            throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "导入数据不可为空");
        }
        
        for (int i = 1; i <= lastRowNum; i++) {
            HSSFRow row = sheet.getRow(i);
            errorRowNum++;
            if (ObjectUtils.isNotNull(row)) {
                // 获取当前行的元素信息
                ArrayList<Cell> rowCells = Lists.newArrayList(row.cellIterator());
                String deptName = null;
                String parentDeptCode = null;
                String deptStatus = null;
                
                // 部门名称校验
                if (Cell.CELL_TYPE_BLANK != rowCells.get(0).getCellType()) {
                    String cell_1 = ExcelUtils.getStringValue(row.getCell(0));
                    if (StringUtils.isNotBlank(cell_1)) {
                        deptName = cell_1;
                    }else {
                        throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据部门名称不允许为空");
                    }
                }else {
                    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据部门名称不允许为空");
                }
                
                // 上级部门编码校验
                if (Cell.CELL_TYPE_BLANK != rowCells.get(1).getCellType()) {
                    String cell_2 = ExcelUtils.getStringValue(row.getCell(1));
                    if (StringUtils.isNotBlank(cell_2)) {
                        parentDeptCode = cell_2;
                    }else {
                        throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据上级部门编码不允许为空");
                    }
                }else {
                    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据上级部门编码不允许为空");
                }
                
                // 部门状态校验
                if (Cell.CELL_TYPE_BLANK != rowCells.get(2).getCellType()) {
                    String cell_3 = ExcelUtils.getStringValue(row.getCell(2));
                    if (StringUtils.isNotBlank(cell_3)) {
                        deptStatus = cell_3;
                    }else {
                        throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据上级部门编码不允许为空");
                    }
                }else {
                    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据上级部门编码不允许为空");
                }
                
                PlatformDept dept = new PlatformDept();
                
                if(!"0".equals(parentDeptCode)) {
                    PlatformDept deptObjCode = deptMapper.selectByDeptCode(parentDeptCode);
                    if(ObjectUtils.isNull(deptObjCode)) {
                        throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据部门编码不存在");
                    }
                    
                    if(deptObjCode.getDescription().equals("0")) {
                        dept.setDescription("1");
                    } else if(deptObjCode.getDescription().equals("1")) {
                        dept.setDescription("2");
                    } else if(deptObjCode.getDescription().equals("2")) {
                        throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据已是三级部门");
                    }
                    dept.setParentCode(parentDeptCode);
                } else {
                    // 系统自动生成部门编码
                    dept.setParentCode("0");
                    // 部门等级 0 一级 1 二级 2 三级
                    dept.setDescription("0");
                }
                
                int count = deptMapper.selectCountByParam(parentDeptCode, deptName);
                if(count>0) {
                    throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据部门已存在");
                }
                
                String code = dbSequenceService.getPlatDepartmentNumber();
                dept.setDeptCode(SystemSeqUtils.getSeq(code));
                dept.setDeptName(deptName);
                dept.setStatus(Integer.parseInt(deptStatus));
                dept.setCreator(creator);
                dept.setCreateTime(new Date());
                deptMapper.insertSelective(dept);
            }
        }
            return JsonResult.successJsonResult();
    }
    
    
}

