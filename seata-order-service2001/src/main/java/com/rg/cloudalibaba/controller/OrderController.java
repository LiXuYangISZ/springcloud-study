package com.rg.cloudalibaba.controller;

import com.rg.cloudalibaba.domain.CommonResult;
import com.rg.cloudalibaba.domain.Order;
import com.rg.cloudalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 17:59
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order){
        System.out.println("===============");
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }
}
