package 多线程.threadLocal;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    public static void main(String[] args) {

        try {
            ThreadLocalTest threadLocalTest = new ThreadLocalTest();
            threadLocalTest.init("test");
            threadLocalTest.name("name");
            threadLocalTest.person("person");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Map<String, String> map = ThreadLocalUtil.getThreadLocal();
            System.out.println(JSON.toJSONString(map));
            ThreadLocalUtil.clearThreadLocal();
        }

    }


    public void init(String init) {
        Map<String, String> map = Maps.newHashMap();
        map.put("init", init);
        ThreadLocalUtil.setThreadLocal(map);
    }

    public void name(String name) {
        Map<String, String> map = ThreadLocalUtil.getThreadLocal();
        map.put("name", name);
        ThreadLocalUtil.setThreadLocal(map);
    }


    public void person(String person) {
        Map<String, String> map = ThreadLocalUtil.getThreadLocal();
        map.put("person", person);
        ThreadLocalUtil.setThreadLocal(map);
    }


    @Test
    public void tt() {

        for (int i = 0; i < 10; i++) {
            ThreadLocalTest threadLocalTest = new ThreadLocalTest();

            final String num = String.valueOf(i);

            CompletableFuture.runAsync(() -> {
                try {
                    threadLocalTest.tt2(num);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(num);
                    Map<String, String> map = ThreadLocalUtil.getThreadLocal();
                    System.out.println(JSON.toJSONString(map));
                    ThreadLocalUtil.clearThreadLocal();
                }
            });

        }


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tt2(String num) {

        init("test" + num);
        name("name" + num);
        person("person" + num);

        ThreadLocalTest2 test2 = new ThreadLocalTest2();
        test2.other("other" + num);


    }
}
