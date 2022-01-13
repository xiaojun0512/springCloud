package com.xj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("config")
@RefreshScope   //支持nacos动态刷新功能
@Slf4j
public class NacosConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("getConfigInfo")
    public String getConfigInfo(@RequestParam("name") String name){
        return configInfo + ";name:" + name + UUID.randomUUID().toString();
    }
}
