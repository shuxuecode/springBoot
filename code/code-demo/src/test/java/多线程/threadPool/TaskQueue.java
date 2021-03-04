package 多线程.threadPool;

import java.util.concurrent.LinkedBlockingQueue;

public class TaskQueue<R extends Runnable> extends LinkedBlockingQueue<Runnable> {


    @Override
    public boolean offer(Runnable runnable) {
        return super.offer(runnable);
    }
}


