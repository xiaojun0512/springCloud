package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StreamRabbitConsumer1Application {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumer1Application.class,args);
        log.info("==============================StreamRabbitConsumer1启动成功==============================");
    }
}
