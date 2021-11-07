package toolTest;

import com.google.common.util.concurrent.Striped;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {

    private static Striped<Lock> striped = Striped.lazyWeakLock(10);

    private static volatile Lock lock = new ReentrantLock();

    private static volatile String flag = "a";

    private static ExecutorService threadPool;


    @BeforeEach
    public void before() {
        threadPool = Executors.newFixedThreadPool(8);
    }


    private static long start = 0L;

    @Test
    void t() throws InterruptedException {
        start = System.currentTimeMillis();
        System.out.println("开始： " + start);

        for (int i = 0; i < 5; i++) {
            int num = i;
//            CompletableFuture.runAsync(() -> {
//                run(num);
//            });

            threadPool.execute(() -> {
                new MapTest().run(num + 10);
            });
        }

        TimeUnit.SECONDS.sleep(15L);
    }

    private void run(int num) {
        synchronized (flag) {
            System.out.println("开始执行" + num);
            try {
//            lock.lock();
//                System.out.println("lock" + num);

                System.out.println("执行逻辑 " + num);
                TimeUnit.SECONDS.sleep(1L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//            lock.unlock();
                System.out.println("unlock" + num);
            }
            System.out.println(num + " : " + (System.currentTimeMillis() - start));
        }
    }


    @Test
    void t1() throws InterruptedException {
        start = System.currentTimeMillis();
        System.out.println("开始： " + start);

        for (int i = 0; i < 5; i++) {
            int num = i;
            CompletableFuture.runAsync(() -> {
                new MapTest().run1(num + 100);
            });
        }

        TimeUnit.SECONDS.sleep(15L);
    }

    private void run1(int num) {
        System.out.println("开始执行" + num);
        try {
            lock.lock();
            System.out.println("lock" + num);
            System.out.println("执行逻辑 " + num);
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("unlock" + num);
            System.out.println(num + " : " + (System.currentTimeMillis() - start));
        }
    }


    @Test
    void t2() {
        Lock lock1 = striped.get("a");
        Lock lock2 = striped.get("a");

        System.out.println(lock1 == lock2); // true
        System.out.println(lock1.equals(lock2)); // true
    }
}
