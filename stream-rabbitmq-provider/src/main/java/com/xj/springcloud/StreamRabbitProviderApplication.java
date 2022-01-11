package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StreamRabbitProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitProviderApplication.class,args);
        log.info("==============================StreamRabbitProvider启动成功==============================");
    }
}
