package com.xuyiwei.weather.service;

import java.util.ArrayList;
import java.util.List;

import com.xuyiwei.weather.vo.City;
import com.xuyiwei.weather.vo.Forecast;
import com.xuyiwei.weather.vo.Weather;
import com.xuyiwei.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月26日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Weather getDataByCityId(String cityId) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//		ParameterizedTypeReference<WeatherResponse> typeRef = new ParameterizedTypeReference<WeatherResponse>() {};
//		ResponseEntity<WeatherResponse> responseEntity  = restTemplate.exchange("http://MICRO-WEATHER-DATA-EUREKA-CLIENT/weather/cityId/"+cityId, HttpMethod.GET,new HttpEntity<String>(headers),typeRef);
// 		String stuteCode = responseEntity.getStatusCode().toString();
//		WeatherResponse WeatherResponse = responseEntity.getBody();
		WeatherResponse weatherResponse = restTemplate.getForObject("http://MICRO-WEATHER-DATA-EUREKA-CLIENT/weather/cityId/"+cityId,WeatherResponse.class);
		Weather weather = weatherResponse.getData();
		return weather;
	}

}
