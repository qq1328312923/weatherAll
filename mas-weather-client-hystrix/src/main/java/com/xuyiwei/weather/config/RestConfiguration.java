package com.xuyiwei.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Configuration.
 * spring 对于rest的封装
 * @since 1.0.0 2017年11月22日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Configuration
public class RestConfiguration {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	@LoadBalanced //开启负载均衡客户端
	public RestTemplate restTemplate() {
		return builder.build();

    }

	@Bean //直连的restTemplat，这时只能使用http://127.0.0.1:8083//getusername地址，不能解析http://user/getusername
	RestTemplate directRestTemplate() {
		return builder.build();
	}


}
