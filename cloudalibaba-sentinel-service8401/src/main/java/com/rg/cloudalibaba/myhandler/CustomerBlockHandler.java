package com.rg.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rg.springcloud.pojo.CommonResult;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/30 10:02
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(2020, "自定义的限流处理信息handlerException1......CustomerBlockHandler");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(2020, "自定义的限流处理信息handlerException2......CustomerBlockHandler");
    }
}
