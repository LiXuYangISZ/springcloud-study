package com.rg.springcloud.controller;


import com.rg.springcloud.pojo.CommonResult;
import com.rg.springcloud.pojo.Payment;
import com.rg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @version 1.0
 * @Description PaymentController
 * @date 2021/12/23 11:27
 */

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        // int age = 10 / 2;
        log.info("*****查询结构:{}"+"12344", payment);
        if(payment!=null){
            return new CommonResult(200, "查询成功"+"\t 服务端口" + serverPort, payment);
        }else{
            return new CommonResult(444, "没有对应记录,查询ID:" + id);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentById() {
        return serverPort;
    }


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){ // ??? 为啥这里不需要@RequestBody呢??
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果*:"+result);
        if(result>0) {
            return new CommonResult(200, "插入数据成功", result);
        }else
        {
            return new CommonResult(444, "插入数据失败");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List <String> services = discoveryClient.getServices();//获取Eureka上所有的服务
        for (String service : services) {
            log.info("*****service:"+service);
        }
        //获得某一个服务所有的实例
        List <ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        System.out.println("*****paymentFeignTimeOut from port:"+serverPort);
        //暂停几秒钟线程
        try {
            //暂停几秒钟线程
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;

    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }



}
