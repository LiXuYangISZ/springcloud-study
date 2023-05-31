package com.rg.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lxy
 * @version 1.0
 * @Description 前后端进行交互的结果类
 * @date 2021/12/23 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//状态码
    private String message;//状态信息
    private T data;//返回的json数据

    public CommonResult(Integer code,String message){//失败时调用的方法.
        this(code,message,null);
    }
}
