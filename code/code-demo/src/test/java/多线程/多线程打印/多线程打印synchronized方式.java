package 多线程.多线程打印;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.SliderUI;
import java.util.concurrent.Semaphore;

/**
 *
 */
public class 多线程打印synchronized方式 {

    public class ThreadPrinter implements Runnable {

        private String str;
        private Object pre;
        private Object self;

        public ThreadPrinter(String str, Object pre, Object self) {
            this.str = str;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 10) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.println(str);
                        i++;
                        self.notifyAll();
                    }

                    try {
                        pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    @Test
    void t() throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter aa = new ThreadPrinter("a", c, a);
        ThreadPrinter bb = new ThreadPrinter("b", a, b);
        ThreadPrinter cc = new ThreadPrinter("c", b, c);

        new Thread(aa).start();
        Thread.sleep(10);
        new Thread(bb).start();
        Thread.sleep(10);
        new Thread(cc).start();
        Thread.sleep(10);

    }


}
