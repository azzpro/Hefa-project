package com.hefa.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefa.client.service.DemoClientService;

@RestController
@RequestMapping("client")
public class DemoClientController {

	@Autowired
	private DemoClientService demoService;
	
	@RequestMapping(value = "getName",method = RequestMethod.GET)
	public String getName(@RequestParam("args") String args) {
		return demoService.getName(args);
	}
}
