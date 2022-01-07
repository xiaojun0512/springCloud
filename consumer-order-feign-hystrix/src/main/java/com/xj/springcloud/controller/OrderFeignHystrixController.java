package com.xj.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xj.springcloud.service.OrderFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("orderFeignHystrix")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallBack") //全局异常方法
public class OrderFeignHystrixController {

    @Resource
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("timeOut")
    //客户端服务降级
//    @HystrixCommand(fallbackMethod = "timeOutHystrix",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //超时
//    })
    @HystrixCommand
    public String timeOut(@RequestParam("id") String id){
        return orderFeignHystrixService.timeOut(id);
    }

    public String timeOutHystrix(@RequestParam("id") String id){
        return "超时";
    }

    /**
     * 全局fallbackMethod
     * @return
     */
    public String defaultFallBack(){
        return "全局异常";
    }

    @GetMapping("get")
    public String get(@RequestParam("id") String id){
        return orderFeignHystrixService.get(id);
    }
}
