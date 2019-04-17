package com.hefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@RestController
@EnableFeignClients
public class HefaClientServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "true");
		 SpringApplication.run(HefaClientServiceApplication.class, args);
	}
	
	/**
	 * 开启consul健康检查
	 * @return
	 */
	@GetMapping("/health")
	public String health() {
		return "HefaClientService";
	}
}
