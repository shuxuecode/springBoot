package com.example.springboot270.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @date 2023/5/8
 */
@Service
public class TestService {


    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
    public void retryTest() throws Exception {
        System.out.println("开始执行方法retryTest");
        Integer.valueOf("abc");
    }


    /**
     * 下面这种方式无法重试，因为retry使用了Aspect增强，而@Retryable注解的方法的调用方和被调用方都在同一类中，这样就导致了重试失效
     */

    public void testRetry() {
        System.out.println("开始执行方法testRetry");
        this.testRetry2();
    }

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
    public void testRetry2() {
        System.out.println("开始执行方法testRetry2");
        Integer.valueOf("abc");
    }
}
