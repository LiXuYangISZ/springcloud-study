package com.rg.cloudalibaba.controller;

import com.rg.cloudalibaba.domain.CommonResult;
import com.rg.cloudalibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 19:43
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200, "扣减库存成功!");
    }
}
