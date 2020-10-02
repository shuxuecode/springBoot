package com.zsx.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class NettyServer {


    @PostConstruct
    private void init() {
        System.out.println("PostConstruct");
        this.start();
    }

    private void start() {
        System.out.println("start");
    }


}
