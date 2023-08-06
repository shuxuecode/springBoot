package com.zsx.redisson;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class 可重入锁 {


    @Test
    public void test1() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(config);

        // 获取锁
        RLock lock = client.getLock("anyLock");

        try {
            lock.lock();
        } finally {
            // 释放锁
            lock.unlock();
        }


        // 支持自动过期解锁
        // 5秒后自动解锁，无需调用unlock方法手动解锁


        try {
            // 尝试加锁，最多等待10秒，上锁以后5秒后自动解锁
            boolean tryLock = lock.tryLock(10, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }


    }

    @Test
    public void 异步执行测试() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(config);

        RLock lock = client.getLock("anyLock");
        lock.lockAsync();
        // 5秒钟以后自动解锁
        lock.lockAsync(5, TimeUnit.SECONDS);
        // 尝试加锁，最多等待10秒，上锁以后5秒自动解锁
        RFuture<Boolean> future = lock.tryLockAsync(10, 5, TimeUnit.SECONDS);

        // 回调方法
        future.whenComplete((res, ex) -> {
            if (ex != null) {
                // 加锁失败，处理异常
                ex.printStackTrace();
            } else {
                try {
                    // 执行加锁成功后的业务逻辑
                    System.out.println("加锁成功，开始执行业务逻辑...");
                    Thread.sleep(2000);
                    System.out.println("业务逻辑执行完成，释放锁...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        });


    }

}
