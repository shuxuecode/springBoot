package 多线程.thread;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * wait()
 * notify()
 * notifyAll()
 * 它们依赖于“同步锁”，同步锁由对象锁持有，并且每个对象有且仅有一个。
 * 这就是为什么notify(), wait()等函数定义在Object类，而不是Thread类中的原因。
 */
public class WaitNotifyTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaitNotifyTest.class);

    private static Object object = new Object();

    @Test
    public void t() throws InterruptedException {
        AAA aaa = new AAA();
        BBB bbb = new BBB();
        CCC ccc = new CCC();

        aaa.start();
        ccc.start();
        bbb.start();

        TimeUnit.SECONDS.sleep(20L);
    }

    class AAA extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.info("aaa");
            }

        }
    }

    class BBB extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                LOGGER.info("bbb");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                object.notify();
                object.notifyAll();
            }
        }
    }

    class CCC extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.info("ccc");
            }
        }
    }


}
