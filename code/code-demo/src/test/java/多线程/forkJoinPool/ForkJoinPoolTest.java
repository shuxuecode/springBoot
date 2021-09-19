package 多线程.forkJoinPool;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * todo
 *
 * @date 2021/9/16
 */
public class ForkJoinPoolTest {


    @Test
    void t1() {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();


        DemoTask demoTask = new DemoTask();

        forkJoinPool.execute(demoTask);

    }


}

class DemoTask extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println("执行业务逻辑");


        ForkJoinTask.invokeAll(createTask());

    }

    private List<DemoTask> createTask() {
        DemoTask demoTask1 = new DemoTask();
        DemoTask demoTask2 = new DemoTask();

        return Lists.newArrayList(demoTask1, demoTask2);
    }
}
