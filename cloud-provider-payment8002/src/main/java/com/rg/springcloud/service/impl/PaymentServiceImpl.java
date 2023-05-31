package com.rg.springcloud.service.impl;

import com.rg.springcloud.dao.PaymentDao;
import com.rg.springcloud.pojo.Payment;
import com.rg.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lxy
 * @version 1.0
 * @Description PaymentService实现类
 * @date 2021/12/23 11:25
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
