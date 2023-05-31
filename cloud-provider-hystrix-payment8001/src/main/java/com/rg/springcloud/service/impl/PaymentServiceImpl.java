package com.rg.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rg.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/3 11:29
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问,返回OK
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:  "+Thread.currentThread().getName()+" paymentInfo_OK,id:   "+id+"O(∩_∩)O哈哈哈~~~";
    }

    /**
     * 超时访问
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {

        int timeNumber = 5;
        // int a  =  10 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " paymentInfo_TimeOUt,id:   " + id + "O(∩_∩)O哈哈哈~~~" + "耗时(秒):" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:  " + Thread.currentThread().getName() + " 8001系统繁忙或者运行报错,请稍后再试,id: " + id + "\t"+"o(╥﹏╥)o呜呜呜"  ;
    }

    //===服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数  当在配置时间窗口内达到此数量的失败后，进行短路。默认20个
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期,也等于短路多久以后开始尝试是否恢复的时间. 默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//出错百分比阈值,失败率达到此阈值后，开始短路跳闸。默认50%
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("*******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号:"+serialNumber;

    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试,o(╥﹏╥)o id:"+id;
    }
}
