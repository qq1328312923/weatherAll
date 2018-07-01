package com.xuyiwei.weather.service;

import com.xuyiwei.weather.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * City Data Service.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@FeignClient("micro-weather-city-eureka-client")
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
