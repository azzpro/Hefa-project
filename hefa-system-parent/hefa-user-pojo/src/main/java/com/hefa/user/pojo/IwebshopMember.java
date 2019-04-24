package com.hefa.user.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class IwebshopMember {
	
	private Integer userId;
	private String trueName;//真实姓名
	private String telephone;//联系电话
	private String mobile;//手机号
	private String area;//地区
	private String contactAddr;//联系地址
	private String qq;//QQ号
	private Byte sex;//性别 1男2女 
	private Date birthday;//生日
	private Integer groupId;//分组
	private Integer exp;//经验值
	private Integer point;//积分
	private String messageIds;//消息ID
	private Date time;//注册时间
	private String zip;//邮政编码
	private Byte status;//用户状态1正常状态 2 删除至回收站 3锁定
	private String prop;//用户拥有工具
	private BigDecimal balance;//用户余额
	private Date lastLogin;//最后一次登录时间
	private String custom;//用户习惯方式
	private String email;//Email
}
