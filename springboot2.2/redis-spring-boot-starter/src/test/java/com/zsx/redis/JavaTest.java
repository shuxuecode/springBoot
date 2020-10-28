package com.zsx.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class JavaTest {


    public static void main(String[] args) {

        RedisURI redisURI = RedisURI.builder()
                .withHost("127.0.0.1")
                .withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        RedisClient client = RedisClient.create(redisURI);

        StatefulRedisConnection<String, String> connect = client.connect();

        RedisCommands<String, String> redisCommands = connect.sync();

        String key = "keyss";

        String value = redisCommands.get(key);
        System.out.println("value : " + value);

        String result = redisCommands.set(key, key);
        System.out.println("result : " + result);

        value = redisCommands.get(key);
        System.out.println("value : " + value);


        connect.close();
        client.shutdown();
    }
}
