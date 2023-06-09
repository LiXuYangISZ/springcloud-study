package com.rg.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.rg.cloudalibaba.service.PaymentService;
import com.rg.springcloud.pojo.CommonResult;
import com.rg.springcloud.pojo.Payment;
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
 * @date 2022/1/30 10:51
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler负责在sentinel里面配置的降级限流
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult <Payment> fallback(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id==4){
            System.out.println("44444444444");
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
        }else if(result.getData()==null){
            System.out.println("111111111111111");
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常...");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback,exception内容:" + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    //========================Sentinel结合OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        // if(id==4){
        //     throw new RuntimeException("没有该id");
        // }
        return paymentService.paymentSQL(id);
    }

}
