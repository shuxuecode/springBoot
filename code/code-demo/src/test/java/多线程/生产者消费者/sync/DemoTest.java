package 多线程.生产者消费者.sync;

import org.junit.jupiter.api.Test;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用synchronize wait notify/notifyall实现生产者消费者模式
 */
public class DemoTest {

    public static AtomicInteger atomicInteger = new AtomicInteger();
    public volatile boolean flag = true;
    public static final int max_count = 10;
    public static final List<Integer> pool = new ArrayList<>();

    public void produce() {
        while (flag) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (pool) {

                while (pool.size() == max_count) {
                    System.out.println("队列满了，暂停生产");
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                pool.add(atomicInteger.incrementAndGet());
                System.out.println("生产了 " + atomicInteger.get() + "   当前队列中有 " + pool.size() + " 个");

                pool.notifyAll();
            }
        }
    }

    public void consume() {
        while (flag) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (pool) {

                while (pool.size() == 0) {
                    System.out.println("队列空了，暂停消费");
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Integer num = pool.get(0);
                pool.remove(0);
                System.out.println("消费了 " + num + "   当前队列中有 " + pool.size() + " 个");

                pool.notifyAll();
            }
        }
    }

    public void stop() {
        flag = false;
    }


    @Test
    void t() throws InterruptedException {
        DemoTest demoTest = new DemoTest();

        new Thread(() -> {
            demoTest.produce();
        }).start();

        new Thread(() -> {
            demoTest.consume();
        }).start();

        TimeUnit.SECONDS.sleep(30);

        demoTest.stop();

    }
}
