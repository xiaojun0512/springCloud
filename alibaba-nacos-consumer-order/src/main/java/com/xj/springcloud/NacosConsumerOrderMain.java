package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class NacosConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrderMain.class,args);
        log.info("==============================NacosConsumerOrder启动成功==============================");
    }
}
