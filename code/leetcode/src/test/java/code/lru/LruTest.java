package code.lru;

public class LruTest {

    public static void main(String[] args) {

        LruCache<String> lruCache = new LruCache<>(2);
        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");

        String value = lruCache.get("3");

        System.out.println(value);

    }
}
