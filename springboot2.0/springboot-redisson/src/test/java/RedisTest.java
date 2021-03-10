import com.zsx.redisson.SpringbootRedissonApplication;
import io.lettuce.core.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootRedissonApplication.class})
public class RedisTest {

    @Autowired
    RedisKeyValueTemplate redisKeyValueTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void t() {
//        System.out.println(redisKeyValueTemplate);
        System.out.println(redisTemplate);


        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                for (int i = 0; i < 10; i++) {
//                    ops.boundValueOps("zhao" + i).set("value" + i);
//                    ops.boundValueOps("zhao" + i).get();
                    ops.delete("zhao" + i);

//                    ops.opsForValue().set("zhao" + i, "value");
                }
                return null;
            }
        };

        RedisCallback<String> redisCallback = (RedisCallback) connection -> {
            for (int i = 0; i < 10; i++) {
//                    connection.set(("zhao" + i).getBytes(), "value".getBytes());

                connection.del(("zhao" + i).getBytes());
            }
            return null;
        };

        List list = redisTemplate.executePipelined(redisCallback);

        System.out.println(list.size());
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
