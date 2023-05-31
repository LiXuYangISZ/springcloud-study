package com.rg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/4 10:14
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixFeignMain80.class, args);
    }
}
