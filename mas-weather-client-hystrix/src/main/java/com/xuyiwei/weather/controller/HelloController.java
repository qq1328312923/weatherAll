package com.xuyiwei.weather.controller;

 import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
 import com.xuyiwei.weather.service.CityDataService;
import com.xuyiwei.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xuyiwei on 2018/7/1.
 */
@RestController
public class HelloController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping("hello")
    @HystrixCommand(fallbackMethod = "defaultCities")
    public String listCity() throws Exception {
        // 通过Feign客户端来查找
        List<City> cityList = cityDataService.listCity();
        return "你好";
    }

    public String defaultCities() {
        return "City Data Server is down!";
    }
}
