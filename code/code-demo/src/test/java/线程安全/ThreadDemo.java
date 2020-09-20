package 线程安全;

import java.time.LocalDateTime;

/**
 * Created by ZSX on 2018/11/22.
 *
 * @author ZSX
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        thread1.setName("t1");

        Thread1 thread2 = new Thread1();
        thread2.setName("t2");

        thread1.start();

        thread2.start();

        synchronized (thread2) {
            thread2.wait(10000L);
        }


    }


}

class Thread1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now().toString() + " >>> " + 1111);
    }
}