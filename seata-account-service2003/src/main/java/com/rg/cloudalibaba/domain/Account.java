package com.rg.cloudalibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    //用户id
    private Long userId;
    //总额度
    private BigDecimal total;
    //已用额度
    private BigDecimal used;
    //剩余额度
    private BigDecimal residue;
}
