package com.hefa.client.service;

import org.springframework.stereotype.Service;

@Service
public class DemoClientService {
	
	public String getName(String args) {
		return args;
	}
}
