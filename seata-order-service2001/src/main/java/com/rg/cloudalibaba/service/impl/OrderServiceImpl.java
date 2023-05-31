package com.rg.cloudalibaba.service.impl;

import com.rg.cloudalibaba.dao.OrderDao;
import com.rg.cloudalibaba.domain.Order;
import com.rg.cloudalibaba.service.AccountService;
import com.rg.cloudalibaba.service.OrderService;
import com.rg.cloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 17:22
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：
     * 下订单->减库存->减余额->改状态
     */
    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order){
        log.info("--------------->下单开始");
        orderDao.create(order);
        //远程调用库存服务扣减库存
        log.info("----------------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----------------->order-service中扣减库存结束");

        //远程调用账户服务扣减余额
        log.info("----------------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----------------->order-service中扣减余额结束");

        //修改订单状态
        log.info("----------------->order-service中修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("----------------->order-service中修改订单状态结束");
        log.info("--------------->下单结束");
    }


}
