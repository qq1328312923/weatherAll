package com.xuyiwei.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsaWeatherCollectionServerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaWeatherCollectionServerFeignApplication.class, args);
	}
}
