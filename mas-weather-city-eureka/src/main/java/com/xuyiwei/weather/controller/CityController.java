package com.xuyiwei.weather.controller;

import java.util.List;

import com.xuyiwei.weather.service.CityDataService;
import com.xuyiwei.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 /**
 * Hello Controller.
 * 
 * @since 1.0.0 2017年11月20日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityDataService cityDataService;
	
	@RequestMapping
	public List<City> listCity() throws Exception {
		System.out.println("1111111");
		return cityDataService.listCity();
	}
}
