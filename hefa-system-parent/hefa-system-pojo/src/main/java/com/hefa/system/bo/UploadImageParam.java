package com.hefa.system.bo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

public class UploadImageParam {
	@NotBlank(message = "存储空间名称不能为空")
	private String bucketname;
	@NotBlank(message = "文件名不能为空")
	private String filename;
	@NotBlank(message = "文件后缀不能为空")
	private String suffix;
	@NotBlank(message = "文件数据不能为空")
	private String filedata;
	@NotBlank(message = "图片类型不能为空")
	private Integer plattype;
	@NotBlank(message = "平台类型不能为空")
	private Integer imagetype;
	public String getBucketname() {
		return bucketname;
	}
	public void setBucketname(String bucketname) {
		this.bucketname = bucketname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getFiledata() {
		return filedata;
	}
	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}
	public Integer getPlattype() {
		return plattype;
	}
	public void setPlattype(Integer plattype) {
		this.plattype = plattype;
	}
	public Integer getImagetype() {
		return imagetype;
	}
	public void setImagetype(Integer imagetype) {
		this.imagetype = imagetype;
	}
	public UploadImageParam(String bucketname, String filename, String suffix, String filedata, Integer plattype,
			Integer imagetype) {
		super();
		this.bucketname = bucketname;
		this.filename = filename;
		this.suffix = suffix;
		this.filedata = filedata;
		this.plattype = plattype;
		this.imagetype = imagetype;
	}
	public UploadImageParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
