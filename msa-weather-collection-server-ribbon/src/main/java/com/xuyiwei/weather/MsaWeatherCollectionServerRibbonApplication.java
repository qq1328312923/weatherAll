package com.xuyiwei.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaWeatherCollectionServerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaWeatherCollectionServerRibbonApplication.class, args);
	}
}
