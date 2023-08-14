package com.example.springboot270.service;

import com.example.springboot270.config.anno.TestAnno;
import com.example.springboot270.req.DemoReq;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @date 2023/8/14
 */
@Service
public class DemoService {


    @TestAnno
    public String getUuid(DemoReq req) {
        return UUID.randomUUID().toString();
    }

}
