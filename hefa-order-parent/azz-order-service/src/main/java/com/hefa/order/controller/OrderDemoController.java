package com.hefa.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.order.service.OrderDemoService;

@RestController
@RequestMapping("order")
public class OrderDemoController {

	@Autowired
	private OrderDemoService orderDemoService;
	
	@RequestMapping("getAge")
	public String getAge(@RequestParam("age") String age) {
		return orderDemoService.getAge(age);
	}
}
