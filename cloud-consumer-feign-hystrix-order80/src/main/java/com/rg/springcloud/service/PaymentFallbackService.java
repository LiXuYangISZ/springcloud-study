package com.rg.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/4 21:35
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_Timeout,o(╥﹏╥)o";
    }


}
