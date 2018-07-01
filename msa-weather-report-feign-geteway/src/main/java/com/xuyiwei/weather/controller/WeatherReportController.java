package com.xuyiwei.weather.controller;

import com.xuyiwei.weather.service.DataClientService;
import com.xuyiwei.weather.vo.City;
import com.xuyiwei.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* Weather Report Controller.
*
* @since 1.0.0 2017年11月24日
* @author <a href="https://waylau.com">Way Lau</a>
*/
@RestController
@RequestMapping("/report")
public class WeatherReportController {
   private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

   @Autowired
   private DataClientService dataClientService;

   @GetMapping("/cityId/{cityId}")
   public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
       // 获取城市ID列表
       // TODO 改为由城市数据API微服务来提供数据
       List<City> cityList = null;

       try {

           // TODO 改为由城市数据API微服务提供数据
           cityList = dataClientService.listCity();
//			cityList = new ArrayList<>();
       } catch (Exception e) {
           logger.error("Exception!", e);
       }

       model.addAttribute("title", "老卫的天气预报");
       model.addAttribute("cityId", cityId);
       model.addAttribute("cityList", cityList);
       WeatherResponse weatherResponse = dataClientService.getDataByCityId(cityId);
       model.addAttribute("report", weatherResponse.getData());
       return new ModelAndView("weather/report", "reportModel", model);
   }

}
