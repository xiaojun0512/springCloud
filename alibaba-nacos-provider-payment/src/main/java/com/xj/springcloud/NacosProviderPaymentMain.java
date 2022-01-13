package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NacosProviderPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPaymentMain.class,args);
        log.info("==============================NacosProviderPayment启动成功==============================");
    }
}
