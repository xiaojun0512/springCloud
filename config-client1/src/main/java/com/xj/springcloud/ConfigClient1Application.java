package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class ConfigClient1Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient1Application.class,args);
        log.info("==============================ConfigClient1启动成功==============================");
    }
}
