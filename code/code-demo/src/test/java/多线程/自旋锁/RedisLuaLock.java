package 多线程.自旋锁;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import 单元测试.redisDemo.RedisClient;

public class RedisLuaLock {

    private static Logger logger = LoggerFactory.getLogger(RedisLuaLock.class);

    private Jedis jedis = RedisClient.getClient();

    public boolean lock(String key, String value) {
        Long one = 1L;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("local key = KEYS[1]\n");
        stringBuilder.append("local value = ARGV[1]\n");
        stringBuilder.append("local ttl = ARGV[2]\n");
        stringBuilder.append("local ok = redis.call('setnx', key, value)\n");

        stringBuilder.append("if ok ==1 then\n");
        stringBuilder.append(" redis.call('expire', key, ttl)\n");
        stringBuilder.append("end\n");
        stringBuilder.append("return ok");

        String lockScript = stringBuilder.toString();

        Object eval = jedis.eval(lockScript, Lists.newArrayList(key), Lists.newArrayList(value, "10"));
        if (one.equals(eval)) {
            logger.info("  redis获取分布式锁 " + value + " 得到锁");
            return true;
        }

        String theValue = jedis.get(key);
        if (StringUtils.isNotBlank(theValue) && theValue.equals(value)) {
            logger.info("  redis获取分布式锁 " + value + " 得到锁");
            return true;
        }

        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public boolean unlock(String key, String value) {
        Long one = 1L;
        logger.info("  redis释放分布式锁 " + value);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end\n");
        String unLockScript = stringBuilder.toString();

        Object eval = jedis.eval(unLockScript, Lists.newArrayList(key), Lists.newArrayList(value));
        if (one.equals(eval)) {
            logger.info("  redis获取分布式锁 " + value + " 得到锁");
            return true;
        }

        return false;
    }

}
