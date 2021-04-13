package 多线程.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class 线程中断测试 {

    private static Logger logger = LoggerFactory.getLogger(线程中断测试.class);

    public static void main(String[] args) {

        Thread thread = new Thread() {
            public void run() {
                logger.info("线程启动");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("线程结束");
            }
        };

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        System.out.println(Thread.interrupted());

    }
}
