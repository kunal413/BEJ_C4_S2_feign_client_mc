package com.niit.jap.demoAPIGatWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoApiGatWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiGatWayApplication.class, args);
	}

}
