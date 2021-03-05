package 多线程.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class TaskQueue<R extends Runnable> extends LinkedBlockingQueue<Runnable> {

    private TaskThreadPoolExecutor executor;

    public TaskQueue(int capacity) {
        super(capacity);
    }

    public void setExecutor(TaskThreadPoolExecutor exec) {
        executor = exec;
    }

    @Override
    public boolean offer(Runnable runnable) {
        if (executor == null) {
            throw new RejectedExecutionException("线程池为空");
        }

        int currentPoolThreadSize = executor.getPoolSize();

        if (executor.getSubmittedTaskCount() < currentPoolThreadSize) {
            return super.offer(runnable);
        }

        if (currentPoolThreadSize < executor.getMaximumPoolSize()) {
            return false;
        }

        return super.offer(runnable);
    }

    public boolean retryOffer(Runnable runnable, long timeout, TimeUnit timeUnit) throws InterruptedException {
        if (executor.isShutdown()) {
            throw new RejectedExecutionException("线程池已关闭");
        }
        return super.offer(runnable, timeout, timeUnit);
    }
}


