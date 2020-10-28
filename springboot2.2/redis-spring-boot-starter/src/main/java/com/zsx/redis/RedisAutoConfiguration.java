package com.zsx.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.PriorityOrdered;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnProperty(prefix = "redis", name = "enable", havingValue = "true", matchIfMissing = true)
public class RedisAutoConfiguration implements PriorityOrdered {


    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedisCommands createClient() {

        RedisURI redisURI = RedisURI.builder()
                .withHost(redisProperties.getHost())
                .withPort(redisProperties.getPort())
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        RedisClient client = RedisClient.create(redisURI);

        StatefulRedisConnection<String, String> connect = client.connect();

        RedisCommands<String, String> redisCommands = connect.sync();

        return redisCommands;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
