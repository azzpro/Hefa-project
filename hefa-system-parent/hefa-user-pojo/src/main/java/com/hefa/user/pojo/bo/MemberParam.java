package com.hefa.user.pojo.bo;

import com.hefa.common.page.QueryPage;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MemberParam extends QueryPage{

	private String startTime;//搜索开始时间
	private String endTime;//搜索结束时间
	private String meberNumber;//搜索会员编码
}
