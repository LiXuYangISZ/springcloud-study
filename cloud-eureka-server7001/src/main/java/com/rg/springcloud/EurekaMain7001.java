package com.rg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2021/12/24 18:41
 */
@SpringBootApplication
@EnableEurekaServer   //这个是Eureka的Server..
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
