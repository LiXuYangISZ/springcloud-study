package com.rg.cloudalibaba.service.impl;

import com.rg.cloudalibaba.dao.StorageDao;
import com.rg.cloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 19:37
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------------------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------------------------->storage-service中扣减库存结束");
    }
}
