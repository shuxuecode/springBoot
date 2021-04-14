package 多线程;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    @Test
    public void t1() {
        Semaphore semaphore = new Semaphore(8);
//        Semaphore semaphore = new Semaphore(8, false); // 无法保证顺序

        for (int i = 0; i < 8; i++) {
            final int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行任务" + num);
                    semaphore.release();
                }
            }).start();
        }
    }
}
