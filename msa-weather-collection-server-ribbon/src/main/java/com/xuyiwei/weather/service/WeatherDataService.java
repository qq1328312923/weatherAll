package com.xuyiwei.weather.service;

import com.xuyiwei.weather.vo.City;

import java.util.List;


/**
 * City Data Service.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface WeatherDataService {


	/**
	 * 根据城市ID来同步天气
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);

}
