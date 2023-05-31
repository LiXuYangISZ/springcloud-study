package com.rg.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/2/1 18:34
 */
@Configuration
@MapperScan({"com.rg.cloudalibaba.dao"})
public class MyBatisConfig {
}
