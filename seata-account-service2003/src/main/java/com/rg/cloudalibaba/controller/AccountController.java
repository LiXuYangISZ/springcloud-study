package com.rg.cloudalibaba.controller;

import com.rg.cloudalibaba.domain.CommonResult;
import com.rg.cloudalibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 20:45
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200, "扣减账号余额成功!");
    }

}
