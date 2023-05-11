package com.example.springboot270.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * @date 2023/5/11
 */
@Component
public final class ThreadExecutor implements InitializingBean {


    private static ThreadExecutor instance;


    @Autowired
    private final Map<String, ThreadPoolTaskExecutor> threadPoolMap = new ConcurrentHashMap<>();

    public ThreadExecutor() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
        System.out.println(threadPoolMap.size());
    }

    public static <V> Future<V> submit(Callable<V> callable) {
        if (callable == null) {
            throw new RuntimeException("callable is null");
        }

        ThreadPoolTaskExecutor executor = instance.threadPoolMap.get("test");
        if (executor == null) {
            throw new RuntimeException("not Found thread pool instance");
        }

        return executor.submit(callable);
    }

}
