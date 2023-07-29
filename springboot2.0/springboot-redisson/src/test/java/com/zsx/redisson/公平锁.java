package com.zsx.redisson;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class 公平锁 {

    // todo xue
    @Test
    public void test01() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(config);

        RLock fairLock = client.getFairLock("anyLock");

        fairLock.lock();

        fairLock.unlock();

        fairLock.lock(5, TimeUnit.SECONDS);

        try {
            boolean tryLock = fairLock.tryLock(10, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
