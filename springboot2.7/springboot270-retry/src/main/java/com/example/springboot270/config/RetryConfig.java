package com.example.springboot270.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @date 2023/5/8
 */
@Configuration
@EnableRetry // 启动重试注解
public class RetryConfig {
}
