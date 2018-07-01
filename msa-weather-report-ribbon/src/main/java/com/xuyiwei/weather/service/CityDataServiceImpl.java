package com.xuyiwei.weather.service;

import com.xuyiwei.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        List<City> citys =  restTemplate.getForObject(url,List.class);
//        HttpHeaders headers = new HttpHeaders();
//        ParameterizedTypeReference<List<City>> typeRef = new ParameterizedTypeReference<List<City>>() {};
//        ResponseEntity<List<City>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), typeRef);
//        List<City> citys = responseEntity.getBody();

        return citys;
    }

}
