package com.xuyiwei.weather.service;

import com.xuyiwei.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by xuyiwei on 2018/6/29.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    private static final long TIME_OUT = 10L; // 1800s

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate directRestTemplate;

    @Override
    public void syncDateByCityId(String cityId) {

        String uri = WEATHER_URI + "?citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {

        // 调用服务接口来获取
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try{
            ResponseEntity<String> responseEntity  = directRestTemplate.exchange(uri, HttpMethod.GET,entity,String.class);
            String stuteCode = responseEntity.getStatusCode().toString();
            String body = responseEntity.getBody();
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set(uri,body);
        }catch (Exception e){
            logger.error(uri+"该想为空");
        }
    }
}
