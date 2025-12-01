package com.springboot335.springboot335.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TaskService {

    @Async
    public CompletableFuture<String> task1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task1, name={}", Thread.currentThread().getName());
        return CompletableFuture.completedFuture("task1");
    }

}
