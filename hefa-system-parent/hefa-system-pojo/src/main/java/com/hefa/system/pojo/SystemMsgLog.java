package com.hefa.system.pojo;


import java.io.Serializable;
import java.util.Date;

public class SystemMsgLog implements Serializable {
    /**
     * 主键ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 短信标题
     *
     * @mbg.generated
     */
    private String msgTitle;
    
    private String msgCode;
    private String msgMail;
    /**
     * 短信内容
     *
     * @mbg.generated
     */
    private String msgContent;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private Long msgPhone;

    /**
     * 发送短信时间
     *
     * @mbg.generated
     */
    private Date msgTime;

    /**
     * 发送状态 1 成功 2 失败
     *
     * @mbg.generated
     */
    private Integer msgStatus;

    /**
     * 短信平台 
     *
     * @mbg.generated
     */
    private String msgPlatform;

    /**
     * 类型   1 : 注册 2 : 找回密码  3：忘记密码 4：提现 ，5：修改登录手机号
     *
     * @mbg.generated
     */
    private Integer msgType;


    private static final long serialVersionUID = 1L;

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
     * 短信标题<br/>
     * 返回值对应的表列名 msg_log.msg_title
     *
     * @return 返回值对应 msg_log.msg_title
     *
     * @mbg.generated
     */
    public String getMsgTitle() {
        return msgTitle;
    }


	public String getMsgMail() {
		return msgMail;
	}

	public void setMsgMail(String msgMail) {
		this.msgMail = msgMail;
	}


	/**
     * 短信标题<br/>
     * msg_log.msg_title
     *
     * @param msgTitle 值对应 msg_log.msg_title
     *
     * @mbg.generated
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle == null ? null : msgTitle.trim();
    }

    /**
     * 短信内容<br/>
     * 返回值对应的表列名 msg_log.msg_content
     *
     * @return 返回值对应 msg_log.msg_content
     *
     * @mbg.generated
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * 短信内容<br/>
     * msg_log.msg_content
     *
     * @param msgContent 值对应 msg_log.msg_content
     *
     * @mbg.generated
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    /**
     * 手机号码<br/>
     * 返回值对应的表列名 msg_log.msg_phone
     *
     * @return 返回值对应 msg_log.msg_phone
     *
     * @mbg.generated
     */
    public Long getMsgPhone() {
        return msgPhone;
    }

    /**
     * 手机号码<br/>
     * msg_log.msg_phone
     *
     * @param msgPhone 值对应 msg_log.msg_phone
     *
     * @mbg.generated
     */
    public void setMsgPhone(Long msgPhone) {
        this.msgPhone = msgPhone;
    }

    /**
     * 发送短信时间<br/>
     * 返回值对应的表列名 msg_log.msg_time
     *
     * @return 返回值对应 msg_log.msg_time
     *
     * @mbg.generated
     */
    public Date getMsgTime() {
        return msgTime;
    }

    /**
     * 发送短信时间<br/>
     * msg_log.msg_time
     *
     * @param msgTime 值对应 msg_log.msg_time
     *
     * @mbg.generated
     */
    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    /**
     * 发送状态 1 成功 2 失败<br/>
     * 返回值对应的表列名 msg_log.msg_status
     *
     * @return 返回值对应 msg_log.msg_status
     *
     * @mbg.generated
     */
    public Integer getMsgStatus() {
        return msgStatus;
    }

    /**
     * 发送状态 1 成功 2 失败<br/>
     * msg_log.msg_status
     *
     * @param msgStatus 值对应 msg_log.msg_status
     *
     * @mbg.generated
     */
    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    /**
     * 短信平台 1建周 2 亿美<br/>
     * 返回值对应的表列名 msg_log.msg_platform
     *
     * @return 返回值对应 msg_log.msg_platform
     *
     * @mbg.generated
     */
    public String getMsgPlatform() {
        return msgPlatform;
    }

    /**
     * 短信平台 1建周 2 亿美<br/>
     * msg_log.msg_platform
     *
     * @param msgPlatform 值对应 msg_log.msg_platform
     *
     * @mbg.generated
     */
    public void setMsgPlatform(String msgPlatform) {
        this.msgPlatform = msgPlatform;
    }

    /**
     * 类型   1 : 注册 2 : 找回密码  3：忘记密码 4：提现 ，5：修改登录手机号<br/>
     * 返回值对应的表列名 msg_log.msg_type
     *
     * @return 返回值对应 msg_log.msg_type
     *
     * @mbg.generated
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * 类型   1 : 注册 2 : 找回密码  3：忘记密码 4：提现 ，5：修改登录手机号<br/>
     * msg_log.msg_type
     *
     * @param msgType 值对应 msg_log.msg_type
     *
     * @mbg.generated
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }


	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	@Override
	public String toString() {
		return "SystemMsgLog [id=" + id + ", msgTitle=" + msgTitle + ", msgCode=" + msgCode + ", msgContent="
				+ msgContent + ", msgPhone=" + msgPhone + ", msgTime=" + msgTime + ", msgStatus=" + msgStatus
				+ ", msgPlatform=" + msgPlatform + ", msgType=" + msgType + "]";
	}

	
	

    
}