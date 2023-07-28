package com.zsx.redisson;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class 可重入锁 {


    @Test
    public void test1() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(config);

        RLock lock = client.getLock("anyLock");

        try {
            lock.lock();
        } finally {
            lock.unlock();
        }

        // 5秒后自动解锁
        lock.lock(5, TimeUnit.SECONDS);


        try {
            // 尝试加锁，最多等待10秒，上锁以后5秒后自动解锁
            boolean tryLock = lock.tryLock(10, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }
    }

}
