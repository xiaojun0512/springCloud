package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class PaymentZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZookeeperApplication.class,args);
        log.info("==============================PaymentZookeeper启动成功==============================");
    }
}
