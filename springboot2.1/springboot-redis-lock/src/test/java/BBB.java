import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class BBB {




    @Test
    public void test01() {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128); // 最大连接数
        poolConfig.setMaxIdle(32);  // 最大空闲连接数
        poolConfig.setMinIdle(8);   // 最小空闲连接数

        // 创建连接池
        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379);

        System.out.println("jedisPool.getResource()1 = " + jedisPool.getResource());
        System.out.println("jedisPool.getResource()2 = " + new JedisPool(poolConfig, "localhost", 6279).getResource());

        System.out.println("jedisPool1 = " + jedisPool);
        System.out.println("jedisPool2 = " + new JedisPool(poolConfig, "localhost", 6279));

        try (Jedis jedis = jedisPool.getResource()) {
            // 执行操作
            jedis.set("poolKey", "poolValue");
            System.out.println(jedis.get("poolKey")); // 输出: poolValue
        }

        // 关闭连接池
        jedisPool.close();
    }





    public static void main(String[] args) {


        // 创建连接
        Jedis jedis = new Jedis("localhost", 6379); // 默认端口6379

        // 认证（如果设置了密码）
        // jedis.auth("password");

        // 测试连接
        System.out.println("连接成功");
        System.out.println("服务正在运行: " + jedis.ping());

        // 关闭连接
        jedis.close();


    }


}
