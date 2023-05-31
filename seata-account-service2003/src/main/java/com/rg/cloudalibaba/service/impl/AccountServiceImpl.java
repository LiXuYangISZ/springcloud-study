package com.rg.cloudalibaba.service.impl;

import com.rg.cloudalibaba.dao.AccountDao;
import com.rg.cloudalibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginContext;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 20:40
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("-------------------account-service扣减账号余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountDao.decrease(userId, money);
        log.info("-------------------account-service扣减账号余额结束");
    }
}
