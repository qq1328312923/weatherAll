package com.xuyiwei.weather.service;

import com.xuyiwei.weather.vo.WeatherResponse;

/**
 * Created by xuyiwei on 2018/6/29.
 */
public interface WeatherDataService {

    /**
     * 根据城市id来获得该城市的天气服务数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称来获得该城市的天气服务数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
