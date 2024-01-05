package com.zsx.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class DemoService2 {

    public String uuid() {
        return UUID.randomUUID().toString();
    }
}
