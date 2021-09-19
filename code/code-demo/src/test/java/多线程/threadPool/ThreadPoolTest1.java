package 多线程.threadPool;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest1 {

//    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(16);

//    private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 5L, TimeUnit.SECONDS, queue);

    private TaskQueue<Runnable> queue = new TaskQueue<>(6);
    private TaskThreadPoolExecutor executor = new TaskThreadPoolExecutor(2, 4, 5L, TimeUnit.SECONDS, queue);

    {

        queue.setExecutor(executor);
    }

    @Test
    public void t1() {
        CompletableFuture.runAsync(() -> {
            int i = 1;
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                }
                System.out.println(i++);
                print();
                if (executor.getCompletedTaskCount() == 10) {
                    System.out.println("任务执行完成 ================================================================");
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            if (i == 2) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                }
            }
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        do {

        } while (true);
    }


    public void print() {
        System.out.println();
        System.out.println();
        System.out.println("开始打印 -------------------------------------------------------");

        int corePoolSize = executor.getCorePoolSize();
        System.out.println("线程池的核心线程数量 : " + corePoolSize);

        int maximumPoolSize = executor.getMaximumPoolSize();
        System.out.println("线程池的最大线程数量 : " + maximumPoolSize);

        int poolSize = executor.getPoolSize();
        System.out.println("线程池当前的线程数量 : " + poolSize);

        int activeCount = executor.getActiveCount();
        System.out.println("线程池中正在执行任务的线程数量 : " + activeCount);

        // 线程池曾经创建过的最大线程数量。通过这个数据可以知道线程池是否满过，也就是达到了maximumPoolSize
        int largestPoolSize = executor.getLargestPoolSize();
        System.out.println("线程池曾经创建过的最大线程数量 : " + largestPoolSize);

        long completedTaskCount = executor.getCompletedTaskCount();
        System.out.println("线程池已完成的任务数量 : " + completedTaskCount);

    }


}
