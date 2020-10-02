package com.zsx.controller;

import com.zsx.service.NettyClient;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    @Autowired
    private NettyClient nettyClient;

    @GetMapping("/")
    public String t() {
        Channel channel = nettyClient.getChannel();
        if (channel != null && channel.isActive()) {
            channel.writeAndFlush(System.currentTimeMillis() + "\r\n");
        }
        return UUID.randomUUID().toString();
    }

}
