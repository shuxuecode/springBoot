package 多线程.threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 */
public class TaskThreadPoolExecutor extends ThreadPoolExecutor {

    /**
     * 用于记录当前线程池中已提交的任务数量
     */
    private final AtomicInteger submittedTaskCount = new AtomicInteger(0);

    public TaskThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TaskThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public int getSubmittedTaskCount() {
        return submittedTaskCount.get();
    }

    // 任务执行前
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    // 任务执行后
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        // 任务执行完后需要将线程池中已提交的任务数减1
        submittedTaskCount.decrementAndGet();
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        // 已提交的任务数加1
        submittedTaskCount.incrementAndGet();

        try {
            super.execute(command);
        } catch (RejectedExecutionException ree) {
            // 被拒绝后重试将任务添加到队列中
            final TaskQueue queue = (TaskQueue) super.getQueue();
            try {
                if (!queue.retryOffer(command, 0, TimeUnit.MILLISECONDS)) {
                    submittedTaskCount.decrementAndGet();
                    throw new RejectedExecutionException("队列已满", ree);
                }
            } catch (InterruptedException e) {
                submittedTaskCount.decrementAndGet();
                throw new RejectedExecutionException(e);
            }

        } catch (Throwable t) {
            submittedTaskCount.decrementAndGet();
            throw t;
        }
    }


}