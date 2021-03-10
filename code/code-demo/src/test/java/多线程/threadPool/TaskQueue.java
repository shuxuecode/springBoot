package 多线程.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 自定义队列
 *
 * @param <R>
 */
public class TaskQueue<R extends Runnable> extends LinkedBlockingQueue<Runnable> {

    /**
     * 自定义线程池类
     */
    private TaskThreadPoolExecutor executor;

    public TaskQueue(int capacity) {
        super(capacity);
    }

    public void setExecutor(TaskThreadPoolExecutor exec) {
        executor = exec;
    }

    /**
     * 重写offer方法
     * <p>
     * offer方法的含义是：将任务提交到队列中，返回值为true/false，分别代表提交成功/提交失败
     *
     * @param runnable
     * @return
     */
    @Override
    public boolean offer(Runnable runnable) {
        if (executor == null) {
            throw new RejectedExecutionException("线程池为空");
        }

        // 当前线程数
        int currentPoolThreadSize = executor.getPoolSize();

        // 判断已提交的任务数量是否小于当前线程数，如果小于则说明线程池中还有空闲线程，直接放到队列中，让线程去处理
        if (executor.getSubmittedTaskCount() < currentPoolThreadSize) {
            return super.offer(runnable);
        }

        if (currentPoolThreadSize < executor.getMaximumPoolSize()) {
            // 如果当前线程数 小于 最大线程数，返回false，表示加入队列失败，让线程池创建新的线程
            return false;
        }

        // 当前线程数 >= 最大线程数，需要将任务加到队列中
        return super.offer(runnable);
    }

    public boolean retryOffer(Runnable runnable, long timeout, TimeUnit timeUnit) throws InterruptedException {
        if (executor.isShutdown()) {
            throw new RejectedExecutionException("线程池已关闭");
        }
        return super.offer(runnable, timeout, timeUnit);
    }
}


