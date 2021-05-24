package 多线程.多线程打印;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class 多线程打印Semaphore方式 {

    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(0);
    static Semaphore semaphore3 = new Semaphore(0);

    @Test
    void t() {

        Thread thread1 = new Thread(() -> {
            while (true) {
                semaphore1.acquireUninterruptibly(); // 获取信号执行,a信号量减1,当a为0时将无法继续获得该信号量
                System.out.println(1);
                semaphore2.release(); // 释放信号，b信号量加1（初始为0），此时可以获取b信号量
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                semaphore2.acquireUninterruptibly();
                System.out.println(2);
                semaphore3.release();
            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                semaphore3.acquireUninterruptibly();
//                semaphore3.acquire();
                System.out.println(3);
                semaphore1.release();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
