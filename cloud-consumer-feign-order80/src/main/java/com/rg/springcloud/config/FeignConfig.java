package com.rg.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.Log;


/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/2 16:51
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
