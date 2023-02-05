package com.zsx.springbootspringevent.config;

import com.zsx.springbootspringevent.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 事件监听器
 * <p>
 * 实现ApplicationListener接口，指定监听的事件类型
 *
 * @date 2022/7/20
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

    private static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1000);
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 300, TimeUnit.SECONDS, queue);


    //@Override
    //public void onApplicationEvent(TestEvent event) {
    //    String msg = event.getMsg();
    //    //System.out.println("TestListener msg = " + msg);
    //
    //    try {
    //        TimeUnit.SECONDS.sleep(1);
    //    } catch (InterruptedException e) {
    //        throw new RuntimeException(e);
    //    }
    //
    //    LOGGER.info("TestListener msg = {}", msg);
    //
    //}

    @Override
    public void onApplicationEvent(TestEvent event) {
        String msg = event.getMsg();
        LOGGER.info("TestListener get msg = {}", msg);
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            LOGGER.info("TestListener async msg = {}", msg);
        }, threadPool);

    }
}
