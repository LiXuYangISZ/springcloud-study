package com.rg.springcloud.service;

import com.rg.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author lxy
 * @version 1.0
 * @Description PaymentService
 * @date 2021/12/23 11:24
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
