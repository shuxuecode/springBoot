package guavaTest;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 令牌桶测试
 */
public class RateLimiterTest {

    @Test
    public void t2() throws InterruptedException {

        RateLimiter limiter = RateLimiter.create(10);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 30; i++) {

            // acquire()方法就是获取一个令牌（源码中使用permit，许可证），
            // 如果permit足够，则直接返回而无需等待，如果不足，则等待1/QPS秒。
            // double acquire()：获取一个permit，如果permits充足则直接返回，否则等待1/QPS秒。此方法返回线程等待的时间（秒），如果返回0.0表示未限流、未等待。
            double time = limiter.acquire();
            // double acquire(int n)：获取n个permits，如果permits充足则直接返回，否则限流并等待，等待时间为“不足的permits个数 / QPS”。
//            double acquire = limiter.acquire(5);

            long after = System.currentTimeMillis() - start;

            if (time > 0D) {

                System.out.println(i + ",limited,等待:" + time + "，已开始" + after + "毫秒  " + System.currentTimeMillis());

            } else {

                System.out.println(i + ",enough" + "，已开始" + after + "毫秒");

            }

            //模拟冷却时间，下一次loop可以认为是bursty开始

            if (i == 9) {
                Thread.sleep(2000);

            }

        }


        System.out.println("total time：" + (System.currentTimeMillis() - start));
    }

    @Test
    public void t1() {
        RateLimiter rateLimiter = RateLimiter.create(5);

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int n = random.nextInt(5);
            n = 2;
            n = 0;
            double acquire;
            if (n > 0) {
                acquire = rateLimiter.acquire(n);
            } else {
                acquire = rateLimiter.acquire();
            }
            System.out.println(n);
            if (acquire > 0d) {
                System.out.println(acquire);
            } else {
                System.out.println("满" + acquire);
            }


        }
//
//        boolean tryAcquire = rateLimiter.tryAcquire();
//        System.out.println(tryAcquire);
//        double acquire = rateLimiter.acquire();
//        System.out.println(acquire);
//
//        System.out.println(rateLimiter.acquire());
//        System.out.println(rateLimiter.acquire());
//
//
//        System.out.println(rateLimiter.tryAcquire());
//        System.out.println(rateLimiter.tryAcquire());
//        System.out.println(rateLimiter.tryAcquire());

    }
}
