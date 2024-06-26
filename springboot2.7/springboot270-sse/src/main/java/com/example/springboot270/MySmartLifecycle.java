package com.example.springboot270;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @date 2022/10/19
 */
// todo zsx  

@Component
public class MySmartLifecycle implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("MySmartLifecycle start");
    }

    @Override
    public void stop() {
        System.out.println("MySmartLifecycle stop");

    }

    @Override
    public boolean isRunning() {
        System.out.println("MySmartLifecycle isRunning");
        return false;
    }

    @Override
    public boolean isAutoStartup() {
        System.out.println("MySmartLifecycle isAutoStartup");
        return SmartLifecycle.super.isAutoStartup();
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("MySmartLifecycle stop");
        callback.run();
    }

    @Override
    public int getPhase() {
        System.out.println("MySmartLifecycle getPhase");
        // 返回阶段，决定启动和停止的顺序
        return 0;
    }
}
