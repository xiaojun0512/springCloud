package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@Slf4j
@EnableEurekaServer
public class Eureka1Applicaiton {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1Applicaiton.class,args);
        log.info("==============================Eureka1Server启动成功==============================");
    }
}
