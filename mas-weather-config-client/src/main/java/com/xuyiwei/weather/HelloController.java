package com.xuyiwei.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuyiwei on 2018/7/1.
 */
@RestController
public class HelloController
{
    @Value("${myww}")
    private String myww;

    @RequestMapping("hello")
    public String hello(){
        System.out.println(myww);
        return "hello";
    }
}
