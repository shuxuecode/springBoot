package com.springboot335.springboot335.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("Custom-Async-");
        executor.initialize();
        return executor;
    }

    //@Override
    //public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    //    return new CustomAsyncExceptionHandler();
    //}

    /**
     * 自定义异步异常处理器
     * <p>
     * ***注意***：AsyncUncaughtExceptionHandler 只能处理返回类型为 void 的异步方法中未被捕获的异常。
     * ***注意***：AsyncUncaughtExceptionHandler 只能处理返回类型为 void 的异步方法中未被捕获的异常。
     * ***注意***：AsyncUncaughtExceptionHandler 只能处理返回类型为 void 的异步方法中未被捕获的异常。
     *
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            System.out.println("Exception occurred in async method: " + method.getName() + ", params: " + params + ", message: " + ex.getMessage());
        };
    }

}