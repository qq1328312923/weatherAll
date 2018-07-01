package com.xuyiwei.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MasWeatherCityEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasWeatherCityEurekaApplication.class, args);
	}
}
