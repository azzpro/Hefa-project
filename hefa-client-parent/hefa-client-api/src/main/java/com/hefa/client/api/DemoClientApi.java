package com.hefa.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="hefa-client-service")
public interface DemoClientApi {
	
	@GetMapping("/client/getName")
	String getName(@RequestParam("args") String args);
}
