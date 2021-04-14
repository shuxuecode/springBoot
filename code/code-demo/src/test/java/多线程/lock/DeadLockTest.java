package 多线程.lock;

import org.junit.Test;

public class DeadLockTest {

    @Test
    public void test() throws InterruptedException {
        testA();
    }


    //    Lock lock = new Lock();
    Lock2 lock = new Lock2();

    public void testA() throws InterruptedException {
        System.out.println("执行A");
        lock.lock();
        testB();
        lock.unlock();
    }

    public void testB() throws InterruptedException {
        System.out.println("执行B");
        lock.lock();

        lock.unlock();
    }
}

/**
 * 定义一个不可重入锁
 * <p>
 * A方法需要等B方法执行完才能解锁，但是B方法想执行完代码又必须要lock锁来加锁。A的锁未解锁前，其他代码块无法使用此锁来加锁
 * <p>
 * 当A方法获取lock锁去锁住一段需要做原子性操作的B方法时，如果这段B方法又需要锁去做原子性操作，那么A方法就必定要与B方法出现死锁。这种会出现问题的重入一把锁的情况，叫不可重入锁。
 */
class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

/**
 * 定义一个 可重入锁
 */
class Lock2 {
    private boolean isLocked = false;
    // 标识 临界资源被哪个线程锁住了
    Thread lockedBy = null;

    // 加锁次数，解锁的时候，可以确保所有加锁的过程都解锁了，其他线程才能访问
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        // 获取当前线程
        Thread thread = Thread.currentThread();

        // 当临界资源已被锁上，但当前请求锁的线程又不是之前锁上临界资源的线程。那么当前请求锁的线程需要等待。
        while (isLocked && lockedBy != thread) {
            wait();
        }

        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {

                isLocked = false;
                notify();
            }
        }
    }

}