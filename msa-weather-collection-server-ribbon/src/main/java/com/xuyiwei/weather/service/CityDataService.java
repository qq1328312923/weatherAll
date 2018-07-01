package com.xuyiwei.weather.service;

import com.xuyiwei.weather.vo.City;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * City Data Service.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */


	List<City> listCity(String url) throws Exception;
}
