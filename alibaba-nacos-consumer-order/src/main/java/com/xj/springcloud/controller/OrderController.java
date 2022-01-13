package com.xj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Value("${nacosprovider.url}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("getNacosPort")
    public String getNacosPort(@RequestParam("name") String name){
        return restTemplate.getForObject(serverUrl + "/nacos/getNacosPort?name=" + name,String.class);
    }
}
