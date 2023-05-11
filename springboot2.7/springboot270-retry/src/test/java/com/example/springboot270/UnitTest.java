package com.example.springboot270;

import com.example.springboot270.service.TestService;
import com.example.springboot270.utils.ThreadExecutor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @date 2023/5/8
 */

@SpringBootTest
public class UnitTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitTest.class);

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

    @Test
    void test03() throws InterruptedException, ExecutionException, TimeoutException {
        Future<String> future = ThreadExecutor.submit(() -> {
            LOGGER.info("UnitTest thread pool test run {}", "...");
            return String.valueOf("123");
        });

        String res = future.get(1L, TimeUnit.SECONDS);

        System.out.println(res);

        TimeUnit.SECONDS.sleep(3L);
    }
}
