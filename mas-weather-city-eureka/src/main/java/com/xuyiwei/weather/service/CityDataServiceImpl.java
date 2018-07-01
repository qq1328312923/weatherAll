package com.xuyiwei.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xuyiwei.weather.util.XmlBuilder;
import com.xuyiwei.weather.vo.City;
import com.xuyiwei.weather.vo.CityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/**
 * City Data Service.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class CityDataServiceImpl implements CityDataService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public List<City> listCity() throws Exception {
		if(stringRedisTemplate.hasKey("citys")){
			List<City> list = (List<City>) JSON.parse(stringRedisTemplate.opsForValue().get("citys"));
			return list;
		}else{
            // 读取XML文件
			Resource resource = new ClassPathResource("citylist.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";

			while ((line = br.readLine()) !=null) {
				buffer.append(line);
			}

			br.close();

			// XML转为Java对象
			CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
			List<City> list =  cityList.getCityList();
			String json = JSON.toJSONString(list);
			stringRedisTemplate.opsForValue().set("citys",json);
			return list;
		}

	}

}
