package com.hefa.user.pojo.vo;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Dept implements Serializable {

    /**
     * 部门编码
     *
     * @mbg.generated
     */
    private String deptCode;

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    private String deptName;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 状态   0无效  1有效
     *
     * @mbg.generated
     */
    private Integer status;

    private Date createTime;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * 最后修改时间
     *
     * @mbg.generated
     */
    private Date lastModifyTime;

    /**
     * 修改人
     *
     * @mbg.generated
     */
    private String modifier;

    /**
     * 父级编码
     */
    private String parentCode;
    
    private static final long serialVersionUID = 1L;

}