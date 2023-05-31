package com.rg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/2 15:29
 */
@SpringBootApplication
@EnableFeignClients  //激活Feign组件
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
