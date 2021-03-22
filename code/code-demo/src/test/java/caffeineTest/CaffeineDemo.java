package caffeineTest;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CaffeineDemo {


    @Test
    public void test() {
        // 手动加载
        Cache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(5, TimeUnit.MINUTES) // 自从最后一次写入后多久就会过期
                .expireAfterAccess(5, TimeUnit.SECONDS) // 自从最后一次访问（写入或读取）后多久后过期
                // .expireAfter() // 自定义过期策略
                .build();

        cache.put("a", new Date());

        Object value = cache.getIfPresent("a");

        System.out.println(value);

        // 失效
        cache.invalidate("a");
    }

    @Test
    public void t2() {
        // 同步加载
        LoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .refreshAfterWrite(1, TimeUnit.MINUTES) // 指定刷新周期
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public @Nullable Object load(@NonNull String key) throws Exception {
                        return "null";
                    }
                });

        Object value = cache.get("a");

        System.out.println(value);


    }

    @Test
    public void t3() {
        // 异步加载
        AsyncLoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                // 异步加载机制
                .buildAsync(new CacheLoader<String, Object>() {
                    @Override
                    public @Nullable Object load(@NonNull String key) throws Exception {
                        return "null";
                    }
                });

        Object value = null;
        try {
            value = cache.get("a").get(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(value);


    }
}
