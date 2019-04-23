package com.hefa.order.platform.bo;

import com.hefa.common.page.QueryPage;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PayOrderListParam extends QueryPage{
 
	private String param; //页面查询参数
}
