package com.rg.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2021/12/24 11:13
 */
@RestController
@Slf4j
public class OrderController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    public RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("消费者调用支付服务(consul)--->result:"+result);
        return result;
    }


}
