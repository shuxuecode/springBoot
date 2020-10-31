package 多线程.threadLocal;

import java.util.Map;

public class ThreadLocalTest2 {


    public void other(String other) {
        Map<String, String> map = ThreadLocalUtil.getThreadLocal();
        map.put("other", other);
        ThreadLocalUtil.setThreadLocal(map);


        new ThreadLocalTest().name("123_" + other);

    }

}
