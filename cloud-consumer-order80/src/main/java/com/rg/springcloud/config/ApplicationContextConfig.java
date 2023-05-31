package com.rg.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2021/12/24 11:12
 */
@Configuration
public class ApplicationContextConfig {
    //向SpringBoot容器中加入该组件
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
