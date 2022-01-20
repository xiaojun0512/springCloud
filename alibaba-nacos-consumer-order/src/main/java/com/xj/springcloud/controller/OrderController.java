package com.xj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xj.springcloud.service.PaymentService;
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

    @Resource
    private PaymentService paymentService;

    @GetMapping("getNacosPort")
    public String getNacosPort(@RequestParam("name") String name){
        return restTemplate.getForObject(serverUrl + "/nacos/getNacosPort?name=" + name,String.class);
    }

    @GetMapping("sentinelPort")
//    @SentinelResource(value = "sentinelPort",fallback = "errSentinelPort1")   //运行异常
//    @SentinelResource(value = "sentinelPort",blockHandler = "errSentinelPort")  //配置sentinel异常
    @SentinelResource(value = "sentinelPort",blockHandler = "errSentinelPort",fallback = "errSentinelPort1")  //两个同时配置，都满足时报sentinel异常
    public String sentinelPort(@RequestParam("name") String name){
        return restTemplate.getForObject(serverUrl + "/nacos/getNacosPort?name=" + name,String.class);
    }

    @GetMapping("errSentinelPort")
    public String errSentinelPort(@RequestParam("name") String name,BlockException e) {
        return "配置异常=" + name + " 400;" + UUID.randomUUID().toString();
    }

    @GetMapping("errSentinelPort1")
    public String errSentinelPort1(@RequestParam("name") String name,Throwable e) {
        return "运行异常=" + name + " 400;" + UUID.randomUUID().toString();
    }

    @GetMapping("getFeignNacosPort")
    public String getFeignNacosPort(@RequestParam("name") String name){
        return paymentService.getNacosPort(name);
    }
}
