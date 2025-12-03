package com.springboot335.springboot335.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TaskService {

    @Async
    public void task2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task2, name={}", Thread.currentThread().getName());

        if (1 == 1) {
            throw new RuntimeException("task1 error"); // 这个异常会被 AsyncUncaughtExceptionHandler 捕获
        }
    }


    @Async
    public CompletableFuture<String> task1(Integer id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task1, name={}", Thread.currentThread().getName());

        if (id == 1) {
            throw new RuntimeException("task1 error");
        }

        return CompletableFuture.completedFuture("task1 + " + id);
    }

}
