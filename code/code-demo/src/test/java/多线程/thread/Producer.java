package 多线程.thread;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.synth.SynthViewportUI;
import java.util.concurrent.TimeUnit;

public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private static Object object = new Object();

    @Test
    public void t() throws InterruptedException {
        AAA aaa = new AAA();
        BBB bbb = new BBB();

        aaa.start();
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
            LOGGER.info("bbb");
            synchronized (object){
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                object.notifyAll();
            }
        }
    }

}



