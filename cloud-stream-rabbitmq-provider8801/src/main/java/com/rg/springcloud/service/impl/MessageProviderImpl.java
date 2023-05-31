package com.rg.springcloud.service.impl;

import com.rg.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/19 20:58
 */
@EnableBinding(Source.class)//可以理解为是一个消息的发送管道的定义
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serial).build());//创建并发送消息
        log.info("*****serial:{}",serial);
        return serial;
    }
}
