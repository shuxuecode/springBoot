package com.zsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemoService {

    @Autowired
    DemoService2 demoService2;

    public String uuid() {
        return UUID.randomUUID().toString();
    }
}
