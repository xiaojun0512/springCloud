package com.xj.springcloud.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("orderConsul")
@Api(tags = "orderConsul数据接口")
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("paymentInfo")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL + "/paymentConsul/paymentConsul", String.class);
    }

}
