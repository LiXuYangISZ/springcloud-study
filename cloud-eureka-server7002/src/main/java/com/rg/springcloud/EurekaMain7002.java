package com.rg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2021/12/25 10:23
 */
@SpringBootApplication
@EnableEurekaServer   //这个是Eureka的Server..
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }

}
