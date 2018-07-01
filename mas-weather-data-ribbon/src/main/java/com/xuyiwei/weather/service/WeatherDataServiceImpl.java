package com.xuyiwei.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuyiwei.weather.vo.WeatherResponse;
 import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by xuyiwei on 2018/6/29.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    private static final long TIME_OUT = 1800L; // 1800s

    @Autowired
    private RestTemplate normalRestTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URI+"?citykey="+cityId;
        return doGetWeather(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URI+"?city="+cityName;
        return doGetWeather(url);
    }

    /**
     * 发送http请求得到天气数据
     * @param url
     * @return
     */
    private WeatherResponse doGetWeather(String url) {
        String body = null;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String,String> oop = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(url)){
            body = oop.get(url);
        }else{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            body =  normalRestTemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
            oop.set(url,body);
        }

        WeatherResponse weatherResponse = null;
        try {
            //字符串转对象
            weatherResponse = mapper.readValue(body, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;

    }
}
