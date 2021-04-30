package 多线程.lock;

import java.util.concurrent.TimeUnit;

public class 死锁测试 {

    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        LockA lockA = new LockA();
        Thread threadA = new Thread(lockA);
        threadA.setName("线程A");
        threadA.start();


        LockB lockB = new LockB();
        Thread threadB = new Thread(lockB);
        threadB.setName("线程B");
        threadB.start();

        // 死锁了
    }

}

class LockA implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (死锁测试.obj1) {
                    System.out.println(Thread.currentThread().getName() + " 锁住了 obj1");
                    TimeUnit.SECONDS.sleep(5); // 等待 LockB 锁住 obj2
                    synchronized (死锁测试.obj2) {
                        System.out.println(Thread.currentThread().getName() + " 锁住了 obj2");
                        TimeUnit.SECONDS.sleep(60);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (死锁测试.obj2) {
                    System.out.println(Thread.currentThread().getName() + " 锁住了 obj2");
                    TimeUnit.SECONDS.sleep(5); // 等待 LockA 锁住 obj1
                    synchronized (死锁测试.obj1) {
                        System.out.println(Thread.currentThread().getName() + " 锁住了 obj1");
                        TimeUnit.SECONDS.sleep(60);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}