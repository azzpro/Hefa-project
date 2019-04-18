package com.hefa.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@RestController
public class HefaConfigServerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(HefaConfigServerApplication.class, args);
	}
	
	/**
	 * 开启consul健康检查
	 * @return
	 */
	@GetMapping("/health")
	public String health() {
		return "HefaConfigServer";
	}
}
