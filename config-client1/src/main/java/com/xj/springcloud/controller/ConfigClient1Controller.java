package com.xj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("configClient")
@RefreshScope
public class ConfigClient1Controller {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("getConfigInfo")
    public String getConfigInfo(){
        return configInfo+"\t"+serverPort;
    }
}
