package com.rg.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/29 14:29
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        // try {
        //     TimeUnit.MILLISECONDS.sleep(800);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "---------------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info("*****************testB");
        return "---------------testB";

    }

    @GetMapping("/testD")
    public String testD(){
        // try {
        //     TimeUnit.MILLISECONDS.sleep(800);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        log.info("*****************testD");
        int age = 10 / 0;
        return "---------------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
    @RequestParam(value = "p2",required = false) String p2){
        return "------------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception){
        return "------------dealHandler_testHotKey";
    }

}
