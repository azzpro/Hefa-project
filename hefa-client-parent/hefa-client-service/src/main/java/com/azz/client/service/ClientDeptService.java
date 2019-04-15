/*******************************************************************************
 * Project Key : CPPII
 * Create on 2018年10月24日 下午1:24:28
 * Copyright (c) 2018. 爱智造.
 * 注意：本内容仅限于爱智造内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
 
package com.azz.client.service;

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

import com.azz.client.mapper.ClientDeptMapper;
import com.azz.client.pojo.ClientDept;
import com.azz.client.pojo.bo.AddClientDeptParam;
import com.azz.client.pojo.bo.DelDeptParam;
import com.azz.client.pojo.bo.EditClientDeptParam;
import com.azz.client.pojo.bo.EditDeptIsEnableParam;
import com.azz.client.pojo.bo.ImportClientDeptParam;
import com.azz.client.pojo.bo.SearchClientChildDeptParam;
import com.azz.client.pojo.bo.SearchClientDeptInfoByCodeParam;
import com.azz.client.pojo.bo.SearchClientDeptInfoParam;
import com.azz.client.pojo.bo.SearchClientDeptIsExistParam;
import com.azz.client.pojo.bo.SearchClientDeptParam;
import com.azz.client.pojo.vo.ClientDeptInfo;
import com.azz.client.pojo.vo.ClientDeptList;
import com.azz.core.common.JsonResult;
import com.azz.core.common.errorcode.ClientErrorCode;
import com.azz.core.common.errorcode.JSR303ErrorCode;
import com.azz.core.constants.ClientConstants;
import com.azz.core.exception.BaseException;
import com.azz.exception.JSR303ValidationException;
import com.azz.system.sequence.api.DbSequenceService;
import com.azz.util.ExcelUtils;
import com.azz.util.JSR303ValidateUtils;
import com.azz.util.ObjectUtils;
import com.azz.util.StringUtils;
import com.azz.util.SystemSeqUtils;
import com.google.common.collect.Lists;

import lombok.Cleanup;
import sun.misc.BASE64Decoder;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 彭斌  2018年10月29日 上午11:29:39
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ClientDeptService {

    
    @Autowired
    private ClientDeptMapper clientDeptMapper;
    
    @Autowired
    private DbSequenceService dbSequenceService;
    
    public JsonResult<List<ClientDeptList>> searchClientDeptList(@RequestBody SearchClientDeptParam param){
        JSR303ValidateUtils.validate(param);
        List<ClientDeptList> clientDeptList = clientDeptMapper.selectFirstLevelList(param);
        return JsonResult.successJsonResult(clientDeptList);
    }
    
    public JsonResult<List<ClientDeptList>> searchChildClientDeptList(@RequestBody SearchClientChildDeptParam param){
        JSR303ValidateUtils.validate(param);
        List<ClientDeptList> clientDeptList = clientDeptMapper.selectChildlList(param);
        return JsonResult.successJsonResult(clientDeptList);
    }
    
    public JsonResult<String> editDept(@RequestBody EditClientDeptParam param){
        JSR303ValidateUtils.validate(param);
        
        ClientDept cdObj = clientDeptMapper.selectByDeptCode(param.getDeptCode());
        if(ObjectUtils.isNull(cdObj)) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_NO_EXIST);
        }
        
        if(!param.getDeptName().trim().equals(cdObj.getDeptName())) {
            SearchClientDeptInfoParam scdObj = new SearchClientDeptInfoParam();
            scdObj.setCompanyCode(param.getCompanyCode());
            scdObj.setDeptName(param.getDeptName().trim());
            ClientDept clientDept = clientDeptMapper.selectClientDeptInfoByName(scdObj);
            if(ObjectUtils.isNotNull(clientDept)) {
                throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_EXIST);
            }
        }
        // 部门名称编码重名
        if(param.getDeptCode().equals(param.getParentCode())) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_CLIENT_PARENT_CODE_ERROR);
        }
        
        String parentCode = param.getParentCode();
        ClientDept cdParentObj = null;
        if(!"0".equals(parentCode)) {
            cdParentObj = clientDeptMapper.selectByDeptCode(parentCode);
            if(ObjectUtils.isNull(cdParentObj)) {
                throw new BaseException(ClientErrorCode.CLIENT_DEPT_PARENT_CODE_ERROR_NO_EXIST);
            }
        }
        
        SearchClientDeptInfoByCodeParam scd = new SearchClientDeptInfoByCodeParam();
        scd.setCompanyCode(param.getCompanyCode());
        scd.setDeptCode(param.getParentCode());
        ClientDept parentClientDept = clientDeptMapper.selectClientDeptInfoByCode(scd);
        if(ObjectUtils.isNotNull(parentClientDept)) {
            if(parentClientDept.getDescription().equals("0")) {
                cdObj.setDescription("1");
            } else if(parentClientDept.getDescription().equals("1")) {
                cdObj.setDescription("2");
            } else if(parentClientDept.getDescription().equals("2")) {
                throw new BaseException(ClientErrorCode.CLIENT_DEPT_CLIENT_LEVEL_ERROR_EXIST);
            }
        }
        
        cdObj.setDeptName(param.getDeptName().trim());
        cdObj.setLastModifyTime(new Date());
        cdObj.setParentCode(param.getParentCode());
        cdObj.setStatus(param.getStatus());
        cdObj.setModifier(param.getModifier());
        clientDeptMapper.updateByPrimaryKeySelective(cdObj);
        return JsonResult.successJsonResult();
    }
    
    public JsonResult<String> isEnableDept(@RequestBody EditDeptIsEnableParam param){
        JSR303ValidateUtils.validate(param);
        
        ClientDept cdObj = clientDeptMapper.selectByDeptCode(param.getDeptCode());
        if(ObjectUtils.isNull(cdObj)) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_NO_EXIST);
         }
        if(param.getStatus().equals(ClientConstants.DeptStatus.DISABLE.getValue())) {
            // 禁用
            cdObj.setStatus(ClientConstants.DeptStatus.DISABLE.getValue());
        } else if(param.getStatus().equals(ClientConstants.DeptStatus.ENABLE.getValue())) {
            // 启用
            cdObj.setStatus(ClientConstants.DeptStatus.ENABLE.getValue());
        } else {
            // 异常信息 状态不存在
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_STATUS_ERROR_NO_EXIST);
        }
        clientDeptMapper.updateByPrimaryKeySelective(cdObj);
        return JsonResult.successJsonResult();
    }
    
    public JsonResult<String> delDept(@RequestBody DelDeptParam param){
        JSR303ValidateUtils.validate(param);
        ClientDept cdObj = clientDeptMapper.selectByDeptCode(param.getDeptCode());
        if(ObjectUtils.isNull(cdObj)) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_NO_EXIST);
         }
        // 校验该部门是否还存在用户信息
        int isExist = clientDeptMapper.selectClientUserIsExistDept(param.getDeptCode());
        if(isExist > 0) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_CLIENT_ERROR_EXIST);
        }
        cdObj.setStatus(ClientConstants.DeptStatus.INVALID.getValue());
        cdObj.setLastModifyTime(new Date());
        cdObj.setModifier(param.getModifier());
        clientDeptMapper.updateByPrimaryKeySelective(cdObj);
        return JsonResult.successJsonResult();
    }
    
    public JsonResult<String> addFirstLevelDept(@RequestBody AddClientDeptParam param){
        // 部门信息非空校验
        JSR303ValidateUtils.validate(param);
        SearchClientDeptIsExistParam record = new SearchClientDeptIsExistParam();
        record.setCompanyCode(param.getCompanyCode());
        record.setDeptName(param.getDeptName());
        // 校验父级名称唯一
        int isExist = clientDeptMapper.selectFirstLevelExist(record);
        if(isExist>0) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_EXIST);
        }
        String sequence = dbSequenceService.getClientDepartmentNumber();
        ClientDept clientDept = new ClientDept();
        clientDept.setDeptCode(SystemSeqUtils.getSeq(sequence));
        clientDept.setCompanyCode(param.getCompanyCode());
        clientDept.setCreateTime(new Date());
        clientDept.setDeptName(param.getDeptName());
        clientDept.setParentCode("0");
        clientDept.setCreator(param.getCreator());
        clientDept.setStatus(param.getStatus());
        clientDept.setCreator(param.getCreator());
        clientDept.setDescription("0");  // 部门等级0 一级 1 二级  2三级
        
        clientDeptMapper.insertSelective(clientDept);
        
        return JsonResult.successJsonResult();
    }
    
    public JsonResult<String> addChildDept(@RequestBody AddClientDeptParam param){
        // 部门信息非空校验
        JSR303ValidateUtils.validate(param);
        SearchClientDeptInfoParam record = new SearchClientDeptInfoParam();
        record.setCompanyCode(param.getCompanyCode());
        record.setDeptName(param.getDeptName());
        ClientDept cdObj = clientDeptMapper.selectClientDeptInfoByName(record);
        if(ObjectUtils.isNotNull(cdObj)) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_EXIST);
        }
       
        SearchClientDeptInfoByCodeParam deptByCodeObj = new SearchClientDeptInfoByCodeParam();
        deptByCodeObj.setCompanyCode(param.getCompanyCode());
        deptByCodeObj.setDeptCode(param.getParentCode());
        ClientDept dept = clientDeptMapper.selectClientDeptInfoByCode(deptByCodeObj);
        
        if(ObjectUtils.isNull(dept)) {
            throw new BaseException(ClientErrorCode.CLIENT_DEPT_ERROR_NO_EXIST);
        }
        
        ClientDept clientDept = new ClientDept();
        
        SearchClientDeptInfoByCodeParam scd = new SearchClientDeptInfoByCodeParam();
        scd.setCompanyCode(param.getCompanyCode());
        scd.setDeptCode(param.getParentCode());
        ClientDept parentClientDept = clientDeptMapper.selectClientDeptInfoByCode(scd);
        if(ObjectUtils.isNotNull(parentClientDept)) {
            if(parentClientDept.getDescription().equals("0")) {
                clientDept.setDescription("1");
            } else if(parentClientDept.getDescription().equals("1")) {
                clientDept.setDescription("2");
            } else if(parentClientDept.getDescription().equals("2")) {
                throw new BaseException(ClientErrorCode.CLIENT_DEPT_CLIENT_LEVEL_ERROR_EXIST);
            }
        }
        String sequence = dbSequenceService.getClientDepartmentNumber();
        clientDept.setDeptCode(SystemSeqUtils.getSeq(sequence));
        clientDept.setCompanyCode(param.getCompanyCode());
        clientDept.setCreateTime(new Date());
        clientDept.setDeptName(param.getDeptName());
        clientDept.setParentCode(param.getParentCode());
        clientDept.setCreator(param.getCreator());
        clientDept.setStatus(param.getStatus());
        clientDeptMapper.insertSelective(clientDept);
        return JsonResult.successJsonResult();
    }
    
    public JsonResult<ClientDeptInfo> getDeptInfo(@RequestBody SearchClientDeptInfoByCodeParam param){
        ClientDeptInfo cdObj = clientDeptMapper.selectClientByCode(param);
        return JsonResult.successJsonResult(cdObj);
    }
    
    
    public JsonResult<String> importClientDept(@RequestBody ImportClientDeptParam param) throws IOException{
        // 记录出错行数
       int errorRowNum = 1;
       String creator = param.getCreator();
       String companyCode = param.getCompanyCode();
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
               
               ClientDept clientDept = new ClientDept();
               if(!"0".equals(parentDeptCode)) {
                   // 校验父级部门编码是否存在
                   SearchClientDeptInfoByCodeParam scd = new SearchClientDeptInfoByCodeParam();
                   scd.setCompanyCode(companyCode);
                   scd.setDeptCode(parentDeptCode);
                   ClientDept parentClientDept = clientDeptMapper.selectClientDeptInfoByCode(scd);
                   if(ObjectUtils.isNull(parentClientDept)) {
                       throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据部门编码不存在");
                   }
                   // 校验部门名称是否唯一
                   SearchClientDeptInfoParam record = new SearchClientDeptInfoParam();
                   record.setCompanyCode(companyCode);
                   record.setDeptName(deptName);
                   ClientDept cdObj = clientDeptMapper.selectClientDeptInfoByName(record);
                   if(ObjectUtils.isNotNull(cdObj)) {
                       throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据部门已存在");
                   }
                   
                   if(parentClientDept.getDescription().equals("0")) {
                       clientDept.setDescription("1");
                   } else if(parentClientDept.getDescription().equals("1")) {
                       clientDept.setDescription("2");
                   } else if(parentClientDept.getDescription().equals("2")) {
                       throw new JSR303ValidationException(JSR303ErrorCode.SYS_ERROR_INVALID_REQUEST_PARAM, "第" + errorRowNum + "行数据已是三级部门");
                   }
                   
                   clientDept.setParentCode(parentDeptCode);
               } else {
                   // 系统自动生成部门编码
                   clientDept.setParentCode("0");
                   // 部门等级 0 一级 1 二级 2 三级
                   clientDept.setDescription("0");
               }
               String sequence = dbSequenceService.getClientDepartmentNumber();
               clientDept.setDeptCode(SystemSeqUtils.getSeq(sequence));
               clientDept.setCompanyCode(param.getCompanyCode());
               clientDept.setCreateTime(new Date());
               clientDept.setDeptName(deptName);
               clientDept.setParentCode(parentDeptCode);
               clientDept.setCreator(creator);
               clientDept.setStatus(Integer.parseInt(deptStatus));
               clientDeptMapper.insertSelective(clientDept);
               
           }
       }
           return JsonResult.successJsonResult();
   } 
}

