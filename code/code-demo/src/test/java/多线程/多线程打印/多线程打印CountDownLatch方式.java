package 多线程.多线程打印;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class 多线程打印CountDownLatch方式 {


    private CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private CountDownLatch countDownLatch2 = new CountDownLatch(1);
    private CountDownLatch countDownLatch3 = new CountDownLatch(1);

    @Test
    void t() {


        Thread thread1 = new Thread(() -> {

            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(1);

            countDownLatch2.countDown();
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(2);

                countDownLatch3.countDown();
            }
        });

        Thread thread3 = new Thread(() -> {

            try {
                countDownLatch3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(3);

//            countDownLatch2.countDown();
        });


        thread3.start();
        thread2.start();
        thread1.start();

        countDownLatch1.countDown();
    }

}
