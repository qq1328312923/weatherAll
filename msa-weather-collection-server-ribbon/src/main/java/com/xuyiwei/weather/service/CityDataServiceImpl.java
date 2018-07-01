package com.xuyiwei.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuyiwei.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * City Data Service.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月23日
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<City> listCity(String url) {
//        List<City> citys =  restTemplate.getForObject(url,List.class);
        HttpHeaders headers = new HttpHeaders();
        ParameterizedTypeReference<List<City>> typeRef = new ParameterizedTypeReference<List<City>>() {};
        ResponseEntity<List<City>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), typeRef);
        List<City> citys = responseEntity.getBody();

//        String citys =  restTemplate.getForObject(url,String.class);
//        ObjectMapper  objectMapper = new ObjectMapper();
//        List<City> cityLis = new ArrayList<>();
//        try {
//            cityLis = objectMapper.readValue(citys,List.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return citys;
    }

}
