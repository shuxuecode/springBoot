package com.springboot335.springboot335.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * 注解说明
 * @Retryable注解 被注解的方法发生异常时会重试
 *      value:指定发生的异常进行重试
 *      include:和value一样，默认空，当exclude也为空时，所有异常都重试
 *      exclude:指定异常不重试，默认空，当include也为空时，所有异常都重试
 *      maxAttemps:重试次数，默认3
 *      backoff:重试补偿机制，默认没有
 * @Backoff注解
 *      delay:指定延迟后重试
 *      multiplier:指定延迟的倍数，比如delay=5000l,multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
 * @Recover 当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调
 */


@Service
@Retryable(
        value = Exception.class,
        backoff = @Backoff(delay = 1000, multiplier = 2)
)
public class TestServiceImpl implements TestService {
    @Override
    public String testGet(Integer id) {
        String time = LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("time=" + time + "   " + "id = " + id);
        Integer.valueOf("a");
        return "get " + id;
    }
}
