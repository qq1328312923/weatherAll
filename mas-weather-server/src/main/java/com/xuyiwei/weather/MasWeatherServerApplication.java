package com.xuyiwei.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MasWeatherServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasWeatherServerApplication.class, args);
	}
}
