package 多线程.并发场景;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentHashMap 做唯一锁
 * todo
 * @date 2021/12/23
 */
@Slf4j
public class ConcurrentHashMapLockTest {

    public static final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Test
    void t1() {

        for (int i = 0; i < 10; i++) {
            int n = i;
            //if (i % 2 == 0) {
            //    n = 222;
            //} else {
            //    n = 333;
            //}

            n = new Random().nextInt(4);

            String num = String.valueOf(n);
            executorService.execute(() -> {
                test(num);
            });

        }

        try {
            TimeUnit.SECONDS.sleep(15L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void test(String id) {

        // putIfAbsent   如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
        Object putIfAbsent = map.putIfAbsent(id, id);
        if (putIfAbsent == null) {
            runTask(id);
        } else {
            log.warn("newTaks={} 与 oldTask={} 冲突", id, putIfAbsent);
        }

    }

    public void runTask(String id) {
        try {
            log.info("开始执行任务 {}", id);
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            map.remove(id);
        }
    }


}
