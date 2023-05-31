package com.rg.cloudalibaba.service;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 19:35
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
