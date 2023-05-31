package com.rg.cloudalibaba.service;

import com.rg.springcloud.pojo.CommonResult;
import com.rg.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/30 12:57
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult <Payment> paymentSQL(Long id) {
        return new CommonResult <>(444, "服务降级返回,没有该流水信息", new Payment(id, "errorSerial"));
    }
}
