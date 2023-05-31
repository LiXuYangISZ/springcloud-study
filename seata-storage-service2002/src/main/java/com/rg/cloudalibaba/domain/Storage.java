package com.rg.cloudalibaba.domain;

import lombok.Data;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 19:22
 */
@Data
public class Storage {
    private Long id;
    //产品id
    private Long productId;
    //总库存
    private Integer total;
    //已用库存
    private Integer used;
    //剩余库存
    private Integer residue;
}
