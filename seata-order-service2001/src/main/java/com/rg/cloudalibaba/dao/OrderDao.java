package com.rg.cloudalibaba.dao;

import com.rg.cloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 17:07
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
