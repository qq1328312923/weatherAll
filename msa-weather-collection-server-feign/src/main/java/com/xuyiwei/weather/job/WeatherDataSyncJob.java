package com.xuyiwei.weather.job;

import com.xuyiwei.weather.service.CityDataService;
import com.xuyiwei.weather.service.WeatherDataService;
import com.xuyiwei.weather.vo.City;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xuyiwei on 2018/6/29.
 */
@Component
public class WeatherDataSyncJob {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataService weatherDataService;

    @Autowired
    private CityDataService cityDataService;

    @Scheduled(fixedRate = 1000 * 1800)
    public void weatherDataSync(){
        logger.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        List<City> cityList = null;

        try {

            // TODO 改为由城市数据API微服务提供数据
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:" + cityId);

            weatherDataService.syncDateByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End！");
    }
}
