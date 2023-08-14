package com.example.springboot270;

import com.example.springboot270.req.DemoReq;
import com.example.springboot270.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot270ApplicationTests {


    @Autowired
    DemoService demoService;


    @Test
    void t1() {
        DemoReq req = new DemoReq();
        req.setId(1);
        req.setName("test");

        demoService.getUuid(req);
    }


    @Test
    void contextLoads() {
    }

}
