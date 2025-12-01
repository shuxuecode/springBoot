package com.springboot335.springboot335.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("Exception occurred in async method: " + method.getName());
        System.out.println("Exception message: " + ex.getMessage());
        // 可以在这里添加日志记录或其他处理逻辑
        log.error("Exception occurred in async method: " + method.getName(), ex);
    }
}
