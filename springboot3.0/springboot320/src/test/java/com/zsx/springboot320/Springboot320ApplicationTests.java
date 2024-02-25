package com.zsx.springboot320;

import com.zsx.springboot320.dto.RequestDTO;
import com.zsx.springboot320.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Springboot320ApplicationTests {


    @Autowired
    DemoService demoService;

    @Test
    void contextLoads() {
        RequestDTO request = new RequestDTO();

        request.setName("test");
        request.setId(123);

        demoService.getNow(request);
    }

}
