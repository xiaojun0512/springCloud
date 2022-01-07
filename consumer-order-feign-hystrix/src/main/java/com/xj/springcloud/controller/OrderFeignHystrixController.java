package com.xj.springcloud.controller;


import com.xj.springcloud.service.OrderFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("orderFeignHystrix")
@Slf4j
public class OrderFeignHystrixController {

    @Resource
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("timeOut")
    public String timeOut(){
        return orderFeignHystrixService.timeOut();
    }

    @GetMapping("get")
    public String get(){
        return orderFeignHystrixService.get();
    }
}
