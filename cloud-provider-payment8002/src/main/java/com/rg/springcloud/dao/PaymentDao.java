package com.rg.springcloud.dao;

import com.rg.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lxy
 * @version 1.0
 * @Description 支付dao类
 * @date 2021/12/23 11:06
 */
@Mapper
@Repository
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
