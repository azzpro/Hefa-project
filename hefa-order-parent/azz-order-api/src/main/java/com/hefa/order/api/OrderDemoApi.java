package com.hefa.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hefa-order-service")
public interface OrderDemoApi {

	@RequestMapping(value = "/order/getAge",method = RequestMethod.GET)
	String getAge(@RequestParam("age") String age);
}
