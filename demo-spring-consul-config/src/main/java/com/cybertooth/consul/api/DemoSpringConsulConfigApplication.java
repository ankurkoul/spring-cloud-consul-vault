package com.cybertooth.consul.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value=MyConfig.class)
public class DemoSpringConsulConfigApplication {

	@Autowired
	 private MyConfig myConfig;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringConsulConfigApplication.class, args);
	}

	@GetMapping("/getConfig")
	public MyConfig getConfig() {
		return this.myConfig;
	}
}
