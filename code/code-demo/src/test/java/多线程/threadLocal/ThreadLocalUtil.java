package 多线程.threadLocal;

import java.util.Map;

public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal<>();

    public static void setThreadLocal(Map<String, String> map) {
        THREAD_LOCAL.set(map);
    }

    public static Map<String, String> getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    public static void clearThreadLocal() {
        THREAD_LOCAL.remove();
    }

}
