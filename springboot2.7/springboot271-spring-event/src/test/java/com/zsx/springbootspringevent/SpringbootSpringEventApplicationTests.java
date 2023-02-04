package com.zsx.springbootspringevent;

import com.zsx.springbootspringevent.service.TestService;
import com.zsx.springbootspringevent.service.TestService2;
import com.zsx.springbootspringevent.service.TestServiceAsync;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class SpringbootSpringEventApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(123);
    }

    @Autowired
    TestService testService;

    @Autowired
    TestService2 testService2;

    @Autowired
    TestServiceAsync testServiceAsync;

    @Test
    void t1() {
        testService.publish();
    }

    @Test
    void t2() {
        testService2.publish();
    }

    @Test
    void t3() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final int num = i;
            // 异步并发
            //CompletableFuture.runAsync(() -> {
            //    long start = System.currentTimeMillis();
            //    testServiceAsync.publish("->" + num);
            //    System.out.println("publish 耗时: " + (System.currentTimeMillis() - start));
            //});

            // 同步并发
            long start = System.currentTimeMillis();
            testServiceAsync.publish("->" + num);
            System.out.println("publish 耗时: " + (System.currentTimeMillis() - start));
        }

        Thread.sleep(15000);
    }
}
