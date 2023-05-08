package com.example.springboot270;

import com.example.springboot270.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @date 2023/5/8
 */

@SpringBootTest
public class UnitTest {

    @Autowired
    TestService testService;


    @Test
    public void test01() throws Exception {
        testService.retryTest();
    }

    @Test
    public void test02() throws Exception {
        testService.testRetry();
    }

}
