package 多线程.生产者消费者.queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用阻塞队列实现生产者消费者模型
 */
public class QueueTest {

    private static final int max_count = 10;
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(max_count);
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void produce() throws InterruptedException {
        while (flag) {
            boolean offer = blockingQueue.offer(atomicInteger.incrementAndGet(), 2, TimeUnit.SECONDS);
            if (offer) {
                System.out.println("生产 " + atomicInteger.get() + "  队列大小 " + blockingQueue.size());
            } else {
                System.out.println("生产失败 " + atomicInteger.get() + "  队列大小 " + blockingQueue.size());
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    public void consume() throws InterruptedException {
        Integer poll = null;
        while (true) {
            poll = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (poll == null) {
                System.out.println("消费失败，即将退出");
                return;
            }
            System.out.println("消费 " + poll + "  队列大小 " + blockingQueue.size());
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }

    public void stop() {
        flag = false;
    }

    @Test
    void t() throws InterruptedException {
        QueueTest queueTest = new QueueTest();

        new Thread(() -> {
            try {
                queueTest.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                queueTest.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(30);

        queueTest.stop();
    }

}
