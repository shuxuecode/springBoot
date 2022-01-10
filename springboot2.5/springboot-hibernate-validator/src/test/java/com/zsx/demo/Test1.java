package com.zsx.demo;

import com.alibaba.fastjson.JSON;
import com.zsx.demo.service.DemoService;
import com.zsx.demo.service.test.DemoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @date 2022/1/10
 */
@SpringBootTest(classes = {SpringbootHibernateValidatorApplication.class})
public class Test1 {

    @Autowired
    DemoService<String, String> demoService;

    @Test
    void t1() {
        System.out.println(8899);
        demoService.test("8899");
    }
}
