package com.hefa.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.api.DemoClientApi;
import com.hefa.order.api.OrderDemoApi;

@RestController
@RequestMapping("order")
public class OriagtaController {
	
	private static final Logger logger = LoggerFactory.getLogger(OriagtaController.class);
	
	@Autowired
	private OrderDemoApi oda;
	
	//@Autowired
	//private DemoClientApi dca;
	
	@RequestMapping(value = "getAge",method = RequestMethod.GET)
	public String getAge(@RequestParam("age") String age) {
		logger.info("aaage ------>{}",oda.getAge(age));
		return oda.getAge(age);
	}
	
	/*@RequestMapping(value = "getName",method = RequestMethod.GET)
	public String getName(@RequestParam("args") String args) {
		logger.info("name------>{}",dca.getName(args));
		return oda.getAge(args);
	}*/
}
